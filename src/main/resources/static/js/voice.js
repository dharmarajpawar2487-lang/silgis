/* ========================================= */
/* ===== AI VOICE GUIDE ==================== */
/* ========================================= */

function speakLabIntro(){

let lab = document.getElementById("labName").innerText;
let lang = document.getElementById("voiceLang").value;

let info = {};

/* PROGRAMMING LAB */

if(lab === "Programming Lab"){

info = {

en:"Welcome to the Programming Lab. This laboratory is used for learning programming languages and coding practice. Students write programs, perform practical experiments and develop software projects using computers. The lab helps students improve logical thinking, problem solving skills and programming knowledge required for software development.",

hi:"प्रोग्रामिंग लैब में आपका स्वागत है। इस लैब में छात्र विभिन्न प्रोग्रामिंग भाषाएँ सीखते हैं और कोडिंग का अभ्यास करते हैं। यहाँ छात्र प्रोग्राम लिखते हैं, प्रैक्टिकल प्रयोग करते हैं और सॉफ्टवेयर प्रोजेक्ट विकसित करते हैं। यह लैब छात्रों की लॉजिकल थिंकिंग, समस्या समाधान क्षमता और सॉफ्टवेयर विकास कौशल को बेहतर बनाती है।",

mr:"प्रोग्रामिंग लॅबमध्ये आपले स्वागत आहे. या लॅबमध्ये विद्यार्थी विविध प्रोग्रामिंग भाषा शिकतात आणि कोडिंगचा सराव करतात. येथे विद्यार्थी प्रोग्राम लिहितात, प्रॅक्टिकल प्रयोग करतात आणि सॉफ्टवेअर प्रकल्प विकसित करतात. ही लॅब विद्यार्थ्यांची लॉजिकल थिंकिंग, समस्या सोडवण्याची क्षमता आणि सॉफ्टवेअर विकास कौशल्य वाढवते."

};

}


/* MICROPROCESSOR LAB */

else if(lab === "Microprocessor Lab"){

info = {

en:"The Microprocessor Laboratory is used to study the working and programming of microprocessors and microcontrollers. In this lab students perform experiments on processor architecture, assembly language programming and interfacing techniques. The laboratory contains microprocessor kits, trainers and computers which help students understand low level hardware operations and embedded system concepts.",

hi:"माइक्रोप्रोसेसर लैब में माइक्रोप्रोसेसर और माइक्रोकंट्रोलर के कार्य और प्रोग्रामिंग का अध्ययन किया जाता है। इस लैब में छात्र प्रोसेसर आर्किटेक्चर, असेंबली लैंग्वेज प्रोग्रामिंग और इंटरफेसिंग तकनीकों पर प्रयोग करते हैं। यहाँ माइक्रोप्रोसेसर किट, ट्रेनर और कंप्यूटर उपलब्ध हैं जो छात्रों को हार्डवेयर ऑपरेशन और एम्बेडेड सिस्टम की समझ देते हैं।",

mr:"मायक्रोप्रोसेसर लॅबमध्ये मायक्रोप्रोसेसर आणि मायक्रोकंट्रोलरचे कार्य आणि प्रोग्रामिंगचा अभ्यास केला जातो. या लॅबमध्ये विद्यार्थी प्रोसेसर आर्किटेक्चर, असेंब्ली भाषा प्रोग्रामिंग आणि इंटरफेसिंग तंत्रज्ञानावर प्रयोग करतात. येथे मायक्रोप्रोसेसर किट, ट्रेनर आणि संगणक उपलब्ध आहेत जे विद्यार्थ्यांना लो लेव्हल हार्डवेअर ऑपरेशन आणि एम्बेडेड सिस्टम समजण्यास मदत करतात."

};

}


/* COMPUTER CENTER */

else if(lab === "Computer Center Lab"){

info = {

en:"The Computer Center provides computing facilities for students and faculty members. It contains multiple computers with internet connectivity and essential software required for academic activities. Students use this lab for programming practice, project development, research work and learning different computer applications.",

hi:"कंप्यूटर सेंटर छात्रों और शिक्षकों को कंप्यूटिंग सुविधाएँ प्रदान करता है। यहाँ इंटरनेट से जुड़े कई कंप्यूटर और शैक्षणिक गतिविधियों के लिए आवश्यक सॉफ्टवेयर उपलब्ध हैं। छात्र इस लैब का उपयोग प्रोग्रामिंग अभ्यास, प्रोजेक्ट विकास, रिसर्च कार्य और विभिन्न कंप्यूटर एप्लिकेशन सीखने के लिए करते हैं।",

mr:"कॉम्प्युटर सेंटर विद्यार्थ्यांना आणि शिक्षकांना संगणकीय सुविधा उपलब्ध करून देते. येथे इंटरनेटसह अनेक संगणक आणि शैक्षणिक कामांसाठी आवश्यक सॉफ्टवेअर उपलब्ध आहेत. विद्यार्थी या लॅबमध्ये प्रोग्रामिंगचा सराव, प्रोजेक्ट डेव्हलपमेंट, रिसर्च आणि विविध संगणक अनुप्रयोग शिकतात."

};

}


/* HARDWARE LAB */

else if(lab === "Hardware Lab"){

info = {

en:"The Hardware Laboratory provides practical knowledge about computer hardware components and their functioning. Students learn how to assemble and disassemble computers, troubleshoot hardware problems and understand components such as motherboard, CPU, RAM and storage devices.",

hi:"हार्डवेयर लैब में छात्रों को कंप्यूटर हार्डवेयर के बारे में प्रायोगिक ज्ञान दिया जाता है। यहाँ छात्र कंप्यूटर को असेंबल और डिसअसेंबल करना, हार्डवेयर समस्याओं को ठीक करना और मदरबोर्ड, सीपीयू, रैम तथा स्टोरेज डिवाइस जैसे घटकों को समझना सीखते हैं।",

mr:"हार्डवेअर लॅबमध्ये विद्यार्थ्यांना संगणकाच्या हार्डवेअर घटकांचे प्रात्यक्षिक ज्ञान दिले जाते. येथे विद्यार्थी संगणक असेंबल आणि डिसअसेंबल करणे, हार्डवेअर समस्या सोडवणे आणि मदरबोर्ड, CPU, RAM व स्टोरेज डिव्हाइस समजून घेणे शिकतात."

};

}


/* SOFTWARE TESTING LAB */

else if(lab === "Software Testing Lab"){

info = {

en:"The Software Testing Laboratory helps students learn different techniques used to test software applications. In this lab students perform manual and automated testing using various testing tools. They learn about test cases, debugging, quality assurance and ensuring the reliability of software systems.",

hi:"सॉफ्टवेयर टेस्टिंग लैब में छात्र सॉफ्टवेयर एप्लिकेशन को टेस्ट करने की विभिन्न तकनीकें सीखते हैं। यहाँ छात्र मैनुअल और ऑटोमेटेड टेस्टिंग करते हैं और विभिन्न टेस्टिंग टूल्स का उपयोग करते हैं। वे टेस्ट केस, डिबगिंग, क्वालिटी एश्योरेंस और सॉफ्टवेयर की विश्वसनीयता सुनिश्चित करना सीखते हैं।",

mr:"सॉफ्टवेअर टेस्टिंग लॅबमध्ये विद्यार्थी सॉफ्टवेअर अनुप्रयोगांची चाचणी करण्याच्या विविध पद्धती शिकतात. येथे विद्यार्थी मॅन्युअल आणि ऑटोमेटेड टेस्टिंग करतात आणि विविध टेस्टिंग टूल्स वापरतात. ते टेस्ट केस, डिबगिंग, क्वालिटी अ‍ॅश्युरन्स आणि सॉफ्टवेअरची विश्वासार्हता सुनिश्चित करणे शिकतात."

};

}


/* NETWORKING LAB */

else if(lab === "Networking Lab"){

info = {

en:"The Networking Laboratory provides practical knowledge about computer networks and communication systems. Students learn network configuration, IP addressing, routing, switching and network security. The lab contains routers, switches, network cables and computers for hands on practice.",

hi:"नेटवर्किंग लैब में छात्रों को कंप्यूटर नेटवर्क और संचार प्रणाली का प्रायोगिक ज्ञान दिया जाता है। यहाँ छात्र नेटवर्क कॉन्फ़िगरेशन, आईपी एड्रेसिंग, राउटिंग, स्विचिंग और नेटवर्क सुरक्षा सीखते हैं। इस लैब में राउटर, स्विच, नेटवर्क केबल और कंप्यूटर उपलब्ध हैं।",

mr:"नेटवर्किंग लॅबमध्ये विद्यार्थ्यांना संगणक नेटवर्क आणि कम्युनिकेशन सिस्टिमचे प्रात्यक्षिक ज्ञान दिले जाते. येथे विद्यार्थी नेटवर्क कॉन्फिगरेशन, आयपी अ‍ॅड्रेसिंग, राउटिंग, स्विचिंग आणि नेटवर्क सुरक्षा शिकतात. या लॅबमध्ये राउटर, स्विच, नेटवर्क केबल आणि संगणक उपलब्ध आहेत."

};

}


/* HOD CABIN */

else if(lab === "HOD Cabin"){

info = {

en:"The Head of Department cabin is the administrative office of the department. It is used for departmental planning, academic management and student guidance. The HOD monitors teaching activities, conducts meetings with faculty members and supports students in academic and career development.",

hi:"एच ओ डी केबिन विभाग का प्रशासनिक कार्यालय है। यहाँ विभागीय योजना, शैक्षणिक प्रबंधन और छात्रों का मार्गदर्शन किया जाता है। विभाग प्रमुख शिक्षण गतिविधियों की निगरानी करते हैं, शिक्षकों के साथ बैठक करते हैं और छात्रों को शैक्षणिक तथा करियर मार्गदर्शन प्रदान करते हैं।",

mr:"विभाग प्रमुखांचे केबिन हे विभागाचे प्रशासकीय कार्यालय आहे. येथे विभागीय नियोजन, शैक्षणिक व्यवस्थापन आणि विद्यार्थ्यांना मार्गदर्शन केले जाते. विभाग प्रमुख अध्यापनाच्या कामावर देखरेख करतात, शिक्षकांबरोबर बैठक घेतात आणि विद्यार्थ्यांना शैक्षणिक व करिअर मार्गदर्शन देतात."

};

}
let speech = new SpeechSynthesisUtterance(info[lang.split("-")[0]]);
speech.lang = lang;

window.speechSynthesis.speak(speech);

}

/* PAGE LOAD */

window.onload = speakLabIntro;
