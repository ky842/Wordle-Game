async function getRandomWord() {
    const request = await fetch("https://random-words-api.kushcreates.com/api?length=5&words=1");
    let word = await request.json();
    word = word[0]["word"];

    console.log(word);

    return word;
}


const startBtn = document.getElementById("start");
const title = document.getElementById("title");
const guessInput = document.getElementById("guess");
const guessLabel = document.getElementById("guess-label");
const check = document.getElementById("check");

startBtn.addEventListener("click", () => {
    title.classList.add("hidden");
    startBtn.classList.add("hidden");
    guessLabel.classList.toggle("hidden");
    guessInput.classList.toggle("hidden");
    check.classList.toggle("hidden");
})

function checkGuess(word, guess) {
    const userGuess = guess; // save here, so guess can be edited during checking

    word = word.toLowerCase();
    guess = guess.toLowerCase();

    const green = new Array(5);
    const greenIndexArr = [];
    const yellowIndexArr = [];

    for (let i = 0; i < word.length; i++) {
        if (word[i] === guess[i]) {
            green[i] = word[i];
            word = word.slice(0, i) + " " + word.slice(i + 1); // remove checked letter
            guess = guess.slice(0, i) + " " + guess.slice(i + 1); // remove checked letter
            greenIndexArr.push(i);
        }
    }

    for (let i = 0; i < word.length; i++) {
        if (!greenIndexArr.includes(i) && guess.includes(word[i]) && word[i] !== " ") {
            const char = word[i];
            const idx = guess.indexOf(char); // index of matched character in GUESS
            //console.log(idx);

            yellowIndexArr.push(idx);

            guess = guess.slice(0, idx) + " " + guess.slice(idx + 1);
        }
    }

    return [greenIndexArr, yellowIndexArr];
}

console.log(checkGuess("chery", "score"));
console.log(checkGuess("SLATE", "SLATE"));
console.log(checkGuess("SLATE", "CHIPS"));
console.log(checkGuess("DRIVE", "RIVED"));
console.log(checkGuess("ROBIN", "APPLE"));
console.log(checkGuess("ROBIN", "FLOOD"));
console.log(checkGuess("APPLE", "CHIPS"));
console.log(checkGuess("APPLE", "SPREE"));
console.log(checkGuess("GEESE", "STAGE"));
console.log(checkGuess("STEAL", "LEAST"));
