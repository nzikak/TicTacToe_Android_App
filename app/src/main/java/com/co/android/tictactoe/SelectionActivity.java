package com.co.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SelectionActivity extends AppCompatActivity {

    private int gridSize = 3;
    private int roundSelection = 3;
    private String playerOne_Name;
    private String playerTwo_Name;
    private Button gridFive;
    private Button gridThree;
    private Button startGame;
    private EditText playerOne;
    private EditText playerTwo;

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

        playerOne = (EditText) findViewById(R.id.playerOne);
        playerTwo = (EditText) findViewById(R.id.playerTwo);
        gridThree = (Button) findViewById(R.id.grid_three);
        gridFive = (Button) findViewById(R.id.grid_five);
        startGame = (Button) findViewById(R.id.start_game);


        gridThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridSize = 3;
                gridThree.setBackgroundResource(R.drawable.selected_button);
                gridFive.setBackgroundResource(R.drawable.button_background);
                Toast.makeText(SelectionActivity.this, "Match three rows to win", Toast.LENGTH_SHORT).show();
            }

        });

        gridFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridSize = 5;
                gridFive.setBackgroundResource(R.drawable.selected_button);
                gridThree.setBackgroundResource(R.drawable.button_background);
                Toast.makeText(SelectionActivity.this, "Match four rows to win", Toast.LENGTH_SHORT).show();
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
                playerOne_Name = playerOne.getText().toString();
                playerTwo_Name = playerTwo.getText().toString();
                if (gridSize == 3) {
                    if (!TextUtils.isEmpty(playerOne_Name) && !TextUtils.isEmpty(playerTwo_Name)) {
                        Intent intent = new Intent(SelectionActivity.this, MultiPlayerGrid3Activity.class);
                        intent.putExtra("playerOne", playerOne_Name);
                        intent.putExtra("playerTwo", playerTwo_Name);
                        intent.putExtra("roundSelection", roundSelection);
                        startActivity(intent);
                    }
                } else if (gridSize == 5) {
                    if (!TextUtils.isEmpty(playerOne_Name) && !TextUtils.isEmpty(playerTwo_Name)) {
                        Intent intent = new Intent(SelectionActivity.this, MultiPlayerGrid5Activity.class);
                        intent.putExtra("playerOne", playerOne_Name);
                        intent.putExtra("playerTwo", playerTwo_Name);
                        intent.putExtra("roundSelection", roundSelection);
                        startActivity(intent);
                    }
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
