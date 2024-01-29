package com.ltimindtree.home.controller;

import com.ltimindtree.otp.service.OTPService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    public OTPService otpService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String homePage(Model model){
        String message = "Welcome to Home Page";
        model.addAttribute("appName", appName);
        model.addAttribute("message", message);
        return "signin";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String dashboard(){
        return "dashboard";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String login(){
        return "signin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String admin(){
        return "admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String user(){
        return "user";
    }

    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String about(){
        return "aboutus";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String error403(){
        return "error/403";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            String username = auth.getName();
            //Remove the recently used OTP from server.
            otpService.clearOTP(username);
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/login?logout";
    }
}
