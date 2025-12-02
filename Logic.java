import java.util.Random;
import java.util.Scanner;

public class Logic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer;
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
                        System.out.print("ON  ");
                    } else {
                        System.out.print("OFF  ");
                    }
                } 
                System.out.println();
            }
            System.out.println("Enter a light you want to switch using coordinate format (eg. (x y) )");
            


        } else if (answer.equalsIgnoreCase("no")) {
            System.out.println("Goodbye then");
            System.exit(0);
        } else {
            System.out.println("I do not understand that");
            System.exit(0);
        }

    }

    static void newMap(int[][] lightColour, double randomNum) {
        for (int i = 0; i < lightColour.length; i++) {
            for (int k = 0; k < lightColour.length; k++) {
            System.out.println(lightColour[i][k] + " ");
            } 
            System.out.println();
        }
        System.out.println("Enter a light you want to switch using coordinate format (eg. (x y) )");
    }
}

