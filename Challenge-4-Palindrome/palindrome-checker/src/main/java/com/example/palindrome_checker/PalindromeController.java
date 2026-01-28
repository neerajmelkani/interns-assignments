package com.example.palindrome_checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/palindrome")
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @GetMapping("/{input}")
    public String checkPalindrome(@PathVariable String input) {

        if (palindromeService.isPalindrome(input)) {
            return "The string '" + input + "' is a palindrome.";
        } else {
            return "The string '" + input + "' is not a palindrome.";
        }
    }
}
