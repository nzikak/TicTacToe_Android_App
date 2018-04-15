package com.co.android.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SelectionActivity extends AppCompatActivity {

    private  int gridSize = 3;
    private int roundSelection = 3;
    private String playerX_Name;
    private String playerO_Name;
    private Button gridFive;
    private Button gridThree;
    private Button startGame;
    private EditText playerX;
    private EditText playerO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.activity_selection);

        final Button oneRound = (Button) findViewById(R.id.multi_player_one_round);
        final Button threeRounds = (Button) findViewById(R.id.multi_player_three_rounds);
        final Button fiveRounds = (Button) findViewById(R.id.multi_player_five_rounds);
        final Button sevenRounds = (Button) findViewById(R.id.multi_player_seven_rounds);
        final Button tenRounds = (Button) findViewById(R.id.multi_player_ten_rounds);

        playerX = (EditText) findViewById(R.id.playerX);
        playerO = (EditText) findViewById(R.id.playerO);
        gridThree = (Button) findViewById(R.id.grid_three);
        gridFive = (Button) findViewById(R.id.grid_five);
        startGame = (Button) findViewById(R.id.start_game);


        gridThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridSize = 3;
                gridThree.setBackgroundResource(R.drawable.selected_button);
                gridFive.setBackgroundResource(R.drawable.button_background);
            }

        });

        gridFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridSize = 5;
                gridFive.setBackgroundResource(R.drawable.selected_button);
                gridThree.setBackgroundResource(R.drawable.button_background);
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
                playerX_Name = playerX.getText().toString();
                playerO_Name = playerO.getText().toString();
                if (!TextUtils.isEmpty(playerX_Name) && !TextUtils.isEmpty(playerO_Name)) {
                    Intent intent = new Intent(SelectionActivity.this, MainActivity.class);
                    intent.putExtra("playerX", playerX_Name);
                    intent.putExtra("playerO", playerO_Name);
                    intent.putExtra("gridSize", gridSize);
                    startActivity(intent);
                }
            }

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
    }
}
