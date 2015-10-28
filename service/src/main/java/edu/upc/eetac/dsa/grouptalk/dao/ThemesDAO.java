package edu.upc.eetac.dsa.grouptalk.dao;

import edu.upc.eetac.dsa.grouptalk.entity.Themes;
import edu.upc.eetac.dsa.grouptalk.entity.ThemesCollection;

import java.sql.SQLException;

/**
 * Created by Jordi on 26/10/2015.
 */
public interface ThemesDAO {
    public Themes createThemes(String userid, String subject, String content, String interestgroupid) throws SQLException;
    public Themes getThemesById(String id) throws SQLException;
    public ThemesCollection getThemes() throws SQLException;
    public Themes updateThemes(String id, String subject, String content) throws SQLException;
    public boolean deleteThemes(String id) throws SQLException;
}
