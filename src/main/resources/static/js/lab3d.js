document.addEventListener("DOMContentLoaded", function(){

/* 3D CODE START */

const lab = document.getElementById("labName").innerText;

const container = document.getElementById("lab3d");

const scene = new THREE.Scene();

const camera = new THREE.PerspectiveCamera(
75,
container.clientWidth / container.clientHeight,
0.1,
1000
);

window.addEventListener("resize",function(){

camera.aspect = container.clientWidth / 420;

camera.updateProjectionMatrix();

renderer.setSize(container.clientWidth,420);

});

container.appendChild(renderer.domElement);

const controls = new THREE.OrbitControls(camera,renderer.domElement);


/* ===================================== */
/* ===== ANIMATION LOOP ===== */
/* ===================================== */

function animate(){

requestAnimationFrame(animate);

controls.update();

renderer.render(scene,camera);

}


/* ===================================== */
/* ===== LAB TYPE CHECK ===== */
/* ===================================== */

if(lab === "HOD Cabin"){

createHodCabin();

}else{

createProgrammingLab();

}

animate();

/* ===== PROGRAMMING LAB 3D ===== */
/* ================================================= */

function createProgrammingLab(){

/* ===== LIGHTING ===== */

const light=new THREE.AmbientLight(0xffffff,1.5);
scene.add(light);

const mainLight = new THREE.PointLight(0xffffff,2);
mainLight.position.set(0,10,0);
scene.add(mainLight);


/* ===== FLOOR ===== */

const floor=new THREE.Mesh(
new THREE.PlaneGeometry(40,40),
new THREE.MeshStandardMaterial({
color:0x1e293b,
roughness:0.6,
metalness:0.2
})
);

floor.rotation.x=-Math.PI/2;
scene.add(floor);


/* ===== WALLS ===== */

function createWall(x,y,z,width,height,depth){

const wall=new THREE.Mesh(
new THREE.BoxGeometry(width,height,depth),
new THREE.MeshStandardMaterial({color:0xf1f5f9})
);

wall.position.set(x,y,z);
scene.add(wall);

}

/* BACK WALL */

createWall(0,5,-12,24,10,0.5);

/* LEFT WALL */

createWall(-12,5,0,0.5,10,24);

/* RIGHT WALL */

createWall(12,5,0,0.5,10,24);


/* ===== CEILING ===== */

const ceiling=new THREE.Mesh(
new THREE.PlaneGeometry(40,40),
new THREE.MeshStandardMaterial({color:0xffffff})
);

ceiling.rotation.x=Math.PI/2;
ceiling.position.y=10;
scene.add(ceiling);


/* ===== WINDOWS ===== */

function createWindow(x,y,z){

const frame=new THREE.Mesh(
new THREE.BoxGeometry(3,2,0.2),
new THREE.MeshStandardMaterial({color:0x334155})
);

frame.position.set(x,y,z);
scene.add(frame);

const glass=new THREE.Mesh(
new THREE.PlaneGeometry(2.6,1.6),
new THREE.MeshStandardMaterial({
color:0x60a5fa,
transparent:true,
opacity:0.6
})
);

glass.position.set(x,y,z+0.11);
scene.add(glass);

}

for(let i=-8;i<=8;i+=4){
createWindow(-11,4,i);
}


/* ===== TUBE LIGHTS ===== */

function createTubeLight(x,y,z){

const tube=new THREE.Mesh(
new THREE.BoxGeometry(4,0.2,0.2),
new THREE.MeshStandardMaterial({color:0xffffff})
);

tube.position.set(x,y,z);
scene.add(tube);

const light=new THREE.PointLight(0xffffff,1.2,15);
light.position.set(x,y,z);
scene.add(light);

}

createTubeLight(0,9,0);
createTubeLight(0,9,6);
createTubeLight(0,9,-6);


/* ===== TABLE + COMPUTER ===== */

function createTable(x,z){

const table=new THREE.Mesh(
new THREE.BoxGeometry(3,0.2,1.2),
new THREE.MeshStandardMaterial({color:0x8b5a2b})
);

table.position.set(x,1,z);
scene.add(table);

/* COMPUTER */

const monitor=new THREE.Mesh(
new THREE.BoxGeometry(0.8,0.5,0.1),
new THREE.MeshStandardMaterial({color:0x111827})
);

monitor.position.set(x,1.4,z);
scene.add(monitor);

/* SCREEN */

const screen=new THREE.Mesh(
new THREE.PlaneGeometry(0.7,0.4),
new THREE.MeshBasicMaterial({color:0x22c55e})
);

screen.position.set(x,1.4,z+0.06);
scene.add(screen);

}


/* ===== CHAIR ===== */

function createChair(x,z){

const seat=new THREE.Mesh(
new THREE.BoxGeometry(0.7,0.1,0.7),
new THREE.MeshStandardMaterial({color:0x7f1d1d})
);

seat.position.set(x,0.6,z);
scene.add(seat);

const back=new THREE.Mesh(
new THREE.BoxGeometry(0.7,0.8,0.1),
new THREE.MeshStandardMaterial({color:0x991b1b})
);

back.position.set(x,1,z+0.3);
scene.add(back);

}


/* ===== STUDENT ===== */

function createStudent(x,z){

const body=new THREE.Mesh(
new THREE.BoxGeometry(0.5,1,0.5),
new THREE.MeshStandardMaterial({color:0x2563eb})
);

body.position.set(x,1.2,z);
scene.add(body);

const head=new THREE.Mesh(
new THREE.SphereGeometry(0.25,16,16),
new THREE.MeshStandardMaterial({color:0xffcc99})
);

head.position.set(x,1.9,z);
scene.add(head);

}


/* ===== LAB ROWS ===== */

for(let i=-8;i<=8;i+=3){

createTable(-6,i);
createChair(-6,i+1);
createStudent(-6,i+0.5);

}

for(let i=-8;i<=8;i+=3){

createTable(6,i);
createChair(6,i+1);
createStudent(6,i+0.5);

}


/* ===== CONNECTING ROW ===== */

for(let i=-3;i<=3;i+=3){

createTable(i,-10);
createChair(i,-9);
createStudent(i,-9.5);

}


/* ===== CAMERA ===== */

camera.position.set(0,6,15);
camera.lookAt(0,0,0);

animate();

}
/* ================================================= */
/* =====  HOD CABIN */
/* ================================================= */

function createHodCabin(){

/* ===== LIGHTING ===== */

const ambient=new THREE.AmbientLight(0xffffff,0.6);
scene.add(ambient);

const light=new THREE.DirectionalLight(0xffffff,1);
light.position.set(5,10,5);
light.castShadow=true;
scene.add(light);

const glowLight=new THREE.PointLight(0x38bdf8,1.2,40);
glowLight.position.set(0,6,0);
scene.add(glowLight);


/* ===== FLOOR ===== */

const floor=new THREE.Mesh(
new THREE.PlaneGeometry(40,40),
new THREE.MeshStandardMaterial({
color:0xe5e7eb,
roughness:0.2,
metalness:0.1
})
);

floor.rotation.x=-Math.PI/2;
floor.receiveShadow=true;
scene.add(floor);


/* ===== FUTURISTIC WALL MATERIAL ===== */

const wallMaterial=new THREE.MeshStandardMaterial({
color:0xf1f5f9,
emissive:0x0ea5e9,
emissiveIntensity:0.04,
roughness:0.6
});

function createWall(x,y,z,w,h,d){

const wall=new THREE.Mesh(
new THREE.BoxGeometry(w,h,d),
wallMaterial
);

wall.position.set(x,y,z);
scene.add(wall);

}


/* ===== WALLS ===== */

createWall(0,5,-12,24,10,0.5);
createWall(-12,5,0,0.5,10,24);
createWall(12,5,0,0.5,10,24);
createWall(0,5,12,24,10,0.5);


/* ===== DOOR (FRONT ENTRY) ===== */

const door=new THREE.Mesh(

new THREE.BoxGeometry(3,5,0.2),

new THREE.MeshStandardMaterial({
color:0x334155,
metalness:0.6,
roughness:0.2
})

);

door.position.set(0,2.5,12);
scene.add(door);


/* ===== WINDOW ===== */

const windowFrame=new THREE.Mesh(

new THREE.BoxGeometry(6,2.5,0.2),

new THREE.MeshStandardMaterial({color:0x64748b})

);

windowFrame.position.set(0,5,-11.8);
scene.add(windowFrame);


const glass=new THREE.Mesh(

new THREE.PlaneGeometry(5.6,2.1),

new THREE.MeshPhysicalMaterial({
color:0x7dd3fc,
transparent:true,
opacity:0.4,
reflectivity:1
})

);

glass.position.set(0,5,-11.7);
scene.add(glass);


/* ===== CUPBOARD ===== */

const cupboard=new THREE.Mesh(

new THREE.BoxGeometry(10,2,1.5),

new THREE.MeshStandardMaterial({color:0x9ca3af})

);

cupboard.position.set(0,1,-9);
scene.add(cupboard);


/* ===== TROPHIES ===== */

function createTrophy(x,z){

const base=new THREE.Mesh(
new THREE.CylinderGeometry(0.2,0.2,0.2,16),
new THREE.MeshStandardMaterial({color:0x8b5a2b})
);

base.position.set(x,2,z);
scene.add(base);

const cup=new THREE.Mesh(
new THREE.ConeGeometry(0.3,0.6,16),
new THREE.MeshStandardMaterial({color:0xffd700})
);

cup.position.set(x,2.4,z);
scene.add(cup);

}

for(let i=-3;i<=3;i+=2){
createTrophy(i,-9);
}


/* ===== HOD TABLE ===== */

const table=new THREE.Mesh(

new THREE.BoxGeometry(8,0.3,3),

new THREE.MeshStandardMaterial({
color:0x9ca3af,
metalness:0.5,
roughness:0.3
})

);

table.position.set(0,1,0);
table.castShadow=true;
scene.add(table);


/* ===== LAPTOP ===== */

const laptop=new THREE.Mesh(

new THREE.BoxGeometry(1.2,0.1,0.8),

new THREE.MeshStandardMaterial({color:0x111827})

);

laptop.position.set(0,1.3,0);
scene.add(laptop);


/* ===== HOD CHAIR ===== */

const hodChair=new THREE.Mesh(

new THREE.BoxGeometry(1,1,1),

new THREE.MeshStandardMaterial({color:0x1f2937})

);

hodChair.position.set(0,0.6,-1.8);
scene.add(hodChair);


/* ===== HOD PERSON ===== */

const body=new THREE.Mesh(

new THREE.BoxGeometry(0.8,1.2,0.6),

new THREE.MeshStandardMaterial({color:0x2563eb})

);

body.position.set(0,1.4,-1.5);
scene.add(body);

const head=new THREE.Mesh(

new THREE.SphereGeometry(0.35,16,16),

new THREE.MeshStandardMaterial({color:0xffcc99})

);

head.position.set(0,2.2,-1.5);
scene.add(head);


/* ===== VISITOR CHAIRS ===== */

function createChair(x,z,color){

const seat=new THREE.Mesh(

new THREE.BoxGeometry(0.8,0.1,0.8),

new THREE.MeshStandardMaterial({color:color})

);

seat.position.set(x,0.6,z);
scene.add(seat);

const back=new THREE.Mesh(

new THREE.BoxGeometry(0.8,0.8,0.1),

new THREE.MeshStandardMaterial({color:color})

);

back.position.set(x,1,z+0.3);
scene.add(back);

}


/* LEFT SIDE CHAIRS */

for(let i=0;i<4;i++){
createChair(-8,4-i*2,0x2563eb);
}


/* RIGHT SIDE CHAIRS */

for(let i=0;i<4;i++){
createChair(8,4-i*2,0x991b1b);
}


/* ===== PRINTER + PC ===== */

const printerTable=new THREE.Mesh(

new THREE.BoxGeometry(2,0.2,1),

new THREE.MeshStandardMaterial({color:0x9ca3af})

);

printerTable.position.set(9,1,-3);
scene.add(printerTable);


const pc=new THREE.Mesh(

new THREE.BoxGeometry(0.8,0.5,0.1),

new THREE.MeshStandardMaterial({color:0x111827})

);

pc.position.set(9,1.4,-3);
scene.add(pc);


const printer=new THREE.Mesh(

new THREE.BoxGeometry(0.6,0.4,0.6),

new THREE.MeshStandardMaterial({color:0xe5e7eb})

);

printer.position.set(9.8,1.3,-3);
scene.add(printer);


/* ===== CAMERA ===== */

camera.position.set(0,4,18);
camera.lookAt(0,1,0);


/* ===== ANIMATION ===== */

function animate(){

requestAnimationFrame(animate);

controls.update();

renderer.render(scene,camera);

}

animate();
}


});
