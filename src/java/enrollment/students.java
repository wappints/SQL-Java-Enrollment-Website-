/*
 * Author: Tendido, Dy, Norona, Bacayan     
 *         CCINFOM S11
 */

package enrollment;
import java.sql.*;
import java.util.*;

public class students {
    
    public  long    studentid;
    public  String  completename;
    public  String  degreeid;
    
    public  ArrayList<students> studlist = new ArrayList<> ();
    
    public students () {
        studentid    = 0;
        completename = "";
        degreeid     = "";
        
        studlist.clear();
    };
        
    public int modRecord() { 
        try {
            
            Connection conn;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE students set completename=?, degreeid=? WHERE studentid=?");

            pstmt.setLong (3, studentid);
            pstmt.setString (1, completename);
            pstmt.setString (2, degreeid);
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE studentid=?");

            pstmt.setLong (1, studentid);
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students VALUES (?,?,?)");

            pstmt.setLong(1, studentid);
            pstmt.setString (2, completename);
            pstmt.setString (3, degreeid);
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students WHERE studentid=?");

            pstmt.setLong (1, studentid);
            
            ResultSet rs = pstmt.executeQuery();   

            while (rs.next()) {
                studentid     = rs.getLong("studentid");
                completename  = rs.getString("completename");
                degreeid      = rs.getString("degreeid");
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
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students");
            
            ResultSet rs = pstmt.executeQuery();   

            studlist.clear();
            while (rs.next()) {
                students s = new students();
                s.studentid     = rs.getLong("studentid");
                s.completename  = rs.getString("completename");
                s.degreeid      = rs.getString("degreeid");
                studlist.add(s);
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
        
        students stds = new students ();
        
        /*
        stds.studentid = 11900001;
        stds.completename = "Isabel Tendido";
        stds.degreeid = "DLSU";
        stds.addRecord ();
        */  
        
        /*
        stds.studentid = 11900001;
        stds.completename = "Ma. Isabel Tendido";
        stds.degreeid = "DLSU-M";
        stds.modRecord();
        */
        
        /*
        stds.studentid = 11900001;
        stds.delRecord();
        */
        
        /*
        stds.studentid = 10100011;
        stds.viewRecord();
        
        System.out.println(stds.studentid);
        System.out.println(stds.completename);
        System.out.println(stds.degreeid);
        */
        
        
        stds.viewAllRecords();
        
        for (int i=0; i< stds.studlist.size(); i++) {
            students a = new students();
            a = stds.studlist.get(i);
            System.out.println(a.studentid);
            System.out.println(a.completename);
            System.out.println(a.degreeid);
            System.out.println ("-----");    
        }
        
    }
}
