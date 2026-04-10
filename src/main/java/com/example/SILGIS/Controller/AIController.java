package com.example.SILGIS.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AIController {

    @PostMapping("/ask")
    public String askAI(@RequestBody Map<String,String> data){

        String question = data.get("question");
        String lang = data.get("lang");

        String q = question.toLowerCase();

        /* ================= PROGRAMMING LAB ================= */

        if(q.contains("programming")){

            if(lang.equals("mr"))
                return "प्रोग्रामिंग लॅबमध्ये आपले स्वागत आहे. येथे विद्यार्थी प्रोग्रामिंग भाषा शिकतात आणि कोडिंगचा सराव करतात.";

            if(lang.equals("hi"))
                return "प्रोग्रामिंग लैब में आपका स्वागत है। यहाँ छात्र प्रोग्रामिंग भाषाएँ सीखते हैं और कोडिंग का अभ्यास करते हैं।";

            return "Welcome to Programming Lab. This laboratory is used for learning programming languages and coding practice. Students develop software programs and projects.";
        }


        /* ================= MICROPROCESSOR LAB ================= */

        if(q.contains("microprocessor")){

            if(lang.equals("mr"))
                return "मायक्रोप्रोसेसर लॅबमध्ये विद्यार्थी मायक्रोप्रोसेसर आणि मायक्रोकंट्रोलरचा अभ्यास करतात.";

            if(lang.equals("hi"))
                return "माइक्रोप्रोसेसर लैब में छात्र माइक्रोप्रोसेसर और माइक्रोकंट्रोलर का अध्ययन करते हैं।";

            return "The Microprocessor Laboratory is used to study microprocessors and microcontrollers including processor architecture and assembly programming.";
        }


        /* ================= COMPUTER CENTER ================= */

        if(q.contains("computer center") || q.contains("computer")){

            if(lang.equals("mr"))
                return "कॉम्प्युटर सेंटर विद्यार्थ्यांना संगणकीय सुविधा उपलब्ध करून देते.";

            if(lang.equals("hi"))
                return "कंप्यूटर सेंटर छात्रों और शिक्षकों को कंप्यूटिंग सुविधाएँ प्रदान करता है।";

            return "The Computer Center provides computing facilities with internet access for students and faculty.";
        }


        /* ================= HARDWARE LAB ================= */

        if(q.contains("hardware")){

            if(lang.equals("mr"))
                return "हार्डवेअर लॅबमध्ये विद्यार्थी संगणक हार्डवेअरबद्दल शिकतात.";

            if(lang.equals("hi"))
                return "हार्डवेयर लैब में छात्र कंप्यूटर हार्डवेयर के बारे में सीखते हैं।";

            return "The Hardware Laboratory teaches students about computer components, assembling computers and troubleshooting hardware issues.";
        }


        /* ================= SOFTWARE TESTING LAB ================= */

        if(q.contains("testing")){

            if(lang.equals("mr"))
                return "सॉफ्टवेअर टेस्टिंग लॅबमध्ये विद्यार्थी सॉफ्टवेअर चाचणी शिकतात.";

            if(lang.equals("hi"))
                return "सॉफ्टवेयर टेस्टिंग लैब में छात्र सॉफ्टवेयर टेस्टिंग सीखते हैं।";

            return "The Software Testing Laboratory teaches students how to test software applications using manual and automated testing techniques.";
        }


        /* ================= NETWORKING LAB ================= */

        if(q.contains("network")){

            if(lang.equals("mr"))
                return "नेटवर्किंग लॅबमध्ये विद्यार्थी संगणक नेटवर्क शिकतात.";

            if(lang.equals("hi"))
                return "नेटवर्किंग लैब में छात्र कंप्यूटर नेटवर्क के बारे में सीखते हैं।";

            return "The Networking Laboratory provides practical knowledge about computer networks including IP addressing and routing.";
        }


        /* ================= HOD CABIN ================= */

        if(q.contains("hod")){

            if(lang.equals("mr"))
                return "विभाग प्रमुखांचे केबिन हे विभागाचे प्रशासकीय कार्यालय आहे.";

            if(lang.equals("hi"))
                return "एच ओ डी केबिन विभाग का प्रशासनिक कार्यालय है।";

            return "The Head of Department cabin is used for academic planning, meetings and student guidance.";
        }


        /* ================= GREETING ================= */

        if(q.contains("hello") || q.contains("hi")){

            if(lang.equals("mr"))
                return "नमस्कार! SILGIS Smart Lab Tour मध्ये आपले स्वागत आहे.";

            if(lang.equals("hi"))
                return "नमस्ते! SILGIS Smart Lab Tour में आपका स्वागत है।";

            return "Hello! Welcome to SILGIS Smart Lab Tour.";
        }


        /* ================= DEFAULT RESPONSE ================= */

        if(lang.equals("mr"))
            return "मी SILGIS AI Assistant आहे. कृपया लॅब बद्दल प्रश्न विचारा.";

        if(lang.equals("hi"))
            return "मैं SILGIS AI Assistant हूँ। कृपया लैब के बारे में पूछें।";

        return "I am SILGIS AI Assistant. Please ask about any lab.";
    }
}