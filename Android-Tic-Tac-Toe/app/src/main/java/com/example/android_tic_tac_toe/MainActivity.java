package com.example.android_tic_tac_toe;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button Button_1_1,Button_1_2,Button_1_3,Button_2_1,Button_2_2,Button_2_3,Button_3_1,Button_3_2,Button_3_3;
    private Switch switch1,switch2;
    boolean player = true;
    boolean computerPlay = true;
    private TextView switch_play;
    String board[][]=new String[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button_1_1 = (Button) findViewById(R.id.Button_1_1);
        Button_1_2 = (Button) findViewById(R.id.Button_1_2);
        Button_1_3 = (Button) findViewById(R.id.Button_1_3);
        Button_2_1 = (Button) findViewById(R.id.Button_2_1);
        Button_2_2 = (Button) findViewById(R.id.Button_2_2);
        Button_2_3 = (Button) findViewById(R.id.Button_2_3);
        Button_3_1 = (Button) findViewById(R.id.Button_3_1);
        Button_3_2 = (Button) findViewById(R.id.Button_3_2);
        Button_3_3 = (Button) findViewById(R.id.Button_3_3);
        switch_play = (TextView) findViewById(R.id.switch_play);
        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);
        switch_play.setText("Player x");

        Button_1_1.setOnClickListener(btnListener);
        Button_1_2.setOnClickListener(btnListener);
        Button_1_3.setOnClickListener(btnListener);
        Button_2_1.setOnClickListener(btnListener);
        Button_2_2.setOnClickListener(btnListener);
        Button_2_3.setOnClickListener(btnListener);
        Button_3_1.setOnClickListener(btnListener);
        Button_3_2.setOnClickListener(btnListener);
        Button_3_3.setOnClickListener(btnListener);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j]=" ";
            }
        }
        computer();
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked) {
                    switch2.setVisibility(View.VISIBLE);
                    Reset();
                    if(switch2.isChecked()){
                        switch_play.setText("Player x");
                        computerPlay = false;
                        player = false;
                        switch2.setText("Player first");
                    }else {
                        switch_play.setText("Player x");
                        computerPlay = false;
                        player = false;
                        switch2.setText("Computer");
                    }
                    switch1.setText("Computer");
                }
                else {
                    Reset();
                    switch_play.setText("Player x");
                    computerPlay = true;
                    player = false;
                    switch2.setVisibility(View.INVISIBLE);
                    switch1.setText("Double");
                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Reset();
                    switch_play.setText("Player x");
                    computerPlay = true;
                    player = true;
                    switch2.setText("Player first");
                }
                else {
                    Reset();
                    switch_play.setText("Player x");
                    computerPlay = true;
                    player = true;
                    switch2.setText("Computer");
                }
            }
        });
    }
    private View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.Button_1_1:
                    if(board[0][0].equals(" ")) {
                        if (player) {
                            board[0][0] = "x";
                            Button_1_1.setText("x");
                            player=false;
                        }else {
                            board[0][0] = "o";
                            Button_1_1.setText("o");
                            player=true;
                        }
                        computer();
                    }
                    break;
                case R.id.Button_1_2:
                    if(board[0][1].equals(" ")) {
                        if (player) {
                            board[0][1] = "x";
                            Button_1_2.setText("x");
                            player=false;
                        }else {
                            board[0][1] = "o";
                            Button_1_2.setText("o");
                            player=true;
                        }
                        computer();
                    }
                    break;
                case R.id.Button_1_3:
                    if(board[0][2].equals(" ")) {
                        if (player) {
                            board[0][2] = "x";
                            Button_1_3.setText("x");
                            player=false;
                        }else {
                            board[0][2] = "o";
                            Button_1_3.setText("o");
                            player=true;
                        }
                        computer();
                    }
                    break;
                case R.id.Button_2_1:
                    if(board[1][0].equals(" ")) {
                        if (player) {
                            board[1][0] = "x";
                            Button_2_1.setText("x");
                            player=false;
                        } else {
                            board[1][0] = "o";
                            Button_2_1.setText("o");
                            player=true;
                        }
                        computer();
                    }
                    break;
                case R.id.Button_2_2:
                    if(board[1][1].equals(" ")) {
                        if (player) {
                            board[1][1] = "x";
                            Button_2_2.setText("x");
                            player=false;
                        } else {
                            board[1][1] = "o";
                            Button_2_2.setText("o");
                            player=true;
                        }
                        computer();
                    }
                    break;
                case R.id.Button_2_3:
                    if(board[1][2].equals(" ")) {
                        if (player) {
                            board[1][2] = "x";
                            Button_2_3.setText("x");
                            player=false;
                        } else {
                            board[1][2] = "o";
                            Button_2_3.setText("o");
                            player=true;
                        }
                        computer();
                    }
                    break;
                case R.id.Button_3_1:
                    if(board[2][0].equals(" ")) {
                        if (player) {
                            board[2][0] = "x";
                            Button_3_1.setText("x");
                            player=false;
                        } else {
                            board[2][0] = "o";
                            Button_3_1.setText("o");
                            player=true;
                        }
                        computer();
                    }
                    break;
                case R.id.Button_3_2:
                    if(board[2][1].equals(" ")) {
                        if (player) {
                            board[2][1] = "x";
                            Button_3_2.setText("x");
                            player=false;
                        } else {
                            board[2][1] = "o";
                            Button_3_2.setText("o");
                            player=true;
                        }
                        computer();
                    }
                    break;
                case R.id.Button_3_3:
                    if(board[2][2].equals(" ")) {
                        if (player) {
                            board[2][2] = "x";
                            Button_3_3.setText("x");
                            player=false;
                        } else {
                            board[2][2] = "o";
                            Button_3_3.setText("o");
                            player=true;
                        }
                        computer();
                    }
                    break;
            }
            if(player){
                switch_play.setText("Player x");
            }else {
                switch_play.setText("Player o");
            }
            int mark = checkWinner();
            if (!(mark == 0)) {
                if (mark < 0) {
                    showDialog("Player O win");
                } else {
                    showDialog("Player X win");
                }
            }else if(!check()){
                showDialog("Draw");
            }
        }
    };
    private void computer(){
        if(!(checkWinner() == 0)||!check())return;
        if(computerPlay){
            computer a=new computer();
            int move[]=a.bestMove(board);
            if(move[0]==0){
                if(move[1]==0){
                    board[0][0] = "o";
                    Button_1_1.setText("o");
                }else if(move[1]==1){
                    board[0][1] = "o";
                    Button_1_2.setText("o");
                }else if(move[1]==2){
                    board[0][2] = "o";
                    Button_1_3.setText("o");
                }
            }else if(move[0]==1){
                if(move[1]==0){
                    board[1][0] = "o";
                    Button_2_1.setText("o");
                }else if(move[1]==1){
                    board[1][1] = "o";
                    Button_2_2.setText("o");
                }else if(move[1]==2){
                    board[1][2] = "o";
                    Button_2_3.setText("o");
                }
            }else if(move[0]==2){
                if(move[1]==0){
                    board[2][0] = "o";
                    Button_3_1.setText("o");
                }else if(move[1]==1){
                    board[2][1] = "o";
                    Button_3_2.setText("o");
                }else if(move[1]==2){
                    board[2][2] = "o";
                    Button_3_3.setText("o");
                }
            }
            player=true;
        }
    }
    private int checkWinner(){
        for (int i = 0; i < 3; i++) {
            if(board[i][0].equals("x")&&board[i][1].equals("x")&&board[i][2].equals("x")){
                return 1;
            }else if(board[i][0].equals("o")&&board[i][1].equals("o")&&board[i][2].equals("o")){
                return -1;
            }else  if(board[0][i].equals("x")&&board[1][i].equals("x")&&board[2][i].equals("x")){
                return 1;
            }else if(board[0][i].equals("o")&&board[1][i].equals("o")&&board[2][i].equals("o")){
                return -1;
            }
        }
        if(board[0][0].equals("x")&&board[1][1].equals("x")&&board[2][2].equals("x")){
            return 1;
        }else if(board[0][0].equals("o")&&board[1][1].equals("o")&&board[2][2].equals("o")){
            return -1;
        }
        if(board[0][2].equals("x")&&board[1][1].equals("x")&&board[2][0].equals("x")){
            return 1;
        }else if(board[0][2].equals("o")&&board[1][1].equals("o")&&board[2][0].equals("o")){
            return -1;
        }
        return 0;
    }
    private boolean check(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j].equals(" "))return true;
            }
        }
        return false;
    }
    private void Reset(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j]=" ";
            }
        }
        Button_1_1.setText("");
        Button_1_2.setText("");
        Button_1_3.setText("");
        Button_2_1.setText("");
        Button_2_2.setText("");
        Button_2_3.setText("");
        Button_3_1.setText("");
        Button_3_2.setText("");
        Button_3_3.setText("");
        if(!switch1.isChecked()) {
            if(switch2.isChecked()){
                computerPlay = true;
                player = true;
            }else {
                computerPlay = true;
                player = true;
                computer();
            }
        }
    }
    private void showDialog(String message) {
        final android.app.AlertDialog build = new android.app.AlertDialog.Builder(this).create();
        View view = getLayoutInflater().inflate(R.layout.splash_dialog, null);
        build.setView(view, 0, 0, 0, 0);
        build.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                Reset();
                switch_play.setText("Player x");
            }
        });
        build.show();
        int width = getWindowManager().getDefaultDisplay().getWidth();
        WindowManager.LayoutParams params = build.getWindow().getAttributes();
        params.width = width - (width / 6);
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        build.getWindow().setAttributes(params);
        TextView warnmessage =(TextView) view.findViewById(R.id.warnmessage);
        Button Button = (Button) view.findViewById(R.id.splash_dialog_Button);
        warnmessage.setText(message);
        Button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Reset();
                build.dismiss();
                switch_play.setText("Player x");
            }
        });
    }
}
