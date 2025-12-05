import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer;
        boolean win = false;
        System.out.println("Welcome to lights out, you must turn out all of the lights. Ready to play? (yes/no)");
        answer = sc.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            int[][] lightMap = new int[5][5];
            int[][] lightColour = new int [lightMap.length][lightMap.length];
            
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
                } 
                System.out.println();
            }
            int[] guess = new int [2];
            
            while (!win) {
                System.out.println("Enter a light you want to switch using coordinate format (eg. (y x) )");
                guess[0] = sc.nextInt();
                guess[1] = sc.nextInt();
                onInput(lightColour, guess);
                checkForWin(lightColour, win);
                newMap(lightColour, guess);
            }
            System.out.println("You win! congrats");
            System.exit(0);

        } else if (answer.equalsIgnoreCase("no")) {
            System.out.println("Goodbye then");
            System.exit(0);
        } else {
            System.out.println("I do not understand that");
            System.exit(0);
        }

    }

    static void checkForWin (int [][] lightColour, boolean win) {
        if (Arrays.asList(lightColour).contains(1)){
            win = false;
        } else {
            win = true;
        }
    }

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

    }
    
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
    }
}

