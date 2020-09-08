package tictactoe;

import java.util.Random;

public class EasyAI extends Player {
    private final Random random = new Random();
    private  int numberOfOCells=0;
    private  int numberOfXCells=0;



    @Override
    public char [][] isPlaying(char[][] game) {
        System.out.println("Making move level \"easy\"");
        checkNoCells(game);


        while (true) {
            int num1 = random.nextInt(3);
            int num2 = random.nextInt(3);

            if (game[num1][num2] == '_') {

                if (numberOfXCells <= numberOfOCells) {
                    game[num1][num2] = 'X';
                    numberOfXCells++;

                } else {
                    game[num1][num2] = 'O';
                    numberOfOCells++;
                }
                return game;
            }
        }
    }

}
