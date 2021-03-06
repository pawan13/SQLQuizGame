package com.pk.android.quizgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.pk.android.quizgame.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static  final String DaTABASE_NAME = "QuizGame.db";
    private static  final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;
    public QuizDbHelper(@Nullable Context context) {
        super(context, DaTABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + "(" +
                QuestionsTable._ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                QuestionsTable.COLUMN_QUESTION + "TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + "TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + "TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + "TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + "INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);

    }
    private void fillQuestionsTable() {
        Question q1 = new Question("A is correct", "A", "B", "C", 1);
        addQuestions(q1);
        Question q2 = new Question("B is correct", "A", "B", "C", 2);
        addQuestions(q2);
        Question q3 = new Question("C is correct", "A", "B", "C", 3);
        addQuestions(q3);
        Question q4 = new Question("A is correct", "A", "B", "C", 1);
        addQuestions(q4);
        Question q5 = new Question("B is correct", "A", "B", "C", 2);
        addQuestions(q5);

    }
    private void addQuestions(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }
    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME, null);

        if(c.moveToFirst()){
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            }while(c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
