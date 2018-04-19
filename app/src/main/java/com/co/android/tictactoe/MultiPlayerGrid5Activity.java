package com.co.android.tictactoe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class MultiPlayerGrid5Activity extends AppCompatActivity {
    ArrayList<Integer> checkedGrid = new ArrayList<>();
    private int roundCount = 1;
    private int playerTurns = 1;
    private int playerOneScoreCount = 0;
    private int playerTwoScoreCount = 0;
    private String playerOne = "";
    private String playerTwo = "";
    private LinearLayout gridLayout;
    private RelativeLayout winnerContainer;
    private TextView winner;
    private Button menu, nextRound;
    private ActionBar mActionBar;
    private TextView PlayerOneScore, PlayerTwoScore;
    
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, 
            btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25;
    
    private Integer[][] winningRows = {{1, 2, 3, 4}, {2, 3, 4, 5}, {6, 7, 8, 9}, {7, 8, 9, 10}, {11, 12, 13, 14}, {12, 13, 14, 15},
            {16, 17, 18, 19}, {17, 18, 19, 20}, {21, 22, 23, 24}, {22, 23, 24, 25}, {1, 6, 11, 16}, {6, 11, 16, 21}, {2, 7, 12, 17},
            {7, 12, 17, 22}, {3, 8, 13, 18}, {8, 13, 18, 23}, {4, 9, 14, 19}, {9, 14, 19, 24}, {5, 10, 15, 20}, {10, 15, 20, 25},
            {1, 7, 13, 19}, {7, 13, 19, 25}, {2, 8, 14, 20}, {4, 8, 12, 16}, {5, 9, 13, 17}, {9, 13, 17, 21}, {6, 12, 18, 24},
            {7, 13, 19, 25}, {10, 14, 18, 22}};
    

    private ArrayList<Integer> playerOneMoves = new ArrayList<>();
    private ArrayList<Integer> playerTwoMoves = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.five_by_five);
        
        TextView playerOneName, playerTwoName;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            playerOne = extras.getString("playerOne");
            playerTwo = extras.getString("playerTwo");
        }
        
        gridLayout = (LinearLayout) findViewById(R.id.grid5_layout);
        playerOneName = (TextView) findViewById(R.id.grid5_playerOneName);
        playerTwoName = (TextView) findViewById(R.id.grid5_playerTwoName);
        winner = (TextView) findViewById(R.id.grid5_winner);
        PlayerOneScore = (TextView) findViewById(R.id.grid5_playerOne_score);
        PlayerTwoScore = (TextView) findViewById(R.id.grid5_playerTwo_score);
        winnerContainer = (RelativeLayout) findViewById(R.id.grid5_winner_container);
        menu = (Button) findViewById(R.id.grid5_menu);
        nextRound = (Button) findViewById(R.id.grid5_next_round);

        Animation animation = AnimationUtils.loadAnimation(MultiPlayerGrid5Activity.this, R.anim.slide_in);
        animation.setDuration(1500);
        gridLayout.startAnimation(animation);
        playerOneName.setText(playerOne);
        playerTwoName.setText(playerTwo);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btn1 = (Button) findViewById(R.id.grid5_btn1);
        btn2 = (Button) findViewById(R.id.grid5_btn2);
        btn3 = (Button) findViewById(R.id.grid5_btn3);
        btn4 = (Button) findViewById(R.id.grid5_btn4);
        btn5 = (Button) findViewById(R.id.grid5_btn5);
        btn6 = (Button) findViewById(R.id.grid5_btn6);
        btn7 = (Button) findViewById(R.id.grid5_btn7);
        btn8 = (Button) findViewById(R.id.grid5_btn8);
        btn9 = (Button) findViewById(R.id.grid5_btn9);
        btn10 = (Button) findViewById(R.id.grid5_btn10);
        btn11 = (Button) findViewById(R.id.grid5_btn11);
        btn12 = (Button) findViewById(R.id.grid5_btn12);
        btn13 = (Button) findViewById(R.id.grid5_btn13);
        btn14 = (Button) findViewById(R.id.grid5_btn14);
        btn15 = (Button) findViewById(R.id.grid5_btn15);
        btn16 = (Button) findViewById(R.id.grid5_btn16);
        btn17 = (Button) findViewById(R.id.grid5_btn17);
        btn18 = (Button) findViewById(R.id.grid5_btn18);
        btn19 = (Button) findViewById(R.id.grid5_btn19);
        btn20 = (Button) findViewById(R.id.grid5_btn20);
        btn21 = (Button) findViewById(R.id.grid5_btn21);
        btn22 = (Button) findViewById(R.id.grid5_btn22);
        btn23 = (Button) findViewById(R.id.grid5_btn23);
        btn24 = (Button) findViewById(R.id.grid5_btn24);
        btn25 = (Button) findViewById(R.id.grid5_btn25);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setText(selection(playerTurns));
                btn1.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 1);
                checkForWin();
                playerTurns++;
                btn1.setEnabled(false);
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setText(selection(playerTurns));
                btn2.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 2);
                checkForWin();
                playerTurns++;
                btn2.setEnabled(false);
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setText(selection(playerTurns));
                btn3.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 3);
                checkForWin();
                playerTurns++;
                btn3.setEnabled(false);
            }

        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn4.setText(selection(playerTurns));
                btn4.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 4);
                checkForWin();
                playerTurns++;
                btn4.setEnabled(false);
            }

        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5.setText(selection(playerTurns));
                btn5.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 5);
                checkForWin();
                playerTurns++;
                btn5.setEnabled(false);
            }

        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn6.setText(selection(playerTurns));
                btn6.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 6);
                checkForWin();
                playerTurns++;
                btn6.setEnabled(false);
            }

        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn7.setText(selection(playerTurns));
                btn7.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 7);
                checkForWin();
                playerTurns++;
                btn7.setEnabled(false);
            }

        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn8.setText(selection(playerTurns));
                btn8.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 8);
                checkForWin();
                playerTurns++;
                btn8.setEnabled(false);
            }

        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn9.setText(selection(playerTurns));
                btn9.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 9);
                checkForWin();
                playerTurns++;
                btn9.setEnabled(false);
            }

        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn10.setText(selection(playerTurns));
                btn10.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 10);
                checkForWin();
                playerTurns++;
                btn10.setEnabled(false);
            }

        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn11.setText(selection(playerTurns));
                btn11.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 11);
                checkForWin();
                playerTurns++;
                btn11.setEnabled(false);
            }

        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn12.setText(selection(playerTurns));
                btn12.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 12);
                checkForWin();
                playerTurns++;
                btn12.setEnabled(false);
            }

        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn13.setText(selection(playerTurns));
                btn13.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 13);
                checkForWin();
                playerTurns++;
                btn13.setEnabled(false);
            }

        });

        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn14.setText(selection(playerTurns));
                btn14.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 14);
                checkForWin();
                playerTurns++;
                btn14.setEnabled(false);
            }

        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn15.setText(selection(playerTurns));
                btn15.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 15);
                checkForWin();
                playerTurns++;
                btn15.setEnabled(false);
            }

        });

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn16.setText(selection(playerTurns));
                btn16.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 16);
                checkForWin();
                playerTurns++;
                btn16.setEnabled(false);
            }

        });

        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn17.setText(selection(playerTurns));
                btn17.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 17);
                checkForWin();
                playerTurns++;
                btn17.setEnabled(false);
            }

        });

        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn18.setText(selection(playerTurns));
                btn18.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 18);
                checkForWin();
                playerTurns++;
                btn18.setEnabled(false);
            }

        });

        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn19.setText(selection(playerTurns));
                btn19.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 19);
                checkForWin();
                playerTurns++;
                btn19.setEnabled(false);
            }

        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn20.setText(selection(playerTurns));
                btn20.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 20);
                checkForWin();
                playerTurns++;
                btn20.setEnabled(false);
            }

        });

        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn21.setText(selection(playerTurns));
                btn21.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 21);
                checkForWin();
                playerTurns++;
                btn21.setEnabled(false);
            }

        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn22.setText(selection(playerTurns));
                btn22.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 22);
                checkForWin();
                playerTurns++;
                btn22.setEnabled(false);
            }

        });

        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn23.setText(selection(playerTurns));
                btn23.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 23);
                checkForWin();
                playerTurns++;
                btn23.setEnabled(false);
            }

        });

        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn24.setText(selection(playerTurns));
                btn24.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 24);
                checkForWin();
                playerTurns++;
                btn24.setEnabled(false);
            }

        });

        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn25.setText(selection(playerTurns));
                btn25.setTextColor(colorSelect(playerTurns));
                playerMoves(playerTurns, 25);
                checkForWin();
                playerTurns++;
                btn25.setEnabled(false);
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
                    playerOneMoves.contains(winningRows[i][2]) && playerOneMoves.contains(winningRows[i][3])) {
                if (!(checkedGrid.contains(winningRows[i][0]) && checkedGrid.contains(winningRows[i][1]) &&
                        checkedGrid.contains(winningRows[i][2]))) {
                    checkedGrid.add(winningRows[i][0]);
                    checkedGrid.add(winningRows[i][1]);
                    checkedGrid.add(winningRows[i][2]);
                    greenRows(winningRows[i][0], winningRows[i][1], winningRows[i][2], winningRows[i][3]);
                    updatePlayerScore(1);
                    startNewRound();
                    break;
                }

            }
            if (playerTwoMoves.contains(winningRows[i][0]) && playerTwoMoves.contains(winningRows[i][1]) &&
                    playerTwoMoves.contains(winningRows[i][2]) && playerTwoMoves.contains(winningRows[i][3])) {

                if (!(checkedGrid.contains(winningRows[i][0]) && checkedGrid.contains(winningRows[i][1]) &&
                        checkedGrid.contains(winningRows[i][2]))) {
                    checkedGrid.add(winningRows[i][0]);
                    checkedGrid.add(winningRows[i][1]);
                    checkedGrid.add(winningRows[i][2]);
                    greenRows(winningRows[i][0], winningRows[i][1], winningRows[i][2], winningRows[i][3]);
                    updatePlayerScore(2);
                    startNewRound();
                    break;
                }

            }
            if (playerTurns == 25) {
                if (checkForDraw()) {
                    playerOneScoreCount++;
                    playerTwoScoreCount++;
                    PlayerOneScore.setText(String.valueOf(playerOneScoreCount));
                    PlayerTwoScore.setText(String.valueOf(playerTwoScoreCount));
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
            PlayerOneScore.setText(String.valueOf(playerOneScoreCount));
            winner.setText(getString(R.string.winner, playerOne));
            return;
        }
        if (player == 2) {
            playerTwoScoreCount++;
            PlayerTwoScore.setText(String.valueOf(playerTwoScoreCount));
            winner.setText(getString(R.string.winner, playerTwo));
        }

    }

    public void startNewRound() {
        Button[] buttons = {btn1, btn2, btn3, btn4, btn5,
                btn6, btn7, btn8, btn9, btn10, btn11, btn12,
                btn13, btn14, btn15, btn16, btn17, btn18, btn19,
                btn20, btn21, btn22, btn23, btn24, btn25};
        for (Button x : buttons) {
            if (x.isEnabled()) {
                x.setEnabled(false);
            }
        }
        Animation animation = AnimationUtils.loadAnimation(MultiPlayerGrid5Activity.this, R.anim.slide_in);
        animation.setDuration(1000);
        winnerContainer.startAnimation(animation);
        winnerContainer.setVisibility(View.VISIBLE);
        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MultiPlayerGrid5Activity.this, StartActivity.class);
                startActivity(intent);
            }
        });

    }

    public void resetGame() {
        winnerContainer.setVisibility(View.GONE);
        Animation animation = AnimationUtils.loadAnimation(MultiPlayerGrid5Activity.this, R.anim.slide_in);
        animation.setDuration(1000);
        gridLayout.startAnimation(animation);
        Button[] buttons = {btn1, btn2, btn3, btn4, btn5,
                btn6, btn7, btn8, btn9, btn10, btn11, btn12,
                btn13, btn14, btn15, btn16, btn17, btn18, btn19,
                btn20, btn21, btn22, btn23, btn24, btn25};
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
                    && playerOneMoves.contains(winningRows[i][2]) && playerOneMoves.contains(winningRows[i][3]))
                    || (playerTwoMoves.contains(winningRows[i][0]) && playerTwoMoves.contains(winningRows[i][1]) &&
                    playerTwoMoves.contains(winningRows[i][2])
                    && playerTwoMoves.contains(winningRows[i][3]))) {
                endsInDraw = false;
                break;
            }
        }
        return endsInDraw;
    }

    public void greenRows(int a, int b, int c, int d) {
       Button[] buttons = {btn1, btn2, btn3, btn4, btn5,
                btn6, btn7, btn8, btn9, btn10, btn11, btn12,
                btn13, btn14, btn15, btn16, btn17, btn18, btn19,
                btn20, btn21, btn22, btn23, btn24, btn25}; 

        buttons[a - 1].setBackgroundResource(R.drawable.won_rows);
        buttons[b - 1].setBackgroundResource(R.drawable.won_rows);
        buttons[c - 1].setBackgroundResource(R.drawable.won_rows);
        buttons[d - 1].setBackgroundResource(R.drawable.won_rows);

    }
}
