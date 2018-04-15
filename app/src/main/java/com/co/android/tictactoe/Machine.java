package com.co.android.tictactoe;


import android.support.v7.app.AppCompatActivity;
import com.co.android.tictactoe.MainActivity;


public class Machine {

    /*

     private int playerTurns = 1;

    private int[][] winningRows = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
    ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
    ArrayList<Integer> rowOne = new ArrayList<>(3);
    ArrayList<Integer> rowTwo = new ArrayList<>(3);
    ArrayList<Integer> rowThree = new ArrayList<>(3);
    ArrayList<Integer> movesOne = new ArrayList<>(5);
    ArrayList<Integer> movesTwo = new ArrayList<>(4);


    private int gOne;
    private int gTwo;
    private int gThree;
    private int gFour;
    private int gFive;
    private int gSix;
    private int gSeven;
    private int gEight;
    private int gNine;


    private TextView gridOne;
    private TextView gridTwo;
    private TextView gridThree;
    private TextView gridFour;
    private TextView gridFive;
    private TextView gridSix;
    private TextView gridSeven;
    private TextView gridEight;
    private TextView gridNine;

     rowOne.add(1);
        rowOne.add(2);
        rowOne.add(3);
        rowTwo.add(4);
        rowTwo.add(5);
        rowTwo.add(6);
        rowThree.add(7);
        rowThree.add(8);
        rowThree.add(9);
        rows.add(rowOne);
        rows.add(rowTwo);
        rows.add(rowThree);


        gridOne = (TextView) findViewById(R.id.grid1);
        gridTwo = (TextView) findViewById(R.id.grid2);
        gridThree = (TextView) findViewById(R.id.grid3);
        gridFour = (TextView) findViewById(R.id.grid4);
        gridFive = (TextView) findViewById(R.id.grid5);
        gridSix = (TextView) findViewById(R.id.grid6);
        gridSeven = (TextView) findViewById(R.id.grid7);
        gridEight = (TextView) findViewById(R.id.grid8);
        gridNine = (TextView) findViewById(R.id.grid9);


        gridOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gOne = 1;
                movesOne.add(gOne);
                PlayerOneTurn(gOne);

            }

        });

        gridTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gTwo = 4;
                movesOne.add(gTwo);
                PlayerOneTurn(gTwo);
            }

        });

        gridThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gThree = 7;
                movesOne.add(gThree);
                PlayerOneTurn(gThree);
            }

        });

        gridFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gFour = 2;
                movesOne.add(gFour);
                PlayerOneTurn(gFour);
            }

        });

        gridFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gFive = 5;
                movesOne.add(gFive);
                PlayerOneTurn(gFive);
            }

        });

        gridSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gSix = 8;
                movesOne.add(gSix);
                PlayerOneTurn(gSix);
            }

        });

        gridSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gSeven = 3;
                movesOne.add(gSeven);
                PlayerOneTurn(gSeven);
            }

        });

        gridEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gEight = 6;
                movesOne.add(gEight);
                PlayerOneTurn(gEight);
            }

        });


        gridNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gNine = 9;
                movesOne.add(gNine);
                PlayerOneTurn(gNine);
            }

        });


    }


    public void gridSelection(int gridNumber, String marker) {
        switch (gridNumber) {
            case 1:
                gridOne.setText(marker);
                break;
            case 2:
                gridFour.setText(marker);
                break;
            case 3:
                gridSeven.setText(marker);
                break;
            case 4:
                gridTwo.setText(marker);
                break;
            case 5:
                gridFive.setText(marker);
                break;
            case 6:
                gridEight.setText(marker);
                break;
            case 7:
                gridThree.setText(marker);
                break;
            case 8:
                gridSix.setText(marker);
                break;
            case 9:
                gridNine.setText(marker);
                break;
            default:
                return;
        }



         public void PlayerOneTurn(int num) {
        switch (playerTurns) {
            case 1:
                gridSelection(num, "X");
                playerTurns++;
                playerTwoTurn();
                break;
            case 3:
                gridSelection(num, "X");
                playerTurns++;
                playerTwoTurn();
                break;
            case 5:
                gridSelection(num, "X");
                playerTurns++;
                playerTwoTurn();
                break;
            case 7:
                gridSelection(num, "X");
                playerTurns++;
                playerTwoTurn();
                break;
            case 9:
                gridSelection(num, "X");
                playerTurns++;
                playerTwoTurn();
                checkForWin();
                break;
            default:
                playerTwoTurn();
                checkForWin();


        }
    }

    public void playerTwoTurn() {
        int gridSelect = (int) Math.floor(Math.random() * 9);
        if (playerTurns == 2 && movesOne.size() == 1) {
            while (!movesOne.contains(gridSelect)) {
                if (!movesOne.contains(gridSelect)) {
                    gridSelection(gridSelect, "O");
                    movesTwo.add(gridSelect);
                    playerTurns++;
                    break;
                }
                gridSelect = (int) Math.floor(Math.random() * 9);
            }
            return;
        }

        if (movesOne.contains(rows.get(0).get(0)) && movesOne.contains(rows.get(0).get(1)) && !movesTwo.contains(3)) {
            gridSelect = 3;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(1)) && movesOne.contains(rows.get(0).get(2)) && !movesTwo.contains(1)) {
            gridSelect = 1;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(0)) && movesOne.contains(rows.get(0).get(2)) && !movesTwo.contains(2)) {
            gridSelect = 2;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(1).get(0)) && movesOne.contains(rows.get(1).get(1)) && !movesTwo.contains(6)) {
            gridSelect = 6;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(1).get(1)) && movesOne.contains(rows.get(1).get(2)) && !movesTwo.contains(4)) {
            gridSelect = 4;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(1).get(0)) && movesOne.contains(rows.get(1).get(2)) && !movesTwo.contains(5)) {
            gridSelect = 5;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(2).get(0)) && movesOne.contains(rows.get(2).get(1)) && !movesTwo.contains(9)) {
            gridSelect = 9;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(2).get(1)) && movesOne.contains(rows.get(2).get(2)) && !movesTwo.contains(7)) {
            gridSelect = 7;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(2).get(0)) && movesOne.contains(rows.get(2).get(2)) && !movesTwo.contains(8)) {
            gridSelect = 8;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(0)) && movesOne.contains(rows.get(1).get(0)) && !movesTwo.contains(7)) {
            gridSelect = 7;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(1)) && movesOne.contains(rows.get(1).get(1)) && !movesTwo.contains(8)) {
            gridSelect = 8;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(2)) && movesOne.contains(rows.get(1).get(2)) && !movesTwo.contains(9)) {
            gridSelect = 9;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(1).get(0)) && movesOne.contains(rows.get(2).get(0)) && !movesTwo.contains(1)) {
            gridSelect = 1;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(1).get(1)) && movesOne.contains(rows.get(2).get(1)) && !movesTwo.contains(2)) {
            gridSelect = 2;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(1).get(2)) && movesOne.contains(rows.get(2).get(2)) && !movesTwo.contains(3)) {
            gridSelect = 3;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(0)) && movesOne.contains(rows.get(2).get(0)) && !movesTwo.contains(4)) {
            gridSelect = 4;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(1)) && movesOne.contains(rows.get(2).get(1)) && !movesTwo.contains(5)) {
            gridSelect = 5;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(2)) && movesOne.contains(rows.get(2).get(2)) && !movesTwo.contains(6)) {
            gridSelect = 6;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(0)) && movesOne.contains(rows.get(1).get(1)) && !movesTwo.contains(9)) {
            gridSelect = 9;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(1).get(1)) && movesOne.contains(rows.get(2).get(2)) && !movesTwo.contains(1)) {
            gridSelect = 1;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(0)) && movesOne.contains(rows.get(2).get(2)) && !movesTwo.contains(5)) {
            gridSelect = 5;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(2)) && movesOne.contains(rows.get(1).get(1)) && !movesTwo.contains(7)) {
            gridSelect = 7;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(1).get(1)) && movesOne.contains(rows.get(2).get(0)) && !movesTwo.contains(3)) {
            gridSelect = 3;
            Logic(true, gridSelect);
        } else if (movesOne.contains(rows.get(0).get(2)) && movesOne.contains(rows.get(2).get(0)) && !movesTwo.contains(5)) {
            gridSelect = 5;
            Logic(true, gridSelect);
        }

    }

    public void Logic(boolean check, int gridSelect) {
        if (playerTurns == 4 && check) {
            gridSelection(gridSelect, "O");
            movesTwo.add(gridSelect);
            playerTurns++;
        }
        else if (playerTurns == 4) {
            for (int k = 1; k < 10; k++) {
                if (!((movesOne.contains(k)) || (movesTwo.contains(k)))) {
                    gridSelection(k, "O");
                    movesTwo.add(k);
                    playerTurns++;
                    break;
                }

            }
        } else if (playerTurns == 6 && check) {
            gridSelection(gridSelect, "O");
            movesTwo.add(gridSelect);
            playerTurns++;
        } else if (playerTurns == 6) {
            for (int k = 1; k < 10; k++) {
                if ((!movesOne.contains(k)) && (!movesTwo.contains(k))) {
                    gridSelection(k, "O");
                    movesTwo.add(k);
                    playerTurns++;
                    break;
                }
            }
        } else if (playerTurns == 8 && check) {
            gridSelection(gridSelect, "O");
            movesTwo.add(gridSelect);
            playerTurns++;
        } else if (playerTurns == 8) {
            for (int k = 1; k < 10; k++) {
                if ((!movesOne.contains(k)) && (!movesTwo.contains(k))) {
                    gridSelection(k, "O");
                    movesTwo.add(k);
                    playerTurns++;
                    break;
                }
            }

        }
    }

    public void checkForWin() {

        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                if (movesOne.contains(rows.get(k))) {
                    Toast.makeText(this, "X won the game", Toast.LENGTH_SHORT).show();
                    break;
                } else if (movesTwo.contains(rows.get(k))) {
                    Toast.makeText(this, "O won the game", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    Toast.makeText(this, "It's a draw", Toast.LENGTH_SHORT).show();
                }

            }
        }





    }

    Add: Round selection & Timer

     */


}


