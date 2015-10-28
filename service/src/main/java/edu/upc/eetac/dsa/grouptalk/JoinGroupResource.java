package edu.upc.eetac.dsa.grouptalk;

import edu.upc.eetac.dsa.grouptalk.dao.*;
import edu.upc.eetac.dsa.grouptalk.entity.AuthToken;
import edu.upc.eetac.dsa.grouptalk.entity.InterestGroups;
import edu.upc.eetac.dsa.grouptalk.entity.JoinGroup;
import edu.upc.eetac.dsa.grouptalk.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Created by Jordi on 28/10/2015.
 */

@Path("joingroup")
public class JoinGroupResource {
    @Context
    private SecurityContext securityContext;
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(GrouptalkMediaType.GROUPTALK_AUTH_TOKEN)
    public Response createJoinGroup(@FormParam("userid") String userid, @FormParam("groupid") String groupid,@Context UriInfo uriInfo) throws URISyntaxException {
        if(userid == null || groupid == null)
            throw new BadRequestException("all parameters are mandatory");
        JoinGroupDAO joinGroupDAO = new JoinGroupDAOImpl();
        JoinGroup joinGroup = null;
        AuthToken authenticationToken = null;
        try {
            joinGroup = joinGroupDAO.createJoinGroup(securityContext.getUserPrincipal().getName(), groupid);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + joinGroup.getUserid());
        return Response.created(uri).type(GrouptalkMediaType.GROUPTALK_InterestGroups).entity(joinGroup).build();
    }
    @Path("/goout")
    @DELETE
    public Response deleteJoinGroup(@FormParam("userid") String userid, @FormParam("groupid") String groupid,@Context UriInfo uriInfo) throws URISyntaxException {
        if(userid == null || groupid == null)
            throw new BadRequestException("all parameters are mandatory");
        JoinGroupDAO joinGroupDAO = new JoinGroupDAOImpl();
        JoinGroup joinGroup = null;
        AuthToken authenticationToken = null;
        try {
            joinGroup = joinGroupDAO.deleteJoinGroup(securityContext.getUserPrincipal().getName(), groupid);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + joinGroup.getUserid());
        return Response.created(uri).type(GrouptalkMediaType.GROUPTALK_InterestGroups).entity(joinGroup).build();
    }
}
