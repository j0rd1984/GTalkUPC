package edu.upc.eetac.dsa.grouptalk;

import edu.upc.eetac.dsa.grouptalk.dao.CommentDAOImpl;
import edu.upc.eetac.dsa.grouptalk.dao.CommentsDAO;
import edu.upc.eetac.dsa.grouptalk.entity.AuthToken;
import edu.upc.eetac.dsa.grouptalk.entity.Comments;
import edu.upc.eetac.dsa.grouptalk.entity.CommentsCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Created by Jordi on 28/10/2015.
 */
@Path("comments")
public class CommentsResource {
    @Context
    private SecurityContext securityContext;
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(GrouptalkMediaType.GROUPTALK_Comments)
    public Response createComments(@FormParam("content") String content,@FormParam("themeid") String themeid, @Context UriInfo uriInfo) throws URISyntaxException {
        if(content == null || themeid == null)
            throw new BadRequestException("all parameters are mandatory");
        CommentsDAO commentsDAO = new CommentDAOImpl();
        Comments comments = null;
        AuthToken authenticationToken = null;
        try {
            comments = commentsDAO.createComments(securityContext.getUserPrincipal().getName(), content, themeid);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + comments.getId() );
        return Response.created(uri).type(GrouptalkMediaType.GROUPTALK_Comments).entity(comments).build();
    }
    @GET
    @Produces(GrouptalkMediaType.GROUPTALK_Comments_COLLECTION)
    public CommentsCollection getComments(){
        CommentsCollection commentsCollection = null;
        CommentsDAO commentsDAO = new CommentDAOImpl();
        try {
            commentsCollection = commentsDAO.getComments();
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }

        return commentsCollection;
    }

    @Path("/{id}")
    @GET
    @Produces(GrouptalkMediaType.GROUPTALK_Comments)
    public Comments getComments(@PathParam("id") String id){
        Comments comments = null;
        CommentsDAO commentsDAO = new CommentDAOImpl();
        try {
            comments = commentsDAO.getCommentsById(id);
            if(comments == null)
                throw new NotFoundException("Comment with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return comments;
    }
    @Path("/{id}")
    @PUT
    @Consumes(GrouptalkMediaType.GROUPTALK_Comments)
    @Produces(GrouptalkMediaType.GROUPTALK_Comments)
    public Comments updateComments(@PathParam("id") String id, Comments comments) {
        if(comments == null)
            throw new BadRequestException("entity is null");
        if(!id.equals(comments.getId()))
            throw new BadRequestException("path parameter id and entity parameter id doesn't match");

        String userid = securityContext.getUserPrincipal().getName();
        if(!userid.equals(comments.getUserid()))
            throw new ForbiddenException("operation not allowed");

        CommentsDAO commentsDAO = new CommentDAOImpl();
        try {
            comments = commentsDAO.updateComments(id, comments.getContent());
            if(comments == null)
                throw new NotFoundException("Comment with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return comments;
    }
    @Path("/{id}")
    @DELETE
    public void deleteComments(@PathParam("id") String id) {
        String userid = securityContext.getUserPrincipal().getName();
        CommentsDAO commentsDAO = new CommentDAOImpl();
        try {
            String ownerid = commentsDAO.getCommentsById(id).getUserid();
            if(!userid.equals(ownerid))
                throw new ForbiddenException("operation not allowed");
            if(!commentsDAO.deleteComments(id))
                throw new NotFoundException("Comment with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
    }

}
