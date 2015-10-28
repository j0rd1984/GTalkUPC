package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.JoinGroup;

import java.sql.SQLException;

/**
 * Created by Jordi on 28/10/2015.
 */
public interface JoinGroupDAO {
    public JoinGroup createJoinGroup(String userid, String interestgroupid) throws SQLException;
    public JoinGroup getJoinGroupById(String id) throws SQLException;
    public JoinGroup deleteJoinGroup(String id, String interestgroupid) throws SQLException;
}
