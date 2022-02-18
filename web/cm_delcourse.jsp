<%-- 
    Document   : cm_delcourse
    Created on : 02 3, 21, 10:02:16 PM
    Authors    : CCINFOM GRP3 S11 (Tendido, Dy, Norona, Bacayan)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deleting Existing Course - CCINFOM</title>
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
            }

            /* Red*/ 
            .danger:hover {
            border: 1.5px solid #ddd;
            background-color: #f44336;
            color: white;
            }

            /* Full-width input fields */
            input[type=text] {
            width: 45%;
            padding: 15px;
            margin: 0px 0 12px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
            font-family: inherit;
            font-size: inherit;
            line-height: inherit;
            }

            input[type=text]:focus {
            background-color: #ddd;            
            outline: none;
            }
           
        </style>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Enter the course details to delete:</h1>
            </div>
            <div> 
                <form name="cm_delcourse"   action="cm_delcourse_process.jsp" method="POST">
                    <p>Student ID </p>
                    <input type="text" name="courseid" id="courseid">
                    
                    <br><br>
                    <button class="btn danger" value="delete" name="delete">Delete</button>
                    <br><br><br>
                    
                </form>
                <div class="list-group">
                <a href="coursemaintenance.jsp" class="list-group-item">Back to Course Maintenance</a><br>
                </div>
            </div>
        </div>
    </body>
</html>
