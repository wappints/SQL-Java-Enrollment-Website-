/*
 * Author: Tendido, Dy, Norona, Bacayan     
 *         CCINFOM S11
 */

package enrollment;
import java.sql.*;
import java.util.*;

public class enroll {
    public students                 Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<coursedegree>  CourseList      = new ArrayList<> ();
	public ArrayList<enrollment> CoursesEnrolled = new ArrayList<> ();
 
    // perform all the necessary data loading from DB
    public enroll() {
        EnrollmentList.clear();
        CourseList.clear();        
    }; 
    
    // clears enrollment data of the student 
    public int clearEnrollment () {   
		EnrollmentList.clear();
		return 1;
    };
	
    // load valid courses into the course list
    public int loadCourses () {
	try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful.");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM coursedegree WHERE degree=?");
            pstmt.setString(1, Student.degreeid);
            
            ResultSet rs = pstmt.executeQuery();
            CourseList.clear();
            
            while (rs.next()) {
            	coursedegree cd = new coursedegree();
            	cd.courseid     = rs.getString("courseid");
		cd.degree       = rs.getString("degree");
		CourseList.add(cd);
            }	
    	
            pstmt.close();
            conn.close();
            return 1; // Return 1 if successful

	} catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
	}    
    }

    public int addEnrollment (String courseid, int term, int schoolYear) {
        try {
     
            enrollment temp_e = new enrollment();
            temp_e.studentid = Student.studentid;
            temp_e.courseid = courseid;
            temp_e.term = term;
            temp_e.schoolyear = schoolYear;
            EnrollmentList.add(temp_e);
            return 1;
            
	} catch (Exception e) {
            System.out.println(e);
            return 0;
	}
    }
    
    public int delEnrollment(String courseid, int term, int schoolYear) {
        try {
            for (int i = 0; i < EnrollmentList.size(); i++){
                enrollment temp_d = EnrollmentList.get(i);
                if (temp_d.courseid.equals(courseid) && temp_d.term == term && temp_d.schoolyear == schoolYear)
                    EnrollmentList.remove(temp_d);
            }
            return 1;
            
	} catch (Exception e) {
            System.out.println(e);
            return 0;
	}
    };
    public int loadEnrollment (int term, int schoolYear) {
		
		try {
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
			System.out.println("Connection Successful.");
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM enrollment WHERE studentid=? AND term=? AND schoolyear=?");
			pstmt.setLong(1, Student.studentid);
			pstmt.setInt(2, term);
			pstmt.setInt(3, schoolYear);
			
			ResultSet rs = pstmt.executeQuery();
			CoursesEnrolled.clear();
			
			while(rs.next()) {
				enrollment enrolled_temp = new enrollment();
				enrolled_temp.studentid = rs.getLong("studentid");
				enrolled_temp.courseid = rs.getString("courseid");
				enrolled_temp.term = rs.getInt("term");
				enrolled_temp.schoolyear = rs.getInt("schoolyear");
				CoursesEnrolled.add(enrolled_temp);
			}
			
			pstmt.close();
			conn.close();
			return 1;		
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return 0;
			}
		
	}
	
	
    public int confirmEnrollment() {
        try {           
            
            for (int i = 0; i < EnrollmentList.size(); i++) {
                
                enrollment nroll = EnrollmentList.get(i);
                nroll.addRecord();    
            } 
            return 1;
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    } 

}