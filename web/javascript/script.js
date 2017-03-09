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
        alert('Please enter your password twice.');
        return false;
    }
// check for minimum length
    if (document.myForm.pass.value.length < minLength) {
        alert('Your password must be at least ' + minLength + ' characters long. Try again.');
        return false;
    }
// check for spaces
    if (document.myForm.pass.value.indexOf(invalid) > -1) {
        alert("Sorry, spaces are not allowed.");
        return false;
    } else {
        if (pw1 != pw2) {
            alert("You did not enter the same new password twice. Please re-enter your password.");
            return false;
        } else {
            return true;
        }
    }
}
function remove(caller) {
    caller.parent("div").css('visibility', 'hidden');
    caller.parent("div").html("");
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

            descT = "";
            urgencyT = "";
            timeT = "";

            for (i = 0; i < desc.length; i++) {
                descT = "Task: " + desc[i].childNodes[0].nodeValue;
                urgencyT = "Urgency: " + urgency[i].childNodes[0].nodeValue;
                timeT = "Created: " + time[i].childNodes[0].nodeValue;
                //txt += x[i].childNodes[0].nodeValue + "<br>";
                if (urgency[i].childNodes[0].nodeValue === "0") {
                    $("#sortable1").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:green" aria-hidden="true"></i></div>');



                }
                if (urgency[i].childNodes[0].nodeValue === "1") {
                    $("#sortable1").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:yellow" aria-hidden="true"></i></div>');



                }
                if (urgency[i].childNodes[0].nodeValue === "2") {
                    $("#sortable1").append('<div class="ui-state-default task"> ' + descT + ' <br> ' + urgencyT + '<br> ' + timeT + ' <i id="taskInfo" class="fa fa-circle" style="color:red" aria-hidden="true"></i></div>');



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



$(document).ready(function () {

    noteset();
    $("#addTask").click(function () {
        createNote();
        noteset();

    });
    $("#createButton").click(function(){
       createNote(); 
        
    });


    $("#noteButton").click(function () {
        var domElement = $("<div id='draggable' class='col-xs-6 col-sm-3 ui-widget-content ui-draggable ui-draggable-handle'>\n\
                        <form id='radioForm'><div style= 'padding:1px; margin-left: 1.2em; border:1px solid red;float:left; border-radius: 50px'>\n\
                        <input type='radio' value=2 name='optradio'>\n\
                         </div>\n\
                         <div style='padding:1px;border:1px solid blue;float:left; border-radius: 50px'>\n\
                         <input type='radio' value=1 name='optradio'>\n\
                         </div>\n\
                         <div style='padding:1px;border:1px solid green;float:left; border-radius: 50px'>\n\
                         <input type='radio' value=0 name='optradio'>\n\
                         </div></form>\n\
                        <span class='glyphicon glyphicon-remove' id='close' onclick='remove($(this))'; return false;'></span>\n\
                        <span class='glyphicon glyphicon-ok' id='taskaddd' onclick='createNote($(this))'; return false;'></span>\n\
                        <textarea class='form-control ui-widget-header' rows='10' id='noteText' placeholder='Insert stuff here'>\n\
                        </textarea></div>");

        $('#notes').prepend(domElement);
        $("#draggable").draggable();
        $("#draggable").resizable({
            animate: true,
            maxHeight: 600,
            minHeight: 170,
            maxWidth: 458,
            minWidth: 130,
            aspectRatio: true
        });
    });



    $("#sortable1").sortable({
        //    items: "li:not(.ui-state-disabled)" 
        connectWith: "#sortable2"

    });

    $("#sortable2").sortable({
        // cancel: ".ui-state-disabled"
        connectWith: "#sortable1"
    });

    $("#sortable1, #sortable2").disableSelection();














    $("#taskInfo").click(function () {

        $("infoBox").show(1000);
        $("infoBox").append('TEST TEST TEST');
        alert("aasdasd");

    });

    $(document).load(function () {
        $("infoBox").hide();
    });



});

$(function () {
    $(".grid").sortable({
        tolerance: 'pointer',
        revert: 'invalid',
        placeholder: 'span2 well placeholder tile',
        forceHelperSize: true
    });
});

$(document).ready(function() {
    var panels = $('.user-infos');
    var panelsButton = $('.dropdown-user');
    panels.hide();

    //Click dropdown
    panelsButton.click(function() {
        //get data-for attribute
        var dataFor = $(this).attr('data-for');
        var idFor = $(dataFor);

        //current button
        var currentButton = $(this);
        idFor.slideToggle(400, function() {
            //Completed slidetoggle
            if(idFor.is(':visible'))
            {
                currentButton.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>');
            }
            else
            {
                currentButton.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
            }
        })
    });


    $('[data-toggle="tooltip"]').tooltip();

    $('button').click(function(e) {
        e.preventDefault();
        alert("This is a demo.\n :-)");
    });
});







//  End -->

//  End -->
