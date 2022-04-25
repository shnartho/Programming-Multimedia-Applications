package com.example.android_tic_tac_toe;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TenBoard extends AppCompatActivity {
    boolean gameActive = true;
    int playerOnePoint = 0;
    int playerTwoPoint = 0;
    Button score;



    // Player representation
    // 0 - X
    // 1 - O
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2};

    // State meanings:
    // 0 - X
    // 1 - O
    // 2 - Null
    // put all win positions in a 2D array
    int[][] winPositions = {{0, 1, 2},{1,2,3},{2,3,4},{3,4,5},{4,5,6},{5,6,7},{6,7,8},{7,8,9},
            {10,11,12},{11,12,13},{12,13,14},{13,14,15},{14,15,16},{15,16,17},{16,17,18},{17,18,19},
            {20,21,22},{21,22,23},{22,23,24},{23,24,25},{24,25,26},{25,26,27},{26,27,28},{27,28,29},
            {30,31,32},{31,32,33},{32,33,34},{33,34,35},{34,35,36},{35,36,37},{36,37,38},{37,38,39},
            {40,41,42},{41,42,43},{42,43,44},{43,44,45},{44,45,46},{45,46,47},{46,47,48},{47,48,49},
            {50,51,52},{51,52,53},{52,53,54},{53,54,55},{54,55,56},{55,56,57},{56,57,58},{57,58,59},
            {60,61,62},{61,62,63},{62,63,64},{63,64,65},{64,65,66},{65,66,67},{66,67,68},{67,68,69},
            {70,71,72},{71,72,73},{72,73,74},{73,74,75},{74,75,76},{75,76,77},{76,77,78},{77,78,79},
            {80,81,82},{81,82,83},{82,83,84},{83,84,85},{84,85,86},{85,86,87},{86,87,88},{87,88,89},
            {90,91,92},{91,92,93},{92,93,94},{93,94,95},{94,95,96},{95,96,97},{96,97,98},{97,98,99},



            {0,10,20},{10,20,30},{20,30,40},{30,40,50},{40,50,60},{50,60,70},{60,70,80},{70,80,90},
            {1,11,21},{11,21,31},{21,31,41},{31,41,51},{41,51,61},{51,61,71},{61,71,81},{71,81,91},
            {2,12,22},{12,22,23},{22,32,42},{32,42,52},{42,52,62},{52,62,72},{62,72,82},{72,82,92},
            {3,13,23},{13,23,33},{23,33,43},{33,43,53},{43,53,63},{53,63,73},{63,73,83},{73,83,93},
            {4,14,24},{14,24,34},{24,34,44},{34,44,54},{44,54,64},{54,64,74},{64,74,84},{74,84,94},
            {5,15,25},{15,25,35},{25,35,45},{35,45,55},{45,55,65},{55,65,75},{65,75,85},{75,85,95},
            {6,16,26},{16,26,36},{26,36,46},{36,46,56},{46,56,66},{56,66,76},{66,76,86},{76,86,96},
            {7,17,27},{17,27,37},{27,37,47},{37,47,57},{47,57,67},{57,67,77},{67,77,87},{77,87,97},
            {8,18,28},{18,28,38},{28,38,48},{38,48,58},{48,58,68},{58,68,78},{68,78,88},{78,88,98},
            {9,19,29},{19,29,39},{29,39,49},{39,49,59},{49,59,69},{59,69,79},{69,79,89},{79,89,99},


            {70,81,92},
            {60,71,82},{71,82,93},
            {50,61,72},{61,72,83},{72,83,94},
            {40,51,62},{51,62,73},{62,73,84},{73,84,95},
            {30,41,52},{41,52,63},{52,63,74},{63,74,85},{74,85,96},
            {20,31,42},{31,42,53},{42,53,64},{53,64,75},{64,75,86},{75,86,97},
            {10,21,32},{21,32,43},{32,43,54},{43,54,65},{54,65,76},{65,76,87},{76,87,98},
            {0,11,22},{11,22,33},{22,33,44},{33,44,55},{44,55,66},{55,66,77},{66,77,88},{77,88,99},
            {1,12,23},{12,23,34},{23,34,45},{34,45,56},{45,56,67},{56,67,78},{67,78,89},
            {2,13,24},{13,24,35},{24,35,46},{35,46,57},{46,57,68},{57,68,79},
            {3,14,25},{14,25,36},{25,36,47},{36,47,58},{47,58,69},
            {4,15,26},{15,26,37},{26,37,48},{37,48,59},
            {5,16,27},{16,27,38},{27,38,49},
            {6,17,28},{17,28,39},
            {7,18,29},

            {2,11,20},
            {3,12,21},{12,21,30},
            {4,13,22},{13,22,31},{22,31,40},
            {5,14,23},{14,23,32},{23,32,41},{32,41,50},
            {6,15,24},{15,24,33},{24,33,42},{33,42,51},{42,51,60},
            {7,16,25},{16,25,34},{25,34,43},{34,43,52},{43,52,61},{52,61,70},
            {8,17,26},{17,26,35},{26,35,44},{35,44,53},{44,53,62},{53,62,71},{62,71,80},
            {9,18,27},{18,27,36},{27,36,45},{36,45,54},{45,54,63},{54,63,72},{63,72,81},{72,81,90},
            {19,28,37},{28,37,46},{37,46,55},{46,55,64},{55,64,73},{64,73,82},{73,82,91},
            {29,38,47},{38,47,56},{47,56,65},{56,65,74},{65,74,83},{74,83,92},
            {39,48,57},{48,57,66},{57,66,75},{66,75,84},{75,84,93},
            {49,58,67},{58,67,76},{67,76,85},{76,85,94},
            {59,68,77},{68,77,86},{77,86,95},
            {69,78,87},{78,87,96},
            {79,88,97}


//            { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19},{ 20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
//            { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39},{ 40, 41, 42, 43, 44, 45, 46, 47, 48, 49},{ 50, 51, 52, 53, 54, 55, 56, 57, 58, 59},{ 60, 61, 62, 63, 64, 65, 66, 67, 68, 69}, { 70, 71, 72, 73, 74, 75, 76, 77, 78, 79},
//            { 80, 81, 82, 83, 84, 85, 86, 87, 88, 89},{ 90, 91, 92, 93, 94, 95, 96, 97, 98, 99},
//
//            { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90},{ 1, 11, 21, 31, 41, 51, 61, 71, 81, 91},
//            { 2, 12, 22, 32, 42, 52, 62, 72, 82, 92},{ 3, 13, 23, 33, 43, 53, 63, 73, 83, 93},
//            { 4, 14, 24, 34, 44, 54, 64, 74, 84, 94},{ 5, 15, 25, 35, 45, 55, 65, 75, 85, 95},
//            { 6, 16, 26, 36, 46, 56, 66, 76, 86, 96},{ 7, 17, 27, 37, 47, 57, 67, 77, 87, 97},
//            { 8, 18, 28, 38, 48, 58, 68, 78, 88, 98},{ 9, 19, 29, 39, 49, 59, 69, 79, 89, 99},
//
//
//            {0, 11, 22, 33, 44, 55, 66, 77, 88, 99}, { 9, 18, 27, 36, 45, 54, 63, 72, 81, 90}
    };
    public static int counter = 0;

    // this function will be called every time a
    // players tap in an empty box of the grid
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        // game reset function will be called
        // if someone wins or the boxes are full
        if (!gameActive) {
            gameReset(view);
        }

        Button button = (Button)findViewById(R.id.buttonReset);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameReset(v);
            }
        });

        // if the tapped image is empty
        if (gameState[tappedImage] == 2) {
            // increase the counter
            // after every tap
            counter++;

            // check if its the last box
            if (counter == 100) {
                // reset the game
                gameActive = false;

            }

            // mark this position
            gameState[tappedImage] = activePlayer;

            // this will give a motion
            // effect to the image
            img.setTranslationY(-1000f);

            // change the active player
            // from 0 to 1 or 1 to 0
            if (activePlayer == 0) {
                // set the image of x
//                Resources resources = getResources();
//                img.setImageDrawable(resources.getDrawable(R.drawable.x));
                img.setImageResource(R.drawable.x);

                activePlayer = 1;
                TextView status = findViewById(R.id.status);

                if (counter == 100 ) {
                    status.setText("Match Finish (Tap Restart to Play)");
                } else {
                    // change the status
                    status.setText("Opponent's Turn");
                }
            } else {
                // set the image of o
                img.setImageResource(R.drawable.o);

                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                if (counter == 100 ) {
                    status.setText("Match Finish (Tap Restart to Play)");
                } else {

                    // change the status
                    status.setText("Your turn");
                }

            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        int flag = 0;
        // Check if any player has won
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                flag = 1;

                // Somebody has won! - Find out who!
                String winnerStr;

                // game reset function be called
                //gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    playerOnePoint += 1;
                    winnerStr = "Hurreee! PlayerOne got 1 point";
                    TextView player1point = findViewById(R.id.Point11);
                    player1point.setText(Integer.toString(playerOnePoint));
                } else {
                    playerTwoPoint += 1;
                    winnerStr = "Yahoooo! PlayerTwo got 1 point";
                    TextView player2point = findViewById(R.id.Point22);
                    player2point.setText(Integer.toString(playerTwoPoint));
                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }
        // set the status if the match draw
        if (counter == 100 && flag == 0) {
            TextView status = findViewById(R.id.status);
            status.setText("Match Finish (Tap Restart to Play)");
        }

    }



    // reset the game
    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        counter = 0;
        playerOnePoint = 0;
        TextView player1point = findViewById(R.id.Point11);
        player1point.setText(Integer.toString(playerOnePoint));
        playerTwoPoint = 0;
        TextView player2point = findViewById(R.id.Point22);
        player2point.setText(Integer.toString(playerTwoPoint));
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        // remove all the images from the boxes inside the grid
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView12)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView14)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView15)).setImageResource(0);

        ((ImageView) findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView17)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView18)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView19)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView20)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView22)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView23)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView24)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView25)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView26)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView27)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView28)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView29)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView30)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView31)).setImageResource(0);

        ((ImageView) findViewById(R.id.imageView32)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView33)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView34)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView35)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView36)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView37)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView38)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView39)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView40)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView41)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView42)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView43)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView44)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView45)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView46)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView47)).setImageResource(0);

        ((ImageView) findViewById(R.id.imageView48)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView49)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView50)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView51)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView52)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView53)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView54)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView55)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView56)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView57)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView58)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView59)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView60)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView61)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView62)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView63)).setImageResource(0);

        ((ImageView) findViewById(R.id.imageView64)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView65)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView66)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView67)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView68)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView69)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView70)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView71)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView72)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView73)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView74)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView75)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView76)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView77)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView78)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView79)).setImageResource(0);

        ((ImageView) findViewById(R.id.imageView80)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView81)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView82)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView83)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView84)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView85)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView86)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView87)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView88)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView89)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView90)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView91)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView92)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView93)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView94)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView95)).setImageResource(0);

        ((ImageView) findViewById(R.id.imageView96)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView97)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView98)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView99)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tenboard);

        score = findViewById(R.id.exit);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String point1 = String.valueOf(playerOnePoint);
                String point2 = String.valueOf(playerTwoPoint);
                Intent intent = new Intent(TenBoard.this, Score.class);
                intent.putExtra("value1", point1);
                intent.putExtra("value2", point2);
                startActivity(intent);
            }
        });
    }
}