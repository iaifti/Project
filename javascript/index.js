// let students = 30;

// // students += 1;

// console.log(students);

// let userName;
// userName =  window.prompt("What's the username: ");

// console.log(userName);

// let userName;
// document.getElementById("mySubmit").onclick = function(){
//     userName =  document.getElementById("myText").value;
//     console.log(userName);
// }

// let age  = window.prompt("age ? ");

// age = Number(age);

// console.log(age, typeof age);

/*Conter

const decrease =  document.getElementById("decrease");
const increase =  document.getElementById("increase");
const reset =  document.getElementById("reset");
const countLabel = document.getElementById("countLabel");

let count  =  0;
increase.onclick = function(){
    count++;
    countLabel.textContent =  count;
}
decrease.onclick = function(){
    count--;
    countLabel.textContent =  count;
}
reset.onclick = function(){
    count = 0;
    countLabel.textContent =  count;
}
*/

// let username = window.prompt("Enter Username: ");

// username = username.trim().charAt(0).toUpperCase() + username.trim().slice(1).toLowerCase();
// console.log(username);

/*Number Guessing Game

const minNum  = 1;
const maxNum  = 10;
const answer = Math.floor(Math.random() * (maxNum - minNum) + 1);

console.log(answer);


let attempts = 0;
let guess;
let running  =  true;

while(running){

    guess = window.prompt("Guess a number 1-100 ");
    guess = Number(guess);
    
    if(isNaN(guess)){
        window.alert("Please enter a valid Number : ");
    }
    else if(guess < minNum || guess > maxNum){
        window.alert("Please enter a valid Number!");
    }
    else{
        attempts++;
        if(guess < answer){
            window.alert("Try again!");
        }
        else if(guess > answer){
            window.alert("Try again!");
        }
        else{
            window.alert(`You guessed right! The answer was ${answer}. I took ${attempts} attempts.`);
            running = false;
        }

    }   
    
}*/

// const textbox =  document.getElementById("textbox");
// const toFahrenheit =  document.getElementById("toFahrenheit");
// const toCelsius =  document.getElementById("toCelsius");
// const result =  document.getElementById("result");

// let temp;

// function convert(){

//     if(toFahrenheit.checked){
//         result.textContent = "You chose fahrenheit";
//     }
//     else if(toCelsius.checked){
//         result.textContent = "You chose Celcius";
//     }
//     else{
//         result.textContent =  "Select a unit";
//     }
// }

