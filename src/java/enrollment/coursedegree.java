/*
 * Author: Tendido, Dy, Norona, Bacayan     
 *         CCINFOM S11
 */

package enrollment;
import java.sql.*;
import java.util.*;

public class coursedegree {
    
    public String courseid ;
    public String degree ;
    public String moddegree; // for modifying modRecord
    
    public ArrayList <coursedegree> coursedeglist = new ArrayList <> ();
	
    public coursedegree () {
        courseid  = "";
        degree    = "" ;
        moddegree = "";
        
        coursedeglist.clear();
    }
    
    public int modRecord()  { 
        try { 
            Connection conn;     
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE coursedegree SET degree=? WHERE courseid=? AND degree=?");
            
            pstmt.setString (1, moddegree);
            pstmt.setString (2, courseid);
            pstmt.setString (3, degree);
			           
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
			
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        } 
    }
    
    public int delRecord()  { 
        try { 
            Connection conn;     
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM coursedegree WHERE courseid=? AND degree=?");
            
            pstmt.setString (1, courseid);
            pstmt.setString (2, degree);
                      
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
			
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
        
    }
    
    public int addRecord()  {         
        try {
            
            Connection conn;     
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO coursedegree VALUES (?,?)");
            
            pstmt.setString (1, courseid );
            pstmt.setString (2, degree);
          
            
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
			
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }         
    }
          
    public int viewRecord() { 
	try {
            
            Connection conn;     
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM coursedegree WHERE courseid=? AND degree=?");
            
            pstmt.setString (1, courseid );
            pstmt.setString (2, degree);
          
            ResultSet rs = pstmt.executeQuery();   

            while (rs.next()) {
                courseid   = rs.getString("courseid");
                degree     = rs.getString("degree");
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            return 1;
                        
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }          
    }
	
    public int viewAllRecords() { 
	try {
            
            Connection conn;     
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM coursedegree");
            
            ResultSet rs = pstmt.executeQuery();   

            coursedeglist.clear();
            while (rs.next()) {
                coursedegree cd = new coursedegree();
                cd.courseid     = rs.getString("courseid");
                cd.degree       = rs.getString("degree");
                coursedeglist.add(cd);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }  
        
       }
    
    public static void main(String args[]) {
		
        coursedegree crsdgr = new coursedegree();
	
        /*
        crsdgr.courseid = "CCPROG3";
        crsdgr.degree = "BSCS";
        crsdgr.addRecord() ;
	*/
	
        /*
        crsdgr.courseid = "CCPROG3";
        crsdgr.degree = "BSCS";
        crsdgr.moddegree = "BSIT";
        crsdgr.modRecord();
	*/
	   
	/*
        crsdgr.courseid = "CCPROG3";
        crsdgr.degree = "BSIT";
        crsdgr.delRecord() ;
	*/
	   
	/*  
	crsdgr.courseid = "CCPROG2";
        crsdgr.degree = "BSIT";
        crsdgr.viewRecord();
	
        System.out.println(crsdgr.courseid);
        System.out.println(crsdgr.degree);
        */
        
        crsdgr.viewAllRecords();
        
        for (int i=0; i< crsdgr.coursedeglist.size(); i++) {
            coursedegree a = new coursedegree();
            a = crsdgr.coursedeglist.get(i);
            System.out.println(a.courseid);
            System.out.println(a.degree);
            System.out.println ("-----");    
        }
        
    }
}
