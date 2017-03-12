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
function checkPass(email, password, nPass, nPass2) {

    if ((nPass === nPass2 && nPass.length >= 4) || (nPass === "" && nPass2 === "")) {

        jQuery.ajax({

            url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/userPassCheck/" + email + "/" + password,
            type: "GET",

            success: function (resultData) {
                if (resultData === "true") {
                    sendProfile(email, nPass);

                } else {
                    var domElement = $("<div class='alert alert-danger alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                            Wrong password!.\n\
                           </div>");
        $("#myForm").prepend(domElement);

                }


            }, error: function (xhr, ajaxOptions, thrownError) {

                console.log(xhr.status);
                console.log(thrownError);
            },
            timeout: 120000
        });

    } else {
        var domElement = $("<div class='alert alert-danger alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                            Error. Plase follow the rules.\n\
                           </div>");
        $("#myForm").prepend(domElement);


    }

}
function sendProfile(email, nPass) {



    $.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/userByEmail",
        data: email,
        type: 'POST',
        contentType: "text/plain",

        async: false,

        success: function (data) {

            var xml = data;

            if (nPass !== "") {
                xml.getElementsByTagName("password")[0].childNodes[0].nodeValue = nPass;
            }
            xml.getElementsByTagName("email")[0].childNodes[0].nodeValue = $('#emailT').val();
            xml.getElementsByTagName("firstName")[0].childNodes[0].nodeValue = $('#fnameT').val();
            xml.getElementsByTagName("lastName")[0].childNodes[0].nodeValue = $('#lnameT').val();
            alert(xml.getElementsByTagName("firstName")[0].childNodes[0].nodeValue);

            var id = xml.getElementsByTagName("id")[0].childNodes[0].nodeValue;
            var xmlText = new XMLSerializer().serializeToString(xml);

            $.ajax({
                url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/" + id,
                data: xmlText,
                type: 'PUT',
                contentType: "application/xml",
                async: false,

                success: function () {
                    //location.reload();
                    var domElement = $("<div class='alert alert-success alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                            Profile updated!\n\
                           </div>");
        $("#myForm").prepend(domElement);
                }
                ,
                error: function (xhr, ajaxOptions, thrownError) {
                    alert("fail");
                    console.log(xhr.status);
                    console.log(thrownError);
                },
                timeout: 1200000
            });
            //location.reload();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            ;
            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 12000
    });

}


function updateProfile(email) {

    $.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/userByEmail",
        data: email,
        type: 'POST',
        contentType: "text/plain",
        async: false,

        success: function (data) {
            // alert("yyy");
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
function getMessages(email) {
    $("#mailtable").html("");
    $.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/userByEmail",
        data: email,
        type: 'POST',
        contentType: "text/plain",
        async: false,

        success: function (resultData) {
            var receiver = resultData.getElementsByTagName("receiver");
            var sender = resultData.getElementsByTagName("sender");
            var time = resultData.getElementsByTagName("timeCreated");
            var body = resultData.getElementsByTagName("body");
            var subject = resultData.getElementsByTagName("subject");
            var id = resultData.getElementsByTagName("id");


            receiverT = "";
            senderT = "";
            timeT = "";
            bodyT = "";
            subjectT = "";
            idT = "";

            for (i = 0; i < receiver.length; i++) {
                receiverT = receiver[i].childNodes[0].nodeValue;
                senderT = sender[i].childNodes[0].nodeValue;
                subjectT = subject[i].childNodes[0].nodeValue;
                bodyT = body[i].childNodes[0].nodeValue;
                timeT = time[i].childNodes[0].nodeValue;
                idT = id[i].childNodes[0].nodeValue;
                var domElement = $("<tr data-toggle='collapse' data-target='#"+idT+"' class='accordion-toggle'>\n\
                        <td><button class='btn btn-default btn-sm'><i class='glyphicon glyphicon-trash'></i></button></td><td class='mailbox-name'>From: "+senderT+" - To: "+receiverT+"\n\
                        </td><td class='mailbox-subject'><b>Subject: "+subjectT+"</b></td>\n\
                        <td class='mailbox-date'>Time: "+timeT+"</td></tr><tr>\n\
                        <td colspan='12' class='hiddenRow'><div class='accordian-body collapse' id='"+idT+"'><div>"+bodyT+"</div></td></tr>");

                $('#mailtable').append(domElement);

            }


        },
        error: function (xhr, ajaxOptions, thrownError) {
            ;
            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 12000
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
function updateStatus(id, status) {

    $.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.note/" + id,
        data: status,
        type: 'PUT',
        contentType: "text/plain",
        async: false,

        success: function () {
            //location.reload();
            alert("Note Updated");
        }
        ,
        error: function (xhr, ajaxOptions, thrownError) {
            alert("fail");
            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 1200000
    });




}


$(document).ready(function () {


    $("#cUser").click(function () {
        setMessages();
        createUser();



    });




});

