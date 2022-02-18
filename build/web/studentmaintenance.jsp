<%-- 
    Document   : studentmaintainance
    Created on : 02 3, 21, 5:48:08 PM
    Authors    : CCINFOM GRP3 S11 (Tendido, Dy, Norona, Bacayan)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Maintenance - CCINFOM</title>
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

            .list-group-item:nth-child(5) {
            margin-bottom: 0;
            border-bottom-right-radius: 4px;
            border-bottom-left-radius: 4px;
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
            
        </style>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Student Maintenance</h1>  
            </div>
            <div class="list-group">
                
                <a href="addstudent.jsp" class="list-group-item">Add Student Data</a>
                <a href="modstudent.jsp" class="list-group-item">Modify Student Data</a>
                <a href="delstudent.jsp" class="list-group-item">Delete Student Data</a>
                <a href="loadstudent.jsp" class="list-group-item">Load Student Records</a>
                <a href="recordmanagement.jsp" class="list-group-item">Return to Record Management</a><br>
                
            </div>
        </div>
    </body>
</html>

