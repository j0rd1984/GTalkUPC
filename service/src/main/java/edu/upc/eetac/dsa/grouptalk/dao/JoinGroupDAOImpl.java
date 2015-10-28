package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.JoinGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jordi on 28/10/2015.
 */
public class JoinGroupDAOImpl implements JoinGroupDAO {
    @Override
    public JoinGroup createJoinGroup(String userid, String interestgroupid) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String id = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(JoinGroupDAOQuery.CREATE_JoinGroup);
            stmt.setString(1, userid);
            stmt.setString(2, interestgroupid);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        return getJoinGroupById(userid);
    }

    @Override
    public JoinGroup getJoinGroupById(String id) throws SQLException {
        JoinGroup JoinGroup = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(JoinGroupDAOQuery.GET_JoinGroup_BY_ID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JoinGroup = new JoinGroup();
                JoinGroup.setUserid(rs.getString("userid"));
                JoinGroup.setInterestgroupid(rs.getString("content"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return JoinGroup;
    }
    @Override
    public JoinGroup deleteJoinGroup(String userid, String interestgroupid) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(JoinGroupDAOQuery.DELETE_JoinGroup);
            stmt.setString(1, userid);
            stmt.setString(2, interestgroupid);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return getJoinGroupById(userid);
    }

}
