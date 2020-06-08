package com.pk.android.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startingQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_quiz);

       Button startButton = findViewById(R.id.btnStart);
       startButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               NavigateToActivityQuiz();
           }
       });
    }

    private void NavigateToActivityQuiz() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}