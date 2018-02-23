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
public class ChestDataActivity
{
    DatabaseHelper mDatabaseHelper;
    //All different textFields that would be linked to the variables
    public EditText inputEx1C1, inputEx2C2, inputEx3C3, inputEx4C4, inputEx5C5, inputEx6C6;
    public EditText inputSets1C1, inputSets2C2, inputSets3C3, inputSets4C4, inputSets5C5, inputSets6C6, inputSets7C7;
    public EditText inputReps1C1, inputReps2C2, inputReps3C3, inputReps4C4, inputReps5C5, inputReps6C6, inputReps7C7;
    public EditText inputWeight1C1, inputWeight2C2, inputWeight3C3, inputWeight4C4, inputWeight5C5, inputWeight6C6, inputWeight7C7;

    public ChestDataActivity(){

    }

    //Just records everything into the data base in the Text fields
    public void record(){
        //Assigning the variables to the id that they are linked to.
        inputEx1C1 = (EditText) findViewById(R.id.inputEx1C);
        inputEx2C2 = (EditText) findViewById(R.id.inputEx2C);
        inputEx3C3 = (EditText) findViewById(R.id.inputEx3C);
        inputEx4C4 = (EditText) findViewById(R.id.inputEx4C);
        inputEx5C5 = (EditText) findViewById(R.id.inputEx5C);
        inputEx6C6 = (EditText) findViewById(R.id.inputEx6C);

        inputSets1C1 = (EditText) findViewById(R.id.inputSets1C);
        inputSets2C2 = (EditText) findViewById(R.id.inputSets2C);
        inputSets3C3 = (EditText) findViewById(R.id.inputSets3C);
        inputSets4C4 = (EditText) findViewById(R.id.inputSets4C);
        inputSets5C5 = (EditText) findViewById(R.id.inputSets5C);
        inputSets6C6 = (EditText) findViewById(R.id.inputSets6C);

        inputReps1C1 = (EditText) findViewById(R.id.inputReps1C);
        inputReps2C2 = (EditText) findViewById(R.id.inputReps2C);
        inputReps3C3 = (EditText) findViewById(R.id.inputReps3C);
        inputReps4C4 = (EditText) findViewById(R.id.inputReps4C);
        inputReps5C5 = (EditText) findViewById(R.id.inputReps5C);
        inputReps6C6 = (EditText) findViewById(R.id.inputReps6C);

        inputWeight1C1 = (EditText) findViewById(R.id.inputWeight1C);
        inputWeight2C2 = (EditText) findViewById(R.id.inputWeight2C);
        inputWeight3C3 = (EditText) findViewById(R.id.inputWeight3C);
        inputWeight4C4 = (EditText) findViewById(R.id.inputWeight4C);
        inputWeight5C5 = (EditText) findViewById(R.id.inputWeight5C);
        inputWeight6C6 = (EditText) findViewById(R.id.inputWeight6C);

        //Making a new Entry that is only updated if an entire row of set resps and weight is filled.
        String newEntry = "";
        if(inputEx1C1.length() != 0 && inputSets1C1.length() != 0 && inputReps1C1.length() != 0 && inputWeight1C1.length() != 0){
            newEntry = newEntry + "" + inputEx1C1.getText().toString() + " :" +spaceItEx( inputEx1C1.length())+ " Sets : " + inputSets1C1.getText().toString() +  ""+spaceIt(inputSets1C1.length())+ " Reps : " + inputReps1C1.getText().toString() + ""+spaceIt(inputReps1C1.length())+ " Weight : " + inputWeight1C1.getText().toString()+"\n";
        }
        if(inputEx2C2.length() != 0 && inputSets2C2.length() != 0 && inputReps2C2.length() != 0 && inputWeight2C2.length() != 0){
            newEntry =newEntry + "" + inputEx2C2.getText().toString() + " :" +spaceItEx( inputEx2C2.length())+ " Sets : " + inputSets2C2.getText().toString() + ""+spaceIt(inputSets2C2.length())+" Reps : " + inputReps2C2.getText().toString() + ""+spaceIt(inputReps2C2.length())+ " Weight : " + inputWeight2C2.getText().toString()+"\n";
        }
        if(inputEx3C3.length() != 0 && inputSets3C3.length() != 0 && inputReps3C3.length() != 0 && inputWeight3C3.length() != 0){
            newEntry = newEntry + "" + inputEx3C3.getText().toString() + " :" +spaceItEx( inputEx3C3.length())+ " Sets : " + inputSets3C3.getText().toString() + ""+spaceIt(inputSets3C3.length())+" Reps : " + inputReps3C3.getText().toString() + ""+spaceIt(inputReps3C3.length())+ " Weight : " + inputWeight3C3.getText().toString()+"\n";
        }
        if(inputEx4C4.length() != 0 && inputSets4C4.length() != 0 && inputReps4C4.length() != 0 && inputWeight4C4.length() != 0){
            newEntry = newEntry + "" + inputEx4C4.getText().toString() + " :" +spaceItEx( inputEx4C4.length())+ " Sets : " + inputSets4C4.getText().toString() + ""+spaceIt(inputSets4C4.length())+" Reps : " + inputReps4C4.getText().toString() + ""+spaceIt(inputReps4C4.length())+ " Weight : " + inputWeight4C4.getText().toString()+"\n";
        }
        if(inputEx5C5.length() != 0 && inputSets5C5.length() != 0 && inputReps5C5.length() != 0 && inputWeight5C5.length() != 0){
            newEntry = newEntry + "" + inputEx5C5.getText().toString() + " :" +spaceItEx( inputEx5C5.length())+ " Sets : " + inputSets5C5.getText().toString() + ""+spaceIt(inputSets5C5.length())+" Reps : " + inputReps5C5.getText().toString() + ""+spaceIt(inputReps5C5.length())+ " Weight : " + inputWeight5C5.getText().toString()+"\n";
        }
        if(inputEx6C6.length() != 0 && inputSets6C6.length() != 0 && inputReps6C6.length() != 0 && inputWeight6C6.length() != 0){
            newEntry = newEntry + "" + inputEx6C6.getText().toString() + " :" +spaceItEx( inputEx6C6.length())+ " Sets : " + inputSets6C6.getText().toString() + ""+spaceIt(inputSets6C6.length())+" Reps : " + inputReps6C6.getText().toString() +""+spaceIt(inputReps6C6.length())+  " Weight : " + inputWeight6C6.getText().toString();
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

            // Set the textfields to 0
            inputSets1C1.setText("");
            inputSets2C2.setText("");
            inputSets3C3.setText("");
            inputSets4C4.setText("");
            inputSets5C5.setText("");
            inputSets6C6.setText("");

            inputReps1C1.setText("");
            inputReps2C2.setText("");
            inputReps3C3.setText("");
            inputReps4C4.setText("");
            inputReps5C5.setText("");
            inputReps6C6.setText("");

            inputWeight1C1.setText("");
            inputWeight2C2.setText("");
            inputWeight3C3.setText("");
            inputWeight4C4.setText("");
            inputWeight5C5.setText("");
            inputWeight6C6.setText("");
            //Notify the user of the update of database!
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