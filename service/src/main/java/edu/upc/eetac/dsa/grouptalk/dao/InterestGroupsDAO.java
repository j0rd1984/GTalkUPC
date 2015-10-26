package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.InterestGroups;
import edu.upc.eetac.dsa.grouptalk.entity.InterestGroupsCollection;

import java.sql.SQLException;

/**
 * Created by Jordi on 26/10/2015.
 */
public interface InterestGroupsDAO {
    public InterestGroups createInterestGroups(String userid, String content) throws SQLException;
    public InterestGroups getInterestGroupsById(String id) throws SQLException;
    public InterestGroupsCollection getInterestGroups() throws SQLException;
    public InterestGroups updateInterestGroups(String id, String content) throws SQLException;
    public boolean deleteInterestGroups(String id) throws SQLException;
}
