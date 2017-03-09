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
$(document).ready(function () {
    $("#cUser").click(function (){
        createUser();
        
        
        
    });




});

