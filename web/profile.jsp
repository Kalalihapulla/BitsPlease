
<%-- 
    Document   : userDash
    Created on : Feb 26, 2017, 5:14:20 PM
    Author     : Jere
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Project Bits | Profile</title>

        <meta charset="utf-8" />
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

        <!-- JavaScript -->

        <script src="vendor/jquery/jquery.js"></script>
        <script src="javasscript/grayscale.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="javascript/script.js"></script>
        <script src="javascript/script2.js"></script>

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

        <div class='container' id='main'>
            <h1 class="page-header">Edit Profile</h1>
            <div class="row">
                <div class="col-md-4 col-sm-6 col-xs-12">
                    <div class="text-center" id = "trump">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/d/d2/Donald_Trump_August_19,_2015_(cropped).jpg" style="width:50%;height:50%;" class="avatar img-circle img-thumbnail" alt="avatar">
                        <h6>This is you, you have the best words</h6>
                    </div>
                </div>

                <div class="col-md-8 col-sm-6 col-xs-12 personal-info" style="padding-right: 2em;">
                    <h3>Personal info</h3>
                    <form class="form-horizontal center-block" id="myForm" role="form">
                        <div class="form-group">
                            <label class="col-lg-3 control-label">First name:</label>
                            <div class="col-lg-8">
                                <input class="form-control" value="" id="fnameT" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Last name:</label>
                            <div class="col-lg-8">
                                <input class="form-control" value="" id="lnameT" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Position:</label>
                            <div class="col-lg-8">
                                <input class="form-control" value="" id="positionT" type="text" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Email:</label>
                            <div class="col-lg-8">
                                <input class="form-control" id="emailT" value="" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">New password:</label>
                            <div class="col-md-8">
                                <input class="form-control" value="" type="password" id = "nPass">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">New password again:</label>
                            <div class="col-md-8">
                                <input class="form-control" value="" type="password" id = "nPass2">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Old password(requirement):</label>
                            <div class="col-md-8">
                                <input class="form-control" value="" type="password" id = "oPass">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label"></label>
                            <div class="col-md-8">
                                <input class="btn btn-primary" id ="change" value="Save Changes" type="button" onSubmit="" onclick="  var userId = '${loggedInUser}'; var oPass = $('#oPass').val(); var nPass = $('#nPass').val();var nPass2 = $('#nPass2').val(); checkPass(userId, oPass, nPass, nPass2);">
                                <span></span>
                                <input class="btn btn-default" value="Cancel" type="button" onclick="location.reload();"
                            </div>
                        </div>
                </div>
                </form>
            </div>
        </div>
    </div>

</body>
<script>
    $(document).ready(function () {
        var userId = '${loggedInUser}';
        updateProfile(userId);
        var audioElement = document.createElement('audio');
        audioElement.loop = false;
        audioElement.setAttribute('src', 'noot.mp3');
        $('#trump').click(function () {
            audioElement.play();
            $('#trump').effect("shake");
        });
    });
</script>

</html>
