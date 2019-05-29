package com.example.android.quizzy.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.quizzy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A quiz app about movies , actors and the cinema,etc..
 * <p>
 * questions and answers: (correct answers are between brackets)
 * 1 - Which planet did Superman come from?
 * (Krypton)
 * Kryptonite
 * <p>
 * 2 - What superhero has been played by Michael Keaton, Val Kilmer, George Clooney and Christian Bale?
 * (Batman)
 * <p>
 * 3 - Which of these movies were directed by Woody Allen
 * Play it again, Sam 1972
 * (Midnight in Paris 2011)
 * (Irrational Man 2015)
 * Casino Royale 1967
 * <p>
 * 4 - who is the director of Reservoir Dogs
 * Quentin Tarantino
 * <p>
 * 5 - How many seasons did the TV series Friends last?
 * 10
 * <p>
 * 6 - which of these movies were directed by James Cameron?
 * (The Terminator  1984)
 * (Avatar 2009)
 * Terminator 3 : Genisys 2015
 * Terminator Salvation 2009
 * <p>
 * 7 - who is the director of the social network?
 * (David Fincher)
 * Steven Spielberg
 * <p>
 * 8 - who played "Captain Miller" in the war movie saving the private ryan?
 * Tom Hanks
 * <p>
 * 9 - Who played Alfie Solomons in the TV Series Peaky Blinders?
 * Tom Hardy
 * <p>
 * 10 - how many seasons are they for peaky blinders so far?
 * 4
 */

public class MainActivity extends AppCompatActivity {

    private int grade = 0;

    @BindView(R.id.answer_1_A)
    RadioButton radioButton1;

    @BindView(R.id.answer_2)
    EditText editText2;

    @BindView(R.id.answer_3_A)
    CheckBox checkBox3a;

    @BindView(R.id.answer_3_B)
    CheckBox checkBox3b;

    @BindView(R.id.answer_3_C)
    CheckBox checkBox3c;

    @BindView(R.id.answer_3_D)
    CheckBox checkBox3d;

    @BindView(R.id.edit_text_4)
    EditText editText4;

    @BindView(R.id.edit_text_5)
    EditText editText5;

    @BindView(R.id.checkbox_6_A)
    CheckBox checkBox6a;

    @BindView(R.id.checkbox_6_B)
    CheckBox checkBox6b;

    @BindView(R.id.checkbox_6_C)
    CheckBox checkBox6c;

    @BindView(R.id.checkbox_6_D)
    CheckBox checkBox6d;

    @BindView(R.id.radio_7_a)
    RadioButton radioButton7;

    @BindView(R.id.edit_text8)
    EditText editText8;

    @BindView(R.id.edit_text9)
    EditText editText9;

    @BindView(R.id.edit_text10)
    EditText editText10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cons);

        ButterKnife.bind(this);
    }

    /**
     * This method is triggered when the submit answers button is clicked
     * calculate the grade for the answers submitted
     *
     * <p>it calculate the grade for the answers as follows:
     * for each radiobutton : add 5 points for the correct answer and 0 points for the wrong answer
     * for each checkbox : add 5 poins for every answer that has the correct checkboxes checked
     * and the incorrect checkboxes unchecked.
     * decrementing points for wrong answers could result in negative results.
     * for the textbox answer add 5 points for the correct answer and 0 for the wrong answer </p>
     */
    public void submitAnswer(View view) {
        //checks the first answer and add 5 if correct
        if (radioButton1.isChecked()) {
            grade += 5;
        }

        //second answer
        if (getString(R.string.answer_2).equals(editText2.getText().toString())) {
            grade += 5;
        }

        //third answer
        if (!checkBox3a.isChecked() && checkBox3b.isChecked() && checkBox3c.isChecked() && !checkBox3d.isChecked()) {
            grade += 5;
        }

        //4th answer
        if (getString(R.string.answer_4).equals(editText4.getText().toString())) {
            grade += 5;
        }

        //5th answer
        if (getString(R.string.answer_5).equals(editText5.getText().toString())) {
            grade += 5;
        }

        //6th answer
        if (checkBox6a.isChecked() && checkBox6b.isChecked() && !checkBox6c.isChecked() && !checkBox6d.isChecked()) {
            grade += 5;
        }

        //7th answer
        if (radioButton7.isChecked()) {
            grade += 5;
        }

        //8th answer
        if (getString(R.string.answer_8).equals(editText8.getText().toString())) {
            grade += 5;
        }

        //9th answer
        if (getString(R.string.answer_9).equals(editText9.getText().toString())) {
            grade += 5;
        }

        //10th answer
        if (getString(R.string.answer_10).equals(editText10.getText().toString())) {
            grade += 5;
        }

        String message = getString(R.string.answer, grade);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        //reset grade back to 0
        grade = 0;
    }
}
