/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function createUser() {
    var fName = $("#fName").val();
    var lName = $("#lName").val();
    var email = $("#email").val();
    var password = $("#pass").val();
    var job = "EMPTY";
    var xml = "<userAccount><email>" + email + "</email> <firstName>" + fName + "</firstName><jobDescription>" + job + "</jobDescription><lastName>" + lName + "</lastName><password>" + password + "</password></userAccount>";

    $.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount",
        data: xml,
        type: 'POST',
        contentType: "application/xml",
        dataType: "application/plain",
        success: function () {
            //location.reload();
        }
        ,
        error: function (xhr, ajaxOptions, thrownError) {

            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 1200000
    });
}
function getMessages() {



}
function updateProfile(email) {

    $.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/userByEmail",
        data: email,
        type: 'POST',
        contentType: "text/plain",
        async: false,

        success: function (data) {
           
            var email = data.getElementsByTagName("email");
            var fname = data.getElementsByTagName("firstName");
            var lname = data.getElementsByTagName("lastName");
            var job = data.getElementsByTagName("jobDescription");
            emailT = email[0].childNodes[0].nodeValue;
            fnameT = fname[0].childNodes[0].nodeValue;
            lnameT = lname[0].childNodes[0].nodeValue;
            jobT = job[0].childNodes[0].nodeValue;
            
            $('#fnameT').val(fnameT);
            $('#lnameT').val(lnameT);
            $('#emailT').val(emailT);
            $('#positionT').val(jobT);
           
            //location.reload();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            //alert("fail");
            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 1200000
    });


}
function setMessages() {
    jQuery.ajax({

        url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/userByEmail",
        type: "GET",

        success: function (resultData) {
            var text = "";
            var message = resultData.getElementsByTagName("body");
            for (i = 0; i < message.length; i++) {
                text += message[i].childNodes[0].nodeValue;



            }
            alert(text);

        }, error: function (xhr, ajaxOptions, thrownError) {
            alert("fail");
            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 120000
    });



}


$(document).ready(function () {


    $("#cUser").click(function () {
        setMessages();
        createUser();



    });




});

