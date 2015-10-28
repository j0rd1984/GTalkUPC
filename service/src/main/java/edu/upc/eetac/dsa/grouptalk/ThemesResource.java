package edu.upc.eetac.dsa.grouptalk;

import edu.upc.eetac.dsa.grouptalk.dao.CommentDAOImpl;
import edu.upc.eetac.dsa.grouptalk.dao.CommentsDAO;
import edu.upc.eetac.dsa.grouptalk.dao.ThemesDAO;
import edu.upc.eetac.dsa.grouptalk.dao.ThemesDAOImpl;
import edu.upc.eetac.dsa.grouptalk.entity.AuthToken;
import edu.upc.eetac.dsa.grouptalk.entity.Comments;
import edu.upc.eetac.dsa.grouptalk.entity.Themes;
import edu.upc.eetac.dsa.grouptalk.entity.ThemesCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Created by Jordi on 28/10/2015.
 */
@Path("themes")
public class ThemesResource {
    @Context
    private SecurityContext securityContext;
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(GrouptalkMediaType.GROUPTALK_Themes)
    public Response createThemes(@FormParam("subject") String subject, @FormParam("content") String content,@FormParam("interestgroupid") String interestgroupid, @Context UriInfo uriInfo) throws URISyntaxException {
        if(subject==null || content == null || interestgroupid == null)
            throw new BadRequestException("all parameters are mandatory");
        ThemesDAO themesDAO = new ThemesDAOImpl();
        Themes themes = null;
        AuthToken authenticationToken = null;
        try {
            themes = themesDAO.createThemes(securityContext.getUserPrincipal().getName(), subject, content, interestgroupid);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + themes.getId());
        return Response.created(uri).type(GrouptalkMediaType.GROUPTALK_Themes).entity(themes).build();
    }
    @GET
    @Produces(GrouptalkMediaType.GROUPTALK_Themes_COLLECTION)
    public ThemesCollection getThemes(){
        ThemesCollection themesCollection = null;
        ThemesDAO themesDAO = new ThemesDAOImpl();
        try {
            themesCollection = themesDAO.getThemes();
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }

        return themesCollection;
    }

    @Path("/{id}")
    @GET
    @Produces(GrouptalkMediaType.GROUPTALK_Themes)
    public Themes getThemes(@PathParam("id") String id){
        Themes themes = null;
        ThemesDAO themesDAO = new ThemesDAOImpl();
        try {
            themes = themesDAO.getThemesById(id);
            if(themes == null)
                throw new NotFoundException("Theme with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return themes;
    }
    @Path("/{id}")
    @PUT
    @Consumes(GrouptalkMediaType.GROUPTALK_Themes)
    @Produces(GrouptalkMediaType.GROUPTALK_Themes)
    public Themes updateThemes(@PathParam("id") String id, Themes themes) {
        if(themes == null)
            throw new BadRequestException("entity is null");
        if(!id.equals(themes.getId()))
            throw new BadRequestException("path parameter id and entity parameter id doesn't match");

        String userid = securityContext.getUserPrincipal().getName();
        if(!userid.equals(themes.getUserid()))
            throw new ForbiddenException("operation not allowed");

        ThemesDAO themesDAO = new ThemesDAOImpl();
        try {
            themes = themesDAO.updateThemes(id, themes.getContent());
            if(themes == null)
                throw new NotFoundException("Theme with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return themes;
    }
    @Path("/{id}")
    @DELETE
    public void deleteThemes(@PathParam("id") String id) {
        String userid = securityContext.getUserPrincipal().getName();
        ThemesDAO themesDAO = new ThemesDAOImpl();
        try {
            String ownerid = themesDAO.getThemesById(id).getUserid();
            if(!userid.equals(ownerid))
                throw new ForbiddenException("operation not allowed");
            if(!themesDAO.deleteThemes(id))
                throw new NotFoundException("Theme with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
    }
}
