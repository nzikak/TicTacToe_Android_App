package com.co.android.tictactoe;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.x;
import static android.view.View.X;


public class SinglePlayerActivity extends AppCompatActivity {

    private int roundSelection = 3;
    private String playerX = "You";
    private String playerO = "Joe";
    private int playerTurns = 1;


    private Button grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
            grid3_btn8, grid3_btn9, grid5_btn1, grid5_btn2, grid5_btn3, grid5_btn4, grid5_btn5,
            grid5_btn6, grid5_btn7, grid5_btn8, grid5_btn9, grid5_btn10, grid5_btn11, grid5_btn12,
            grid5_btn13, grid5_btn14, grid5_btn15, grid5_btn16, grid5_btn17, grid5_btn18, grid5_btn19,
            grid5_btn20, grid5_btn21, grid5_btn22, grid5_btn23, grid5_btn24, grid5_btn25;

    private Integer[][] grid3winningRows = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};

    private Integer[][] grid5winningRows = {{1, 2, 3, 4}, {2, 3, 4, 5}, {6, 7, 8, 9}, {7, 8, 9, 10}, {11, 12, 13, 14}, {12, 13, 14, 15},
            {16, 17, 18, 19}, {17, 18, 19, 20}, {21, 22, 23, 24}, {22, 23, 24, 25}, {1, 6, 11, 16}, {6, 11, 16, 21}, {2, 7, 12, 17},
            {7, 12, 17, 22}, {3, 8, 13, 18}, {8, 13, 18, 23}, {4, 9, 14, 19}, {9, 14, 19, 24}, {5, 10, 15, 20}, {10, 15, 20, 25},
            {1, 7, 13, 19}, {7, 13, 19, 25}, {2, 8, 14, 20}, {4, 8, 12, 16}, {5, 9, 13, 17}, {9, 13, 17, 21}, {6, 12, 18, 24},
            {7, 13, 19, 25}, {10, 14, 18, 22}};

    private ArrayList<Integer> aiMoves = new ArrayList<>();

    private ArrayList<Integer> playerOneMoves = new ArrayList<>();
    private ArrayList<Integer> playerTwoMoves = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        super.onCreate(savedInstanceState);

        TextView grid3_playerA, grid3_playerB, grid5_playerA, grid5_playerB;

        int gridSize = 3;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            gridSize = bundle.getInt("gridSize");
            roundSelection = bundle.getInt("roundSelection");
        }

        if (gridSize == 3) {
            setContentView(R.layout.three_by_three);
            LinearLayout grid3Layout = (LinearLayout) findViewById(R.id.grid3_layout);
            grid3_playerA = (TextView) findViewById(R.id.grid3_playerA);
            grid3_playerB = (TextView) findViewById(R.id.grid3_playerB);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in);
            animation.setDuration(1500);
            grid3Layout.startAnimation(animation);
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            grid3_playerA.setText(playerX);
            grid3_playerB.setText(playerO);

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
                    grid3_btn1.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 1);
                    playerTurns++;
                    grid3_btn1.setEnabled(false);
                    grid3AITurn();
                }
            });

            grid3_btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid3_btn2.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 2);
                    playerTurns++;
                    grid3_btn2.setEnabled(false);
                    grid3AITurn();
                }
            });

            grid3_btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid3_btn3.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 3);
                    grid3_btn3.setEnabled(false);
                    playerTurns++;
                    grid3AITurn();
                }
            });

            grid3_btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid3_btn4.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 4);
                    grid3_btn4.setEnabled(false);
                    playerTurns++;
                    grid3AITurn();
                }
            });

            grid3_btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid3_btn5.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 5);
                    grid3_btn5.setEnabled(false);
                    playerTurns++;
                    grid3AITurn();
                }
            });

            grid3_btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid3_btn6.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 6);
                    grid3_btn6.setEnabled(false);
                    playerTurns++;
                    grid3AITurn();
                }
            });

            grid3_btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid3_btn7.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 7);
                    grid3_btn7.setEnabled(false);
                    playerTurns++;
                    grid3AITurn();
                }
            });

            grid3_btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid3_btn8.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 8);
                    grid3_btn8.setEnabled(false);
                    playerTurns++;
                    grid3AITurn();
                }
            });

            grid3_btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid3_btn9.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 9);
                    grid3_btn9.setEnabled(false);
                    playerTurns++;
                    grid3AITurn();
                }
            });

        }

        if (gridSize == 5) {
            setContentView(R.layout.five_by_five);
            LinearLayout grid5Layout = (LinearLayout) findViewById(R.id.grid5_layout);
            grid5_playerA = (TextView) findViewById(R.id.grid5_playerA);
            grid5_playerB = (TextView) findViewById(R.id.grid5_playerB);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in);
            animation.setDuration(1500);
            grid5Layout.startAnimation(animation);
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            grid5_playerA.setText(playerX);
            grid5_playerB.setText(playerO);

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
                    grid5_btn1.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 1);
                    playerTurns++;
                    grid5_btn1.setEnabled(false);
                }
            });

            grid5_btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn2.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 2);
                    playerTurns++;
                    grid5_btn2.setEnabled(false);
                }
            });

            grid5_btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn3.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 3);
                    playerTurns++;
                    grid5_btn3.setEnabled(false);
                }
            });

            grid5_btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn4.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 4);
                    playerTurns++;
                    grid5_btn4.setEnabled(false);
                }
            });

            grid5_btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn5.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 5);
                    playerTurns++;
                    grid5_btn5.setEnabled(false);
                }
            });

            grid5_btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn6.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 6);
                    playerTurns++;
                    grid5_btn6.setEnabled(false);

                }
            });

            grid5_btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn7.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 7);
                    playerTurns++;
                    grid5_btn7.setEnabled(false);
                }
            });

            grid5_btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn8.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 8);
                    playerTurns++;
                    grid5_btn8.setEnabled(false);
                }
            });

            grid5_btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn9.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 9);
                    playerTurns++;
                    grid5_btn9.setEnabled(false);

                }
            });

            grid5_btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn10.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 10);
                    playerTurns++;
                    grid5_btn10.setEnabled(false);
                }
            });

            grid5_btn11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn11.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 11);
                    playerTurns++;
                    grid5_btn11.setEnabled(false);

                }
            });

            grid5_btn12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn12.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 12);
                    playerTurns++;
                    grid5_btn12.setEnabled(false);
                }
            });

            grid5_btn13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn13.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 13);
                    playerTurns++;
                    grid5_btn13.setEnabled(false);

                }
            });

            grid5_btn14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn14.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 14);
                    playerTurns++;
                    grid5_btn14.setEnabled(false);
                }
            });

            grid5_btn15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn15.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 15);
                    playerTurns++;
                    grid5_btn15.setEnabled(false);
                }
            });

            grid5_btn16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn16.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 16);
                    playerTurns++;
                    grid5_btn16.setEnabled(false);

                }
            });

            grid5_btn17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn17.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 17);
                    playerTurns++;
                    grid5_btn17.setEnabled(false);
                }
            });

            grid5_btn18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn18.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 18);
                    playerTurns++;
                    grid5_btn18.setEnabled(false);

                }
            });

            grid5_btn19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn19.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 19);
                    playerTurns++;
                    grid5_btn19.setEnabled(false);
                }
            });

            grid5_btn20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn20.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 20);
                    playerTurns++;
                    grid5_btn20.setEnabled(false);
                }
            });

            grid5_btn21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn21.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 21);
                    playerTurns++;
                    grid5_btn21.setEnabled(false);
                }
            });

            grid5_btn22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn22.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 22);
                    playerTurns++;
                    grid5_btn22.setEnabled(false);
                }
            });

            grid5_btn23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn23.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 23);
                    playerTurns++;
                    grid5_btn23.setEnabled(false);
                }
            });

            grid5_btn24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn24.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 24);
                    playerTurns++;
                    grid5_btn24.setEnabled(false);
                }
            });

            grid5_btn25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    grid5_btn25.setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, 25);
                    playerTurns++;
                    grid5_btn25.setEnabled(false);
                }
            });
        }
    }

    public String markerSelection(int turns) {
        if(turns % 2 == 0) {
            return "O";
        }
        return "X";
    }

    public void playerMoves(int turns, int move) {
        if(turns % 2 == 0) {
            playerTwoMoves.add(move);
            return;
        }
        playerOneMoves.add(move);
    }

    public void grid3AITurn() {
        grid3AISelection(playerTurns);
    }

    public void grid3AISelection(int aiTurn) {
        Button [] grid3Buttons = {grid3_btn1, grid3_btn2, grid3_btn3, grid3_btn4, grid3_btn5, grid3_btn6, grid3_btn7,
                grid3_btn8, grid3_btn9};
        Random rand = new Random();
        if (aiTurn == 2) {
              for(int i = 0; i < grid3winningRows.length; i++) {
                      if (playerOneMoves.get(0) != grid3winningRows[i][0] && playerOneMoves.get(0) != grid3winningRows[i][1] &&
                              playerOneMoves.get(0) != grid3winningRows[i][2]) {
                          int selection = grid3winningRows[i][rand.nextInt(3)];
                          grid3Buttons[selection].setText(markerSelection(playerTurns));
                          playerMoves(playerTurns, selection);
                          grid3Buttons[selection].setEnabled(false);
                          aiMoves.add(grid3winningRows[i][0]);
                          aiMoves.add(grid3winningRows[i][1]);
                          aiMoves.add(grid3winningRows[i][2]);
                          playerTurns++;
                          Toast.makeText(this, grid3winningRows[i][0].toString() + grid3winningRows[i][1].toString() +
                                  grid3winningRows[i][2].toString(), Toast.LENGTH_SHORT).show();
                          return;
                  }
              }

            /*  while(playerTwoMoves.isEmpty()) {
                   int selection = rand.nextInt(9);
                    if(selection != playerOneMoves.get(0)) {
                        grid3Buttons[selection].setText(markerSelection(playerTurns));
                        playerMoves(playerTurns, selection);
                        grid3Buttons[selection].setEnabled(false);
                        playerTurns++;
                        return;
                }
            } */
        }

       if (aiTurn == 4) {
            for(int i = 0; i < grid3winningRows.length; i++) {
                if(playerOneMoves.contains(grid3winningRows[i][0]) && playerOneMoves.contains(grid3winningRows[i][1])
                        && playerTwoMoves.get(0) != grid3winningRows[i][2] - 1) {
                    int selection = grid3winningRows[i][2];
                    grid3Buttons[selection - 1].setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, selection);
                    grid3Buttons[selection - 1].setEnabled(false);
                    aiMoves.clear();
                    playerTurns++;
                    return;
                }
                else if(playerOneMoves.contains(grid3winningRows[i][1]) && playerOneMoves.contains(grid3winningRows[i][2])
                        && (playerTwoMoves.get(0) != grid3winningRows[i][0] - 1)) {
                    int selection = grid3winningRows[i][0];
                    grid3Buttons[selection - 1].setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, selection);
                    Toast.makeText(this, playerTwoMoves.get(0) + " " + playerTwoMoves.get(1), Toast.LENGTH_SHORT).show();
                    grid3Buttons[selection - 1].setEnabled(false);
                    aiMoves.clear();
                    playerTurns++;
                    return;
                }
                else if(playerOneMoves.contains(grid3winningRows[i][0]) && playerOneMoves.contains(grid3winningRows[i][2])
                        && playerTwoMoves.get(0) != grid3winningRows[i][1] - 1) {
                    int selection = grid3winningRows[i][1];
                    grid3Buttons[selection - 1].setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, selection);
                    grid3Buttons[selection].setEnabled(false);
                    aiMoves.clear();
                    playerTurns++;
                    return;
                }
                else if(playerOneMoves.contains(grid3winningRows[i][1]) && playerOneMoves.contains(grid3winningRows[i][2])
                        && playerTwoMoves.get(0) != grid3winningRows[i][0] - 1) {
                    int selection = grid3winningRows[i][0];
                    grid3Buttons[selection - 1].setText(markerSelection(playerTurns));
                    playerMoves(playerTurns, selection);
                    grid3Buttons[selection - 1].setEnabled(false);
                    aiMoves.clear();
                    playerTurns++;
                    return;
                }
            }
           for(int x = 0; x < aiMoves.size(); x++) {
               if(playerTwoMoves.get(0) != aiMoves.get(x) && !playerOneMoves.contains(aiMoves.get(x))) {
                   int selection = aiMoves.get(x);
                   grid3Buttons[selection].setText(markerSelection(playerTurns));
                   playerMoves(playerTurns, selection);
                   grid3Buttons[selection].setEnabled(false);
                   playerTurns++;
                   return;
               }
           }
        }

        if(aiTurn == 6) {
           if(!aiMoves.isEmpty()) {
               for(int x = 0; x < aiMoves.size(); x++) {
                   if(!playerTwoMoves.contains(aiMoves.get(x)) && !playerOneMoves.contains(aiMoves.get(x))) {
                       int selection = aiMoves.get(x);
                       grid3Buttons[selection].setText(markerSelection(playerTurns));
                       playerMoves(playerTurns, selection);
                       grid3Buttons[selection].setEnabled(false);
                       playerTurns++;
                       return;
                   }
               }
            }

        }
    }

}
