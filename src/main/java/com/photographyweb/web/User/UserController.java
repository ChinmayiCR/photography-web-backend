package com.photographyweb.web.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.photographyweb.web.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/images")
    public String getAllImages(){
        return "Successful";
    }

    @GetMapping("/images/{imageId}")
    public String getImageById(@PathVariable String imageId){
        return "Successful";
    }

    @PostMapping("/contactus")
    public void postContactus(@RequestBody User user){
        return;
    }
}
