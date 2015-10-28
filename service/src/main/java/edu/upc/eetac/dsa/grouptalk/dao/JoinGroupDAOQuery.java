package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by Jordi on 28/10/2015.
 */
public interface JoinGroupDAOQuery {
    public final static String CREATE_JoinGroup = "insert into user_group (userid,interestgroup) values (UNHEX(?), unhex(?))";
    public final static String GET_JoinGroup_BY_ID = "select hex(u.userid) as userid, s.content as content from interestgroups s, user_group u where u.userid=unhex(?) and u.interestgroup=s.id";
    public final static String DELETE_JoinGroup = "delete from user_group where userid=unhex(?) and interestgroup=unhex(?)";
}
