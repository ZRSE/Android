package edu.csumb.a003386642.average;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class AverageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average);

        View calculate = findViewById(R.id.submitBtn);
        calculate.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_average, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.submitBtn) {
            EditText input1 = findViewById(R.id.inputNum1);
            EditText input2 = findViewById(R.id.inputNum2);
            TextView average = findViewById(R.id.printAvg);

            try {
                String inputx = input1.getText().toString();
                String inputy = input2.getText().toString();

                Double inputOne = Double.parseDouble(inputx);
                Double inputTwo = Double.parseDouble(inputy);


                Double averageOfTwoNumbers = (inputOne+inputTwo) / 2;

                if (inputOne <= 100 || inputTwo <= 100) {

                    Double letterGrade = averageOfTwoNumbers/10;
                    String letter;

                     if (9 <= letterGrade) {
                        letter = "(A)";
                    } else if (8 <= letterGrade) {
                        letter = "(B)";
                    } else if (7 <= letterGrade) {
                        letter = "(C)";
                    } else if (6 <= letterGrade) {
                         letter = "(D)";
                    } else {
                        letter = "(F)";
                    }

                    average.setText("Average = " +Double.toString(averageOfTwoNumbers) +" "+ letter);
                } else {
                    average.setText("Number too big..");
                }



            } catch (Exception e) {
                average.setText("Please input a number..");
            }


        }


    }
}
