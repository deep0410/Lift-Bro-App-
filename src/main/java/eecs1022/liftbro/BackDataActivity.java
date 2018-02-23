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
public class BackDataActivity
{
    DatabaseHelper mDatabaseHelper;
    //All different textFields that would be linked to the variables
    public EditText inputEx1B1, inputEx2B2, inputEx3B3, inputEx4B4, inputEx5B5, inputEx6B6, inputEx7B7;
    public EditText inputSets1B1, inputSets2B2, inputSets3B3, inputSets4B4, inputSets5B5, inputSets6B6, inputSets7B7;
    public EditText inputReps1B1, inputReps2B2, inputReps3B3, inputReps4B4, inputReps5B5, inputReps6B6, inputReps7B7;
    public EditText inputWeight1B1, inputWeight2B2, inputWeight3B3, inputWeight4B4, inputWeight5B5, inputWeight6B6, inputWeight7B7;

    public BackDataActivity(){

    }

    //Just records everything into the data base in the Text fields
    public void record(){
        //Assigning the variables to the id that they are linked to.
        inputEx1B1 = (EditText) findViewById(R.id.inputEx1B);
        inputEx2B2 = (EditText) findViewById(R.id.inputEx2B);
        inputEx3B3 = (EditText) findViewById(R.id.inputEx3B);
        inputEx4B4 = (EditText) findViewById(R.id.inputEx4B);
        inputEx5B5 = (EditText) findViewById(R.id.inputEx5B);
        inputEx6B6 = (EditText) findViewById(R.id.inputEx6B);
        inputEx7B7 = (EditText) findViewById(R.id.inputEx7B);

        inputSets1B1 = (EditText) findViewById(R.id.inputSets1B);
        inputSets2B2 = (EditText) findViewById(R.id.inputSets2B);
        inputSets3B3 = (EditText) findViewById(R.id.inputSets3B);
        inputSets4B4 = (EditText) findViewById(R.id.inputSets4B);
        inputSets5B5 = (EditText) findViewById(R.id.inputSets5B);
        inputSets6B6 = (EditText) findViewById(R.id.inputSets6B);
        inputSets7B7 = (EditText) findViewById(R.id.inputSets7B);

        inputReps1B1 = (EditText) findViewById(R.id.inputReps1B);
        inputReps2B2 = (EditText) findViewById(R.id.inputReps2B);
        inputReps3B3 = (EditText) findViewById(R.id.inputReps3B);
        inputReps4B4 = (EditText) findViewById(R.id.inputReps4B);
        inputReps5B5 = (EditText) findViewById(R.id.inputReps5B);
        inputReps6B6 = (EditText) findViewById(R.id.inputReps6B);
        inputReps7B7 = (EditText) findViewById(R.id.inputReps7B);

        inputWeight1B1 = (EditText) findViewById(R.id.inputWeight1B);
        inputWeight2B2 = (EditText) findViewById(R.id.inputWeight2B);
        inputWeight3B3 = (EditText) findViewById(R.id.inputWeight3B);
        inputWeight4B4 = (EditText) findViewById(R.id.inputWeight4B);
        inputWeight5B5 = (EditText) findViewById(R.id.inputWeight5B);
        inputWeight6B6 = (EditText) findViewById(R.id.inputWeight6B);
        inputWeight7B7 = (EditText) findViewById(R.id.inputWeight7B);

        //Making a new Entry that is only updated if an entire row of set resps and weight is filled.
        String newEntry = "";
        if(inputEx1B1.length() != 0 && inputSets1B1.length() != 0 && inputReps1B1.length() != 0 && inputWeight1B1.length() != 0){
            newEntry = newEntry + "" + inputEx1B1.getText().toString() + " :"+spaceItEx( inputEx1B1.length()) + " Sets :" + inputSets1B1.getText().toString() +""+spaceIt(inputSets1B1.length())+""+ " Reps :" + inputReps1B1.getText().toString() + ""+spaceIt(inputReps1B1.length())+" Weight : " + inputWeight1B1.getText().toString()+"\n";
        }
        if(inputEx2B2.length() != 0 && inputSets2B2.length() != 0 && inputReps2B2.length() != 0 && inputWeight2B2.length() != 0){
            newEntry = newEntry + "" + inputEx2B2.getText().toString() + " :" +spaceItEx( inputEx2B2.length())+" Sets :" +inputSets2B2.getText().toString() +""+spaceIt(inputSets2B2.length())+""+ " Reps :" + inputReps2B2.getText().toString() + ""+spaceIt(inputReps2B2.length())+ " Weight : " + inputWeight2B2.getText().toString()+"\n";
        }
        if(inputEx3B3.length() != 0 && inputSets3B3.length() != 0 && inputReps3B3.length() != 0 && inputWeight3B3.length() != 0){
            newEntry = newEntry + "" + inputEx3B3.getText().toString() + " :" +spaceItEx( inputEx3B3.length())+" Sets :" + inputSets3B3.getText().toString() + ""+spaceIt(inputSets3B3.length())+""+" Reps :" + inputReps3B3.getText().toString() + ""+spaceIt(inputReps3B3.length())+ " Weight : " + inputWeight3B3.getText().toString()+"\n";
        }
        if(inputEx4B4.length() != 0 && inputSets4B4.length() != 0 && inputReps4B4.length() != 0 && inputWeight4B4.length() != 0){
            newEntry = newEntry + "" + inputEx4B4.getText().toString() + " :" +spaceItEx( inputEx4B4.length())+" Sets :" + inputSets4B4.getText().toString() + ""+spaceIt(inputSets4B4.length())+""+" Reps :" + inputReps4B4.getText().toString() +  ""+spaceIt(inputReps4B4.length())+" Weight : " + inputWeight4B4.getText().toString()+"\n";
        }
        if(inputEx5B5.length() != 0 && inputSets5B5.length() != 0 && inputReps5B5.length() != 0 && inputWeight5B5.length() != 0){
            newEntry = newEntry + "" + inputEx5B5.getText().toString() + " :"+spaceItEx( inputEx5B5.length())+" Sets :"+ inputSets5B5.getText().toString() + ""+spaceIt(inputSets5B5.length())+""+" Reps :" + inputReps5B5.getText().toString() + ""+spaceIt(inputReps5B5.length())+ " Weight : " + inputWeight5B5.getText().toString()+"\n";
        }
        if(inputEx6B6.length() != 0 && inputSets6B6.length() != 0 && inputReps6B6.length() != 0 && inputWeight6B6.length() != 0){
            newEntry = newEntry + "" + inputEx6B6.getText().toString() + " :" +spaceItEx( inputEx6B6.length())+" Sets :"+inputSets6B6.getText().toString() +""+spaceIt(inputSets6B6.length())+""+ " Reps :" + inputReps6B6.getText().toString() +  ""+spaceIt(inputReps6B6.length())+" Weight : " + inputWeight6B6.getText().toString()+"\n";
        }
        if(inputEx7B7.length() != 0 && inputSets7B7.length() != 0 && inputReps7B7.length() != 0 && inputWeight7B7.length() != 0){
            newEntry = newEntry + "" + inputEx7B7.getText().toString() + " :" +spaceItEx( inputEx7B7.length())+" Sets :"+ inputSets7B7.getText().toString() + ""+spaceIt(inputSets7B7.length())+""+" Reps :" + inputReps7B7.getText().toString() +  ""+spaceIt(inputReps7B7.length())+" Weight : " + inputWeight7B7.getText().toString();
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
            inputSets1B1.setText("");
            inputSets2B2.setText("");
            inputSets3B3.setText("");
            inputSets4B4.setText("");
            inputSets5B5.setText("");
            inputSets6B6.setText("");
            inputSets7B7.setText("");

            inputReps1B1.setText("");
            inputReps2B2.setText("");
            inputReps3B3.setText("");
            inputReps4B4.setText("");
            inputReps5B5.setText("");
            inputReps6B6.setText("");
            inputReps7B7.setText("");

            inputWeight1B1.setText("");
            inputWeight2B2.setText("");
            inputWeight3B3.setText("");
            inputWeight4B4.setText("");
            inputWeight5B5.setText("");
            inputWeight6B6.setText("");
            inputWeight7B7.setText("");
            //Notify the user of the update of database!
            toastMessage("Record has been updated!");
        } else
        {
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