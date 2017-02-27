<%-- 
    Document   : userDash
    Created on : Feb 26, 2017, 5:14:20 PM
    Author     : Jere
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Project Bits | About</title>

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
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="jquery-3.1.1.min.js"></script>
        <script src="javascript/script.js"></script>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script>
            $(function () {
                $("#accordion").accordion();
            });
        </script>


    </head>
    <body data-spy='scroll' data-target='.navbar-collapse'>


        <div class='navbar navbar-default navbar-fixed-top navbar-inverse bg-inverse'>
            <div class='container-fluid'>
                <div class='navbar-header'>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href='index.jsp' class='navbar-brand'>Bits Please</a>
                </div>
                <div class='collapse navbar-collapse'>
                    <ul class='nav navbar-nav'>
                        <li><a href='about.jsp'>About</a></li>
                            <c:if test="${empty loggedInUser}">
                            <li><a href='signup.jsp'>Sign Up!</a></li>
                            </c:if>
                        <li><a href='dashboard.jsp'>Dashboard</a></li>
                        <li><a href='userDash.jsp'>User dashboard</a></li>
                    </ul><c:if test="${not empty loggedInUser}">
                        <form class='navbar-form navbar-right' method='post' action='login' >
                            <p id='loggedIn'>Welcome ${loggedInUser}</p>
                            <input class='form-control btn btn-info note-input' type='submit' value='Log Out' name='submit'>
                        </form>
                    </c:if>
                    <c:if test="${empty loggedInUser}">
                        <form class='navbar-form navbar-right' method='post' action='login' >
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
            </div>
        </div>

        <div class='container' id='main'>
            <div class='row index-row' id='info'>
                <h1 id='dashboard' class='text-center'>User Dashboard</h1>
                <%--<c:if test="${not empty loggedInUser}">--%>
                    <!--<h3 class='text-center'>Welcome "${loggedInUser}"</h3>-->
                <!--<div class='row' id='notes'></div>-->
                <%--</c:if>--%>
                <%--<c:if test="${empty loggedInUser}">--%>
                <!--<h3 class='text-center'>You have no privileges as you're not logged in. Forgot to <a href="signup.jsp">sign up?</a></h3>-->
                <%--</c:if>--%>
            </div>


            <div id="addTask">
                CLICK ME
            </div>




            <div>


                <div id="sortable1" class="taskBox">

                    <div class="ui-state-default ui-state-disabled task">
                        Go and fill some shelves you fool! <img id="taskInfo" src="questionmark.png">
                    </div>

                    <div class="ui-state-default task">
                        Huomio! Pullonpalautuspisteellä tarvitaan henkilökuntaa... <img id="taskInfo" src="questionmark.png">                       
                    </div>    


                </div>



                <div id="sortable2" class="taskBox">>

                    <div class="ui-state-default task">
                        TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST <img id="taskInfo" src="questionmark.png">           
                    </div>   

                    <div class="ui-state-default task">
                        4 <img id="taskInfo" src="questionmark.png">
                    </div>   

                </div>


            </div>
            
            
            <div id="infoBox">
            </div>
            
            </div>


        <footer class='text-center'>©  Bits Please</footer>






    </body>
</html>