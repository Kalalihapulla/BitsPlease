<%-- 
    Document   : userDash
    Created on : Feb 26, 2017, 5:14:20 PM
    Author     : Jere
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <!--Head-->
    <head>
        <title>Project Bits | User Dash</title>
 
        <meta charset="utf-8" />
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <script src="vendor/jquery/jquery.js"></script>
 
        <!-- JavaScript -->
       
        <script src="javascript/grayscale.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
        <script src="javascript/script.js"></script>
       
        <!-- CSS -->
       
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <link href='https://fonts.googleapis.com/css?family=Dosis' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Aldrich' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="css/grayscale.min.css" rel="stylesheet">
        <link href="skins/square/red.css" type="text/css" rel="stylesheet">
        <link href="css/grayscale.min.css" rel="stylesheet">
       
        <script>
            $(document).ready(function () {
                var user = "${loggedInUser}";
                getUserd(user);
            });
        </script>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
    </head>
    <!--Body -->
    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!--Nav bar start-->
        <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="index.jsp">
                    <i class="fa fa-terminal"></i> <span class="light">Bits</span> Please
                </a>
            </div>

            <!--Signup-->
            <div class="collapse navbar-collapse navbar-center navbar-main-collapse">
                <ul class="nav navbar-nav">                  
                    <c:if test="${empty loggedInUser}">
                        <li><a href='signup.jsp'>Sign Up</a></li>
                        </c:if>
                  <li><a href='dashboard.jsp'>Create tasks</a></li>
                    <li><a href='userDash.jsp'>User dashboard</a></li>
                    <li><a href='messages.jsp'>Messages</a></li>
                    <li><a href="mailbox.jsp">Mailbox</a></li>
                </ul>
                <c:if test="${not empty loggedInUser}">
                    <form class='navbar-form navbar-right' method='post' style='padding-right: 2em;' action='login' >
                        <input class='form-control btn btn-info note-input' type='submit' value='Log Out' name='submit'>
                    </form>
                    <form class='navbar-form navbar-right' method='post' action='profile.jsp' >
                        <button class='form-control btn btn-info note-input' onClick="location.href = 'profile.jsp';" name='profile'>Profile</button>
                    </form>

                </c:if>
                <c:if test="${empty loggedInUser}">
                    <form class='navbar-form navbar-right' style='padding-right: 2em;' method='post' action='login' >
                        <div class='form-group'>
                            <input class='form-control note-input' placeholder='Email' type='email' name='email' />
                        </div>
                        <div class='form-group'>
                            <input class='form-control note-input' placeholder='Password' type='password' name='pass' />
                        </div>
                        <input class='form-control btn btn-info note-input' type='submit' value='Log In' name='submit'>
                    </form>
                </c:if>
            </div>
        </nav>
        
        <!--Main container -->
        <div class='container' id='main'>
            <div id="dashpage">
                <div class='row index-row' id='info'>
                    <h1 id='dashboard' class='text-center'>User Dashboard</h1>
                    <div id="deletenote">
                        Delete note 
                    </div>
                </div>

                <div id="taskinfo">

                </div> 

                <div id="taskboxbackground">

                    <div class="taskheader">
                        Available tasks
                    </div>

                    <div class="taskheader">
                        In progress
                    </div>

                    <div class="taskheader">
                        Completed tasks
                    </div> 


                    <div id="sortable1" class="taskBox row grid span8">

                    </div>

                    <div id="sortable2" class="taskBox row grid span8">

                    </div>

                    <div id="sortable3" class="taskBox row grid span8">

                    </div>

                </div>          

            </div>
        </div>´
    </body>
</html>



