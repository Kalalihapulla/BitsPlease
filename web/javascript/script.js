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
function validate(email) {
    var invalid = " "; // Invalid character is a space
    var minLength = 4; // Minimum length
    var pw1 = document.myForm.pass.value;
    var pw2 = document.myForm.repeat.value;
// check for a value in both fields.

    $.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/signup",
        data: email,
        type: 'POST',
        contentType: "text/plain",
        async: false,

        success: function (data) {
            if (data === "true") {
                var domElement = $("<div class='alert alert-danger alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                             Account already exists\n\
                           </div>");
                $("#myForm").prepend(domElement);
                return false;


            }

        },
        error: function (xhr, ajaxOptions, thrownError) {
            //alert("fail");
            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 1200000
    });
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


function getUserd(email){
    $.ajax({
        url: "http://localhost:8080/ProjectTestUD/webresources/model.useraccount/userJob/"+email,
        type: 'GET',
        async: false,
       

        success: function (data) {
            noteset(data);
        }
        ,
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 1200000
    });
}

function sendMessage(to, subjects, messageout, from) {
    var sender = from;
    var receiver = document.getElementById(to).value;
    var subject = document.getElementById(subjects).value;
    var body = document.getElementById(messageout).value;


    var xml = "<message><body>" + body + "</body><receiver>" + receiver + "</receiver><sender>" + sender + "</sender><subject>" + subject + "</subject></message>";

    $.ajax({

        url: "http://localhost:8080/ProjectTestUD/webresources/model.message",
        data: xml,
        type: 'POST',
        contentType: "application/xml",
        dataType: "application/xml",
        async: false,
        success: function () {
            var domElement = $("<div class='alert alert-success alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                            Message sent!.\n\
                           </div>");
            $("#form1").prepend(domElement);
             $('#form1').closest('form').find("input[type=text], textarea").val("");




        }
        ,
        error: function (xhr, ajaxOptions, thrownError) {
                 var domElement = $("<div class='alert alert-danger alert-dismissable'>\n\
                            <a class='panel-close close' data-dismiss='alert'>×</a>\n\
                            <i class='fa fa-coffee'></i>\n\
                            No such address exists!\n\
                           </div>");
            $("#form1").prepend(domElement);
            console.log(xhr.status);
            console.log(thrownError);
        },
        timeout: 12000

    });

}



function noteset(data) {
    var job = data;
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
            var id = resultData.getElementsByTagName("id");
            var jobD = resultData.getElementsByTagName("worker");
            console.log(job);

            descT = "";
            urgencyT = "";
            timeT = "";
            idT = "";

            for (i = 0; i < desc.length; i++) {
                descT = "Task: " + desc[i].childNodes[0].nodeValue;
                urgencyT = "Urgency: " + urgency[i].childNodes[0].nodeValue;
                timeT = "Created: " + time[i].childNodes[0].nodeValue;
                idT = id[i].childNodes[0].nodeValue;
                jobDT = jobD[i].childNodes[0].nodeValue;
                //txt += x[i].childNodes[0].nodeValue + "<br>";
                if (urgency[i].childNodes[0].nodeValue === "0") {
                    if (status[i].childNodes[0].nodeValue === "STATUS_APPROVED" && (job === jobDT || jobDT === "general")) {
                        $("#sortable1").append('<div class="ui-state-default task" id="' + idT + '"> ' + descT + ' <img class="qm" src="questionmark.png" onclick="opennote($(this))"><br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:#1B7E5A" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_PROCESSING" && (job === jobDT || jobDT === "general")) {
                        $("#sortable2").append('<div class="ui-state-default task" id="' + idT + '"> ' + descT + ' <img class="qm" src="questionmark.png" onclick="opennote($(this))"><br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:#1B7E5A" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_DONE" && (job === jobDT || jobDT === "general")) {
                        $("#sortable3").append('<div class="ui-state-default task" id="' + idT + '"> ' + descT + ' <img class="qm" src="questionmark.png" onclick="opennote($(this))"><br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:#1B7E5A" aria-hidden="true"></i></div>');

                    }

                }
                if (urgency[i].childNodes[0].nodeValue === "1") {
                    if (status[i].childNodes[0].nodeValue === "STATUS_APPROVED" && (job === jobDT || jobDT === "general")) {
                        $("#sortable1").append('<div class="ui-state-default task" id="' + idT + '"> ' + descT + ' <img class="qm" src="questionmark.png" onclick="opennote($(this))"><br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:#FFCC33" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_PROCESSING" && (job === jobDT || jobDT === "general")) {
                        $("#sortable2").append('<div class="ui-state-default task" id="' + idT + '"> ' + descT + ' <img class="qm" src="questionmark.png" onclick=opennote($(this))"><br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:#FFCC33" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_DONE" && (job === jobDT || jobDT === "general")) {
                        $("#sortable3").append('<div class="ui-state-default task" id="' + idT + '"> ' + descT + ' <img class="qm" src="questionmark.png" onclick="opennote($(this))"><br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:#FFCC33" aria-hidden="true"></i></div>');

                    }



                }
                if (urgency[i].childNodes[0].nodeValue === "2") {
                    if (status[i].childNodes[0].nodeValue === "STATUS_APPROVED" && (job === jobDT || jobDT === "general")) {
                        $("#sortable1").append('<div class="ui-state-default task" id="' + idT + '"> ' + descT + ' <img class="qm" src="questionmark.png" onclick="opennote($(this))"><br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:#D54E21" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_PROCESSING" && (job === jobDT || jobDT === "general")) {
                        $("#sortable2").append('<div class="ui-state-default task" id="' + idT + '"> ' + descT + ' <img class="qm" src="questionmark.png" onclick="opennote($(this))"><br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:#D54E21" aria-hidden="true"></i></div>');

                    }
                    if (status[i].childNodes[0].nodeValue === "STATUS_DONE" && (job === jobDT || jobDT === "general")) {
                        $("#sortable3").append('<div class="ui-state-default task" id="' + idT + '"> ' + descT + ' <img class="qm" src="questionmark.png" onclick="opennote($(this))"><br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:#D54E21" aria-hidden="true"></i></div>');

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

function createNoteDrop(caller, job) {
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
    caller.fadeTo(500, 0, function () {
        caller.css('visibility', 'hidden');
    });
    caller.html("");



}
function removal(caller) {
    caller.parent("div").css('visibility', 'hidden');
    caller.parent("div").html("");
}

function opennote(caller) {


    $(function () {

        //  $("#taskinfo").empty();
        $("#taskinfo").dialog({
            autoOpen: false,
            show: {
                effect: "blind",
                duration: 500
            },
            hide: {
                effect: "blind",
                duration: 500
            },
            width: 600,
            height: 400
        });

        var noteinfo = $(caller).closest('.task').val();
        console.log(noteinfo);
        $("#taskinfo").append('<div class="ui-state-default task"> ' + noteinfo + '</div>');
        $("#taskinfo").dialog("open");

    });
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
        var domElement = $("<div id='note" + noteIndex + "' class='draggable col-xs-6 col-sm-3 ui-widget-content ui-draggable ui-draggable-handle'>\n\
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
        $(".draggable").draggable({
            containment: ".row"
        });
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
        connectWith: "#sortable1, #sortable2, #sortable3",
        tolerance: 'pointer',
        forceHelperSize: true,
        containment: "#taskboxbackground",

        start: function (e, ui) {
            $(ui.placeholder).hide(200);
        },
        change: function (e, ui) {
            $(ui.placeholder).hide().show(200);

        },
        
        receive: function(event, ui) {
        var source = ui.sender;
        var target = $(event.target);
        var id = ui.item.attr("id");
               
            if (target.is("#sortable1")) {
                     var status = "STATUS_APPROVED";
                }
                  
                if (target.is("#sortable2")) {
                     var status = "STATUS_PROCESSING";
                }
 
                 if (target.is("#sortable3")) {
                     var status = "STATUS_DONE";
                }
                
                $.ajax({
                    
                    url: "http://localhost:8080/ProjectTestUD/webresources/model.note/" + id,
                    data: status,
                    type: 'PUT',
                    contentType: "text/plain",
                    async: false,
 
                    success: function () {
                        //location.reload();
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

    //$(function () {
    //  $(".grid").sortable({
    //      tolerance: 'pointer',
    //      revert: 'invalid',
    //     placeholder: 'span2 well placeholder tile',
    //        forceHelperSize: true
    //     });
    //  });


    $(function () {
        $(".droppable").droppable({
            drop: function (event, ui) {
                var id = (ui.draggable.attr("id"));
                switch ($(this).attr("id")) {
                    case 'dropStore':
                        createNoteDrop($("#" + id), 'store');
                        break;
                    case 'dropMana':
                        createNoteDrop($("#" + id), 'management');
                        break;
                    case 'dropJan':
                        createNoteDrop($("#" + id), 'janitor');
                        break;
                    case 'dropCash':
                        createNoteDrop($("#" + id), 'cash');
                        break;
                }

                $(this)
                        .animate({backgroundColor: '#98FB98', opacity: 0.6}, 1000, function () {
                            $(this).animate({backgroundColor: 'white', opacity: 0.4}, 3000);
                        })
                        ;
            }



        });

});

/*
Reference: http://jsfiddle.net/BB3JK/47/
*/

$('select').each(function(){
    var $this = $(this), numberOfOptions = $(this).children('option').length;
  
    $this.addClass('select-hidden'); 
    $this.wrap('<div class="select"></div>');
    $this.after('<div class="select-styled"></div>');

    var $styledSelect = $this.next('div.select-styled');
    $styledSelect.text($this.children('option').eq(0).text());
  
    var $list = $('<ul />', {
        'class': 'select-options'
    }).insertAfter($styledSelect);
  
    for (var i = 0; i < numberOfOptions; i++) {
        $('<li />', {
            text: $this.children('option').eq(i).text(),
            rel: $this.children('option').eq(i).val()
        }).appendTo($list);
    }
  
    var $listItems = $list.children('li');
  
    $styledSelect.click(function(e) {
        e.stopPropagation();
        $('div.select-styled.active').not(this).each(function(){
            $(this).removeClass('active').next('ul.select-options').hide();
        });
        $(this).toggleClass('active').next('ul.select-options').toggle();
    });
  
    $listItems.click(function(e) {
        e.stopPropagation();
        $styledSelect.text($(this).text()).removeClass('active');
        $this.val($(this).attr('rel'));
        $list.hide();
        //console.log($this.val());
    });
  
    $(document).click(function() {
        $styledSelect.removeClass('active');
        $list.hide();
    });

});

});


