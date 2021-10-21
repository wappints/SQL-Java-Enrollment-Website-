/*
 * Author: Tendido, Dy, Norona, Bacayan     
 *         CCINFOM S11
 */
package enrollment;
import java.sql.*;
import java.util.*;

public class drop {
  
    public students                        Student             = new students();
    public ArrayList<enrollment>    CourseEnrolledList  = new ArrayList<> ();
    public ArrayList<enrollment>    DropEnrolledList  = new ArrayList<> ();

    // perform all the necessary data loading from DB
    public drop() {
       
        CourseEnrolledList.clear();
        DropEnrolledList.clear();
    };  
    
    // clears dropping data of the student
    public int clearDrop () {
        DropEnrolledList.clear();
        return 1;    
    }   
    
    // load enrollment data of the student
    public int loadEnrollment (int term, int schoolyear) {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful.");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM enrollment WHERE studentid=? AND term=? AND schoolyear=?"); 
            pstmt.setLong(1, Student.studentid);
            pstmt.setInt(2, term);
            pstmt.setInt(3, schoolyear);
            
            ResultSet rs = pstmt.executeQuery();
            
            CourseEnrolledList.clear();            
            while (rs.next()) {
            	enrollment e   = new enrollment();
                e.studentid    = Student.studentid;
            	e.courseid     = rs.getString("courseid");
		e.term         = rs.getInt("term");
                e.schoolyear   = rs.getInt("schoolyear");
		CourseEnrolledList.add(e);
            }	
    	
            pstmt.close();
            conn.close();
            return 1; // Return 1 if successful

	} catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
	}
    }   
    
    public int addDrop (String courseid, int term, int schoolYear) {
        try {
     
            enrollment temp_e = new enrollment();
            temp_e.studentid = Student.studentid;
            temp_e.courseid = courseid;
            temp_e.term = term;
            temp_e.schoolyear = schoolYear;
            
            DropEnrolledList.add(temp_e);
            return 1;
            
	} catch (Exception e) {
            System.out.println(e);
            return 0;
	}
    }
    
    public int delDrop(String courseid, int term, int schoolYear) {
        try {
            for (int i = 0; i < DropEnrolledList.size(); i++){
                enrollment temp_d = DropEnrolledList.get(i);
                if (temp_d.courseid.equals(courseid) && temp_d.term == term && temp_d.schoolyear == schoolYear)
                    DropEnrolledList.remove(temp_d);
            }
            return 1;
            
	} catch (Exception e) {
            System.out.println(e);
            return 0;
	}
    }
    
    // saves dropping data into the Database
    public int confirmDrop() {
        try {           
            
            for (int i = 0; i < DropEnrolledList.size(); i++) {
                
                enrollment nroll = DropEnrolledList.get(i);
                nroll.delRecord();    
            } 
            return 1;
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public static void main(String args[]){
        drop dp = new drop();
                     
        /*
        students s = new students();
        s.studentid = 10100001;
        s.viewRecord();
        
        dp.Student = s;
        
        dp.loadEnrollment();
        
        /*
        for (int i = 0; i < dp.CourseEnrolledList.size(); i++){
            enrollment a = dp.CourseEnrolledList.get(i);
            
            System.out.println(a.studentid);
            System.out.println(a.courseid);
            System.out.println(a.term);
            System.out.println(a.schoolyear);
            System.out.println ("-----");    
        }
        */
        /*
                
        dp.addDrop("CCPROG", 1, 20192020);
        dp.addDrop("CCINFOM", 2, 20192020);
        
        /*
        for (int i = 0; i < dp.DropEnrolledList.size(); i++){
            enrollment a = dp.DropEnrolledList.get(i);
            
            System.out.println("studentid:    " + a.studentid);
            System.out.println("courseid:     " + a.courseid);
            System.out.println("term:         " + a.term);
            System.out.println("school year:  " + a.schoolyear);
            System.out.println ("-----"); 
        }
        */        
        
        // dp.delDrop("CCPROG", 1, 20192020);
                
        for (int i = 0; i < dp.DropEnrolledList.size(); i++){
            enrollment a = dp.DropEnrolledList.get(i);
            
            System.out.println("studentid:    " + a.studentid);
            System.out.println("courseid:     " + a.courseid);
            System.out.println("term:         " + a.term);
            System.out.println("school year:  " + a.schoolyear);
            System.out.println ("-----"); 
        }       
        
        
        dp.confirmDrop();  
    }
     
}

