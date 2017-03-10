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
function updateProfile(email) {
    var user = "rebelhaze@gmail.com";
    alert(email);




    $.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/userByEmail",
        data: user,
        type: 'POST',
        contentType: "text/plain",
       
        async:false,

        success: function (data) {
            alert("works");
            var email = data.getElementsByTagName("email");
            var fname = data.getElementsByTagName("firstName");
            alert(fname);
            //location.reload();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            alert("fail");
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
            var text="";
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

