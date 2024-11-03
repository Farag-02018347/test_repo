package game;

import android.util.Log;

import java.util.Random;

public class LightGame {
    private boolean[][] game ;
    public boolean gameFinished = false;
    private int move_counter = 0;
    private Random random = new Random();

    public LightGame () {
        this.game = new boolean[3][3];
       for (int i = 0; i < 3; i++) {

           for (int j = 0; j < 3; j++) {
               this.game[i][j] = false; // make the randomized game
           }
       }
    }
    public void setGameBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.game[i][j] = random.nextBoolean();
                Log.d("settingGame",game[i][j]?"true":"false" );// make the randomized game
            }
        }
        move_counter = 0;
    }

    public void moveMade(int i, int j) {
        int top = i-1, bottom = i + 1, right = j + 1, left = j - 1;
        if (top >= 0) {
            game[top][j] = !game[top][j];
        }
        if (bottom >= 0 && bottom < 3) {
            game[bottom][j] = !game[bottom][j];
        }
        if (right <= 2 ) {
            game[i][right] = !game[i][right];
        }
        if (left >= 0) {
            game[i][left] = !game[i][left];
        }
        game[i][j] = !game[i][j];
        move_counter++;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.game[i][j]) {
                    gameFinished = false;
                    return gameFinished;// make the randomized game
                }
            }
        }
        gameFinished = true;
        return gameFinished;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public boolean[][] getGame() {
        return game;
    }

    public int getMove_counter() {
        return this.move_counter;
    }

    public void resetMove_counter() {
        this.move_counter = 0;
    }
}
