/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBCHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Truc
 */
public class JDBCHelper {
    static String urlDB = "jdbc:sqlserver://localhost:1433;databaseName=EDUSY";
    static String usersName = "sa";
    static String password = "123";
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static PreparedStatement getStm(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(urlDB,usersName,password);
        PreparedStatement stm;
        if(sql.trim().startsWith("{")) {
            stm = conn.prepareCall(sql);
        } else {
            stm = conn.prepareStatement(sql);
        }
        for(int i=0;i<args.length;i++){
            stm.setObject(i+1, args[i]);
        }
        return stm;
    }
    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement stm = JDBCHelper.getStm(sql, args);
        return stm.executeQuery();
    }
    
    public static Object value(String sql, Object... args){
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static int update(String sql, Object... args){
        try {
            PreparedStatement stm = JDBCHelper.getStm(sql, args);
            try {
                return stm.executeUpdate();
            } finally {
                stm.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
