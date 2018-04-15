package com.co.android.tictactoe;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.animation;


public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> checkedGrid = new ArrayList<>();
    private int roundCount = 1;
    private int playerTurns = 1;
    private int playerAScore = 0;
    private int playerBScore = 0;
    private String playerX = "";
    private String playerO = "";
    private Button grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
            grid3_btn8, grid3_btn9, grid5_btn1, grid5_btn2, grid5_btn3, grid5_btn4, grid5_btn5,
            grid5_btn6, grid5_btn7, grid5_btn8, grid5_btn9, grid5_btn10, grid5_btn11, grid5_btn12,
            grid5_btn13, grid5_btn14, grid5_btn15, grid5_btn16, grid5_btn17, grid5_btn18, grid5_btn19,
            grid5_btn20, grid5_btn21, grid5_btn22, grid5_btn23, grid5_btn24, grid5_btn25;
    private LinearLayout gridLayout;
    private RelativeLayout winPop;
    private TextView playerWon;
    private Button menu, nextRound;
    private ActionBar mActionBar;
    private Integer[][] grid3winningRows = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
    private Integer[][] grid5winningRows = {{1, 2, 3, 4}, {2, 3, 4, 5}, {6, 7, 8, 9}, {7, 8, 9, 10}, {11, 12, 13, 14}, {12, 13, 14, 15},
            {16, 17, 18, 19}, {17, 18, 19, 20}, {21, 22, 23, 24}, {22, 23, 24, 25}, {1, 6, 11, 16}, {6, 11, 16, 21}, {2, 7, 12, 17},
            {7, 12, 17, 22}, {3, 8, 13, 18}, {8, 13, 18, 23}, {4, 9, 14, 19}, {9, 14, 19, 24}, {5, 10, 15, 20}, {10, 15, 20, 25},
            {1, 7, 13, 19}, {7, 13, 19, 25}, {2, 8, 14, 20}, {4, 8, 12, 16}, {5, 9, 13, 17}, {9, 13, 17, 21}, {6, 12, 18, 24},
            {7, 13, 19, 25}, {10, 14, 18, 22}};
    private ArrayList<Integer> playerOneMoves = new ArrayList<>();
    private ArrayList<Integer> playerTwoMoves = new ArrayList<>();
    private TextView grid3_PlayerAScore, grid3_PlayerBScore, grid5_PlayerAScore, grid5_PlayerBScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        TextView grid3_PlayerA, grid3_PlayerB, grid5_PlayerA, grid5_PlayerB;

        int gridSize = 3;


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            playerX = extras.getString("playerX");
            playerO = extras.getString("playerO");
            gridSize = extras.getInt("gridSize");
        }


        if (gridSize == 3) {
            setContentView(R.layout.three_by_three);
            gridLayout = (LinearLayout) findViewById(R.id.grid3_layout);
            winPop = (RelativeLayout) findViewById(R.id.winning);
            playerWon = (TextView) findViewById(R.id.player_won);
            menu = (Button) findViewById(R.id.menu);
            nextRound = (Button) findViewById(R.id.next_round);
            mActionBar = getSupportActionBar();
            mActionBar.setDisplayShowHomeEnabled(false);
            mActionBar.setDisplayShowTitleEnabled(false);

            LayoutInflater mInflater = LayoutInflater.from(this);
            View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
            mActionBar.setCustomView(mCustomView);
            mActionBar.setDisplayShowCustomEnabled(true);

            grid3_PlayerA = (TextView) findViewById(R.id.grid3_playerA);
            grid3_PlayerB = (TextView) findViewById(R.id.grid3_playerB);
            grid3_PlayerAScore = (TextView) findViewById(R.id.grid3_playerA_score);
            grid3_PlayerBScore = (TextView) findViewById(R.id.grid3_playerB_score);

            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in);
            animation.setDuration(1500);
            gridLayout.startAnimation(animation);
            grid3_PlayerA.setText(playerX);
            grid3_PlayerB.setText(playerO);
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
                    checkForGridThreeWin();
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
                    checkForGridThreeWin();
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
                    checkForGridThreeWin();
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
                    checkForGridThreeWin();
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
                    checkForGridThreeWin();
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
                    checkForGridThreeWin();
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
                    checkForGridThreeWin();
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
                    checkForGridThreeWin();
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
                    checkForGridThreeWin();
                    playerTurns++;
                    grid3_btn9.setEnabled(false);
                }

            });
        } else if (gridSize == 5) {
            setContentView(R.layout.five_by_five);
            gridLayout = (LinearLayout) findViewById(R.id.grid5_layout);
            grid5_PlayerA = (TextView) findViewById(R.id.grid5_playerA);
            grid5_PlayerB = (TextView) findViewById(R.id.grid5_playerB);
            grid5_PlayerAScore = (TextView) findViewById(R.id.grid5_playerA_score);
            grid5_PlayerBScore = (TextView) findViewById(R.id.grid5_playerB_score);
            winPop = (RelativeLayout) findViewById(R.id.grid5_winning);
            playerWon = (TextView) findViewById(R.id.grid5_player_won);
            menu = (Button) findViewById(R.id.grid5_menu);
            nextRound = (Button) findViewById(R.id.grid5_next_round);

            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in);
            animation.setDuration(1500);
            gridLayout.startAnimation(animation);
            grid5_PlayerA.setText(playerX);
            grid5_PlayerB.setText(playerO);
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            grid5_btn1 = (Button) findViewById(R.id.grid5_btn1);
            grid5_btn2 = (Button) findViewById(R.id.grid5_btn2);
            grid5_btn3 = (Button) findViewById(R.id.grid5_btn3);
            grid5_btn4 = (Button) findViewById(R.id.grid5_btn4);
            grid5_btn5 = (Button) findViewById(R.id.grid5_btn5);
            grid5_btn6 = (Button) findViewById(R.id.grid5_btn6);
            grid5_btn7 = (Button) findViewById(R.id.grid5_btn7);
            grid5_btn8 = (Button) findViewById(R.id.grid5_btn8);
            grid5_btn9 = (Button) findViewById(R.id.grid5_btn9);
            grid5_btn10 = (Button) findViewById(R.id.grid5_btn10);
            grid5_btn11 = (Button) findViewById(R.id.grid5_btn11);
            grid5_btn12 = (Button) findViewById(R.id.grid5_btn12);
            grid5_btn13 = (Button) findViewById(R.id.grid5_btn13);
            grid5_btn14 = (Button) findViewById(R.id.grid5_btn14);
            grid5_btn15 = (Button) findViewById(R.id.grid5_btn15);
            grid5_btn16 = (Button) findViewById(R.id.grid5_btn16);
            grid5_btn17 = (Button) findViewById(R.id.grid5_btn17);
            grid5_btn18 = (Button) findViewById(R.id.grid5_btn18);
            grid5_btn19 = (Button) findViewById(R.id.grid5_btn19);
            grid5_btn20 = (Button) findViewById(R.id.grid5_btn20);
            grid5_btn21 = (Button) findViewById(R.id.grid5_btn21);
            grid5_btn22 = (Button) findViewById(R.id.grid5_btn22);
            grid5_btn23 = (Button) findViewById(R.id.grid5_btn23);
            grid5_btn24 = (Button) findViewById(R.id.grid5_btn24);
            grid5_btn25 = (Button) findViewById(R.id.grid5_btn25);

            grid5_btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn1.setText(selection(playerTurns));
                    grid5_btn1.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 1);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn1.setEnabled(false);
                }

            });

            grid5_btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn2.setText(selection(playerTurns));
                    grid5_btn2.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 2);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn2.setEnabled(false);
                }

            });

            grid5_btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn3.setText(selection(playerTurns));
                    grid5_btn3.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 3);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn3.setEnabled(false);
                }

            });

            grid5_btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn4.setText(selection(playerTurns));
                    grid5_btn4.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 4);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn4.setEnabled(false);
                }

            });

            grid5_btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn5.setText(selection(playerTurns));
                    grid5_btn5.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 5);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn5.setEnabled(false);
                }

            });

            grid5_btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn6.setText(selection(playerTurns));
                    grid5_btn6.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 6);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn6.setEnabled(false);
                }

            });

            grid5_btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn7.setText(selection(playerTurns));
                    grid5_btn7.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 7);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn7.setEnabled(false);
                }

            });

            grid5_btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn8.setText(selection(playerTurns));
                    grid5_btn8.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 8);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn8.setEnabled(false);
                }

            });

            grid5_btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn9.setText(selection(playerTurns));
                    grid5_btn9.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 9);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn9.setEnabled(false);
                }

            });

            grid5_btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn10.setText(selection(playerTurns));
                    grid5_btn10.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 10);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn10.setEnabled(false);
                }

            });

            grid5_btn11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn11.setText(selection(playerTurns));
                    grid5_btn11.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 11);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn11.setEnabled(false);
                }

            });

            grid5_btn12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn12.setText(selection(playerTurns));
                    grid5_btn12.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 12);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn12.setEnabled(false);
                }

            });

            grid5_btn13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn13.setText(selection(playerTurns));
                    grid5_btn13.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 13);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn13.setEnabled(false);
                }

            });

            grid5_btn14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn14.setText(selection(playerTurns));
                    grid5_btn14.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 14);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn14.setEnabled(false);
                }

            });

            grid5_btn15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn15.setText(selection(playerTurns));
                    grid5_btn15.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 15);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn15.setEnabled(false);
                }

            });

            grid5_btn16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn16.setText(selection(playerTurns));
                    grid5_btn16.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 16);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn16.setEnabled(false);
                }

            });

            grid5_btn17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn17.setText(selection(playerTurns));
                    grid5_btn17.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 17);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn17.setEnabled(false);
                }

            });

            grid5_btn18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn18.setText(selection(playerTurns));
                    grid5_btn18.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 18);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn18.setEnabled(false);
                }

            });

            grid5_btn19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn19.setText(selection(playerTurns));
                    grid5_btn19.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 19);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn19.setEnabled(false);
                }

            });

            grid5_btn20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn20.setText(selection(playerTurns));
                    grid5_btn20.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 20);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn20.setEnabled(false);
                }

            });

            grid5_btn21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn21.setText(selection(playerTurns));
                    grid5_btn21.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 21);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn21.setEnabled(false);
                }

            });

            grid5_btn22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn22.setText(selection(playerTurns));
                    grid5_btn22.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 22);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn22.setEnabled(false);
                }

            });

            grid5_btn23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn23.setText(selection(playerTurns));
                    grid5_btn23.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 23);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn23.setEnabled(false);
                }

            });

            grid5_btn24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn24.setText(selection(playerTurns));
                    grid5_btn24.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 24);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn24.setEnabled(false);
                }

            });

            grid5_btn25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn25.setText(selection(playerTurns));
                    grid5_btn25.setTextColor(colorSelect(playerTurns));
                    playerMoves(playerTurns, 25);
                    checkForGridFiveWin();
                    playerTurns++;
                    grid5_btn25.setEnabled(false);
                }

            });
        }

    }

    public String selection(int turns) {
        if (turns % 2 == 0) {
            return "O";
        }
        return "X";

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

    public void checkForGridThreeWin() {
        for (int i = 0; i < grid3winningRows.length; i++) {
            if (playerOneMoves.contains(grid3winningRows[i][0]) && playerOneMoves.contains(grid3winningRows[i][1]) &&
                    playerOneMoves.contains(grid3winningRows[i][2])) {
                if (!(checkedGrid.contains(grid3winningRows[i][0]) && checkedGrid.contains(grid3winningRows[i][1]) &&
                        checkedGrid.contains(grid3winningRows[i][2]))) {
                    checkedGrid.add(grid3winningRows[i][0]);
                    checkedGrid.add(grid3winningRows[i][1]);
                    checkedGrid.add(grid3winningRows[i][2]);
                    grid3GreenRows(grid3winningRows[i][0], grid3winningRows[i][1], grid3winningRows[i][2]);
                    grid3UpdatePlayerScore(1);
                    startNewRound();
                    break;
                }

            }
            if (playerTwoMoves.contains(grid3winningRows[i][0]) && playerTwoMoves.contains(grid3winningRows[i][1]) &&
                    playerTwoMoves.contains(grid3winningRows[i][2])) {
                if (!(checkedGrid.contains(grid3winningRows[i][0]) && checkedGrid.contains(grid3winningRows[i][1]) &&
                        checkedGrid.contains(grid3winningRows[i][2]))) {
                    checkedGrid.add(grid3winningRows[i][0]);
                    checkedGrid.add(grid3winningRows[i][1]);
                    checkedGrid.add(grid3winningRows[i][2]);
                    grid3GreenRows(grid3winningRows[i][0], grid3winningRows[i][1], grid3winningRows[i][2]);
                    grid3UpdatePlayerScore(2);
                    startNewRound();
                    break;
                }

            }

            if (playerTurns == 9) {
                if (checkForGridThreeDraw()) {
                    playerAScore++;
                    playerBScore++;
                    grid3_PlayerAScore.setText(String.valueOf(playerAScore));
                    grid3_PlayerBScore.setText(String.valueOf(playerBScore));
                    playerWon.setText("It's a draw!");
                    startNewRound();
                    break;
                }
            }
        }
    }


    public void checkForGridFiveWin() {
        for (int i = 0; i < grid5winningRows.length; i++) {
            if (playerOneMoves.contains(grid5winningRows[i][0]) && playerOneMoves.contains(grid5winningRows[i][1]) &&
                    playerOneMoves.contains(grid5winningRows[i][2]) && playerOneMoves.contains(grid5winningRows[i][3])) {
                if (!(checkedGrid.contains(grid5winningRows[i][0]) && checkedGrid.contains(grid5winningRows[i][1]) &&
                        checkedGrid.contains(grid5winningRows[i][2]))) {
                    checkedGrid.add(grid5winningRows[i][0]);
                    checkedGrid.add(grid5winningRows[i][1]);
                    checkedGrid.add(grid5winningRows[i][2]);
                    grid5GreenRows(grid5winningRows[i][0], grid5winningRows[i][1], grid5winningRows[i][2], grid5winningRows[i][3]);
                    grid5UpdatePlayerScore(1);
                    startNewGridFiveRound();
                    break;
                }

            }
            if (playerTwoMoves.contains(grid5winningRows[i][0]) && playerTwoMoves.contains(grid5winningRows[i][1]) &&
                    playerTwoMoves.contains(grid5winningRows[i][2]) && playerTwoMoves.contains(grid5winningRows[i][3])) {

                if (!(checkedGrid.contains(grid5winningRows[i][0]) && checkedGrid.contains(grid5winningRows[i][1]) &&
                        checkedGrid.contains(grid5winningRows[i][2]))) {
                    checkedGrid.add(grid5winningRows[i][0]);
                    checkedGrid.add(grid5winningRows[i][1]);
                    checkedGrid.add(grid5winningRows[i][2]);
                    grid5GreenRows(grid5winningRows[i][0], grid5winningRows[i][1], grid5winningRows[i][2], grid5winningRows[i][3]);
                    grid5UpdatePlayerScore(2);
                    startNewGridFiveRound();
                    break;
                }

            }
            if (playerTurns == 25) {
                if (checkForGridFiveDraw()) {
                    playerAScore++;
                    playerBScore++;
                    grid5_PlayerAScore.setText(String.valueOf(playerAScore));
                    grid5_PlayerBScore.setText(String.valueOf(playerBScore));
                    playerWon.setText("It's a draw!");
                    startNewGridFiveRound();
                    break;
                }
            }
        }

    }

    public void grid3UpdatePlayerScore(int player) {
        if (player == 1) {
            playerAScore++;
            grid3_PlayerAScore.setText(String.valueOf(playerAScore));
            playerWon.setText(playerX + " won!");
            return;
        }
        if (player == 2) {
            playerBScore++;
            grid3_PlayerBScore.setText(String.valueOf(playerBScore));
            playerWon.setText(playerO + " won!");
        }

    }

    public void grid5UpdatePlayerScore(int player) {
        if (player == 1) {
            playerAScore++;
            grid5_PlayerAScore.setText(String.valueOf(playerAScore));
            playerWon.setText(playerX + " won!");
            return;
        }
        if (player == 2) {
            playerBScore++;
            grid5_PlayerBScore.setText(String.valueOf(playerBScore));
            playerWon.setText(playerO + " won!");
        }

    }

    public void startNewGridFiveRound() {
        Button[] grid5Buttons = {grid5_btn1, grid5_btn2, grid5_btn3, grid5_btn4, grid5_btn5,
                grid5_btn6, grid5_btn7, grid5_btn8, grid5_btn9, grid5_btn10, grid5_btn11, grid5_btn12,
                grid5_btn13, grid5_btn14, grid5_btn15, grid5_btn16, grid5_btn17, grid5_btn18, grid5_btn19,
                grid5_btn20, grid5_btn21, grid5_btn22, grid5_btn23, grid5_btn24, grid5_btn25};
        for (Button x : grid5Buttons) {
            if (x.isEnabled()) {
                x.setEnabled(false);
            }
        }
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in);
        animation.setDuration(1000);
        winPop.startAnimation(animation);
        winPop.setVisibility(View.VISIBLE);
        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGridFiveGame();
            }
        });

    }

    public void resetGridFiveGame() {
        winPop.setVisibility(View.GONE);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in);
        animation.setDuration(1000);
        gridLayout.startAnimation(animation);
        Button[] grid5Buttons = {grid5_btn1, grid5_btn2, grid5_btn3, grid5_btn4, grid5_btn5,
                grid5_btn6, grid5_btn7, grid5_btn8, grid5_btn9, grid5_btn10, grid5_btn11, grid5_btn12,
                grid5_btn13, grid5_btn14, grid5_btn15, grid5_btn16, grid5_btn17, grid5_btn18, grid5_btn19,
                grid5_btn20, grid5_btn21, grid5_btn22, grid5_btn23, grid5_btn24, grid5_btn25};
        roundCount++;
        playerTurns = 1;
        playerOneMoves.clear();
        playerTwoMoves.clear();
        checkedGrid.clear();

        for (Button x : grid5Buttons) {
            x.setText("");
            x.setBackgroundResource(R.drawable.button_background);
            x.setEnabled(true);
        }
    }


    public void startNewRound() {
        Button[] grid3Buttons = {grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
                grid3_btn8, grid3_btn9};
        for (Button x : grid3Buttons) {
            if (x.isEnabled()) {
                x.setEnabled(false);
            }
        }
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in);
        animation.setDuration(1000);
        winPop.startAnimation(animation);
        winPop.setVisibility(View.VISIBLE);
        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

    }

    public void resetGame() {
        winPop.setVisibility(View.GONE);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in);
        animation.setDuration(1000);
        gridLayout.startAnimation(animation);
        Button[] grid3Buttons = {grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
                grid3_btn8, grid3_btn9};
        roundCount++;
        playerTurns = 1;
        playerOneMoves.clear();
        playerTwoMoves.clear();
        checkedGrid.clear();

        for (Button x : grid3Buttons) {
            x.setText("");
            x.setBackgroundResource(R.drawable.button_background);
            x.setEnabled(true);
        }
    }

    public boolean checkForGridThreeDraw() {
        boolean endsInDraw = true;
        for (int i = 0; i < grid3winningRows.length; i++) {
            if ((playerOneMoves.contains(grid3winningRows[i][0]) && playerOneMoves.contains(grid3winningRows[i][1])
                    && playerOneMoves.contains(grid3winningRows[i][2])) || (playerTwoMoves.contains(grid3winningRows[i][0]) && playerTwoMoves.contains(grid3winningRows[i][1]) &&
                    playerTwoMoves.contains(grid3winningRows[i][2]))) {
                endsInDraw = false;
                break;
            }
        }
        return endsInDraw;
    }

    public boolean checkForGridFiveDraw() {
        boolean endsInDraw = true;
        for (int i = 0; i < grid5winningRows.length; i++) {
            if ((playerOneMoves.contains(grid5winningRows[i][0]) && playerOneMoves.contains(grid5winningRows[i][1])
                    && playerOneMoves.contains(grid5winningRows[i][2]) && playerOneMoves.contains(grid5winningRows[i][3])) || (playerTwoMoves.contains(grid5winningRows[i][0]) &&
                    playerTwoMoves.contains(grid5winningRows[i][1]) && playerTwoMoves.contains(grid5winningRows[i][2])
                    && playerTwoMoves.contains(grid5winningRows[i][3]))) {
                endsInDraw = false;
                break;
            }
        }
        return endsInDraw;
    }


    public void grid3GreenRows(int a, int b, int c) {
        Button[] grid3Buttons = {grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
                grid3_btn8, grid3_btn9};
        grid3Buttons[a - 1].setBackgroundResource(R.drawable.won_rows);
        grid3Buttons[b - 1].setBackgroundResource(R.drawable.won_rows);
        grid3Buttons[c - 1].setBackgroundResource(R.drawable.won_rows);
    }

    public void grid5GreenRows(int a, int b, int c, int d) {
        Button[] grid5Buttons = {grid5_btn1, grid5_btn2, grid5_btn3, grid5_btn4, grid5_btn5,
                grid5_btn6, grid5_btn7, grid5_btn8, grid5_btn9, grid5_btn10, grid5_btn11, grid5_btn12,
                grid5_btn13, grid5_btn14, grid5_btn15, grid5_btn16, grid5_btn17, grid5_btn18, grid5_btn19,
                grid5_btn20, grid5_btn21, grid5_btn22, grid5_btn23, grid5_btn24, grid5_btn25};

        grid5Buttons[a - 1].setBackgroundResource(R.drawable.won_rows);
        grid5Buttons[b - 1].setBackgroundResource(R.drawable.won_rows);
        grid5Buttons[c - 1].setBackgroundResource(R.drawable.won_rows);
        grid5Buttons[d - 1].setBackgroundResource(R.drawable.won_rows);

    }
}



