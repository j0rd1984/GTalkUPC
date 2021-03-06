package edu.upc.eetac.dsa.grouptalk.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.upc.eetac.dsa.grouptalk.*;
import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.List;

/**
 * Created by Jordi on 25/10/2015.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @InjectLinks({})
    private List<Link> links;
    private String id;
    private String loginid;
    private String email;
    private String fullname;


    public List<Link> getLinks() {
        return links;
    }

    public String getId() {
        return id;
    }

    public String getLoginid() {
        return loginid;
    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}