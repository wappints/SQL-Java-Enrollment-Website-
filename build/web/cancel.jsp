<%-- 
    Document   : cancel
    Created on : 02 4, 21, 11:18:01 PM
    Authors    : CCINFOM GRP3 S11 (Tendido, Dy, Norona, Bacayan)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            session.invalidate();
            response.sendRedirect("index.html");
        %>
    </body>
</html>
