package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by Jordi on 26/10/2015.
 */
public interface ThemesDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_Themes = "insert into themes (id, userid, subject, content) values (UNHEX(?), unhex(?), ?, ?)";
    public final static String GET_Themes_BY_ID = "select hex(s.id) as id, hex(s.userid) as userid, s.content, s.subject, s.creation_timestamp, s.last_modified, u.fullname from themes s, users u where s.id=unhex(?) and u.id=s.userid";
    public final static String GET_Themes = "select hex(id) as id, hex(userid) as userid, subject, creation_timestamp, last_modified from themes";
    public final static String UPDATE_Themes = "update themes set subject=?, content=? where id=unhex(?) ";
    public final static String DELETE_Themes = "delete from themes where id=unhex(?)";
}
