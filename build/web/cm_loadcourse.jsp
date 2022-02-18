<%-- 
    Document   : cm_loadcourse
    Created on : 02 4, 21, 7:45:27 AM
    Authors    : CCINFOM GRP3 S11 (Tendido, Dy, Norona, Bacayan)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Maintenance - CCINFOM</title>
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
           
        </style>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Load Course Records</h1>  
            </div>
            <div class="list-group">
                
                <jsp:useBean id="coursesBean" class="enrollment.courses" scope="session" />
                <jsp:useBean id="coursesTemp" class="enrollment.courses" scope="page"    />
                <% coursesBean.viewAllRecords(); %>
                Complete Course Records on Enrollment Database<br><br>
                <table>
                    <tr>
                        <th>Course ID</th>
                        <th>Course Name</th>
                        <th>Department ID</th>
                    </tr>
                    <%  coursesBean.viewAllRecords();
                        for (int i=0; i<coursesBean.courselist.size(); i++) {
                           coursesTemp = coursesBean.courselist.get(i);
                    %>
                    <tr>
                        <td><%=coursesTemp.courseid%></td>
                        <td><%=coursesTemp.coursename%></td>
                        <td><%=coursesTemp.department%></td>
                    </tr>
                    <% }
                    %>
                </table>
                <br>
                <br>
                <div class="list-group">
                <a href="coursemaintenance.jsp" class="list-group-item">Return to Course Maintenance</a><br>
                </div>
            </div>
        </div>
    </body>
</html>


