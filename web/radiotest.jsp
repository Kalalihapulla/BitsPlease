<%-- 
    Document   : radiotest
    Created on : 10-Mar-2017, 20:43:59
    Author     : Samu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="square/red.css" rel="stylesheet">
        <link href="square/blue.css" rel="stylesheet">
        <script src="javascript/jquery.js"></script>
        <script src="javascript/icheck.js"></script>
        <script>
            $(document).ready(function () {
                $('#high').iCheck({
                    checkboxClass: 'icheckbox_square-red',
                    radioClass: 'iradio_square-red',
                    increaseArea: '20%' // optional
                });
                $('#medium').iCheck({
                    checkboxClass: 'icheckbox_square-yellow',
                    radioClass: 'iradio_square-yellow',
                    increaseArea: '20%' // optional
                });
                $('#low').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                    increaseArea: '20%' // optional
                });
                
            });
        </script>
    </head>
    <body>
        <form>
            <input type="radio" id="yolo" name="iCheck" value="male" checked> Male<br>
            <input type="radio" name="iCheck" value="female"> Female<br>
            <input type="radio" name="iCheck" value="other"> Other
        </form>
    </body>
</html>
