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
public class ShoulderDataActivity
{
    DatabaseHelper mDatabaseHelper;
    //All different textFields that would be linked to the variables
    public EditText inputEx1S1, inputEx2S2, inputEx3S3, inputEx4S4, inputEx5S5, inputEx6S6, inputEx7S7;
    public EditText inputSets1S1, inputSets2S2, inputSets3S3, inputSets4S4, inputSets5S5, inputSets6S6, inputSets7S7;
    public EditText inputReps1S1, inputReps2S2, inputReps3S3, inputReps4S4, inputReps5S5, inputReps6S6, inputReps7S7;
    public EditText inputWeight1S1, inputWeight2S2, inputWeight3S3, inputWeight4S4, inputWeight5S5, inputWeight6S6, inputWeight7S7;

    public ShoulderDataActivity(){

    }

    //Just records everything into the data base in the Text fields
    public void record(){
        //Assigning the variables to the id that they are linked to.
        inputEx1S1 = (EditText) findViewById(R.id.inputEx1S);
        inputEx2S2 = (EditText) findViewById(R.id.inputEx2S);
        inputEx3S3 = (EditText) findViewById(R.id.inputEx3S);
        inputEx4S4 = (EditText) findViewById(R.id.inputEx4S);
        inputEx5S5 = (EditText) findViewById(R.id.inputEx5S);
        inputEx6S6 = (EditText) findViewById(R.id.inputEx6S);

        inputSets1S1 = (EditText) findViewById(R.id.inputSets1S);
        inputSets2S2 = (EditText) findViewById(R.id.inputSets2S);
        inputSets3S3 = (EditText) findViewById(R.id.inputSets3S);
        inputSets4S4 = (EditText) findViewById(R.id.inputSets4S);
        inputSets5S5 = (EditText) findViewById(R.id.inputSets5S);
        inputSets6S6 = (EditText) findViewById(R.id.inputSets6S);

        inputReps1S1 = (EditText) findViewById(R.id.inputReps1S);
        inputReps2S2 = (EditText) findViewById(R.id.inputReps2S);
        inputReps3S3 = (EditText) findViewById(R.id.inputReps3S);
        inputReps4S4 = (EditText) findViewById(R.id.inputReps4S);
        inputReps5S5 = (EditText) findViewById(R.id.inputReps5S);
        inputReps6S6 = (EditText) findViewById(R.id.inputReps6S);

        inputWeight1S1 = (EditText) findViewById(R.id.inputWeight1S);
        inputWeight2S2 = (EditText) findViewById(R.id.inputWeight2S);
        inputWeight3S3 = (EditText) findViewById(R.id.inputWeight3S);
        inputWeight4S4 = (EditText) findViewById(R.id.inputWeight4S);
        inputWeight5S5 = (EditText) findViewById(R.id.inputWeight5S);
        inputWeight6S6 = (EditText) findViewById(R.id.inputWeight6S);

        //Making a new Entry that is only updated if an entire row of set resps and weight is filled.
        String newEntry = "";
        if(inputEx1S1.length() != 0 && inputSets1S1.length() != 0 && inputReps1S1.length() != 0 && inputWeight1S1.length() != 0){
            newEntry = newEntry + "" + inputEx1S1.getText().toString() + " :" +spaceItEx( inputEx1S1.length())+ " Sets : " + inputSets1S1.getText().toString() +""+spaceIt(inputSets1S1.length())+  " Reps : " + inputReps1S1.getText().toString() + ""+spaceIt(inputReps1S1.length())+  " Weight : " + inputWeight1S1.getText().toString()+"\n";
        }

        if(inputEx2S2.length() != 0 && inputSets2S2.length() != 0 && inputReps2S2.length() != 0 && inputWeight2S2.length() != 0){
            newEntry = newEntry + "" + inputEx2S2.getText().toString() + " :" +spaceItEx( inputEx2S2.length())+ " Sets : " + inputSets2S2.getText().toString() +""+spaceIt(inputSets2S2.length())+   " Reps : " + inputReps2S2.getText().toString() + ""+spaceIt(inputReps2S2.length())+  " Weight : " + inputWeight2S2.getText().toString()+"\n";
        }
        if(inputEx3S3.length() != 0 && inputSets3S3.length() != 0 && inputReps3S3.length() != 0 && inputWeight3S3.length() != 0){
            newEntry = newEntry + "" + inputEx3S3.getText().toString() + " :" +spaceItEx( inputEx3S3.length())+" Sets : " + inputSets3S3.getText().toString() +""+spaceIt(inputSets3S3.length())+   " Reps : " + inputReps3S3.getText().toString() + ""+spaceIt(inputReps3S3.length())+  " Weight : " + inputWeight3S3.getText().toString()+"\n";
        }
        if(inputEx4S4.length() != 0 && inputSets4S4.length() != 0 && inputReps4S4.length() != 0 && inputWeight4S4.length() != 0){
            newEntry = newEntry + "" + inputEx4S4.getText().toString() + " :"+spaceItEx( inputEx4S4.length())+ " Sets : " + inputSets4S4.getText().toString() +""+spaceIt(inputSets4S4.length())+   " Reps : " + inputReps4S4.getText().toString() + ""+spaceIt(inputReps4S4.length())+  " Weight : " + inputWeight4S4.getText().toString()+"\n";
        }
        if(inputEx5S5.length() != 0 && inputSets5S5.length() != 0 && inputReps5S5.length() != 0 && inputWeight5S5.length() != 0){
            newEntry = newEntry + "" + inputEx5S5.getText().toString() + " :"+spaceItEx( inputEx5S5.length())+ " Sets : " + inputSets5S5.getText().toString() +""+spaceIt(inputSets5S5.length())+   " Reps : " + inputReps5S5.getText().toString() + ""+spaceIt(inputReps5S5.length())+  " Weight : " + inputWeight5S5.getText().toString()+"\n";
        }
        if(inputEx6S6.length() != 0 && inputSets6S6.length() != 0 && inputReps6S6.length() != 0 && inputWeight6S6.length() != 0){
            newEntry = newEntry + "" + inputEx6S6.getText().toString() + " :" +spaceItEx( inputEx6S6.length())+" Sets : " + inputSets6S6.getText().toString() +""+spaceIt(inputSets6S6.length())+  " Reps : " + inputReps6S6.getText().toString() + ""+spaceIt(inputReps6S6.length())+  " Weight : " + inputWeight6S6.getText().toString();
        }


        // If the new Entry was updated then update the database.
        if (newEntry.length() > 0)
        {
            //Getting todays Date and formatting it using the date class API
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat df =  new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(today);
            AddData(formattedDate);
            AddData(newEntry);

            //set 0
            inputSets1S1.setText("");
            inputSets2S2.setText("");
            inputSets3S3.setText("");
            inputSets4S4.setText("");
            inputSets5S5.setText("");
            inputSets6S6.setText("");

            inputReps1S1.setText("");
            inputReps2S2.setText("");
            inputReps3S3.setText("");
            inputReps4S4.setText("");
            inputReps5S5.setText("");
            inputReps6S6.setText("");

            inputWeight1S1.setText("");
            inputWeight2S2.setText("");
            inputWeight3S3.setText("");
            inputWeight4S4.setText("");
            inputWeight5S5.setText("");
            inputWeight6S6.setText("");
            toastMessage("Record has been updated!");
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