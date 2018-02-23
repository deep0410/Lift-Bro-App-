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
public class ArmDataActivity
{
    DatabaseHelper mDatabaseHelper;
    //All different textFields that would be linked to the variables
    public EditText inputEx1A1, inputEx2A2, inputEx3A3, inputEx4A4, inputEx5A5, inputEx6A6;
    public EditText inputSets1A1, inputSets2A2, inputSets3A3, inputSets4A4, inputSets5A5, inputSets6A6;
    public EditText inputReps1A1, inputReps2A2, inputReps3A3, inputReps4A4, inputReps5A5, inputReps6A6;
    public EditText inputWeight1A1, inputWeight2A2, inputWeight3A3, inputWeight4A4, inputWeight5A5, inputWeight6A6;

    public ArmDataActivity(){

    }

    //Just records everything into the data base in the Text fields
    public void record(){
        //Assigning the variables to the id that they are linked to.
        inputEx1A1 = (EditText) findViewById(R.id.inputEx1A);
        inputEx2A2 = (EditText) findViewById(R.id.inputEx2A);
        inputEx3A3 = (EditText) findViewById(R.id.inputEx3A);
        inputEx4A4 = (EditText) findViewById(R.id.inputEx4A);
        inputEx5A5 = (EditText) findViewById(R.id.inputEx5A);
        inputEx6A6 = (EditText) findViewById(R.id.inputEx6A);

        inputSets1A1 = (EditText) findViewById(R.id.inputSets1A);
        inputSets2A2 = (EditText) findViewById(R.id.inputSets2A);
        inputSets3A3 = (EditText) findViewById(R.id.inputSets3A);
        inputSets4A4 = (EditText) findViewById(R.id.inputSets4A);
        inputSets5A5 = (EditText) findViewById(R.id.inputSets5A);
        inputSets6A6 = (EditText) findViewById(R.id.inputSets6A);

        inputReps1A1 = (EditText) findViewById(R.id.inputReps1A);
        inputReps2A2 = (EditText) findViewById(R.id.inputReps2A);
        inputReps3A3 = (EditText) findViewById(R.id.inputReps3A);
        inputReps4A4 = (EditText) findViewById(R.id.inputReps4A);
        inputReps5A5 = (EditText) findViewById(R.id.inputReps5A);
        inputReps6A6 = (EditText) findViewById(R.id.inputReps6A);

        inputWeight1A1 = (EditText) findViewById(R.id.inputWeight1A);
        inputWeight2A2 = (EditText) findViewById(R.id.inputWeight2A);
        inputWeight3A3 = (EditText) findViewById(R.id.inputWeight3A);
        inputWeight4A4 = (EditText) findViewById(R.id.inputWeight4A);
        inputWeight5A5 = (EditText) findViewById(R.id.inputWeight5A);
        inputWeight6A6 = (EditText) findViewById(R.id.inputWeight6A);

        String newEntry = "";
        //Making a new Entry that is only updated if an entire row of set resps and weight is filled.
        if(inputEx1A1.length() != 0 && inputSets1A1.length() != 0 && inputReps1A1.length() != 0 && inputWeight1A1.length() != 0){
            newEntry = newEntry + "" + inputEx1A1.getText().toString() + " :" +spaceItEx( inputEx1A1.length())+  " Sets : " + inputSets1A1.getText().toString() +""+spaceIt(inputSets1A1.length())+ " Reps : " + inputReps1A1.getText().toString() + ""+spaceIt(inputReps1A1.length())+  " Weight : " + inputWeight1A1.getText().toString()+"\n";
        }

        if(inputEx2A2.length() != 0 && inputSets2A2.length() != 0 && inputReps2A2.length() != 0 && inputWeight2A2.length() != 0){
            newEntry = newEntry + "" + inputEx2A2.getText().toString() + " :" +spaceItEx( inputEx2A2.length())+  " Sets : " + inputSets2A2.getText().toString() +""+spaceIt(inputSets2A2.length())+ " Reps : " + inputReps2A2.getText().toString() + ""+spaceIt(inputReps2A2.length())+  " Weight : " + inputWeight2A2.getText().toString()+"\n";
        }
        if(inputEx3A3.length() != 0 && inputSets3A3.length() != 0 && inputReps3A3.length() != 0 && inputWeight3A3.length() != 0){
            newEntry = newEntry + "" + inputEx3A3.getText().toString() + " :" +spaceItEx( inputEx3A3.length())+  " Sets : " + inputSets3A3.getText().toString()  +""+spaceIt(inputSets3A3.length())+ " Reps : " + inputReps3A3.getText().toString() + ""+spaceIt(inputReps3A3.length())+  " Weight : " + inputWeight3A3.getText().toString()+"\n";
        }
        if(inputEx4A4.length() != 0 && inputSets4A4.length() != 0 && inputReps4A4.length() != 0 && inputWeight4A4.length() != 0){
            newEntry = newEntry + "" + inputEx4A4.getText().toString() + " :" +spaceItEx( inputEx4A4.length())+  " Sets : " + inputSets4A4.getText().toString()  +""+spaceIt(inputSets4A4.length())+ " Reps : " + inputReps4A4.getText().toString() + ""+spaceIt(inputReps4A4.length())+ " Weight : " + inputWeight4A4.getText().toString()+"\n";
        }
        if(inputEx5A5.length() != 0 && inputSets5A5.length() != 0 && inputReps5A5.length() != 0 && inputWeight5A5.length() != 0){
            newEntry = newEntry + "" + inputEx5A5.getText().toString() + " :" +spaceItEx( inputEx5A5.length())+  " Sets : " + inputSets5A5.getText().toString()  +""+spaceIt(inputSets5A5.length())+ " Reps : " + inputReps5A5.getText().toString() + ""+spaceIt(inputReps5A5.length())+ " Weight : " + inputWeight5A5.getText().toString()+"\n";
        }
        if(inputEx6A6.length() != 0 && inputSets6A6.length() != 0 && inputReps6A6.length() != 0 && inputWeight6A6.length() != 0){
            newEntry = newEntry + "" + inputEx6A6.getText().toString() + " :" +spaceItEx( inputEx6A6.length())+  " Sets : " + inputSets6A6.getText().toString()  +""+spaceIt(inputSets6A6.length())+ " Reps : " + inputReps6A6.getText().toString() + ""+spaceIt(inputReps6A6.length())+  " Weight : " + inputWeight6A6.getText().toString();
        }

        // If the new Entry was updated then update the database.
        if (newEntry.length>0)
        {
            //Getting todays Date and formatting it using the date class API
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat df =  new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(today);
            //Adding date and the data in to the database.
            AddData(formattedDate);
            AddData(newEntry);

            //set 0
            inputSets1A1.setText("");
            inputSets2A2.setText("");
            inputSets3A3.setText("");
            inputSets4A4.setText("");
            inputSets5A5.setText("");
            inputSets6A6.setText("");

            inputReps1A1.setText("");
            inputReps2A2.setText("");
            inputReps3A3.setText("");
            inputReps4A4.setText("");
            inputReps5A5.setText("");
            inputReps6A6.setText("");

            inputWeight1A1.setText("");
            inputWeight2A2.setText("");
            inputWeight3A3.setText("");
            inputWeight4A4.setText("");
            inputWeight5A5.setText("");
            inputWeight6A6.setText("");
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