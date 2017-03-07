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
function add(caller) {

}





$(document).ready(function () {




    $("#noteButton").click(function () {
        var domElement = $("<div id='draggable' class='col-xs-6 col-sm-3 ui-widget-content ui-draggable ui-draggable-handle'>\n\
                         <form><div style= 'padding:1px; margin-left: 1.2em; border:1px solid red;float:left; border-radius: 50px'>\n\
                         <input type='radio' name='optradio'>\n\
                         </div>\n\
                         <div style='padding:1px;border:1px solid blue;float:left; border-radius: 50px'>\n\
                         <input type='radio' name='optradio'>\n\
                         </div>\n\
                         <div style='padding:1px;border:1px solid green;float:left; border-radius: 50px'>\n\
                         <input type='radio' name='optradio'>\n\
                         </div></form>\n\
                        <span class='glyphicon glyphicon-remove' id='close' onclick='remove($(this))'; return false;'></span>\n\
                        <span class='glyphicon glyphicon-ok' id='taskaddd' onclick='add($(this))'; return false;'></span>\n\
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





    $("#addTask").click(function () {

        jQuery.ajax({
            url: "http://localhost:8080/ProjectTestUD/webresources/model.note",
            type: "GET",
            contentType: 'application/xml; charset=utf-8',
            success: function (resultData) {
                var x = resultData.getElementsByTagName("description");
                txt = "";
                value = "";
                for (i = 0; i < x.length; i++) {
                    value = x[i].childNodes[0].nodeValue;
                    txt += x[i].childNodes[0].nodeValue + "<br>";
                     $("#sortable1").append('<div class="ui-state-default task"> '+value+' <i id="taskInfo" class="fa fa-circle" style="color:green" aria-hidden="true"></i></div>');
                }
                alert(txt);
                document.getElementById("infoBox").innerHTML = txt;
               

                //here is your json.
                // process it

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("ll");
            },
            timeout: 120000
        });


       

    });


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







//  End -->

//  End -->
