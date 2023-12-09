function rotateButtons() {
    var btn1 = document.getElementById("btn1").innerHTML;
    var btn2 = document.getElementById("btn2").innerHTML;
    var btn3 = document.getElementById("btn3").innerHTML;
    var btn4 = document.getElementById("btn4").innerHTML;
    var btn5 = document.getElementById("btn5").innerHTML;
    var btn6 = document.getElementById("btn6").innerHTML;
    var btn7 = document.getElementById("btn7").innerHTML;
    var btn8 = document.getElementById("btn8").innerHTML;
    var btn9 = document.getElementById("btn9").innerHTML;

    /* Update the button's label */
    document.getElementById("btn1").innerHTML = btn4 ;
    document.getElementById("btn2").innerHTML = btn1 ;
    document.getElementById("btn3").innerHTML = btn2 ;
    document.getElementById("btn4").innerHTML = btn7 ;
    document.getElementById("btn6").innerHTML = btn3 ;
    document.getElementById("btn7").innerHTML = btn8 ;
    document.getElementById("btn8").innerHTML = btn9 ;
    document.getElementById("btn9").innerHTML = btn6 ;
}