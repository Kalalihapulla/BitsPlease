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
//  End -->
