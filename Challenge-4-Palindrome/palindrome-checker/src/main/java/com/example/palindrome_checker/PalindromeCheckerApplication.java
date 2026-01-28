package com.example.palindrome_checker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PalindromeCheckerApplication implements CommandLineRunner {

    private final PalindromeService palindromeService;

    public PalindromeCheckerApplication(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PalindromeCheckerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (palindromeService.isPalindrome(input)) {
            System.out.println("The string '" + input + "' is a palindrome.");
        } else {
            System.out.println("The string '" + input + "' is not a palindrome.");
        }
    }
}
