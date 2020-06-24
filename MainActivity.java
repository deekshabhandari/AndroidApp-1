package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart;
    private Button btnStartAgain;
    private Button btnExit;
    private TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) this.findViewById(R.id.btnStart);
        textMessage= (TextView) this.findViewById(R.id.textMessage);
        btnStartAgain = (Button) this.findViewById((R.id.btnStartAgain));
        btnExit = (Button) this.findViewById(R.id.btnExit);

        btnStart.setOnClickListener(this);
        btnStartAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textMessage.setVisibility(View.VISIBLE);
                btnStart.setVisibility(View.VISIBLE);
                btnStartAgain.setVisibility(View.GONE);
                btnExit.setVisibility(View.GONE);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnStartAgain.setVisibility(View.GONE);
        btnExit.setVisibility(View.GONE);

    }

    public void onClick(View v){
        final EditText input = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("What would you like to talk about?")
                .setView(input)
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        keepTalking(input.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();

        startAgain();
    }

    public void keepTalking(final String topic){
        AlertDialog secondDialog = new AlertDialog.Builder(this)
                .setMessage("Do you like " + topic + "?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        likeTopic(topic);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dislikeTopic(topic);
                    }
                })
                .show();
    }

    public void likeTopic(String topic){
        Context context = getApplicationContext();
        CharSequence message = "I'm happy that you like " + topic + "!!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    public void dislikeTopic(String topic){
        Context context = getApplicationContext();
        CharSequence message =  "Are you serious?? You don't like " + topic + "!! I can not believe it!!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    public void startAgain(){
        btnStart.setVisibility(View.GONE);
        textMessage.setVisibility(View.GONE);
        btnStartAgain.setVisibility(View.VISIBLE);
        btnExit.setVisibility(View.VISIBLE);

    }
}
