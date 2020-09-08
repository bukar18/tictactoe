package tictactoe;

import java.util.Scanner;

public class Main {
    final static Scanner input = new Scanner(System.in);
    static char[][] ticTacToeArray = new char[3][3];
    static int numberOfXCells = 0;
    static int numberOfOCells = 0;
    static int numberOfEmptyCells = 0;
    static String[] mode;
    static Player player1;
    static Player player2;


    public static void main(String[] args) {
        boolean game = true;
        gameMode();




        while (game) {


            switch (mode[0]) {
                case "start":
                    player1 = whosPlaying(mode[1]);
                    player2 = whosPlaying(mode[2]);
                    createGame();
                    printGame();
                    startGame();
                    break;
                case "exit":
                    game = false;
                    break;
            }

        }


    }

    private static void startGame() {
        int cells = 9;
        while (cells > 0) {
            ticTacToeArray = player1.isPlaying(ticTacToeArray);
            printGame();
            checkNoCells();
            if (checkO() || checkX()) {
                gameMode();
                break;
            }
            cells--;

            if(cells == 0){
                System.out.println("Draw");
                gameMode();
                break;
            }
            ticTacToeArray = player2.isPlaying(ticTacToeArray);
            printGame();
            checkNoCells();
            if (checkO() || checkX()) {
                gameMode();
                break;
            }
            cells--;
            if(cells == 0){
                System.out.println("Draw");
                gameMode();
                break;
            }

        }


    }


    private static void createGame() {


        for (int i = 0; i < ticTacToeArray.length; i++) {


            for (int j = 0; j < ticTacToeArray.length; j++) {
                ticTacToeArray[i][j] = '_';
            }

        }


    }



    private static void checkNoCells() {
        for (char[] chars : ticTacToeArray) {
            for (int j = 0; j < ticTacToeArray.length; j++) {
                if (chars[j] == 'X') {
                    numberOfXCells++;
                } else if (chars[j] == 'O') {
                    numberOfOCells++;
                }

            }
        }

    }

    private static void printGame() {
        System.out.println("---------");
        for (char[] chars : ticTacToeArray) {
            System.out.print("| ");
            for (int i = 0; i < ticTacToeArray.length; i++) {

                if (chars[i] == '_') {
                    numberOfEmptyCells++;
                    System.out.print("  ");
                } else {
                    System.out.print(chars[i] + " ");
                }


            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }


    private static boolean checkO() {
        char userInput = 'O';
        int count;

        //checking horizontally
        for (char[] value : ticTacToeArray) {
            count = 0;
            for (int j = 0; j < ticTacToeArray.length; j++) {
                if (userInput == value[j]) {
                    count++;
                }
                if (count == 3) {
                    System.out.println(userInput + " wins/horizontal");
                    return true;
                }

            }


        }


        //checking vertically
        for (int i = 0; i < ticTacToeArray.length; i++) {
            count = 0;
            for (char[] chars : ticTacToeArray) {
                if (userInput == chars[i]) {
                    count++;
                }
                if (count == 3) {
                    System.out.println(userInput + " wins/vertical");
                    return true;
                }

            }


        }
        count = 0;
        //checking firstDiagonal
        for (int i = 0; i < ticTacToeArray.length; i++) {

            if (userInput == ticTacToeArray[i][i]) {
                count++;
            }
            if (count == 3) {
                System.out.println(userInput + " wins/first");
                return true;
            }

        }

        //checking secondDiagonal
        count = 0;
        int hello = 0;
        for (int i = 2; i >= 0; i--) {
            if (userInput == ticTacToeArray[i][hello]) {
                count++;
            }
            if (count == 3) {
                System.out.println(userInput + " wins/second");
                return true;
            }
            hello++;
        }


        return false;


    }

    private static boolean checkX() {
        char userInput = 'X';
        int count;

        //checking horizontally
        for (char[] value : ticTacToeArray) {
            count = 0;
            for (int j = 0; j < ticTacToeArray.length; j++) {
                if (userInput == value[j]) {
                    count++;
                }
                if (count == 3) {
                    System.out.println(userInput + " wins");
                    return true;
                }

            }


        }

        //checking vertically
        for (int i = 0; i < ticTacToeArray.length; i++) {
            count = 0;
            for (char[] chars : ticTacToeArray) {
                if (userInput == chars[i]) {
                    count++;
                }
                if (count == 3) {
                    System.out.println(userInput + " wins");
                    return true;
                }

            }


        }
        count = 0;
        //checking firstDiagonal
        for (int i = 0; i < ticTacToeArray.length; i++) {

            if (userInput == ticTacToeArray[i][i]) {
                count++;
            }
            if (count == 3) {
                System.out.println(userInput + " wins");
                return true;
            }

        }

        //checking secondDiagonal
        count = 0;
        int hello = 0;
        for (int i = 2; i >= 0; i--) {
            if (userInput == ticTacToeArray[i][hello]) {
                count++;
            }
            if (count == 3) {
                System.out.println(userInput + " wins");
                return true;
            }
            hello++;
        }


        return false;


    }

    private static void gameMode() {

        while (true) {
            System.out.println("Input command: ");
            mode = input.nextLine().split(" ");
            if (mode.length == 3 || (mode.length == 1 && mode[0].equals("exit"))) {
                break;
            } else {
                System.out.println("Bad parameters!");
            }

        }

    }

    private static Player whosPlaying(String player) {
        switch (player) {
            case "user":
                return new Human();
            case "easy":
                return new EasyAI();
            case "medium":
                return new MediumAI();
            case "hard":
                return new HardAI();
        }
        return null;


    }


}
