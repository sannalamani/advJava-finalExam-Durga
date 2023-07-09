package fr.epita.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberRestController {

    @GetMapping
    public String getMembers() {
        System.out.println("Hello from GET!");
        return "Hello from GET!";
    }

    @PostMapping
    public String createMember() {
        System.out.println("Hello from POST!");
        return "Hello from POST!";
    }
}