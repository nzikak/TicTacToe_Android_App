package com.co.android.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SinglePlayerSelectionActivity extends AppCompatActivity {

    private int gridSize = 3;
    private int roundSelection = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.activity_single_player_selection);

        final Button threeByThree = (Button) findViewById(R.id.single_player_grid_three);
        final Button fiveByFive = (Button) findViewById(R.id.single_player_grid_five);
        final Button oneRound = (Button) findViewById(R.id.single_player_one_round);
        final Button threeRounds = (Button) findViewById(R.id.single_player_three_rounds);
        final Button fiveRounds = (Button) findViewById(R.id.single_player_five_rounds);
        final Button sevenRounds = (Button) findViewById(R.id.single_player_seven_rounds);
        final Button tenRounds = (Button) findViewById(R.id.single_player_ten_rounds);
        Button startGame = (Button) findViewById(R.id.single_player_start_game);



        threeByThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridSize = 3;
                threeByThree.setBackgroundResource(R.drawable.selected_button);
                fiveByFive.setBackgroundResource(R.drawable.button_background);
            }

        });

        fiveByFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridSize = 5;
                fiveByFive.setBackgroundResource(R.drawable.selected_button);
                threeByThree.setBackgroundResource(R.drawable.button_background);

            }

        });

        oneRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundSelection = 1;
                oneRound.setBackgroundResource(R.drawable.selected_button);
                threeRounds.setBackgroundResource(R.drawable.button_background);
                fiveRounds.setBackgroundResource(R.drawable.button_background);
                sevenRounds.setBackgroundResource(R.drawable.button_background);
                tenRounds.setBackgroundResource(R.drawable.button_background);
            }

        });

        threeRounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundSelection = 3;
                threeRounds.setBackgroundResource(R.drawable.selected_button);
                oneRound.setBackgroundResource(R.drawable.button_background);
                fiveRounds.setBackgroundResource(R.drawable.button_background);
                sevenRounds.setBackgroundResource(R.drawable.button_background);
                tenRounds.setBackgroundResource(R.drawable.button_background);
            }

        });

        fiveRounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundSelection = 5;
                fiveRounds.setBackgroundResource(R.drawable.selected_button);
                threeRounds.setBackgroundResource(R.drawable.button_background);
                oneRound.setBackgroundResource(R.drawable.button_background);
                sevenRounds.setBackgroundResource(R.drawable.button_background);
                tenRounds.setBackgroundResource(R.drawable.button_background);

            }

        });

        sevenRounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundSelection = 7;
                sevenRounds.setBackgroundResource(R.drawable.selected_button);
                threeRounds.setBackgroundResource(R.drawable.button_background);
                fiveRounds.setBackgroundResource(R.drawable.button_background);
                oneRound.setBackgroundResource(R.drawable.button_background);
                tenRounds.setBackgroundResource(R.drawable.button_background);

            }

        });

        tenRounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundSelection = 10;
                tenRounds.setBackgroundResource(R.drawable.selected_button);
                threeRounds.setBackgroundResource(R.drawable.button_background);
                fiveRounds.setBackgroundResource(R.drawable.button_background);
                sevenRounds.setBackgroundResource(R.drawable.button_background);
                oneRound.setBackgroundResource(R.drawable.button_background);

            }

        });

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SinglePlayerSelectionActivity.this, SinglePlayerActivity.class);
                intent.putExtra("gridSize", gridSize);
                intent.putExtra("roundSelection", roundSelection);
                startActivity(intent);
            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
    }
}
