<%-- 
    Document   : Dashboard
    Created on : Feb 12, 2017, 10:38:15 PM
    Author     : samuelja
--%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Bits Please</title>

        <!-- Javascript -->

        <script src="vendor/jquery/jquery.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="javascript/grayscale.js"></script>

        <!-- CSS -->

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="skins/square/red.css" type="text/css" rel="stylesheet">
        <link href="css/grayscale.min.css" rel="stylesheet">

        <!-- Load JSTL -->

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
            <div class="collapse navbar-collapse navbar-center navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <c:if test="${empty loggedInUser}">
                        <li><a href='signup.jsp'>Sign Up</a></li>
                        </c:if>
                  <li><a href='dashboard.jsp'>Create tasks</a></li>
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

        <!-- Main page header -->

        <header class="intro">
            <div class="intro-body">
                <div class="container polaroid">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <img src="css/stockmann.png" class="img-responsive center-block" style="width:90%;height:90%;">
                            <img src="css/deli.png" class="img-responsive center-block" style="width:25%;height:25%;">
                            <a href="#about" class="btn btn-circle page-scroll">
                                <i class="fa fa-angle-double-down animated"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <!-- About Section -->

        <section id="about" class="container content-section text-center">
            <div class="col-lg-8 col-lg-offset-2">
                <div>
                    <h3>NootPad</h3>
                    <div id='about'>
                        <p>
                            NootPad is a school project made in an effort to provide Stockmann Deli with an amazing user experience. NootPad provides the administration with a management tool that can be used to assign work for the users in a dynamic environment.  
                        </p>
                    </div>
                    <h3>Technical Details</h3>
                    <div id='about'>
                        <p>
                            NootPad uses modern web development tools, and runs from a remote web server using Amazon Web Service. 
                        </p>
                    </div>
                    <h3>Developers</h3>
                    <div id='about'>
                        <p>Samuel Jaantila
                        <p>Jere Raassina
                        <p>Joachim Grönberg
                        <p>Himel Rahman
                    </div>
                </div>
            </div> 
        </section>

        <!-- Sign Up -->

        <section id="download" class="content-section text-center">
            <div class="download-section">
                <div class="container">
                    <div class="col-lg-8 col-lg-offset-2">
                        <h2>Try NootPad!</h2>
                        <p>Sign up for NootPad!</p>
                        <a href="signup.jsp" class="btn btn-default btn-lg">Sign Up</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Footer -->

        <footer>
            <div class="container text-center">
                <p>Copyright &copy; Bits Please 2017</p>
            </div>
        </footer>

    </body>

</html>
