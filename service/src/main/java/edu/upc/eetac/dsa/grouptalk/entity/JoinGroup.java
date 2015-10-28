package edu.upc.eetac.dsa.grouptalk.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.List;

/**
 * Created by Jordi on 28/10/2015.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JoinGroup {
    @InjectLinks({})
    private List<Link> links;
    private String userid;
    private String interestgroupid;

    public List<Link> getLinks() {
        return links;
    }

    public String getUserid() {
        return userid;
    }

    public String getInterestgroupid() {
        return interestgroupid;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setInterestgroupid(String interestgroupid) {
        this.interestgroupid = interestgroupid;
    }
}
