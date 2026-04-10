package com.example.SILGIS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Controller
public class AdminController {

    // ===============================
    // Open Admin Login Page
    // ===============================

    @GetMapping("/admin")
    public String openAdminLogin(){

        return "admin_login";

    }

    // ===============================
    // Handle Admin Login
    // ===============================

    @PostMapping("/admin/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password
    ){

        if(username.equals("admin") && password.equals("admin123")){

            return "redirect:/dashboard";

        }

        return "admin_login";

    }

    // ===============================
    // Logout Admin
    // ===============================

    @GetMapping("/logout")
    public String logout(
            HttpServletRequest request,
            HttpServletResponse response
    ){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null){

            new SecurityContextLogoutHandler().logout(request,response,auth);

        }

        return "redirect:/admin";

    }

}