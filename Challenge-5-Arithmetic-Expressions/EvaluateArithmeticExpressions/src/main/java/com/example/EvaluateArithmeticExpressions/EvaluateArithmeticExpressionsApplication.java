package com.example.EvaluateArithmeticExpressions;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

@SpringBootApplication
public class EvaluateArithmeticExpressionsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EvaluateArithmeticExpressionsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        getClass().getClassLoader().getResourceAsStream("input.txt")
                )
        );

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        String line;

        while ((line = reader.readLine()) != null) {

            // Remove '='
            String expressionStr = line.replace("=", "").trim();

            // Handle implicit multiplication: ") (" → ")*("
            expressionStr = expressionStr.replaceAll("\\)\\s*\\(", ")*(");

            // exp4j SUPPORTS ^ directly → DO NOTHING here

            // Build and evaluate expression
            Expression expression = new ExpressionBuilder(expressionStr).build();
            double result = expression.evaluate();

            // Write result to output file
            writer.write(line.replace("=", "= " + (long) result));
            writer.newLine();
        }

        reader.close();
        writer.close();

        System.out.println("SUCCESS ✅ Output written to output.txt");
    }
}
