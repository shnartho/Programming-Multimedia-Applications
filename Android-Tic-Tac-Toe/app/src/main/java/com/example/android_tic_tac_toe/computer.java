package com.example.android_tic_tac_toe;

public class computer {
    public int[] bestMove(String board[][]) {
        int bestScore=-999999999;
        int move[]=new int[]{99,99};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    int score = search(board, 0, true,i,j);
                    if (score > bestScore) {
                        bestScore = score;
                        move = new int[]{i, j};
                    }
                }
            }
        }
       return move;
    }
    public int search(String data[][],int depth,boolean player,int pointX,int pointY) {
        String [][] board = new String[data.length][];
        for(int i = 0; i < data.length; i++)
            board[i] = data[i].clone();
        if (player) {
            board[pointX][pointY] = "o";
            int check=checkWinner(board);
            int mark = check+depth;
            int bestScore=0;
            if(check==0) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j].equals(" ")) {
                            if(bestScore==0){
                                bestScore=search(board, depth - 1, false, i, j);
                            }else {
                                int score = search(board, depth - 1, false, i, j);
                                if (score < bestScore) {
                                    bestScore = score;
                                }
                            }
                        }
                    }
                }
            }
            return bestScore+mark;
        } else {
            board[pointX][pointY] = "x";
            int check=checkWinner(board);
            int mark = check+depth;
            int bestScore=0;
            if(check==0) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j].equals(" ")) {
                            if (bestScore == 0) {
                                bestScore = search(board, depth - 1, true, i, j);
                            } else {
                                int score = search(board, depth - 1, true, i, j);
                                if (score > bestScore) {
                                    bestScore = score;
                                }
                            }
                        }
                    }
                }
            }
            return bestScore+mark;
        }
    }
    public int checkWinner(String board[][]){
        for (int i = 0; i < 3; i++) {
            if(board[i][0].equals("x")&&board[i][1].equals("x")&&board[i][2].equals("x")){
                return -100;
            }else if(board[i][0].equals("o")&&board[i][1].equals("o")&&board[i][2].equals("o")){
                return 100;
            }else  if(board[0][i].equals("x")&&board[1][i].equals("x")&&board[2][i].equals("x")){
                return -100;
            }else if(board[0][i].equals("o")&&board[1][i].equals("o")&&board[2][i].equals("o")){
                return 100;
            }
        }
        if(board[0][0].equals("x")&&board[1][1].equals("x")&&board[2][2].equals("x")){
            return -100;
        }else if(board[0][0].equals("o")&&board[1][1].equals("o")&&board[2][2].equals("o")){
            return 100;
        }
        if(board[0][2].equals("x")&&board[1][1].equals("x")&&board[2][0].equals("x")){
            return -100;
        }else if(board[0][2].equals("o")&&board[1][1].equals("o")&&board[2][0].equals("o")){
            return 100;
        }
        return 0;
    }
}
