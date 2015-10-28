package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by Jordi on 25/10/2015.
 */
public interface CommentDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_COMMENT = "insert into comments (id, userid, content, themeid) values (UNHEX(?), unhex(?), ?,UNHEX(?))";
    public final static String GET_COMMENT_BY_ID = "select hex(s.id) as id, hex(s.userid) as userid, s.content, s.creation_timestamp, s.last_modified, hex(s.themeid) as themeid,u.fullname from comments s, users u where s.id=unhex(?) and u.id=s.userid";
    public final static String GET_COMMENTS = "select hex(id) as id, hex(userid) as userid, creation_timestamp, last_modified from comments";
    public final static String UPDATE_COMMENT = "update comments set content=? where id=unhex(?) ";
    public final static String DELETE_COMMENT = "delete from comments where id=unhex(?)";
}