<%-- 
    Document   : signup
    Created on : Feb 7, 2017, 12:35:45 PM
    Author     : samuelja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--Head-->
    <head>
        <title>Project Bits | Sign up</title>

        <meta charset="utf-8" />
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

        <!--Javascript-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
        <script src="jquery-3.1.1.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="javascript/script.js"></script>
        <script src="javascript/script2.js"></script>
        <script src="jquery.selectbox.min.js" type="text/javascript"></script>


        <!--CSS-->
        <link rel="stylesheet"href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
        <link href='https://fonts.googleapis.com/css?family=Dosis' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Aldrich' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link href="css/grayscale.min.css" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="jquery.selectbox.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

        <!-- Load JSTL -->
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    </head>

    <!--Body-->
    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!--Navbar start-->
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
                        </c:if>
                </ul>
                <c:if test="${not empty loggedInUser}">
                    <form class='navbar-form navbar-right' method='post' action='login' >
                        <p id='loggedIn'>Welcome ${loggedInUser}</p>
                        <input class='form-control btn btn-info note-input' type='submit' value='Log Out' name='submit'>
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

        <!--Main container-->
        <div class='container' id='main'>
            <div class='row index-row' id='info'>
                <h1 id='title' class='text-center'>Bits Please</h1>
            </div>
            <div class='container-fluid' id='back'>
                <h3 class='text-center'>Sign up today!</h3>
                <h4 class='text-center'>Please enter your email and password. The password must be more than 4 characters long.</h4>

                <div class='row index-row'>
                    <div class='col-md-6 col-md-offset-3' >
                        <div class='container-fluid' id='login'>
                            <!--Sign in form-->
                            <form class="form-signin" method='post' onSubmit="return validate()" action='signup' id='myForm' name='myForm'>
                                <label for="fName" class="sr-only">First name</label>
                                <input type="text" name='fName' id="fName" class="form-control" placeholder="First name" required="" autofocus="">
                                <label for="lName" class="sr-only">First name</label>
                                <input type="text" name='lName' id="lName" class="form-control" placeholder="Last name" required="" autofocus="">
                                <label for="email" class="sr-only">Email address</label>
                                <input type="email" name='email' id="email" class="form-control" placeholder="Email address" required="" autofocus="">
                                <label for="pass" class="sr-only">Password</label>
                                <input type="password" name='pass' id="pass" class="form-control" placeholder="Password" required="">
                                <label for="repeat" class="sr-only">Password</label>
                                <input type="password" name='repeat' id="repeat" class="form-control" placeholder="Repeat password" required="">
                                <div style="padding-bottom: 10px">
                                    <select class="form-control" placeholder="Choose job description" id="job">
                                        <option>Management</option>
                                        <option>Janitor</option>
                                        <option>Storekeeper</option>
                                        <option>Cashier</option>
                                    </select>
                                </div>
                                <button class="btn btn-lg btn-primary btn-block" id="cUser" type="submit">Sign Up</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>