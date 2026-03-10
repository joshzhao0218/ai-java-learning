package com.josh.ai;

import java.util.Random;
import java.util.Scanner;

/**
 * Number Guessing AI - AI that guesses your number
 * 
 * This program demonstrates a simple AI that uses binary search
 * to guess a number you're thinking of (1-100).
 */
public class NumberGuessingAI {
    
    private int min = 1;
    private int max = 100;
    private Scanner scanner = new Scanner(System.in);
    
    /** Reset the guessing range */
    public void reset() {
        min = 1;
        max = 100;
    }
    
    /** Make a guess using binary search */
    public int makeGuess() {
        return (min + max) / 2;
    }
    
    /** Update range based on feedback */
    public void updateRange(String feedback) {
        int guess = makeGuess();
        if (feedback.equalsIgnoreCase("too high")) {
            max = guess - 1;
        } else if (feedback.equalsIgnoreCase("too low")) {
            min = guess + 1;
        }
    }
    
    /** Play the guessing game */
    public void play() {
        System.out.println("\n<pencil>️ TNumber Guessing AI");
        System.out.println("===========================================");
        System.out.println("Think of a number between 1 and 100...");
        System.out.println("I will guess your number!\n");
        
        reset();
        int attempts = 0;
        
        while (min <= max) {
            int guess = makeGuess();
            attempts++;
            
            System.out.print("AI guesses: " + guess + " - It is ... ");
            System.out.println("(too high/too low/correct): ");
            String feedback = scanner.nextLine();
            
            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("\n✇∟ AI guessed it in " + attempts + " attempts!");
                return;
            }
            
            updateRange(feedback);
        }
        
        System.out.println("SOmething went wrong...");
    }
    
    // Main method
    public static void main(String[] args) {
        NumberGuessingAI game = new NumberGuessingAI();
        game.play();
    }
}
