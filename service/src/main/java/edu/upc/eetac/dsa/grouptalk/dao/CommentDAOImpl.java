package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Comments;
import edu.upc.eetac.dsa.grouptalk.entity.CommentsCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jordi on 25/10/2015.
 */
public class CommentDAOImpl implements CommentsDAO{

    @Override
    public Comments createComments(String userid, String content, String themeid) throws SQLException {
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

            stmt = connection.prepareStatement(CommentDAOQuery.CREATE_COMMENT);
            stmt.setString(1, id);
            stmt.setString(2, userid);
            stmt.setString(3, content);
            stmt.setString(4, themeid);
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
        return getCommentsById(id);
    }

    @Override
    public Comments getCommentsById(String id) throws SQLException {
        Comments comments = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(CommentDAOQuery.GET_COMMENT_BY_ID);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                comments = new Comments();
                comments.setId(rs.getString("id"));
                comments.setUserid(rs.getString("userid"));
                comments.setCreator(rs.getString("fullname"));
                comments.setContent(rs.getString("content"));
                comments.setThemeid(rs.getString("themeid"));
                comments.setCreationTimestamp(rs.getTimestamp("creation_timestamp").getTime());
                comments.setLastModified(rs.getTimestamp("last_modified").getTime());
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return comments;
    }

    @Override
    public CommentsCollection getComments() throws SQLException {
        CommentsCollection CommentsCollection = new CommentsCollection();

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(CommentDAOQuery.GET_COMMENTS);

            ResultSet rs = stmt.executeQuery();
            boolean first = true;
            while (rs.next()) {
                Comments Comments = new Comments();
                Comments.setId(rs.getString("id"));
                Comments.setUserid(rs.getString("userid"));
                Comments.setCreationTimestamp(rs.getTimestamp("creation_timestamp").getTime());
                Comments.setLastModified(rs.getTimestamp("last_modified").getTime());
                if (first) {
                    CommentsCollection.setNewestTimestamp(Comments.getLastModified());
                    first = false;
                }
                CommentsCollection.setOldestTimestamp(Comments.getLastModified());
                CommentsCollection.getComments().add(Comments);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return CommentsCollection;
    }

    @Override
    public Comments updateComments(String id, String content) throws SQLException {
        Comments Comments = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(CommentDAOQuery.UPDATE_COMMENT);
            stmt.setString(1, content);
            stmt.setString(2, id);

            int rows = stmt.executeUpdate();
            if (rows == 1)
                Comments = getCommentsById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return Comments;
    }

    @Override
    public boolean deleteComments(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(CommentDAOQuery.DELETE_COMMENT);
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

