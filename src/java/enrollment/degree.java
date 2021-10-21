/*
 * Author: Tendido, Dy, Norona, Bacayan     
 *         CCINFOM S11
 */


package enrollment;
import java.sql.*;
import java.util.*;

public class degree {
     
    public  String   degreeid;
    public  String   degreename;
    
    public  ArrayList<degree> deglist = new ArrayList<> ();
   
    public degree () {
        degreeid   = "";
        degreename = "";
        
        deglist.clear();
    };
    
    
    public int modRecord() {
        try {
            
            Connection conn;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE degree set degreename=? WHERE degreeid=?");

            pstmt.setString (2, degreeid);
            pstmt.setString (1, degreename);
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM degree WHERE degreeid=?");

            pstmt.setString (1, degreeid);
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO degree VALUES (?,?)");

            pstmt.setString (1, degreeid);
            pstmt.setString (2, degreename);
            
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }    
    };
    
    public int viewRecord(){
        try {
            
            Connection conn;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM degree WHERE degreeid=?");

            pstmt.setString (1, degreeid);
            
            ResultSet rs = pstmt.executeQuery();   

            while (rs.next()) {
                degreeid    = rs.getString("degreeid");
                degreename  = rs.getString("degreename");
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
    
    public int viewAllRecords(){
        try {
            
            Connection conn;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM degree");
            
            ResultSet rs = pstmt.executeQuery();   

            deglist.clear();
            while (rs.next()) {
                
                degree d = new degree();                
                d.degreeid    = rs.getString("degreeid");
                d.degreename  = rs.getString("degreename");
                deglist.add(d);
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
        
        degree deg = new degree ();
        
        /*
        deg.degreeid = "IT";
        deg.degreename = "Isabel Tendido";
        deg.addRecord ();
        */
        
        /*
        deg.degreeid = "HW";
        deg.degreename = "Help Whales";
        deg.modRecord();
        */
        
        /*
        deg.degreeid = "HW";
        deg.delRecord();
        */
        
        /*
        deg.degreeid = "IT";
        deg.viewRecord();
        
        System.out.println(deg.degreeid);
        System.out.println(deg.degreename);
        */
        
        deg.viewAllRecords();
        
        for (int i=0; i< deg.deglist.size(); i++) {
            degree a = new degree();
            a = deg.deglist.get(i);
            System.out.println (a.degreeid);
            System.out.println (a.degreename);
            System.out.println ("-----");    
        }
            
    }
}
