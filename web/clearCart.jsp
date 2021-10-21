<%-- 
    Document   : clearCart
    Created on : 02 3, 21, 3:12:35 AM
    Authors    : CCINFOM GRP3 S11 (Tendido, Dy, Norona, Bacayan)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clear Cart</title>
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
           
        </style>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Reset Cart Configuration</h1>
            </div> 
        
            <jsp:useBean id="coursesBean" class="enrollment.enroll" scope="session" />
            <% 
                int clearResult = coursesBean.clearEnrollment();

                if(clearResult == 1) { 
                %> 
                <p>Successfully Cleared the Cart. Thank you.</p>
            <%} else {%> 
                <p>There was a problem clearing the cart. </p>
            <% } %>    
            
            <br>
            <div class="list-group">
                <a href="enroll_process.jsp" class="list-group-item">Return to Enrollment Page</a><br>
            </div> 
        </div>
    </body>
</html>
