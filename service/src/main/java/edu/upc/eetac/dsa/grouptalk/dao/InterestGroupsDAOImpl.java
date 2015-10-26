package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.InterestGroups;
import edu.upc.eetac.dsa.grouptalk.entity.InterestGroupsCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jordi on 26/10/2015.
 */
public class InterestGroupsDAOImpl  implements InterestGroupsDAO{

    @Override
    public InterestGroups createInterestGroups(String userid, String content) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String id = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(UserDAOQuery.UUID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                id = rs.getString(1);
            else
                throw new SQLException();

            stmt = connection.prepareStatement(InterestGroupsDAOQuery.CREATE_interestgroups);
            stmt.setString(1, id);
            stmt.setString(2, userid);
            stmt.setString(3, content);
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
        return getInterestGroupsById(id);
    }

    @Override
    public InterestGroups getInterestGroupsById(String id) throws SQLException {
        InterestGroups InterestGroups = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(InterestGroupsDAOQuery.GET_interestgroups_BY_ID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                InterestGroups = new InterestGroups();
                InterestGroups.setId(rs.getString("id"));
                InterestGroups.setUserid(rs.getString("userid"));
                InterestGroups.setCreator(rs.getString("fullname"));
                InterestGroups.setContent(rs.getString("content"));
                InterestGroups.setCreationTimestamp(rs.getTimestamp("creation_timestamp").getTime());
                InterestGroups.setLastModified(rs.getTimestamp("last_modified").getTime());
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return InterestGroups;
    }

    @Override
    public InterestGroupsCollection getInterestGroups() throws SQLException {
        InterestGroupsCollection InterestGroupsCollection = new InterestGroupsCollection();

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(InterestGroupsDAOQuery.GET_interestgroups);

            ResultSet rs = stmt.executeQuery();
            boolean first = true;
            while (rs.next()) {
                InterestGroups InterestGroups = new InterestGroups();
                InterestGroups.setId(rs.getString("id"));
                InterestGroups.setUserid(rs.getString("userid"));
                InterestGroups.setCreationTimestamp(rs.getTimestamp("creation_timestamp").getTime());
                InterestGroups.setLastModified(rs.getTimestamp("last_modified").getTime());
                if (first) {
                    InterestGroupsCollection.setNewestTimestamp(InterestGroups.getLastModified());
                    first = false;
                }
                InterestGroupsCollection.setOldestTimestamp(InterestGroups.getLastModified());
                InterestGroupsCollection.getStings().add(InterestGroups);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return InterestGroupsCollection;
    }

    @Override
    public InterestGroups updateInterestGroups(String id, String content) throws SQLException {
        InterestGroups InterestGroups = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(InterestGroupsDAOQuery.UPDATE_interestgroups);
            stmt.setString(1, content);
            stmt.setString(2, id);

            int rows = stmt.executeUpdate();
            if (rows == 1)
                InterestGroups = getInterestGroupsById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return InterestGroups;
    }

    @Override
    public boolean deleteInterestGroups(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(InterestGroupsDAOQuery.DELETE_interestgroups);
            stmt.setString(1, id);

            int rows = stmt.executeUpdate();
            return (rows == 1);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
}
