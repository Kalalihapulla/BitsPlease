<%-- 
    Document   : Dashboard
    Created on : Feb 13, 2017, 12:23:17 PM
    Author     : samuelja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Project Bits | Dashboard</title>

        <meta charset="utf-8" />
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

        <!-- JavaScript -->

        <script src="javascript/jquery.js"></script>
        <script src="javascript/grayscale.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="javascript/script.js"></script>
        <script src="javascript/icheck.js"></script>

        <!-- CSS -->

        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <link href="skins/square/red.css" type="text/css" rel="stylesheet">
        <link href="skins/square/yellow.css" type="text/css" rel="stylesheet">
        <link href="skins/square/green.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link href="css/grayscale.css" rel="stylesheet">

        <!-- Load JSTL -->

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
            <div class="collapse navbar-collapse navbar-center navbar-main-collapse">
                <ul class="nav navbar-nav">
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
                            <div id="dropStore" class="droppable droppableleft ui-widget-header">
                                STOREKEEPERS
                            </div>
                            <div id="dropMana" class="droppable droppableleft ui-widget-header">
                                MANAGEMENT
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
                        </c:if>

                        <c:if test="${empty loggedInUser}">
                            <h3 class='text-center'>You have no privileges as you're not logged in. Forgot to <a href="signup.jsp">sign up?</a></h3>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
