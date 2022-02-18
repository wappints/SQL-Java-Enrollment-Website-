<%-- 
    Document   : generatereport
    Created on : 02 3, 21, 1:07:40 AM
    Authors    : CCINFOM GRP3 S11 (Tendido, Dy, Norona, Bacayan)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.sql.*, java.util.*" %> 
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generating Report From Query</title>
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
            border-top-left-radius: 4px;
            border-top-right-radius: 4px;
            }
            
            .list-group-item:nth-child(2) {
            border-bottom-left-radius: 4px;
            border-bottom-right-radius: 4px;
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
            <div class="page-header">
               <h1>Generated Report</h1>
            </div>

            <jsp:useBean id="reportsBean" class="enrollment.report" scope="page" />
            <%  reportsBean.term     = Integer.parseInt(request.getParameter("term"));
                reportsBean.schoolyear    = Integer.parseInt(request.getParameter("schoolyear"));
                if (reportsBean.generateReport()!=0) {
            %>
            Generation of a report of term <%=reportsBean.term%> and School Year <%=reportsBean.schoolyear%> was successful <br>

            <p>Current Term: <%=reportsBean.term%>
            <p>School Year: <%=reportsBean.schoolyear%> </p>

            <br>
            <h3>Courses offered </h3>

            <% reportsBean.term = reportsBean.term; %>
            <% reportsBean.schoolyear = reportsBean.schoolyear; %>

            <table>
                <tr>
                    <th>Course ID </th> <th> Course Name </th> <th> Total Enrolled Students</th>
                </tr>
            <%  for(int i = 0; i < reportsBean.CourseList.size(); i++) { %>
                <tr>
                    <td><%=reportsBean.CourseList.get(i).courseid%></td>
                    <td><%=reportsBean.CourseList.get(i).coursename%></td>
                    <td><%=reportsBean.CountList.get(i)%></td>

                </tr>
            <% } %>
            </table>

            <%
                } else {
            %>
            Generation of a report with term was not successful<br>
            <%
                }
            %>
            <br><br>
            <div class="list-group">
                <a href="report.jsp" class="list-group-item">Generate Another Report</a>
                <a href="index.html" class="list-group-item">Return to Main Menu</a><br>
            </div>
        </div>
    </body>
</html>