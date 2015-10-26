package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Comments;
import edu.upc.eetac.dsa.grouptalk.entity.CommentsCollection;

import java.sql.SQLException;

/**
 * Created by Jordi on 25/10/2015.
 */
public interface CommentsDAO {
    public Comments createComments(String userid, String content) throws SQLException;
    public Comments getCommentsById(String id) throws SQLException;
    public CommentsCollection getComments() throws SQLException;
    public Comments updateComments(String id, String content) throws SQLException;
    public boolean deleteComments(String id) throws SQLException;
}
