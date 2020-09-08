package tictactoe;

import java.util.Random;

public class Player {

    protected   int numberOfOCells=0;
    protected   int numberOfXCells=0;
    protected   int opponentX = 0;
    protected   int opponentY = 0;
    protected   Random random =  new Random();
    protected int numberOfEmptyCells = 0;


    public char[][] isPlaying(char[][] game) {
        return null;
    }
    protected   void checkNoCells(char[][] game) {
        int countX = 0;
        int countO = 0;
        int empty = 0;
        for (char[] chars : game) {
            for (int j = 0; j < game.length; j++) {
                if (chars[j] == 'X') {
                    countX++;
                } else if (chars[j] == 'O') {
                    countO++;
                }
                else {
                    empty++;
                }

            }
        }
        numberOfXCells = countX;
        numberOfOCells = countO;

        System.out.println("Number of x = "+numberOfXCells);
        System.out.println("Number of o = "+numberOfOCells);
        numberOfEmptyCells = empty;
    }


}
