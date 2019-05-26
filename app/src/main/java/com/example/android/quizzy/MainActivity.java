package com.example.android.quizzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    int grade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        RadioButton radioButton1 = findViewById(R.id.answer_1_A);
        if (radioButton1.isChecked()) {
            grade += 5;
        }

        //second answer
        EditText editText2 = findViewById(R.id.answer_2);
        if ("Batman".equals(editText2.getText().toString())) {
            grade += 5;
        }

        //third answer
        CheckBox checkBox3a = findViewById(R.id.answer_3_A);
        CheckBox checkBox3b = findViewById(R.id.answer_3_B);
        CheckBox checkBox3c = findViewById(R.id.answer_3_C);
        CheckBox checkBox3d = findViewById(R.id.answer_3_D);

        if (!checkBox3a.isChecked() && checkBox3b.isChecked() && checkBox3c.isChecked() && !checkBox3d.isChecked()) {
            grade += 5;
        }

        //4th answer
        EditText editText4 = findViewById(R.id.edit_text_4);
        if ("Quentin Tarantino".equals(editText4.getText().toString())) {
            grade += 5;
        }

        //5th answer
        EditText editText5 = findViewById(R.id.edit_text_5);
        if ("10".equals(editText5.getText().toString())) {
            grade += 5;
        }

        //6th answer
        CheckBox checkBox6a = findViewById(R.id.checkbox_6_A);
        CheckBox checkBox6b = findViewById(R.id.checkbox_6_B);
        CheckBox checkBox6c = findViewById(R.id.checkbox_6_C);
        CheckBox checkBox6d = findViewById(R.id.checkbox_6_D);

        if (checkBox6a.isChecked() && checkBox6b.isChecked() && !checkBox6c.isChecked() && !checkBox6d.isChecked()) {
            grade += 5;
        }

        //7th answer
        RadioButton radioButton7 = findViewById(R.id.radio_7_a);
        if (radioButton7.isChecked()) {
            grade += 5;
        }

        //8th answer
        EditText editText8 = findViewById(R.id.edit_text8);
        if ("Tom Hanks".equals(editText8.getText().toString())) {
            grade += 5;
        }

        //9th answer
        EditText editText9 = findViewById(R.id.edit_text9);
        if ("Tom Hardy".equals(editText9.getText().toString())) {
            grade += 5;
        }

        //10th answer
        EditText editText10 = findViewById(R.id.edit_text10);
        if ("4".equals(editText10.getText().toString())) {
            grade += 5;
        }

        String message = getString(R.string.answer) + grade;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        //reset grade back to 0
        grade = 0;
    }
}
