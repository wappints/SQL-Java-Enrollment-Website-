/*
 * Author: Tendido, Dy, Norona, Bacayan     
 *         CCINFOM S11
 */

package enrollment;
import java.sql.*;
import java.util.*;

public class courses {
    
    public  String   courseid;
    public  String   coursename;
    public  String   department;
    
    public  ArrayList<courses> courselist = new ArrayList<> ();
    
    public courses () {
        courseid   = "";
        coursename = "";
        department = "";
        
        courselist.clear();
    };
    
    public int modRecord() {
        try {
            
            Connection conn;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE courses set coursename=?, department=? WHERE courseid=?");

            pstmt.setString (3, courseid);
            pstmt.setString (1, coursename);
            pstmt.setString (2, department);
            
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    };
    
    public int delRecord() { 
        try {
            
            Connection conn;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM courses WHERE courseid=?");

            pstmt.setString (1, courseid);
            
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    };
    
    public int addRecord() { 
        try {
            
            Connection conn;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO courses VALUES (?,?,?)");

            pstmt.setString (1, courseid);
            pstmt.setString (2, coursename);
            pstmt.setString (3, department);
            
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    };
    
    public int viewRecord() { 
        try {
            
            Connection conn;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM courses WHERE courseid=?");

            pstmt.setString (1, courseid);
            
            ResultSet rs = pstmt.executeQuery();   

            while (rs.next()) {
                courseid    = rs.getString("courseid");
                coursename  = rs.getString("coursename");
                department  = rs.getString("department");
            }
            rs.close();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    };
    
    public int viewAllRecords() { 
        try {
            
            Connection conn;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM courses");
            
            ResultSet rs = pstmt.executeQuery();   

            courselist.clear();
            while (rs.next()) {
                courses c = new courses();
                c.courseid    = rs.getString("courseid");
                c.coursename  = rs.getString("coursename");
                c.department  = rs.getString("department");
                courselist.add(c);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    };
    
    public static void main(String args[]) {
       
        courses crs = new courses ();
        
        
        crs.courseid = "IT";
        crs.coursename = "Isabel Tendido";
        crs.department = "Bacoor";
        crs.addRecord ();
        
        
        /*
        crs.courseid = "IT";
        crs.coursename = "Ma. Isabel Tendido";
        crs.department = "Bacoor Department";
        crs.modRecord();
        */
        
        /*
        crs.courseid = "IT";
        crs.delRecord();
        */
        
        /*
        crs.courseid = "CCPROG3";
        crs.viewRecord();
        
        System.out.println(crs.courseid);
        System.out.println(crs.coursename);
        System.out.println(crs.department);
        */
        
        
        /* crs.viewAllRecords();
        
        for (int i=0; i< crs.courselist.size(); i++) {
            courses a = new courses();
            a = crs.courselist.get(i);
            System.out.println(a.courseid);
            System.out.println(a.coursename);
            System.out.println(a.department);
            System.out.println ("-----");    
        }
          */     
    }
}
