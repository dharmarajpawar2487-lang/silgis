/* CHATBOT */

/* ================= CHATBOT ================= */

async function sendMessage(){

let inputBox = document.getElementById("userInput");
let text = inputBox.value.trim();

if(text==="") return;

let chatBox = document.getElementById("chatBox");

/* USER MESSAGE */

chatBox.innerHTML += `<div><b>You:</b> ${text}</div>`;

/* BOT THINKING */

chatBox.innerHTML += `<div id="typing"><b>Bot:</b> Thinking...</div>`;

chatBox.scrollTop = chatBox.scrollHeight;

/* ================= AI REQUEST ================= */

try{

let response = await fetch("/ai/ask",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify(text)

});

let data = await response.text();

/* REMOVE THINKING */

document.getElementById("typing").remove();

/* BOT MESSAGE */

chatBox.innerHTML += `<div><b>Bot:</b> ${data}</div>`;

/* VOICE RESPONSE */

speak(data);

}
catch(e){

document.getElementById("typing").remove();

chatBox.innerHTML += `<div><b>Bot:</b> AI server error.</div>`;

}

inputBox.value="";

chatBox.scrollTop = chatBox.scrollHeight;

}


/* ================= ENTER KEY SEND ================= */

document.getElementById("userInput")
.addEventListener("keypress",function(e){

if(e.key==="Enter"){

sendMessage();

}

});


/* ================= VOICE QUESTION ================= */

function startVoice(){

const recognition = new webkitSpeechRecognition();

/* LANGUAGE SELECT */

let lang = document.getElementById("voiceLang").value;

recognition.lang = lang;

recognition.start();

recognition.onresult = function(event){

const speech = event.results[0][0].transcript;

document.getElementById("userInput").value = speech;

sendMessage();

};

}


/* ================= AI VOICE RESPONSE ================= */

function speak(text){

let lang = document.getElementById("voiceLang").value;

const speech = new SpeechSynthesisUtterance(text);

speech.lang = lang;

window.speechSynthesis.speak(speech);

}/* 3D LAB */
/* ===================================== */
/* ===== LAB NAME DETECT ===== */
/* ===================================== */

const lab = document.getElementById("labName").innerText;


/* ===================================== */
/* ===== 3D CONTAINER ===== */
/* ===================================== */

const container = document.getElementById("lab3d");


/* ===================================== */
/* ===== SCENE ===== */
/* ===================================== */

const scene = new THREE.Scene();
scene.background = new THREE.Color(0x020617);


/* ===================================== */
/* ===== CAMERA ===== */
/* ===================================== */

const camera = new THREE.PerspectiveCamera(
75,
container.clientWidth / container.clientHeight,
0.1,
1000
);


/* ===================================== */
/* ===== RENDERER ===== */
/* ===================================== */

const renderer = new THREE.WebGLRenderer({
antialias:true
});

renderer.setSize(
container.clientWidth,
container.clientHeight
);

renderer.shadowMap.enabled = true;

container.appendChild(renderer.domElement);


/* ===================================== */
/* ===== CONTROLS ===== */
/* ===================================== */

const controls = new THREE.OrbitControls(
camera,
renderer.domElement
);


/* ===================================== */
/* ===== LAB TYPE CHECK ===== */
/* ===================================== */

if(lab === "HOD Cabin"){

createHodCabin();

}else{

createProgrammingLab();

}


/* ===================================== */
/* ===== ANIMATION LOOP ===== */
/* ===================================== */

function animate(){

requestAnimationFrame(animate);

controls.update();

renderer.render(scene,camera);

}

animate();