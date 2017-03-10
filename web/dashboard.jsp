<%-- 
    Document   : Dashboard
    Created on : Feb 13, 2017, 12:23:17 PM
    Author     : samuelja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Project Bits | About</title>

        <meta charset="utf-8" />
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <script src="vendor/jquery/jquery.js"></script>

        <!-- Theme JavaScript -->
        <script src="js/grayscale.min.js"></script>

        <link rel="stylesheet"
              href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Dosis' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Aldrich' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <script src="javascript/script.js"></script>
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

        <!-- Theme CSS -->
        <script src="javascript/icheck.js"></script>
        <link href="skins/square/red.css" type="text/css" rel="stylesheet">
        <link href="skins/square/yellow.css" type="text/css" rel="stylesheet">
        <link href="skins/square/green.css" type="text/css" rel="stylesheet">
        <link href="css/grayscale.min.css" rel="stylesheet">
        <link href="css/grayscale.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/styles.css">


        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    </head>
    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">


        <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="index.jsp">
                    <i class="fa fa-terminal"></i> <span class="light">Bits</span> Please
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-center navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <c:if test="${empty loggedInUser}">
                        <li><a href='signup.jsp'>Sign Up</a></li>
                        </c:if>
                    <li><a href='dashboard.jsp'>Dashboard</a></li>
                        <c:if test="${not empty loggedInUser}">
                        <li><a href='userDash.jsp'>User dashboard</a></li>
                        <li><a href='messages.jsp'>Messages</a></li>
                        <li><a href="mailbox.jsp">Mailbox</a></li>
                        </c:if>
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
            <!-- /.navbar-collapse -->
            <!-- /.container -->
        </nav>
        <c:if test="${not empty loggedInUser}">
            <div id='addNote'>
                <button type="button" class="btn btn-primary btn-lg" id='noteButton' name='noteButton'>+</button>
            </div>
        </c:if>


        <div class='container' id='main'>

            <div class='row index-row' id='info'>
                <h1 id='dashboard' class='text-center'>Dashboard</h1>

                <c:if test="${not empty loggedInUser}">

                    <div class='row' style='width:100vw;'>
                        <div class='col-xs-3'>
                    <div id="dropShelf" class="droppable droppableleft ui-widget-header">
                        SHELVERS
                    </div>

                    <div id="dropChef" class="droppable droppableleft ui-widget-header">
                        CHEFS
                    </div>
                        </div>
                        <div class='col-xs-6' id='notes'></div>
                    <div class='col-xs-3'>
                    <div id="dropJan" class="droppable droppableright ui-widget-header">
                        JANITORS
                    </div>
                    <div id="dropCash" class="droppable droppableright ui-widget-header">
                        CASHIERS
                    </div>
                        <div>
                    </div>
                </c:if>

                <c:if test="${empty loggedInUser}">
                    <h3 class='text-center'>You have no privileges as you're not logged in. Forgot to <a href="signup.jsp">sign up?</a></h3>
                </c:if>
            </div>


        </div>





    </body>
</html>
