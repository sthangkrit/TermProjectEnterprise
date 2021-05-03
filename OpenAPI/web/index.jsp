<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
<head>
    <title></title>
</head>

<body>
    <h3> ASEAN Information </h3>

    <form action="OpenAPIServlet" method="post">

    <h4> Choose API: </h4>
         <input type=radio name="select" value="1">นักท่องเที่ยวในแต่ละปีของอาเซียน <br><br>
         <input type=radio name="select" value="2">การว่างงานของประเทศในอาเซียน <p>

       &nbsp &nbsp <input type=submit value="Submit">
     </form>
</body>
</html>