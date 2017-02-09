<%-- 
    Document   : index
    Created on : Feb 7, 2017, 12:25:27 PM
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
    <link rel="stylesheet" type="text/css" href="styles.css" />
    <script src="jquery-3.1.1.min.js"></script>

<style>

  .container {
    background-image: url("best.jpg");
    background-repeat: no-repeat;
    padding-top:150px !important;
    

  }

 .note-input{
    margin-top:0px !important;
    padding-top: 0px !important;
  }

  a {
    font-family: 'Dosis';
    font-size:1.5em;
    color: PapayaWhip;
  }
  
  h1 {
    alignment-adjust: 50%;
    font-size: 8em;
    color: PapayaWhip;
    text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
    font-family: 'Aldrich';
    font-weight: bold;
  }
  
  
  

  

</style>


</head>
<body data-spy='scroll' data-target='.navbar-collapse'>


<div class='navbar navbar-default navbar-fixed-top'>
  <div class='container-fluid'>
     <div class='navbar-header'>
       <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    <a href='bitsplease' class='navbar-brand'>Bits Please</a>
     </div>
     <div class='collapse navbar-collapse'>
       <ul class='nav navbar-nav'>
         <li><a href='about.jsp'>About</a></li>
         <li><a href='signup.jsp'>Sign Up!</a></li>
      </ul>
         <form class='navbar-form navbar-right' method='post' action='login' >
           <div class='form-group'>
             <input class='form-control note-input' placeholder='Email' type='email' name='email' />
           </div>
           <div class='form-group'>
             <input class='form-control note-input' placeholder='Password' type='password' name='pass' />
           </div>
           <input class='form-control btn btn-info note-input' type='submit' value='Log In' name='submit'>
         </form>
     </div>
  </div>
</div>

<div class='container'>
  <div class='row index-row' id='info'>
    <h1 id='title' class='text-center'>Bits Please</h1>
    <p index='intro' class='text-center'>Bits Please </p>
    <h3 class='text-center'>The best thing on the internet!</h3>
  </div>

  </div>

  <footer class='text-center'>©  Bits Please</footer>



<script>

  $(document).ready(resize);
  $(window).resize(resize);
  function resize(){
    $('.container').css('height',$(window).height());
    $('.container').css('width',$(window).width());
  }
</script>





</body>
</html>