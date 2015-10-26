package edu.upc.eetac.dsa.grouptalk.entity;

import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.List;

/**
 * Created by Jordi on 25/10/2015.
 */
public class UserGroup {

    @InjectLinks({})
    private List<Link> links;

    private String userid;
    private String GroupID;

    public List<Link> getLinks() {
        return links;
    }

    public String getUserid() {
        return userid;
    }

    public String getGroupID() {
        return GroupID;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setGroupID(String groupID) {
        GroupID = groupID;
    }
}
