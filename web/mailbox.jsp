<%-- 
    Document   : signup
    Created on : Feb 7, 2017, 12:35:45 PM
    Author     : samuelja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Project Bits | Sign up!</title>

        <meta charset="utf-8" />
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

        <link rel="stylesheet"
              href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Dosis' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Aldrich' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link href="css/grayscale.min.css" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <script src="jquery-3.1.1.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="javascript/script.js"></script>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    </head>
    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
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

        <div class='container' id='main'>
            <div class='row index-row' id='info'>
                <h1 class="page-header" style="padding-left: 1em;">Inbox</h1>
            </div>
            <div class='container-fluid' id='back'>
                <div class="row">
                    <div class="box-body no-padding">
                        <div class="mailbox-controls">
                            <!-- Check all button -->
                            <button class="btn btn-default btn-sm checkbox-toggle"><i class="glyphicon glyphicon-unchecked"></i></button>
                            <div class="btn-group">
                                <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-trash"></i></button>
                                <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-arrow-left"></i></button>
                                <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-share-alt"></i></button>
                            </div><!-- /.btn-group -->
                            <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-refresh"></i></button>
                            <div class="pull-right">
                                1-50/200
                                <div class="btn-group">
                                    <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-arrow-left"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-arrow-right"></i></button>
                                </div><!-- /.btn-group -->
                            </div><!-- /.pull-right -->
                        </div>
                        <hr>
                        <div class="table-responsive mailbox-messages">
                            <table class="table table-striped" id="mailtable">
                                <tbody>
                                    <tr data-toggle="collapse" data-target="#demo1" class="accordion-toggle">
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-name"><a href="readmail.jsp">WM06</a></td>
                                        <td class="mailbox-subject"><b>WM06</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-date">5 mins ago</td>
                                    </tr>
                                    <tr>
                                        <td colspan="12" class="hiddenRow"><div class="accordian-body collapse" id="demo1"> 
                                                <div>Message goes here.</div>                  
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-name"><a href="readmail.jsp">WM06</a></td>
                                        <td class="mailbox-subject"><b>WM06</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-date">5 mins ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-name"><a href="readmail.jsp">WM06</a></td>
                                        <td class="mailbox-subject"><b>WM06</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-date">28 mins ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-name"><a href="readmail.jsp">WM06</a></td>
                                        <td class="mailbox-subject"><b>WM06</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-date">11 hours ago</td>
                                    </tr>
                                </tbody>
                            </table><!-- /.table -->
                        </div><!-- /.mail-box-messages -->
                    </div><!-- /.box-body -->
                    <hr>
                    <div class="box-footer no-padding">
                        <div class="mailbox-controls">
                            <!-- Check all button -->
                            <button class="btn btn-default btn-sm checkbox-toggle"><i class="glyphicon glyphicon-unchecked"></i></button>
                            <div class="btn-group">
                                <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-trash"></i></button>
                                <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-arrow-left"></i></button>
                                <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-share-alt"></i></button>
                            </div><!-- /.btn-group -->
                            <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-refresh"></i></button>
                            <div class="pull-right">
                                1-50/200
                                <div class="btn-group">
                                    <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-arrow-left"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-arrow-right"></i></button>
                                </div><!-- /.btn-group -->
                            </div><!-- /.pull-right -->
                        </div>
                    </div>
                </div><!-- /. box -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </body>
</html>