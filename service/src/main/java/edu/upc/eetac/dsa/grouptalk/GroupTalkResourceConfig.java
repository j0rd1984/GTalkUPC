package edu.upc.eetac.dsa.grouptalk;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 * Created by Jordi on 25/10/2015.
 */
public class GroupTalkResourceConfig extends ResourceConfig {
    public GroupTalkResourceConfig() {
        packages("edu.upc.eetac.dsa.grouptalk");
        packages("edu.upc.eetac.dsa.grouptalk.auth");
        register(RolesAllowedDynamicFeature.class);
    }
}
