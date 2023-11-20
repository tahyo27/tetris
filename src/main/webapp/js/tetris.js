import BLOCKS from "./blocks.js";

//DOM
const playground = document.querySelector(".playground > ul");
const gameText = document.querySelector(".game-text");
const scoreDisplay = document.querySelector(".score");
const restartButton = document.querySelector("#restartBtn");
const startBtn = document.querySelector(".startBtn");
const saveModal = document.querySelector(".myModal");
const scoreInput = document.querySelector('.save_score');
//Setting
const tetris_rows = 25;
const tetris_cols = 10;


//변수
let score = 0;
let duration = 500;
let downInterval;
let tempMovingItem;

const movingItem = {
    type: "jmino",
    direction: 0,
    top: 0,
    left: 3,
}

init()
//functions
function init() {
    gameText.style.display = "none";
    tempMovingItem = { ...movingItem };
    score = 0;
    for(let i = 0; i < tetris_rows; i++) {
        prependNewLine()
    }
    document.addEventListener("DOMContentLoaded", () => {
       startBtn.addEventListener("click", ()=>{
		   startBtn.style.display = "none";
		   startBtn.blur();
		   generateNewBlock();
	   });
    });
}

function prependNewLine() {
    const li = document.createElement("li");
    const ul = document.createElement("ul");
    for(let j = 0; j < tetris_cols; j++) {
        const matrix = document.createElement("li")
        ul.prepend(matrix);
    }
    li.prepend(ul)
    playground.prepend(li)
}

function renderBlocks(moveType = "") {
    const { type, direction, top, left} = tempMovingItem;
    const movingBlocks = document.querySelectorAll(".moving");
    movingBlocks.forEach(moving => {
        moving.classList.remove(type, "moving");
    })

    BLOCKS[type][direction].some(block => {
        const x = block[0] + left;
        const y = block[1] + top;
        const target = playground.childNodes[y]? playground.childNodes[y].childNodes[0].childNodes[x] : null;
        const isAvailable = checkEmpty(target)
        if(isAvailable) {
            target.classList.add(type, "moving")
        } else {
            tempMovingItem = { ...movingItem }
            if(moveType === 'retry') {
                clearInterval(downInterval)
                showGameoverText()
            }
            setTimeout(() => {
                renderBlocks('retry')
                if(moveType ==="top") {
                    seizeBlock();
                }
            }, 0)
           return true;
        }
        
    })
    //정상으로 작동되면 무빙아이템 업데이트
    movingItem.left = left;
    movingItem.top = top;
    movingItem.direction = direction;
}

function seizeBlock() { //블럭이 끝까지 내려오면 고정하고 새블럭 생성
    const movingBlocks = document.querySelectorAll(".moving");
    movingBlocks.forEach(moving => {
        moving.classList.remove("moving");
        moving.classList.add("seized");
    })
    checkMatch()
}
function checkMatch() {
    const childNodes = playground.childNodes;
    childNodes.forEach(child=>{
        let matched = true;
        child.children[0].childNodes.forEach(li=>{
            if(!li.classList.contains("seized")) {
                matched = false;
            }
        })
        if(matched) {
            child.remove();
            prependNewLine()
            score += 10;
            scoreDisplay.innerText = score;
            scoreInput.value = score;
        }
    })

    generateNewBlock()
}
function generateNewBlock() {

    clearInterval(downInterval);
    downInterval = setInterval(() => {
        moveBlock('top', 1)
    },duration);
    const blockArray = Object.entries(BLOCKS);
    const randomIndex = Math.floor(Math.random() * blockArray.length);

    movingItem.type = blockArray[randomIndex][0];
    movingItem.top = 0;
    movingItem.left = 3;
    movingItem.direction = 0;
    tempMovingItem = { ...movingItem };
    renderBlocks()
}

function checkEmpty(target) {
    if(!target || target.classList.contains("seized")) {
        return false;
    }
    return true;
}
function moveBlock(moveType, amount) {
    tempMovingItem[moveType] += amount;
    renderBlocks(moveType)
}

function changeDirection() {
   const direction = tempMovingItem.direction;
   direction === 3 ? tempMovingItem.direction = 0 : tempMovingItem.direction += 1;
    renderBlocks()
}

function dropBlock() {
    clearInterval(downInterval);
    downInterval = setInterval(() => {
        moveBlock("top", 1)
    }, 9);
}

function showGameoverText() {
    gameText.style.display = "flex";
    if(score === 0) {
		saveModal.style.display = "none";
	} else {
		saveModal.style.display = "flex";
	}
}
//키작동
document.addEventListener("keydown", e => {
    switch(e.keyCode) {
        case 39:
            moveBlock("left", 1);
            break;
        case 37:
            moveBlock("left", -1);
            break;
        case 38:
            changeDirection();
            break;
        case 40:
            moveBlock("top", 1);
            break;
        case 32:
            dropBlock();
            break;
        default:
            break;
    }
})

restartButton.addEventListener("click",()=>{
    playground.innerHTML = "";
    gameText.style.display = "none";
    init()
    generateNewBlock();
    startBtn.style.display = "none";
})

