import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer;
        boolean win = false;
        System.out.println("Welcome to lights out, you must turn out all of the lights. Ready to play? (yes/no)"); // intro sentence
        answer = sc.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            int[][] lightMap = new int[5][5];
            int[][] lightColour = new int [lightMap.length][lightMap.length]; //"map" of 5 by 5 1s and 0s
            
            double randomNum;
            for (int i = 0; i < lightColour.length; i++) {
                for (int k = 0; k < lightColour.length; k++) {
                    randomNum = Math.random();
                    if (randomNum > 0.5) {
                        lightColour[i][k] = 1;
                        System.out.print("1  ");
                    } else {
                        lightColour[i][k] = 0;
                        System.out.print("0  ");
                    }
                } //randomly makes each number in double array either a 0 or 1

                System.out.println(); //prints map
            }
            int[] guess = new int [2]; //guess integer 
            
            while (!win) {
                System.out.println("Enter a light you want to switch using coordinate format (eg. (y x) )");
                guess[0] = sc.nextInt();
                guess[1] = sc.nextInt();
                onInput(lightColour, guess);
                checkForWin(lightColour, win);
                newMap(lightColour, guess);
            } //repeatedly asks for coordinates and displays new map until player win

            System.out.println("You win! congrats");
            System.exit(0); // win statement

        } else if (answer.equalsIgnoreCase("no")) {
            System.out.println("Goodbye then");
            System.exit(0); //if player says they do not want to play
        } else {
            System.out.println("I do not understand that");
            System.exit(0); //if player enters invalid input
        }

    }

    static void checkForWin (int [][] lightColour, boolean win) {
        if (Arrays.asList(lightColour).contains(1)){
            win = false;
        } else {
            win = true;
        }
    } // checks to see if all numbers are 0, which would be a win

    static void onInput(int [][] lightColour, int[] guess) {
        int indexX = guess[0] - 1;
        int indexY = guess[1] - 1;
        lightColour[indexX][indexY] = 1 - lightColour[indexX][indexY];
        if (indexY >= 1) {
            lightColour[indexX][indexY - 1] = 1 - lightColour[indexX][indexY - 1];
        }
        if (indexY <= lightColour.length - 2) {
            lightColour[indexX][indexY + 1] = 1 - lightColour[indexX][indexY + 1];
        }
        if (indexX >= 1) {
            lightColour[indexX - 1][indexY] = 1 - lightColour[indexX - 1][indexY];
        }
        if (indexX <= lightColour.length - 2) {
            lightColour[indexX + 1][indexY] = 1 - lightColour[indexX + 1][indexY];
        }

    } // method that changes value of number entered along with every surrounding one
    
    static void newMap(int[][] lightColour, int[] guess) {
        for (int i = 0; i < lightColour.length; i++) {
            for (int k = 0; k < lightColour.length; k++) {
                double randomNum = lightColour[i][k];
                if (randomNum > 0.5) {
                    System.out.print("1  ");
                } else {
                    System.out.print("0  ");
                }
            } 
            System.out.println();
        }
    } //method displaying updated map
} 

