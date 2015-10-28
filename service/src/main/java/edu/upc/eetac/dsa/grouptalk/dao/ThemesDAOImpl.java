package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Themes;
import edu.upc.eetac.dsa.grouptalk.entity.ThemesCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jordi on 26/10/2015.
 */
public class ThemesDAOImpl implements ThemesDAO {
    @Override
    public Themes createThemes(String userid, String subject, String content, String interestgroupid) throws SQLException {
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

            stmt = connection.prepareStatement(ThemesDAOQuery.CREATE_Themes);
            stmt.setString(1, id);
            stmt.setString(2, userid);
            stmt.setString(3, subject);
            stmt.setString(4, content);
            stmt.setString(5, interestgroupid);
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
        return getThemesById(id);
    }

    @Override
    public Themes getThemesById(String id) throws SQLException {
        Themes Themes = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(ThemesDAOQuery.GET_Themes_BY_ID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Themes = new Themes();
                Themes.setId(rs.getString("id"));
                Themes.setUserid(rs.getString("userid"));
                Themes.setCreator(rs.getString("fullname"));
                Themes.setSubject(rs.getString("subject"));
                Themes.setContent(rs.getString("content"));
                Themes.setInterestgroupid(rs.getString("interestgroupid"));
                Themes.setCreationTimestamp(rs.getTimestamp("creation_timestamp").getTime());
                Themes.setLastModified(rs.getTimestamp("last_modified").getTime());
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return Themes;
    }

    @Override
    public ThemesCollection getThemes() throws SQLException {
        ThemesCollection stingCollection = new ThemesCollection();

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(ThemesDAOQuery.GET_Themes);

            ResultSet rs = stmt.executeQuery();
            boolean first = true;
            while (rs.next()) {
                Themes Themes = new Themes();
                Themes.setId(rs.getString("id"));
                Themes.setUserid(rs.getString("userid"));
                Themes.setSubject(rs.getString("subject"));
                Themes.setCreationTimestamp(rs.getTimestamp("creation_timestamp").getTime());
                Themes.setLastModified(rs.getTimestamp("last_modified").getTime());
                if (first) {
                    stingCollection.setNewestTimestamp(Themes.getLastModified());
                    first = false;
                }
                stingCollection.setOldestTimestamp(Themes.getLastModified());
                stingCollection.getThemes().add(Themes);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return stingCollection;
    }

    @Override
    public Themes updateThemes(String id, String content) throws SQLException {
        Themes Themes = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(ThemesDAOQuery.UPDATE_Themes);
            stmt.setString(1, content);
            stmt.setString(2, id);

            int rows = stmt.executeUpdate();
            if (rows == 1)
                Themes = getThemesById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return Themes;
    }

    @Override
    public boolean deleteThemes(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(ThemesDAOQuery.DELETE_Themes);
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
