package com.example.palindrome_checker;

import org.springframework.stereotype.Service;

@Service
class PalindromeService {

    public boolean isPalindrome(String input) {
        String original = input.toLowerCase();
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }
}

