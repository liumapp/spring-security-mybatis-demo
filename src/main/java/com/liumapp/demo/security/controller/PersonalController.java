package com.liumapp.demo.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liumapp on 2/2/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping("personal")
public class PersonalController {

    @PreAuthorize("hasRole('PERSONAL')")
    public ResponseEntity<?> getPersonalGreeting () {
        return ResponseEntity.ok("Greeting from personal");
    }

}
