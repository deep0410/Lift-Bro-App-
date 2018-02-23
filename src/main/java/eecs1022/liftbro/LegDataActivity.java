package eecs1022.liftbro;

import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Deep on 2/21/18.
 */
public class LegDataActivity
{
    DatabaseHelper mDatabaseHelper;
    //All different textFields that would be linked to the variables
    public EditText inputEx1L1, inputEx2L2, inputEx3L3, inputEx4L4, inputEx5L5, inputEx6L6;
    public EditText inputSets1L1, inputSets2L2, inputSets3L3, inputSets4L4, inputSets5L5, inputSets6L6;
    public EditText inputReps1L1, inputReps2L2, inputReps3L3, inputReps4L4, inputReps5L5, inputReps6L6;
    public EditText inputWeight1L1, inputWeight2L2, inputWeight3L3, inputWeight4L4, inputWeight5L5, inputWeight6L6;

    public LegDataActivity(){

    }

    //Just records everything into the data base in the Text fields
    public void record(){
        //Assigning the variables to the id that they are linked to.
        inputEx1L1 = (EditText) findViewById(R.id.inputEx1L);
        inputEx2L2 = (EditText) findViewById(R.id.inputEx2L);
        inputEx3L3 = (EditText) findViewById(R.id.inputEx3L);
        inputEx4L4 = (EditText) findViewById(R.id.inputEx4L);
        inputEx5L5 = (EditText) findViewById(R.id.inputEx5L);
        inputEx6L6 = (EditText) findViewById(R.id.inputEx6L);

        inputSets1L1 = (EditText) findViewById(R.id.inputSets1L);
        inputSets2L2 = (EditText) findViewById(R.id.inputSets2L);
        inputSets3L3 = (EditText) findViewById(R.id.inputSets3L);
        inputSets4L4 = (EditText) findViewById(R.id.inputSets4L);
        inputSets5L5 = (EditText) findViewById(R.id.inputSets5L);
        inputSets6L6 = (EditText) findViewById(R.id.inputSets6L);

        inputReps1L1 = (EditText) findViewById(R.id.inputReps1L);
        inputReps2L2 = (EditText) findViewById(R.id.inputReps2L);
        inputReps3L3 = (EditText) findViewById(R.id.inputReps3L);
        inputReps4L4 = (EditText) findViewById(R.id.inputReps4L);
        inputReps5L5 = (EditText) findViewById(R.id.inputReps5L);
        inputReps6L6 = (EditText) findViewById(R.id.inputReps6L);

        inputWeight1L1 = (EditText) findViewById(R.id.inputWeight1L);
        inputWeight2L2 = (EditText) findViewById(R.id.inputWeight2L);
        inputWeight3L3 = (EditText) findViewById(R.id.inputWeight3L);
        inputWeight4L4 = (EditText) findViewById(R.id.inputWeight4L);
        inputWeight5L5 = (EditText) findViewById(R.id.inputWeight5L);
        inputWeight6L6 = (EditText) findViewById(R.id.inputWeight6L);

        //If statements
        String newEntry = "";
        //Making a new Entry that is only updated if an entire row of set resps and weight is filled.
        if(inputEx1L1.length() != 0 && inputSets1L1.length() != 0 && inputReps1L1.length() != 0 && inputWeight1L1.length() != 0){
            newEntry = newEntry + "" + inputEx1L1.getText().toString() + " :"  +spaceItEx( inputEx1L1.length())+ " Sets : " + inputSets1L1.getText().toString()+""+spaceIt(inputSets1L1.length())+  " Reps : " + inputReps1L1.getText().toString() + ""+spaceIt(inputReps1L1.length())+ " Weight : " + inputWeight1L1.getText().toString()+"\n";
        }

        if(inputEx2L2.length() != 0 && inputSets2L2.length() != 0 && inputReps2L2.length() != 0 && inputWeight2L2.length() != 0){
            newEntry = newEntry + "" + inputEx2L2.getText().toString() + " :"  +spaceItEx( inputEx2L2.length())+ " Sets : " + inputSets2L2.getText().toString() +""+spaceIt(inputSets2L2.length())+  " Reps : " + inputReps2L2.getText().toString() + ""+spaceIt(inputReps2L2.length())+ " Weight : " + inputWeight2L2.getText().toString()+"\n";
        }
        if(inputEx3L3.length() != 0 && inputSets3L3.length() != 0 && inputReps3L3.length() != 0 && inputWeight3L3.length() != 0){
            newEntry = newEntry + "" + inputEx3L3.getText().toString() + " :"  +spaceItEx( inputEx3L3.length())+ " Sets : " + inputSets3L3.getText().toString()+""+spaceIt(inputSets3L3.length())+  " Reps : " + inputReps3L3.getText().toString() + ""+spaceIt(inputReps3L3.length())+ " Weight : " + inputWeight3L3.getText().toString()+"\n";
        }
        if(inputEx4L4.length() != 0 && inputSets4L4.length() != 0 && inputReps4L4.length() != 0 && inputWeight4L4.length() != 0){
            newEntry = newEntry + "" + inputEx4L4.getText().toString() + " :"  +spaceItEx( inputEx4L4.length())+ " Sets : " + inputSets4L4.getText().toString() +""+spaceIt(inputSets4L4.length())+  " Reps : " + inputReps4L4.getText().toString() + ""+spaceIt(inputReps4L4.length())+ " Weight : " + inputWeight4L4.getText().toString()+"\n";
        }
        if(inputEx5L5.length() != 0 && inputSets5L5.length() != 0 && inputReps5L5.length() != 0 && inputWeight5L5.length() != 0){
            newEntry = newEntry + "" + inputEx5L5.getText().toString() + " :"  +spaceItEx( inputEx5L5.length())+ " Sets : " + inputSets5L5.getText().toString()+""+spaceIt(inputSets5L5.length())+  " Reps : " + inputReps5L5.getText().toString() + ""+spaceIt(inputReps5L5.length())+ " Weight : " + inputWeight5L5.getText().toString()+"\n";
        }
        if(inputEx6L6.length() != 0 && inputSets6L6.length() != 0 && inputReps6L6.length() != 0 && inputWeight6L6.length() != 0){
            newEntry = newEntry + "" + inputEx6L6.getText().toString() + " :"  +spaceItEx( inputEx6L6.length())+ " Sets : " + inputSets6L6.getText().toString() +""+spaceIt(inputSets6L6.length())+  " Reps : " + inputReps6L6.getText().toString() + ""+spaceIt(inputReps6L6.length())+ " Weight : " + inputWeight6L6.getText().toString();
        }

        // If the new Entry was updated then update the database.
        if (newEntry.length() > 0)
        {
            //Getting todays Date and formatting it using the date class API
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat df =  new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(today);
            //Adding date and the data in to the database.
            AddData(formattedDate);
            AddData(newEntry);

            //set 0
            inputSets1L1.setText("");
            inputSets2L2.setText("");
            inputSets3L3.setText("");
            inputSets4L4.setText("");
            inputSets5L5.setText("");
            inputSets6L6.setText("");

            inputReps1L1.setText("");
            inputReps2L2.setText("");
            inputReps3L3.setText("");
            inputReps4L4.setText("");
            inputReps5L5.setText("");
            inputReps6L6.setText("");

            inputWeight1L1.setText("");
            inputWeight2L2.setText("");
            inputWeight3L3.setText("");
            inputWeight4L4.setText("");
            inputWeight5L5.setText("");
            inputWeight6L6.setText("");
            toastMessage("Record has been updated!");
            //Notify the user of the update of database!
        } else {
            toastMessage("You must put something in the text field!");
        }

    }


    //Messages popup for user update
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    //method to addthe data in to the database
    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if(insertData){
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }

    }

    /**
     * Computes the amount space to put after exercise name so that it can be formatted correctly
     * @param the lenegth of the exercise n
     * @return the amount of tab needed in a string
     */
    public String spaceItEx(int n){
        String result = "";
        // Assume 45 will the largest charachter name for an exercise
        int x = 45;
        // length - x = the amount of space we need n
        n = x-n;
        //Since tab gives better outlook the decision was to cut n/2
        for(int i = 0; i < n/2; i++) result = result + "\t";
        return result;
    }

    /**
     * Computes the amount space to put after set and repsso that it can be formatted correctly
     * @param the lenegth of the sets and reps n
     * @return the amount of space needed in a string
     */
    public String spaceIt(int n){
        String result = "";
        int x = 7;
        n = x-n;
        for(int i = 0; i < n; i++) result = result + " ";
        return result;
    }

}