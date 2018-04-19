package com.co.android.tictactoe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MultiPlayerGrid3Activity extends AppCompatActivity {
    ArrayList<Integer> checkedGrid = new ArrayList<>();
    private int roundCount = 1;
    private int roundSelection = 3;
    private int playerTurns = 1;
    private int playerOneScoreCount = 0;
    private int playerTwoScoreCount = 0;
    private String playerOne = "";
    private String playerTwo = "";
    private Button grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
            grid3_btn8, grid3_btn9;
    private LinearLayout gridLayout;
    private RelativeLayout winnerContainer;
    private TextView winner;
    private Button menu, nextRound;
    private ActionBar mActionBar;
    private Integer[][] winningRows = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
    private ArrayList<Integer> playerOneMoves = new ArrayList<>();
    private ArrayList<Integer> playerTwoMoves = new ArrayList<>();
    private TextView playerOneScore, playerTwoScore, customActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.three_by_three);

        TextView playerOneName, playerTwoName;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            playerOne = extras.getString("playerOne");
            playerTwo = extras.getString("playerTwo");
            roundSelection = extras.getInt("roundSelection");
        }


        gridLayout = (LinearLayout) findViewById(R.id.grid3_layout);
        winnerContainer = (RelativeLayout) findViewById(R.id.grid3_winner_container);
        winner = (TextView) findViewById(R.id.grid3_winner);
        menu = (Button) findViewById(R.id.grid3_menu);
        //customActionBar = (TextView) findViewById(R.id.roundCount);
        nextRound = (Button) findViewById(R.id.grid3_next_round);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        //customActionBar.setText("Round " + roundCount + " of " + roundSelection);

        playerOneName = (TextView) findViewById(R.id.grid3_playerOneName);
        playerTwoName = (TextView) findViewById(R.id.grid3_playerTwoName);
        playerOneScore = (TextView) findViewById(R.id.grid3_playerOne_score);
        playerTwoScore = (TextView) findViewById(R.id.grid3_playerTwo_score);

        Animation animation = AnimationUtils.loadAnimation(MultiPlayerGrid3Activity.this, R.anim.slide_in);
        animation.setDuration(1500);
        gridLayout.startAnimation(animation);
        playerOneName.setText(playerOne);
        playerTwoName.setText(playerTwo);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        grid3_btn1 = (Button) findViewById(R.id.grid3_btn1);
        grid3_btn2 = (Button) findViewById(R.id.grid3_btn2);
        grid3_btn3 = (Button) findViewById(R.id.grid3_btn3);
        grid3_btn4 = (Button) findViewById(R.id.grid3_btn4);
        grid3_btn5 = (Button) findViewById(R.id.grid3_btn5);
        grid3_btn6 = (Button) findViewById(R.id.grid3_btn6);
        grid3_btn7 = (Button) findViewById(R.id.grid3_btn7);
        grid3_btn8 = (Button) findViewById(R.id.grid3_btn8);
        grid3_btn9 = (Button) findViewById(R.id.grid3_btn9);

        grid3_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid3_btn1.setText(selection(playerTurns));
                grid3_btn1.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 1);
                checkForWin();
                playerTurns++;
                grid3_btn1.setEnabled(false);
            }

        });

        grid3_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid3_btn2.setText(selection(playerTurns));
                grid3_btn2.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 2);
                checkForWin();
                playerTurns++;
                grid3_btn2.setEnabled(false);
            }

        });

        grid3_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid3_btn3.setText(selection(playerTurns));
                grid3_btn3.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 3);
                checkForWin();
                playerTurns++;
                grid3_btn3.setEnabled(false);
            }

        });

        grid3_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid3_btn4.setText(selection(playerTurns));
                grid3_btn4.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 4);
                checkForWin();
                playerTurns++;
                grid3_btn4.setEnabled(false);
            }

        });

        grid3_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid3_btn5.setText(selection(playerTurns));
                grid3_btn5.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 5);
                checkForWin();
                playerTurns++;
                grid3_btn5.setEnabled(false);
            }

        });

        grid3_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid3_btn6.setText(selection(playerTurns));
                grid3_btn6.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 6);
                checkForWin();
                playerTurns++;
                grid3_btn6.setEnabled(false);
            }

        });

        grid3_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid3_btn7.setText(selection(playerTurns));
                grid3_btn7.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 7);
                checkForWin();
                playerTurns++;
                grid3_btn7.setEnabled(false);
            }

        });

        grid3_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid3_btn8.setText(selection(playerTurns));
                grid3_btn8.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 8);
                checkForWin();
                playerTurns++;
                grid3_btn8.setEnabled(false);
            }

        });

        grid3_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid3_btn9.setText(selection(playerTurns));
                grid3_btn9.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 9);
                checkForWin();
                playerTurns++;
                grid3_btn9.setEnabled(false);
            }

        });
    }

    public String selection(int turns) {
        if (turns % 2 == 0) {
            return getString(R.string.o);
        }
        return getString(R.string.x);

    }

    public ColorStateList colorSelect(int turns) {
        if (turns % 2 == 0) {
            return ContextCompat.getColorStateList(this, R.color.o_color);
        }
        return ContextCompat.getColorStateList(this, R.color.cross_color);
    }

    public void playerMoves(int turns, int moves) {
        if (turns % 2 == 0) {
            playerTwoMoves.add(moves);
            return;
        }
        playerOneMoves.add(moves);

    }

    public void checkForWin() {
        for (int i = 0; i < winningRows.length; i++) {
            if (playerOneMoves.contains(winningRows[i][0]) && playerOneMoves.contains(winningRows[i][1]) &&
                    playerOneMoves.contains(winningRows[i][2])) {
                if (!(checkedGrid.contains(winningRows[i][0]) && checkedGrid.contains(winningRows[i][1]) &&
                        checkedGrid.contains(winningRows[i][2]))) {
                    checkedGrid.add(winningRows[i][0]);
                    checkedGrid.add(winningRows[i][1]);
                    checkedGrid.add(winningRows[i][2]);
                    greenRows(winningRows[i][0], winningRows[i][1], winningRows[i][2]);
                    updatePlayerScore(1);
                    startNewRound();
                    break;
                }

            }
            if (playerTwoMoves.contains(winningRows[i][0]) && playerTwoMoves.contains(winningRows[i][1]) &&
                    playerTwoMoves.contains(winningRows[i][2])) {
                if (!(checkedGrid.contains(winningRows[i][0]) && checkedGrid.contains(winningRows[i][1]) &&
                        checkedGrid.contains(winningRows[i][2]))) {
                    checkedGrid.add(winningRows[i][0]);
                    checkedGrid.add(winningRows[i][1]);
                    checkedGrid.add(winningRows[i][2]);
                    greenRows(winningRows[i][0], winningRows[i][1], winningRows[i][2]);
                    updatePlayerScore(2);
                    startNewRound();
                    break;
                }

            }

            if (playerTurns == 9) {
                if (checkForDraw()) {
                    playerOneScoreCount++;
                    playerTwoScoreCount++;
                    playerOneScore.setText(String.valueOf(playerOneScoreCount));
                    playerTwoScore.setText(String.valueOf(playerTwoScoreCount));
                    winner.setText(getString(R.string.draw));
                    startNewRound();
                    break;
                }
            }
        }
    }




    public void updatePlayerScore(int player) {
        if (player == 1) {
            playerOneScoreCount++;
            playerOneScore.setText(String.valueOf(playerOneScoreCount));
            winner.setText(getString(R.string.winner, playerOne));
            return;
        }
        if (player == 2) {
            playerTwoScoreCount++;
            playerTwoScore.setText(String.valueOf(playerTwoScoreCount));
            winner.setText(getString(R.string.winner, playerTwo));
        }

    }







    public void startNewRound() {
        Button[] buttons = {grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
                grid3_btn8, grid3_btn9};
        for (Button x : buttons) {
            if (x.isEnabled()) {
                x.setEnabled(false);
            }
        }
        Animation animation = AnimationUtils.loadAnimation(MultiPlayerGrid3Activity.this, R.anim.slide_in);
        animation.setDuration(1000);
        winnerContainer.startAnimation(animation);
        winnerContainer.setVisibility(View.VISIBLE);
        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundCount++;
                resetGame();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MultiPlayerGrid3Activity.this, StartActivity.class);
                startActivity(intent);
            }
        });

    }

    public void resetGame() {
        winnerContainer.setVisibility(View.GONE);
        Animation animation = AnimationUtils.loadAnimation(MultiPlayerGrid3Activity.this, R.anim.slide_in);
        animation.setDuration(1000);
        gridLayout.startAnimation(animation);
        Button[] buttons = {grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
                grid3_btn8, grid3_btn9};
        roundCount++;
        playerTurns = 1;
        playerOneMoves.clear();
        playerTwoMoves.clear();
        checkedGrid.clear();

        for (Button x : buttons) {
            x.setText("");
            x.setBackgroundResource(R.drawable.button_background);
            x.setEnabled(true);
        }
    }

    public boolean checkForDraw() {
        boolean endsInDraw = true;
        for (int i = 0; i < winningRows.length; i++) {
            if ((playerOneMoves.contains(winningRows[i][0]) && playerOneMoves.contains(winningRows[i][1])
                    && playerOneMoves.contains(winningRows[i][2])) || (playerTwoMoves.contains(winningRows[i][0]) &&
                    playerTwoMoves.contains(winningRows[i][1]) && playerTwoMoves.contains(winningRows[i][2]))) {
                endsInDraw = false;
                break;
            }
        }
        return endsInDraw;
    }




    public void greenRows(int a, int b, int c) {
        Button[] buttons = {grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
                grid3_btn8, grid3_btn9};
        buttons[a - 1].setBackgroundResource(R.drawable.won_rows);
        buttons[b - 1].setBackgroundResource(R.drawable.won_rows);
        buttons[c - 1].setBackgroundResource(R.drawable.won_rows);
    }


}
