package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by Jordi on 26/10/2015.
 */
public interface InterestGroupsDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_interestgroups = "insert into interestgroups (id, userid, content) values (UNHEX(?), unhex(?), ?, ?)";
    public final static String GET_interestgroups_BY_ID = "select hex(s.id) as id, hex(s.userid) as userid, s.content, s.creation_timestamp, s.last_modified, u.fullname from interestgroups s, users u where s.id=unhex(?) and u.id=s.userid";
    public final static String GET_interestgroups = "select hex(id) as id, hex(userid) as userid, creation_timestamp, last_modified from interestgroups";
    public final static String UPDATE_interestgroups = "update interestgroups set content=? where id=unhex(?) ";
    public final static String DELETE_interestgroups = "delete from interestgroups where id=unhex(?)";
}
