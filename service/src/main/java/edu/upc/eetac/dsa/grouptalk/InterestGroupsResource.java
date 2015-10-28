package edu.upc.eetac.dsa.grouptalk;

import edu.upc.eetac.dsa.grouptalk.dao.InterestGroupsDAO;
import edu.upc.eetac.dsa.grouptalk.dao.InterestGroupsDAOImpl;
import edu.upc.eetac.dsa.grouptalk.entity.AuthToken;
import edu.upc.eetac.dsa.grouptalk.entity.InterestGroups;
import edu.upc.eetac.dsa.grouptalk.entity.InterestGroupsCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Created by Jordi on 26/10/2015.
 */
@Path("groups")
public class InterestGroupsResource {
    @Context
    private SecurityContext securityContext;
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(GrouptalkMediaType.GROUPTALK_InterestGroups)
    public Response createInterestGroups(@FormParam("content") String content, @Context UriInfo uriInfo) throws URISyntaxException {
        if(content == null)
            throw new BadRequestException("all parameters are mandatory");
        InterestGroupsDAO interestGroupsDAO = new InterestGroupsDAOImpl();
        InterestGroups interestgroups = null;
        AuthToken authenticationToken = null;
        try {
            interestgroups = interestGroupsDAO.createInterestGroups(securityContext.getUserPrincipal().getName(), content);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + interestgroups.getId());
        return Response.created(uri).type(GrouptalkMediaType.GROUPTALK_InterestGroups).entity(interestgroups).build();
    }
    @GET
    @Produces(GrouptalkMediaType.GROUPTALK_InterestGroups_COLLECTION)
    public InterestGroupsCollection getInterestGroups(){
        InterestGroupsCollection interestGroupsCollection = null;
        InterestGroupsDAO interestGroupsDAO = new InterestGroupsDAOImpl();
        try {
            interestGroupsCollection = interestGroupsDAO.getInterestGroups();
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }

        return interestGroupsCollection;
    }

    @Path("/{id}")
    @GET
    @Produces(GrouptalkMediaType.GROUPTALK_InterestGroups)
    public InterestGroups getInterestGroups(@PathParam("id") String id){
        InterestGroups interestGroups = null;
        InterestGroupsDAO interestGroupsDAO = new InterestGroupsDAOImpl();
        try {
            interestGroups = interestGroupsDAO.getInterestGroupsById(id);
            if(interestGroups == null)
                throw new NotFoundException("Group with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return interestGroups;
    }
    @Path("/{id}")
    @PUT
    @Consumes(GrouptalkMediaType.GROUPTALK_InterestGroups)
    @Produces(GrouptalkMediaType.GROUPTALK_InterestGroups)
    public InterestGroups updateInterestGroups(@PathParam("id") String id, InterestGroups interestGroups) {
        if(interestGroups == null)
            throw new BadRequestException("entity is null");
        if(!id.equals(interestGroups.getId()))
            throw new BadRequestException("path parameter id and entity parameter id doesn't match");

        String userid = securityContext.getUserPrincipal().getName();
        if(!userid.equals(interestGroups.getUserid()))
            throw new ForbiddenException("operation not allowed");

        InterestGroupsDAO interestGroupsDAO = new InterestGroupsDAOImpl();
        try {
            interestGroups = interestGroupsDAO.updateInterestGroups(id, interestGroups.getContent());
            if(interestGroups == null)
                throw new NotFoundException("Group with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return interestGroups;
    }
    @Path("/{id}")
    @DELETE
    public void deleteInterestGroups(@PathParam("id") String id) {
        String userid = securityContext.getUserPrincipal().getName();
        InterestGroupsDAO interestGroupsDAO = new InterestGroupsDAOImpl();
        try {
            String ownerid = interestGroupsDAO.getInterestGroupsById(id).getUserid();
            if(!userid.equals(ownerid))
                throw new ForbiddenException("operation not allowed");
            if(!interestGroupsDAO.deleteInterestGroups(id))
                throw new NotFoundException("Group with id = "+id+" doesn't exist");
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
    }
}
