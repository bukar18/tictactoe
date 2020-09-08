package tictactoe;

public class MediumAI extends Player {




    @Override
    public char[][] isPlaying(char[][] game) {
        System.out.println("Making move level \"medium\"");
        checkNoCells(game);


        return aiMOve(game);

    }



    private boolean mediumAIWin(char[][] game, char ox){


        for (int i = 0; i < game.length ; i++) {
            for (int j = 0; j < game.length ; j++) {
                if(game[i][j] =='_'){
                    game[i][j] = ox;
                    if(check(ox,game)){
                        opponentX = i;
                        opponentY = j;
                      return true;
                    }
                    else {
                        game[i][j] = '_';
                    }


                }
            }
        }
        return false;

    }

    private  boolean check(char check,char[][] game) {
        int count;

        //checking horizontally
        for (char[] value : game) {
            count = 0;
            for (int j = 0; j < game.length; j++) {
                if (check == value[j]) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }

            }


        }

        //checking vertically
        for (int i = 0; i < game.length; i++) {
            count = 0;
            for (char[] chars : game) {
                if (check == chars[i]) {
                    count++;
                }
                if (count == 3) {

                    return true;
                }

            }


        }
        count = 0;
        //checking firstDiagonal
        for (int i = 0; i < game.length; i++) {

            if (check == game[i][i]) {
                count++;
            }
            if (count == 3) {
                return true;
            }

        }

        //checking secondDiagonal
        count = 0;
        int hello = 0;
        for (int i = 2; i >= 0; i--) {
            if (check == game[i][hello]) {
                count++;
            }
            if (count == 3) {

                return true;
            }
            hello++;
        }


        return false;


    }

    private char[][] aiMOve(char[][] game ){

        if (numberOfXCells <= numberOfOCells) {

            if(mediumAIWin(game,'X')){
                return game;
            }
            else if(mediumAIWin(game,'O')){
                game[opponentX][opponentY]='X';
                return game;
            }
            else{
                return mediumRandom(game);
            }
        } else {

            if(mediumAIWin(game,'O')){
                return game;
            }
            else if(mediumAIWin(game,'X')){
                game[opponentX][opponentY]='O';
                return game;
            }
            else{
                return mediumRandom(game);
            }
        }


    }

    protected   char[][]  mediumRandom(char[][] game){
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
