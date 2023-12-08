// var counter = 0
// var clickMeButton = document.createElement('button');
// clickMeButton.id = 'buttonIdentifier';
// clickMeButton.innerHTML = '0';
// clickMeButton.style.background = '#E07996';
// document.body.appendChild(clickMeButton);//#AB79E0
//  clickMeButton.addEventListener("click", function() {
//                 /* This changes the button's label */
//                 counter++
//                 clickMeButton.innerHTML = counter ;
//             });

    



          
var btnn = document.getElementById("btn");
var counter = 0;

/* This sets the initial label for the button */
btnn.innerHTML = '0';

/* This sets the action to perform on a click event */
btnn.addEventListener("click", function() {
    /* Increment the counter and update the button's label */
    counter += 1;
    btnn.innerHTML = counter;
});