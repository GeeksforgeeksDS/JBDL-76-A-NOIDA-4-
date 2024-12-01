package com.example.SpringSecuirtyApp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/student")
    public String getClassRoom(){
        return "student has the access of hostel room";
    }


    @GetMapping("/faculty")
    public String getStaffRoom(){
        return "faculty has the access of staffroom";
    }

    @GetMapping("/library")
    public String getLibrary(){
        return "Everyone has the access of library";
    }

    @GetMapping("/admin")
    public String getAdminRoom(){
        return "admin has the access of adminroom";
    }


}
