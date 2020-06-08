package com.pk.android.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion, textViewScore, textViewQuestionCount, textViewCountDown;
    private RadioGroup rbGrouo;
    private RadioButton rb1, rb2, rb3;
    private Button buttonConfirmNext;

    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.txtQuestion);
        textViewScore = findViewById(R.id.txtScore);
        textViewQuestionCount = findViewById(R.id.txtQuestionCount);
        textViewCountDown = findViewById(R.id.txtTimer);

        rbGrouo = findViewById(R.id.rgOptions);
        rb1 = findViewById(R.id.radiobtn1);
        rb2 = findViewById(R.id.radiobtn2);
        rb3 = findViewById(R.id.radiobtn3);
        buttonConfirmNext = findViewById(R.id.btnConfirmNext);

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestions();

    }
}