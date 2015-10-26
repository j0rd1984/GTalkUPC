package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by Jordi on 25/10/2015.
 */
public interface CommentDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_COMMENT = "insert into stings (id, userid, content) values (UNHEX(?), unhex(?), ?)";
    public final static String GET_COMMENT_BY_ID = "select hex(s.id) as id, hex(s.userid) as userid, s.content, s.creation_timestamp, s.last_modified, u.fullname from stings s, users u where s.id=unhex(?) and u.id=s.userid";
    public final static String GET_COMMENTS = "select hex(id) as id, hex(userid) as userid, creation_timestamp, last_modified from stings";
    public final static String UPDATE_COMMENT = "update stings set content=? where id=unhex(?) ";
    public final static String DELETE_COMMENT = "delete from stings where id=unhex(?)";
}