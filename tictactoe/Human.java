package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player{




    @Override
    public char[][] isPlaying(char[][] game) {
        checkNoCells(game);

        int first;
        int second;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the coordinates: ");

            try {
                first = input.nextInt();
                second = input.nextInt();

                if (first > 3 || first < 1 || second > 3 || second < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    first = first - 1;
                    second = 3 - second;

                    if (game[second][first] == '_') {
                        if (numberOfXCells <= numberOfOCells) {
                            game[second][first] = 'X';
                            numberOfXCells++;

                        } else {
                            game[second][first] = 'O';
                            numberOfOCells++;

                        }
                        return game;
                    } else {

                        System.out.println("This cell is occupied! Choose another one!");

                    }


                }

            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                input.nextLine();
            }


        }
    }

}
