/*
 * Author: Tendido, Dy, Norona, Bacayan     
 *         CCINFOM S11
 */

package enrollment;
import java.sql.*;
import java.util.*;

public class enrollment {
    
    public long studentid;
    public String courseid;
    public int term;
    public int schoolyear;
    
    public ArrayList <enrollment> enrollmentList = new ArrayList <> ();
    
    // temporary variables for modrecord ()
    public String modcourseid;
    public int modterm;
    public int modschoolyear;
    
    public enrollment () {
	studentid   = 0;
	courseid    = "";
	term        = 0;
	schoolyear  = 0;
        
        enrollmentList.clear();
        
	modcourseid    = "";
	modterm        = 0;
	modschoolyear  = 0;
	
    };
	
    
    public int modRecord()  { 
	try { 
            Connection conn;     
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE enrollment SET courseid=?, term=?, schoolyear=? WHERE studentid=? AND courseid=? AND term=? AND schoolyear=?");
            
            
            pstmt.setString (1, modcourseid);
            pstmt.setInt (2, modterm);
            pstmt.setInt (3, modschoolyear);
            pstmt.setLong (4, studentid);
            pstmt.setString (5, courseid);
            pstmt.setInt (6, term);
            pstmt.setInt (7, schoolyear);
			
            
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    };
	
    
    public int delRecord()  { 
        try { 
            Connection conn;     
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM enrollment WHERE studentid=? AND courseid=? AND term=? AND schoolyear=?");
            
            pstmt.setLong (1, studentid);
            pstmt.setString (2, courseid);
            pstmt.setInt (3, term);
            pstmt.setInt (4, schoolyear);
			
            
            pstmt.executeUpdate();   
            pstmt.close();
            conn.close();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    };  
	
    public int addRecord()  { 
	try {
	
            Connection conn;     
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO enrollment VALUES (?,?,?,?)");
            
            pstmt.setLong (1,studentid);
            pstmt.setString (2, courseid);
            pstmt.setInt (3, term);
            pstmt.setInt (4, schoolyear);
          
            
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
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM enroll WHERE studentid=? AND courseid=? AND term=? AND schoolyear=?");
            
            pstmt.setLong (1,studentid);
            pstmt.setString (2, courseid);
            pstmt.setInt (3, term);
            pstmt.setInt (4, schoolyear);
          
            ResultSet rs = pstmt.executeQuery();   

            while (rs.next()) {
                studentid    = rs.getLong("studentid");
                courseid     = rs.getString("courseid");
                term         = rs.getInt("term");
                schoolyear   = rs.getInt("schoolyear");
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
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM enroll");
            
            ResultSet rs = pstmt.executeQuery();   

            enrollmentList.clear();
            while (rs.next()) {
                enrollment e = new enrollment ();                
                e.studentid    = rs.getLong("studentid");
                e.courseid     = rs.getString("courseid");
                e.term         = rs.getInt("term");
                e.schoolyear   = rs.getInt("schoolyear");
                enrollmentList.add(e);
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
       
	enrollment  nroll = new enrollment();
			
	/*
        nroll.studentid = 10100001;
	nroll.courseid = "CCICOMP";
	nroll.term = 2;
	nroll.schoolyear=20192020;
	nroll.addRecord(); 
        */
        
        /*
        nroll.studentid = 10100001;
	nroll.courseid = "CCICOMP";
	nroll.term = 2;
	nroll.schoolyear=20192020;
        
	nroll.modcourseid = "CCPROG3";
	nroll.modterm = 3;
	nroll.modschoolyear=20192020;
	
	nroll.modRecord();
        */
	
        /*
	nroll.studentid = 10100001;
	nroll.courseid = "CCINFOM";
	nroll.term = 2;
	nroll.schoolyear=20192020;
	nroll.delRecord();
	*/
        
        /* 
	nroll.studentid = 10100002;
	nroll.courseid = "CCPROG2";
	nroll.term = 2;
	nroll.schoolyear=20192020;
        nroll.viewRecord();
	
        System.out.println(nroll.studentid);
        System.out.println(nroll.courseid);
        System.out.println(nroll.term);
        System.out.println(nroll.schoolyear);
        */
        
        /*        
        nroll.viewAllRecords();
        
        for (int i=0; i< nroll.enrollmentList.size(); i++) {
            enrollment a = new enrollment();
            a = nroll.enrollmentList.get(i);
            System.out.println(a.studentid);
            System.out.println(a.courseid);
            System.out.println(a.term);
            System.out.println(a.schoolyear);
            System.out.println ("-----");    
        }
        */
        
    }
}
									