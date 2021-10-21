/*
 * Author: Tendido, Dy, Norona, Bacayan     
 *         CCINFOM S11
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;
import java.sql.*;
import java.util.*;

public class report {
    
    
    public  ArrayList<courses>      CourseList       =  new ArrayList<>();
    public  ArrayList<Integer>      CountList        =  new ArrayList<>();
    public  int term; 
    public  int schoolyear;
    
    public report() {
        CourseList.clear();
        CountList.clear();
        term = 0;
        schoolyear = 0;
    }; 
    
    public int resetReport() { 
        CourseList.clear();
        CountList.clear();        
	return 1;
    }
    
    
    public int generateReport(){
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful.");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT   courseid, COUNT(studentid) AS 'TOTALSTUDENTS'" +
                                                            "FROM     enrollment "                                   +
                                                            "WHERE    term=? AND schoolyear=? "                      +
                                                            "GROUP BY courseid");  
            
            pstmt.setInt(1, this.term);
            pstmt.setInt(2, this.schoolyear);
            
            ResultSet rs = pstmt.executeQuery();            
            
            while (rs.next()) { 
                courses c  = new courses();
                
                c.courseid = rs.getString("courseid");
                c.viewRecord();
                CourseList.add(c);
                
                CountList.add(rs.getInt("TOTALSTUDENTS"));    
                
            }
            rs.close();
            pstmt.close();
            conn.close();
            return 1; // Return 1 if successful
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }      
    }
    
    public static void main(String args[]){
        /*        
        report rep = new report();
        
        rep.term = 1;
        rep.schoolyear = 20192020;        
        rep.generateReport();
        
        
        rep.term = 2;
        rep.schoolyear = 20192020;         
        rep.generateReport();
                
        rep.resetReport();        
        
        for (int i = 0; i < rep.CourseList.size(); i++) {
                        
            courses a = rep.CourseList.get(i);            
            int b = rep.CountList.get(i);
            
            System.out.println("courseid:       " + a.courseid);
            System.out.println("coursename:     " + a.coursename);
            System.out.println("total students: " + b);
            System.out.println ("-----"); 
        }
        
        */
    }
}
