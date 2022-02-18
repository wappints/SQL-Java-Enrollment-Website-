<%-- 
    Document   : drop_process
    Created on : 02 4, 21, 11:32:20 AM
    Authors    : CCINFOM GRP3 S11 (Tendido, Dy, Norona, Bacayan)
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dropping of Course</title>
        <style>
            .page-header {
            padding-bottom: 9px;
            margin: 40px 0 20px;
            border-bottom: 1px solid #eee;
            }
              
            .h1, h1 {
            font-size: 36px;
            }

            .h1, .h2, .h3, h1, h2, h3 {
            margin-top: 20px;
            margin-bottom: 10px;
            }
            
            .h1, .h2, .h3, .h4, .h5, .h6, h1, h2, h3, h4, h5, h6 {
            font-family: inherit;
            font-weight: 500;
            line-height: 1.1;
            color: inherit;
            }

            .container {
            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            width: 970px;
            }
            
           .list-group-item:first-child {
            border-radius: 4px;
            margin-bottom: 0;
            }
            
            
            a.list-group-item:focus, a.list-group-item:hover, button.list-group-item:focus, button.list-group-item:hover {
            color: #555;
            text-decoration: none;
            background-color: #f5f5f5;
            }

            a.list-group-item, button.list-group-item {
            color: #555;
            text-decoration: none;
            }

            .list-group-item {
            position: relative;
            display: block;
            padding: 10px 15px;
            margin-bottom: -1px;
            background-color: #fff;
            border: 1px solid #ddd;
            }
            
            body {   
            font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
            font-size: 14px;
            line-height: 1.42857143;
            color: #333;
            background-color: #fff;
            } 
            
            * {
            box-sizing: border-box;
            }
            
            .btn {
            border: 1px solid black;            
            padding: 10px 15px;
            cursor: pointer;
            border-radius: 4px;
            
            font-family: inherit;
            font-size: inherit;
            line-height: inherit;
            background-color: inherit;
            
            border: 1px solid #ddd;
            color: inherit;
            margin-right: 5px;
               
            }

            /* Green */ 
            .success:hover {
            border: 1.5px solid #ddd;
            background-color: #4CAF50;
            color: white;
            }
            
            /* Blue*/ 
            .info:hover {
            border: 1.5px solid #ddd;
            background-color: #2196F3;
            color: white;
            }
            
            /* Red*/ 
            .danger:hover {
            border: 1.5px solid #ddd;
            background-color: #f44336;
            color: white;
            }            

            /* Full-width input fields */
            input[type=text] {
            width: 35%;
            padding: 15px;
            margin: 0px 0 12px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
            font-family: inherit;
            font-size: inherit;
            line-height: inherit;
            margin-right: 10px;
            }

            input[type=text]:focus {
            background-color: #ddd;            
            outline: none;
            }
            
            
            table {
            border-collapse: collapse;
            border-spacing: 0;
            width: 75%;
            border: 1px solid #ddd;
            }

            th, td {
            text-align: left;
            padding: 16px;
            }
            
            tr:nth-child(even) {
            background-color: #f2f2f2;
            }
            
            .floated {
            float:left;
            margin-right:5px;
            }  
                       
            form{
            display: inline;
            }
            
            select{
            
            border: 1px solid black;            
            padding: 10px 15px;
            cursor: pointer;
            border-radius: 4px;
            
            font-family: inherit;
            font-size: inherit;
            line-height: inherit;
            
            border: 1px solid #ddd;
            color: inherit;   
            }
                        
        </style>
    </head>
    <body>
        <div class="container">
            
            <jsp:useBean id="studBean" class="enrollment.students" scope="session"/>
            <% 
                long studid;
                int cterm;
                int schoolyear;
   
                if(request.getSession().getAttribute("studid") == null ) {
                
                    studBean.studentid = Long.parseLong(request.getParameter("studid"));
                    studBean.viewRecord();
                
                    cterm = Integer.parseInt(request.getParameter("cterm"));
                    schoolyear = Integer.parseInt(request.getParameter("schoolyear"));
                    studid = Long.parseLong(request.getParameter("studid"));

                    session.setAttribute("term", cterm);
                    session.setAttribute("year", schoolyear);
                    session.setAttribute("studid", studid);
                } 

                else {
                    studBean.studentid = (long) request.getSession().getAttribute("studid");
                    studid = (long)request.getSession().getAttribute("studid");
                    cterm = (int)request.getSession().getAttribute("term");
                    schoolyear = (int) request.getSession().getAttribute("year");
                }

            %>
        
            <div class="page-header">
               <h1> Dropping of Courses </h1>
            </div>
            
            <p> Student ID : <%=studBean.studentid%></p>
            <p> Name : <%=studBean.completename%></p>
            <p> Degree: <%=studBean.degreeid%></p>
            <p> Current Term: <%=cterm%></p>
            <p> Current SY: <%=schoolyear%></p>
            
            <br>
            
            
            <jsp:useBean id="courseBean" class="enrollment.drop" scope ="session"/>
            <%  courseBean.Student.studentid = (long) studBean.studentid;
                courseBean.loadEnrollment(cterm, schoolyear);
            %>
        
            <table>
                <tr>
                    <th> Student ID </th>
                    <th> Course ID </th>
                    <th> Term </th>
                    <th> School year </th>
                </tr>
  
                <tr>
                    <% for (int i = 0; i < courseBean.CourseEnrolledList.size(); i++) { %>
                    <td><%=courseBean.CourseEnrolledList.get(i).studentid%></td>
                    <td><%=courseBean.CourseEnrolledList.get(i).courseid%></td>
                    <td><%=courseBean.CourseEnrolledList.get(i).term%></td>
                    <td><%=courseBean.CourseEnrolledList.get(i).schoolyear%></td>
                </tr>
            <% } %>
      
            </table>
            
            
            <br>
            <p> Select Course to Drop </p>
            <form name="courseid" action="addtodrop.jsp" method="POST" >
                <input type ="text" id="courseid" name="courseid" class="floated"> 
                <button class="btn success" value="Add to Drop" id="courseid" name="courseid">Add to Drop</button>
            </form>
                                   
            
            <form name="Confirm" action="submitdrop.jsp" method="POST" >
                <button class="btn info" value="Submit">Confirm Drop</button>                               
            </form>
            
            
            <form name="Reset" action="resetdrop.jsp" method="POST" >
                <button class="btn danger" value="Reset">Reset Drop</button>
            </form>
            <br><br><br>
                       
            <table>
                <tr>
                    
                    <th colspan="4" style = "text-align: center">TO BE DROPPED COURSES</th>
                </tr>
                <tr>
                    <th> Student ID </th>
                    <th> Course ID </th>
                    <th> Term </th>
                    <th> School year </th>
                </tr>
          
            <%  for(int i = 0; i < courseBean.DropEnrolledList.size(); i++) { %>
                <tr>
                    <td><%=courseBean.DropEnrolledList.get(i).studentid%></td>
                    <td><%=courseBean.DropEnrolledList.get(i).courseid%></td>
                    <td><%=courseBean.DropEnrolledList.get(i).term%></td>
                    <td><%=courseBean.DropEnrolledList.get(i).schoolyear%></td>
                </tr>
            <% } %>
            </table>
            <br><br>
            <div class="list-group">
                <a href="cancel.jsp" class="list-group-item">Return to Main Menu</a><br>
            </div>
         
        </div> 
    </body>
</html>
