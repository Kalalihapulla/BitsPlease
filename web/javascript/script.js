/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(resize);
$(window).resize(resize);
function resize() {
    $('.container').css('height', $(window).height());
    $('.container').css('width', $(window).width());
}
function validate() {
    var invalid = " "; // Invalid character is a space
    var minLength = 4; // Minimum length
    var pw1 = document.myForm.pass.value;
    var pw2 = document.myForm.repeat.value;
// check for a value in both fields.
    if (pw1 == '' || pw2 == '') {
        var domElement = $("<div class='alert alert-danger alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                           Please enter your password twice.\n\
                           </div>");
        $("#myForm").prepend(domElement);
        return false;
    }
// check for minimum length
    if (document.myForm.pass.value.length < minLength) {
        var domElement = $("<div class='alert alert-danger alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                          Your password must be at least 4 characters long. Try again.\n\
                           </div>");
        $("#myForm").prepend(domElement);
        return false;
    }
// check for spaces
    if (document.myForm.pass.value.indexOf(invalid) > -1) {
        var domElement = $("<div class='alert alert-danger alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                           Sorry, spaces are not allowed.\n\
                           </div>");
        $("#myForm").prepend(domElement);
        return false;
    } else {
        if (pw1 != pw2) {
            var domElement = $("<div class='alert alert-danger alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                            You did not enter the same new password twice. Please re-enter your password.\n\
                           </div>");
            $("#myForm").prepend(domElement);
            return false;
        } else {
            return true;
        }
    }
}

function sendMessage(to, subject, messageout, from) {
    var sender = from;
    var receiver = document.getElementById(to).value;
    var subject = document.getElementById(subject).value;
    var body = document.getElementById(messageout).value;

    var xml = "<message><body>" + body + "</body><receiver>" + receiver + "</receiver><sender>" + sender + "</sender></message>";
 
    $.ajax({

        url: "http://localhost:8080/ProjectTestUD/webresources/model.message",
        data: xml,
        type: 'POST',
        contentType: "application/xml",
        dataType: "application/xml",
        success: function () {
            //location.reload();




        }
        ,
        error: function (xhr, ajaxOptions, thrownError) {

            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 12000

    });

}

function noteset() {
    $(".task").remove();
    jQuery.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.note",
        type: "GET",
        contentType: 'application/xml; charset=utf-8',
        success: function (resultData) {
            var desc = resultData.getElementsByTagName("description");
            var urgency = resultData.getElementsByTagName("urgency");
            var time = resultData.getElementsByTagName("timeCreated");
            var status = resultData.getElementsByTagName("status");

            descT = "";
            urgencyT = "";
            timeT = "";

            for (i = 0; i < desc.length; i++) {
                descT = "Task: " + desc[i].childNodes[0].nodeValue;
                urgencyT = "Urgency: " + urgency[i].childNodes[0].nodeValue;
                timeT = "Created: " + time[i].childNodes[0].nodeValue;
                //txt += x[i].childNodes[0].nodeValue + "<br>";
                if (urgency[i].childNodes[0].nodeValue === "0") {
                    if (status[i].childNodes[0].nodeValue === "STATUS_APPROVED") {
                        $("#sortable1").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:seagreen" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_PROCESSING") {
                        $("#sortable2").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:seagreen" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_DONE") {
                        $("#sortable3").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:seagreen" aria-hidden="true"></i></div>');

                    }

                }
                if (urgency[i].childNodes[0].nodeValue === "1") {
                    if (status[i].childNodes[0].nodeValue === "STATUS_APPROVED") {
                        $("#sortable1").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:gold" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_PROCESSING") {
                        $("#sortable2").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:gold" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_DONE") {
                        $("#sortable3").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:gold" aria-hidden="true"></i></div>');

                    }



                }
                if (urgency[i].childNodes[0].nodeValue === "2") {
                    if (status[i].childNodes[0].nodeValue === "STATUS_APPROVED") {
                        $("#sortable1").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:chocolate" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_PROCESSING") {
                        $("#sortable2").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:chocolate" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_DONE") {
                        $("#sortable3").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:chocolate" aria-hidden="true"></i></div>');

                    }


                }

            }

        },
        error: function (jqXHR, textStatus, errorThrown) {

        },
        timeout: 120000
    });
}
function createNote(caller) {
    var text = caller.siblings('#noteText').val();
    var prio = $("input:radio[name=optradio]:checked").val();
    var xml = "<note><description>" + text + "</description><urgency>" + prio + "</urgency></note>";


    $.ajax({

        url: "http://localhost:8080/ProjectTestUD/webresources/model.note",
        data: xml,
        type: 'POST',
        contentType: "application/xml",
        dataType: "application/xml",
        //processData: false,
        success: function () {




        }
        ,
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        }

    });
    caller.parent("div").css('visibility', 'hidden');
    caller.parent("div").html("");



}

function createNoteDrop(caller) {
    var text = caller.find('#noteText').val();
    var prio = $("input:radio[name=optradio]:checked").val();
    var xml = "<note><description>" + text + "</description><urgency>" + prio + "</urgency></note>";


    $.ajax({

        url: "http://localhost:8080/ProjectTestUD/webresources/model.note",
        data: xml,
        type: 'POST',
        contentType: "application/xml",
        dataType: "application/xml",
        //processData: false,
        success: function () {




        }
        ,
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        }

    });
    caller.fadeTo(500,0,function(){caller.css('visibility', 'hidden');});
    caller.html("");



}

function createNoteDrop(caller, job) {
    console.log(job);
    var text = caller.find('#noteText').val();
    var prio = $("input:radio[name=optradio]:checked").val();
    var xml = "<note><description>" + text + "</description><urgency>" + prio + "</urgency></note>";


    $.ajax({

        url: "http://localhost:8080/ProjectTestUD/webresources/model.note",
        data: xml,
        type: 'POST',
        contentType: "application/xml",
        dataType: "application/xml",
        //processData: false,
        success: function () {




        }
        ,
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        }

    });
    caller.fadeTo(500,0,function(){caller.css('visibility', 'hidden');});
    caller.html("");



}
function remove(caller) {
    $.ajax({
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        }

    });
    caller.parent("div").css('visibility', 'hidden');
    caller.parent("div").html("");
}

function removal(caller) {
    caller.parent("div").css('visibility', 'hidden');
    caller.parent("div").html("");
}


function displayMessage() {
    var domElement = $("<tr data-toggle='collapse' data-target='#demo1' class='accordion-toggle'>\n\
                        <td><input type='checkbox'></td><td class='mailbox-name'><a href='readmail.jsp'>test\n\
                        </a></td><td class='mailbox-subject'><b>test</b> - Trying to find a solution to this problem...</td>\n\
                        <td class='mailbox-date'>5 mins ago</td></tr><tr>\n\
                        <td colspan='12' class='hiddenRow'><div class='accordian-body collapse' id='test'>div>test</div></td></tr>");
    
    $('#mailtable').append(domElement);
}

function loadRadio() {
    $('#high').iCheck({
        checkboxClass: 'icheckbox_square-red',
        radioClass: 'iradio_square-red',
        increaseArea: '20%' // optional
    });
    $('#medium').iCheck({
        checkboxClass: 'icheckbox_square-yellow',
        radioClass: 'iradio_square-yellow',
        increaseArea: '20%' // optional
    });
    $('#low').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
        increaseArea: '20%' // optional
    });

}

$(document).ready(function () {
    var noteIndex = 0;

    noteset();
    $("#addTask").click(function () {
        createNote();
        noteset();

    });
    $("#createButton").click(function () {
        createNote();

    });
    $("#noteButton").click(function () {
        var domElement = $("<div id='note"+noteIndex+"' class='draggable col-xs-6 col-sm-3 ui-widget-content ui-draggable ui-draggable-handle'>\n\
                        <span class='glyphicon glyphicon-remove' id='close' onclick='removal($(this))'; return false;'></span>\n\
                        <span class='glyphicon glyphicon-ok' id='taskaddd' onclick='createNote($(this))'; return false;'></span>\n\
                        <form id='radioForm' style='float:right;padding-right:30px;'><div style= 'padding-right:1px;float:right'>\n\
                        <input type='radio' value=2 id='high' name='optradio'>\n\
                         </div>\n\
                         <div style='padding-left:1px;float:right'>\n\
                         <input type='radio' value=1 id='medium' name='optradio'>\n\
                         </div>\n\
                         <div style='padding-left:1px;float:right'>\n\
                         <input type='radio' value=0 id='low' name='optradio'>\n\
                         </div></form>\n\
                        <textarea class='form-control ui-widget-header' rows='10' id='noteText' placeholder='Insert stuff here'>\n\
                        </textarea></div>");
    
        $('#notes').prepend(domElement);
        loadRadio();
        $(".draggable").draggable();
        $(".draggable").resizable({
            animate: true,
            maxHeight: 600,
            minHeight: 170,
            maxWidth: 458,
            minWidth: 130,
            aspectRatio: true
        });
        noteIndex++;
    });

    $("#sortable1, #sortable2, #sortable3").sortable({
        //    items: "li:not(.ui-state-disabled)"    
        connectWith: "#sortable1, #sortable2, #sortable3"

    });
    $("#sortable1, #sortable2, #sortable3").disableSelection();


    $("#taskInfo").click(function () {

        $("infoBox").show(1000);
        $("infoBox").append('TEST TEST TEST');
        alert("aasdasd");

    });


    $(document).load(function () {
        $("infoBox").hide();
    });

$(function () {
    $(".grid").sortable({
        tolerance: 'pointer',
        revert: 'invalid',
        placeholder: 'span2 well placeholder tile',
        forceHelperSize: true
    });
});


$(function () {
    $(".droppable").droppable({
        drop: function (event, ui) {
            var id = (ui.draggable.attr("id"));
                switch ($(this).attr("id")) {
                    case 'dropShelf':
                        createNoteDrop($("#"+id),'shelf');
                        break;
                    case 'dropChef':
                        createNoteDrop($("#"+id),'chef');
                        break;
                    case 'dropJan':
                        createNoteDrop($("#"+id),'janitor');
                        break;
                    case 'dropCash':
                        createNoteDrop($("#"+id),'cash');
                        break;
                }
            
            $(this)
                    .animate({backgroundColor: '#98FB98', opacity: 0.6}, 1000, function(){
                        $(this).animate({backgroundColor: 'white', opacity: 0.4}, 3000);
            })
                    .find("p")
                    .html("Dropped!")
        ;}
    });
});
});


