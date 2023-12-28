//import Scanner class
import java.util.Scanner;
import java.lang.*;

    public class MyProgram
    {
        //declare static variables - to use in all methods throughout your program
        static Scanner scan = new Scanner(System.in);
        static final String answer = "Know the enemy and know yourself; in a hundred battles you will never be defeated - sun tzu the art of war"; //your riddle
        static int lives = 5, room; // room is the room number chosen by user
        static double math_guess; //contains user answers to math questions when visiting rooms
        static String name, guess;//name is the user name; guess is the user riddle guess
        
        public static void main(String[] args)
        {
            // call welcome method
            welcome();
            System.out.println("");
            // while loop - guess the riddle and visit rooms (write a separate method for rooms)
            while(true)
            {
                // ask the user to guess the riddle and exit game if correct
                System.out.println("What is your guess of the key phrase? ");
                guess = scan.nextLine();
                if(guess.toLowerCase().equals(answer))
                {
                    System.out.println("Congrats you won the game!");
                    System.exit(0);
                }
                else
                {
                    System.out.println("You guessed wrong try again! ");
                    lives -= 1;
                    System.out.println("You have " + lives + " lives left!");
                    if(lives == 0)
                    {
                        System.out.println("You Lost");
                        System.exit(0);
                    }
                }
                //ask the user which room they would like to visit and call the method rooms()
                System.out.println("Which room would you like to enter? 1, 2, 3, or 4?");
                rooms(scan.nextInt());
                //print number of lives left and stop game if lives = 0
                
                
                scan.nextLine(); // wait for input
            }
        }
        
        public static void welcome()
        {
            // provide welcome message
            System.out.println("Welcome to our game we hope you enjoy!");
            
            //ask for name
            System.out.print("What's your First and Last name adventurer? ");
            name = scan.nextLine();
            // print the length of the name, the initials, and print the name backwards
            System.out.println("Your name is " + name.length() + " characters long ");
            char initial1 = name.charAt(0);
            int ind = name.indexOf(" ") + 1;
            char initial2 = name.charAt(ind);
            System.out.println("Your initials are: " + initial1 + initial2);
            
            for(int i = name.length() - 1; i >= 0; i--)
            {
                System.out.print(name.charAt(i));
            }
            
            //i made room 1, 2, and 3.
        }
        public static void rooms(int room)
        {
        // each room has its own monster, math problem
        // use conditional statements to select rooms
            if(room == 1)
            {
            //present monster
                System.out.println("You are faced with a monster!");
                System.out.println("To beat it answer 2 squared");
                if(scan.nextInt() == 4)
                {
                    System.out.println("Congrats you beat the monster!");
                    System.out.println("It dropped a hint: Many rich people commit this crime.");
                }
                else
                {
                    System.out.println("You answered wrong!");
                }
            //ask question to provide hint or lose life
            
            }
            
            //i made room 1, 2, and 3.
        
        // continue for 3 other rooms (4 in total)
            else if(room == 2)
            {
                System.out.println("You are faced with a monster!");
                System.out.println("To beat it answer 3 squared");
                if(scan.nextInt() == 9)
                {
                    System.out.println("Congrats you beat the monster!");
                    System.out.println("It dropped a hint: commonly used when ending an email or quoting someone");
                }
                else
                {
                    System.out.println("You answered wrong!");
                }
                
            //i made room 1, 2, and 3.
            }
            else if(room == 3)
            {
                System.out.println("You are faced with a monster!");
                System.out.println("To beat it answer 4 Cubed");
                if(scan.nextInt() == 64)
                {
                    System.out.println("Congrats you beat the monster!");
                    System.out.println("It dropped a hint: sun tzu");
                }
                else
                {
                    System.out.println("You answered wrong!");
                }
            }
            else if(room == 4)
            {
                System.out.println("You are faced with a monster!");
                System.out.println("To beat it answer 5 to the power of 4");
                if(scan.nextInt() == 625)
                {
                    System.out.println("Congrats you beat the monster!");
                    System.out.println("It dropped a hint: His most famous book");
                }
                else
                {
                    System.out.println("You answered wrong!");
                }
            }
        }
    }
