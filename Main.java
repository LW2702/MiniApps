package com.company;

import java.util.Scanner;

public class Main
{

    public void keepCounting()
    {
        int totalQuestionsAsked = 11;
        int questionNumber = 1;
        /*
         int correctAnswers will be used to display the time taken to complete the test,
         provided that all answers are correct.
         */
        int correctAnswers = 0;

        System.out.println("Keep Counting\n" +
                "-------------\n" +
                "You will be presented with 10 addition questions.\n" +
                "After the first question, the left-hand operand \n" +
                "is the result of the previous addition. \n" +
                "Press enter to start...\n");

        int digitOne = 1 + (int)(Math.random() * 10); // this will assign the first digit of the question. It is not in the
        // loop because it would generate a random number each time the loop ran through, not allowing for the answer to be used instead.
        long startTime = System.currentTimeMillis();

        /*
        the while loop makes sure that no more than 10 questions are asked
         */

        while (questionNumber < totalQuestionsAsked)
        {
            int chooseOperator = 1 + (int)(Math.random() * 2);
            char operator;

            if (chooseOperator == 1)
            {
                operator = '-' ;
            }
            else
            {
                operator = '+';
            }




            int digitTwo = 1 + (int)(Math.random() * 10);
            int sum;


            if (operator == '-')                // this if else statement determines the answer to the question, depending on if operator is + or -
            {

                sum = digitOne - digitTwo;
                if (digitOne < digitTwo)         // this loop will make sure that the answer to the question is always positive
                {
                    while (digitOne < digitTwo)
                    {
                        digitTwo = 1 * (int) (Math.random() * 10);
                    }

                }
                System.out.println("Question " + questionNumber + " : " + digitOne + "  "+ operator + " " + digitTwo + " " + "= ?");
                sum = digitOne - digitTwo;
            }



            else
            {
                System.out.println("Question " + questionNumber + " : " + digitOne + "  "+ operator + " " + digitTwo + " " + "= ?");
                sum = digitOne + digitTwo;
            }

            java.util.Scanner scan = new java.util.Scanner(System.in);



            // this takes the user's answer
            int answer = scan.nextInt();

            if (answer == sum)
            {
                ++correctAnswers;
                digitOne = sum;
            }

            else
            {
                System.out.println("Incorrect. The answer is " + sum);
                break;
            }

            questionNumber++;

        }

        long endTime = System.currentTimeMillis();
         /*
         this if statement checks if all answers entered have been correct.
         If so, the time taken will be displayed.
          */
        if (correctAnswers == 10)
        {
            long totalTime = (endTime - startTime) / 1000;
            System.out.println("The questions were completed in: " +  totalTime + " seconds.");

        }

        System.out.println("\n\n");

        Main app = new Main(); // loads the menu again
        app.menu();

    }


    public void squareRoot() // this is the square root calculator
    {
        System.out.println("""
                Square Root Calculator
                ----------------------
                """);

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a positive number:"); // the number to be square rooted
        int number = in.nextInt();

        System.out.println("How many decimal places do you want the solution calculated to: ");
        int decimalPlaces = in.nextInt();// was decimalPlaces
        double accuracy = 0.00001; // used for the square root calculation. This makes the more accurate


        double lowerBound = 1;             // sq.rt of 1
        double upperBound = 1000;  // sq.rt of 1000000 is 1000


        float average = 0;//= (lowerbound + upperBound) / 2; this will be the average of the bounds
        float averageSq; // this will be the average squared
        double diffBetweenBounds = upperBound - lowerBound;
        float averageTwo;  // stores the average in another variable to be multiplied with average

        /*
        the next lines of code will find the square root of the number
         */




        while (diffBetweenBounds > accuracy)                     // this keeps the process going until square root is met
        {
            average = (float) ((lowerBound + upperBound) / 2);
            averageTwo = average;
            averageSq = (average * averageTwo); // the average of the bounds squared
            if (averageSq > number)
            {
                upperBound = average;
                diffBetweenBounds = upperBound - lowerBound; // updates the value to be compared with accuracy


            }
            else if (averageSq < number)
            {
                lowerBound = average;
                diffBetweenBounds = upperBound - lowerBound;

            }



        }
        // these will be used to display the square root to the desired amount of decimal places
        java.text.DecimalFormat formatter = new java.text.DecimalFormat("0.0");
        java.text.DecimalFormat formatterTwo = new java.text.DecimalFormat("0.00");
        java.text.DecimalFormat formatterThree = new java.text.DecimalFormat("0.000");
        java.text.DecimalFormat formatterFour = new java.text.DecimalFormat("0.0000");
        java.text.DecimalFormat formatterFive = new java.text.DecimalFormat("0.00000");
        java.text.DecimalFormat formatterSix = new java.text.DecimalFormat("0.000000");
        java.text.DecimalFormat formatterSeven = new java.text.DecimalFormat("0.0000000");

        switch (decimalPlaces) // creates the options for how many decimal places depending on user input
        {
            case 1: System.out.println("The number " + number + " rounded to " + decimalPlaces + " decimal places is: " + formatter.format(average)); break;
            case 2: System.out.println("The number " + number + " rounded to " + decimalPlaces + " decimal places is: " +formatterTwo.format((average))); break;
            case 3: System.out.println("The number " + number + " rounded to " + decimalPlaces + " decimal places is: " +formatterThree.format(average)); break;
            case 4: System.out.println("The number " + number + " rounded to " + decimalPlaces + " decimal places is: " +formatterFour.format(average)); break;
            case 5: System.out.println("The number " + number + " rounded to " + decimalPlaces + " decimal places is: " +formatterFive.format(average)); break;
            case 6: System.out.println("The number " + number + " rounded to " + decimalPlaces + " decimal places is: " +formatterSix.format((average))); break;
            case 7: System.out.println("The number " + number + " rounded to " + decimalPlaces + " decimal places is: " +formatterSeven.format(average)); break;


        }
        System.out.println("\n\n");

        Main app = new Main(); // loads the menu again
        app.menu();
    }


    public void findDigit() // will handle finding the check digit for the check digit generator
    {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int inputOriginalDigit = in.nextInt();
        int originalDigit = inputOriginalDigit; // int originalDigit will be used for calculations

        /*
        int first will get the first digit of the number as, for example,
        12000 / 1000 = 1, the type int cannot hold decimal values.
         */
        int first = originalDigit / 10000;

        /*
        the next lines of code will get rid of the digit nearest to
        the left in originalDigit and store them in a separate variable.
        This allows for the process to be redone, allowing for all
        the digits to be separated.
         */
        originalDigit -= first * 10000;

        int second = originalDigit / 1000;
        originalDigit -= second * 1000;

        int third = originalDigit / 100;
        originalDigit -= third * 100;

        int fourth = originalDigit / 10;

        int fifth = originalDigit - fourth * 10;

        // this if statement will check if the input has any zeroes in it
        if (first == 0 || second == 0 || third == 0 || fourth == 0 || fifth == 0) {
            System.out.println("That number is invalid. It cannot contain 0. \n"
                                + "Enter a number: ");
            inputOriginalDigit = 0;
            findDigit();
        }

        /*
        the next lines of code will find the check digit
         */

        int oddPlacedDigits = (first + third + fifth) * 7;
        int evenPlacedDigits = (second + fourth) * 3;
        int sumOfPlaces = oddPlacedDigits + evenPlacedDigits;



        int checkDigit = sumOfPlaces % 10;

        if (checkDigit == 0) {
            System.out.println("The 6-digit final number is: " + inputOriginalDigit + checkDigit);
        } else {
            checkDigit = 10 - checkDigit;
            System.out.println("The 6-digit final number is: " + inputOriginalDigit + checkDigit);
        }


    }

    /*
    test plan for the check digit generator app

    input     expected     output
    12345     123459       123459
    23456     234562       234562
    30923     error        error
    34598     345989       345989
    00200     error        error

     */
    public void checkDigitGen()
    {
        System.out.println("""
                Check-Digit Calculator
                ----------------------
                """);
        System.out.println("""
                This calculator will take a 5-digit number
                and generate a trailing 6th check digit
                Please enter 5-digit number to generate final code:\s
                """);
        Main app = new Main();
        app.findDigit();
        app.menu();

    }




    public void checkDigitCheck() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Please enter 6-digit number to check:");
        int numberToCheck = in.nextInt();
        int inputToCheck = numberToCheck; // inputToCheck will be used in the calculations

        int first = inputToCheck / 100000;


        // this process is the same as check digit generator, but it will include a sixth digit.

        inputToCheck -= first * 100000;

        int second = inputToCheck / 10000;
        inputToCheck -= second * 10000;

        int third = inputToCheck / 1000;
        inputToCheck -= third * 1000;

        int fourth = inputToCheck / 100;
        inputToCheck -= fourth * 100;

        int fifth = inputToCheck / 10;

        int sixth = inputToCheck - fifth * 10;

        int oddPlacedDigits = (first + third + fifth) * 7;
        int evenPlacedDigits = (second + fourth) * 3;
        int sumOfPlaces = oddPlacedDigits + evenPlacedDigits;

        int checkDigit = sumOfPlaces % 10;

        if (checkDigit == 0 && checkDigit == sixth || (10 - checkDigit == sixth)) // if either of these conditions are met, the check digit is valid
        {
            System.out.println("The number is valid");
        }
        else if (first == 0 || second == 0 || third == 0 || fourth == 0 || fifth == 0) // only the sixth digit is allowed to be zero
        {
            System.out.println("The number is not valid");
        }
        else
        {
            System.out.println("The number is not valid");   // if the conditions in the if statement are not met, the number is not valid
        }
        Main app = new Main();
        app.menu();


    }
    public int quit()  // this is for ending the program
    {
        return 0;
    }

    public void menu()   // this method generates the menu for the user to view the available applications, and prompts them to enter a choice
    {
        //java.util.Scanner in = new java.util.Scanner(System.in); // A scanner will allow for the user to interact with the program by being able to input data.
        // This is the menu that will show the selection of applications to the user.
        System.out.println("P4CS Mini Applications \n---------------------------");
        System.out.println("Please select an option:");
        System.out.println("1) Keep Counting Game");
        System.out.println("2) Square Root Calculator");
        System.out.println("3) Check-Digit Generator");
        System.out.println("4) Check-Digit Checker");
        System.out.println("9) Quit");
        System.out.println("\n\nPlease enter option:");
        // int option = in.nextInt();
        java.util.Scanner in = new java.util.Scanner(System.in);
        int option = in.nextInt();
        switch (option)  // the switch will take the user's input and launch the app which corresponds to the number given
        {
            case 1 : keepCounting(); break;
            case 2 : squareRoot(); break;
            case 3 : checkDigitGen(); break;
            case 4 : checkDigitCheck(); break;
            case 9 : quit(); break;
        }


    }




    public static void main(String[] args)
    {
        /*
        this will call the menu function and then the choices of what app to use
        can be made.
         */


            Main app = new Main();


            app.menu();





    }
}
