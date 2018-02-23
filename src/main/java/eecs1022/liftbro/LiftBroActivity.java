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

public class LiftBroActivity extends AppCompatActivity
{
    public static final String TAG = "LiftBroActivity";
    DatabaseHelper mDatabaseHelper;
    public Button recordButton, historyButton;

    Profile user;
    int counter = 0;
    int counterA = 1;
    int counterB = 1;
    int counterC = 1;
    int counterL = 1;
    int counterS = 1;
    int spaceInBetweenEx = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lift_bro);
        recordButton = (Button) findViewById(R.id.buttonRecord);
        historyButton = (Button) findViewById(R.id.buttonHistory);
        mDatabaseHelper = new DatabaseHelper(this);
        user = new Profile();
        setContentsOfTextView(R.id.lblDisplayName, "Please set your profile");


    }
         /* Helper methods for retrieving contents from the GUI */

    private void setContentsOfTextView(int id, String newContents)
    {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    private String getItemsSelected(int id)
    {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    private String getInputOfTextFields(int id)
    {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    public void ButtonChestClicked(View view)
    {
        setContentView(R.layout.chest_lift_bro);
    }

    public void ButtonBackExClicked(View view)
    {
        setContentView(R.layout.back_lift_bro);

    }

    public void ButtonShoulderClicked(View view)
    {
        setContentView(R.layout.shoulders_lift_bro);
    }

    public void ButtonLegsClicked(View view)
    {
        setContentView(R.layout.legs_lift_bro);
    }

    public void ButtonArmsGeneralClicked(View view)
    {
        setContentView(R.layout.armsgeneral_lift_bro);
    }

    public void ButtonCreateProfileClicked(View view)
    {
        counter++;

        if (counter == 1)
        {
            setContentView(R.layout.createprofile_lift_bro);
            counter++;
        } else
        {
            toastMessage("You have already created a profile!");
        }

    }

    public void ButtonProfileClicked(View View)
    {

        String name = getInputOfTextFields(R.id.inputName);
        String age = getInputOfTextFields(R.id.inputAge);
        String height = getInputOfTextFields(R.id.inputHeight);
        String weight = getInputOfTextFields(R.id.inputWeight);
        String experience = getItemsSelected(R.id.spinner);

        double A = Double.parseDouble(age);
        double H = Double.parseDouble(height);
        double W = Double.parseDouble(weight);
        user.addInformation(name, A, H, W, experience);
        setContentView(R.layout.activity_lift_bro);
        setContentsOfTextView(R.id.lblDisplayName, "Welcome " + user.toString());

        counter++;
    }

    public void ButtonBackClicked(View view)
    {

        setContentView(R.layout.activity_lift_bro);

        if (counter == 0)
        {
            setContentsOfTextView(R.id.lblDisplayName, "Please create your profile");
        }

        else
        {
            setContentsOfTextView(R.id.lblDisplayName, "Welcome " + user.toString());
        }
    }


    public void ButtonOptimalClickedA(View view)
    {
        if (counter == 0)
        {
            toastMessage("Please create a profile to use this feature.");
        } else

        {
            if (counterA == 1)
            {

                counterA++;
                String Ex1 = getInputOfTextFields(R.id.inputEx1A);
                String Ex2 = getInputOfTextFields(R.id.inputEx2A);
                String Ex3 = getInputOfTextFields(R.id.inputEx3A);
                String Ex4 = getInputOfTextFields(R.id.inputEx4A);

                setContentsOfTextView(R.id.inputSets1A, "5");
                setContentsOfTextView(R.id.inputSets2A, "5");
                setContentsOfTextView(R.id.inputSets3A, "5");
                setContentsOfTextView(R.id.inputSets4A, "5");

                setContentsOfTextView(R.id.inputReps1A, "5");
                setContentsOfTextView(R.id.inputReps2A, "5");
                setContentsOfTextView(R.id.inputReps3A, "5");
                setContentsOfTextView(R.id.inputReps4A, "5");

                user.getExerciseNames4(Ex1, Ex2, Ex3, Ex4);

                if (Ex1.equals("Bicep Curl"))
                {
                    setContentsOfTextView(R.id.inputWeight1A, user.OPArms(Ex1, "Bicep Curl", 0.2, 0.35, 0.55));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }

                if (Ex2.equals("Hammer Curl"))
                {
                    setContentsOfTextView(R.id.inputWeight2A, user.OPArms(Ex2, "Hammer Curl", 0.05, 0.25, 0.60));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex3.equals("Tricep Pulldown"))
                {
                    setContentsOfTextView(R.id.inputWeight3A, user.OPArms(Ex3, "Tricep Pulldown", 0.2, 0.8, 1.7));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex4.equals("Tricep Kickback"))
                {
                    setContentsOfTextView(R.id.inputWeight4A, user.OPArms(Ex4, "Tricep Kickback", 0.1, 0.2, 0.3));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }

            } else
            {
                toastMessage("The optimal weights are listed already!");
            }
        }
    }

    public void ButtonOptimalClickedB(View view)
    {
        if (counter == 0)
        {
            toastMessage("Please create a profile to use this feature.");
        } else

        {

            if (counterB == 1)
            {
                counterB++;
                String Ex1 = getInputOfTextFields(R.id.inputEx1B);
                String Ex2 = getInputOfTextFields(R.id.inputEx2B);
                String Ex3 = getInputOfTextFields(R.id.inputEx3B);
                String Ex4 = getInputOfTextFields(R.id.inputEx4B);
                String Ex5 = getInputOfTextFields(R.id.inputEx5B);

                setContentsOfTextView(R.id.inputSets1B, "5");
                setContentsOfTextView(R.id.inputSets2B, "5");
                setContentsOfTextView(R.id.inputSets3B, "5");
                setContentsOfTextView(R.id.inputSets4B, "5");
                setContentsOfTextView(R.id.inputSets5B, "5");

                setContentsOfTextView(R.id.inputReps1B, "5");
                setContentsOfTextView(R.id.inputReps2B, "5");
                setContentsOfTextView(R.id.inputReps3B, "5");
                setContentsOfTextView(R.id.inputReps4B, "5");
                setContentsOfTextView(R.id.inputReps5B, "5");

                user.getExerciseNames5(Ex1, Ex2, Ex3, Ex4, Ex5);

                if (Ex1.equals("Deadlift"))
                {
                    setContentsOfTextView(R.id.inputWeight1B, user.OPArms(Ex1, "Deadlift", 1.1, 1.8, 2.4));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }

                if (Ex2.equals("Lat Pulldown"))
                {
                    setContentsOfTextView(R.id.inputWeight2B, user.OPArms(Ex2, "Lat Pulldown", 0.54, 1.04, 1.55));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex3.equals("Standing T-Bar Row"))
                {
                    setContentsOfTextView(R.id.inputWeight3B, user.OPArms(Ex3, "Standing T-Bar Row", 0.5, 1.1, 1.7));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex4.equals("Close Gap Pulldown"))
                {
                    setContentsOfTextView(R.id.inputWeight4B, user.OPArms(Ex4, "Close Gap Pulldown", 0.3, 0.5, 0.6));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex5.equals("Dumbbell Pullover"))
                {
                    setContentsOfTextView(R.id.inputWeight5B, user.OPArms(Ex5, "Dumbbell Pullover", 0.16, 0.2, 0.25));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }


            } else
            {
                toastMessage("The optimal weights are listed already!");
            }

        }
    }

    public void ButtonOptimalClickedC(View view)
    {
        if (counter == 0)
        {
            toastMessage("Please create a profile to use this feature.");
        } else
        {
            if (counterC == 1)
            {

                counterC++;
                String Ex1 = getInputOfTextFields(R.id.inputEx1C);
                String Ex2 = getInputOfTextFields(R.id.inputEx2C);
                String Ex3 = getInputOfTextFields(R.id.inputEx3C);
                String Ex4 = getInputOfTextFields(R.id.inputEx4C);

                setContentsOfTextView(R.id.inputSets1C, "5");
                setContentsOfTextView(R.id.inputSets2C, "5");
                setContentsOfTextView(R.id.inputSets3C, "5");
                setContentsOfTextView(R.id.inputSets4C, "5");

                setContentsOfTextView(R.id.inputReps1C, "5");
                setContentsOfTextView(R.id.inputReps2C, "5");
                setContentsOfTextView(R.id.inputReps3C, "5");
                setContentsOfTextView(R.id.inputReps4C, "5");

                user.getExerciseNames4(Ex1, Ex2, Ex3, Ex4);

                if (Ex1.equals("Flat Bench Press"))
                {
                    setContentsOfTextView(R.id.inputWeight1C, user.OPArms(Ex1, "Flat Bench Press", 0.635, 1.2, 1.7));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }

                if (Ex2.equals("Incline Bench Press"))

                {
                    setContentsOfTextView(R.id.inputWeight2C, user.OPArms(Ex2, "Incline Bench Press", 0.6, 1.07, 1.4));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex3.equals("Decline Bench Press"))
                {
                    setContentsOfTextView(R.id.inputWeight3C, user.OPArms(Ex3, "Decline Bench Press", 0.665, 1.26, 1.8));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex4.equals("Pec Fly"))
                {
                    setContentsOfTextView(R.id.inputWeight4C, user.OPArms(Ex4, "Pec Fly", 0.1, 0.2, 0.3));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
            } else
            {
                toastMessage("The optimal weights are listed already!");
            }
        }
    }

    public void ButtonOptimalClickedL(View view)
    {
        if (counter == 0)
        {
            toastMessage("Please create a profile to use this feature.");
        } else
        {
            if (counterL == 1)
            {

                counterL++;
                String Ex1 = getInputOfTextFields(R.id.inputEx1L);
                String Ex2 = getInputOfTextFields(R.id.inputEx2L);
                String Ex3 = getInputOfTextFields(R.id.inputEx3L);
                String Ex4 = getInputOfTextFields(R.id.inputEx4L);

                setContentsOfTextView(R.id.inputSets1L, "5");
                setContentsOfTextView(R.id.inputSets2L, "5");
                setContentsOfTextView(R.id.inputSets3L, "5");
                setContentsOfTextView(R.id.inputSets4L, "5");

                setContentsOfTextView(R.id.inputReps1L, "5");
                setContentsOfTextView(R.id.inputReps2L, "5");
                setContentsOfTextView(R.id.inputReps3L, "5");
                setContentsOfTextView(R.id.inputReps4L, "5");

                user.getExerciseNames4(Ex1, Ex2, Ex3, Ex4);

                if (Ex1.equals("Front Squat"))
                {
                    setContentsOfTextView(R.id.inputWeight1L, user.OPArms(Ex1, "Front Squat", 0.7, 1.23, 1.7));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }

                if (Ex2.equals("Back Squat"))
                {
                    setContentsOfTextView(R.id.inputWeight2L, user.OPArms(Ex2, "Back Squat", 0.6, 1.2, 1.66));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex3.equals("Leg Press"))
                {
                    setContentsOfTextView(R.id.inputWeight3L, user.OPArms(Ex3, "Leg Press", 1.3, 2.87, 4.2));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex4.equals("Lunges"))
                {
                    setContentsOfTextView(R.id.inputWeight4L, user.OPArms(Ex4, "Lunges", 0.115, 0.44, 0.8));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }

            } else
            {
                toastMessage("The optimal weights are listed already!");
            }
        }
    }

    public void ButtonOptimalClickedS(View view)
    {
        if (counter == 0)
        {
            toastMessage("Please create a profile to use this feature.");
        } else
        {
            if (counterS == 1)
            {

                counterS++;
                String Ex1 = getInputOfTextFields(R.id.inputEx1S);
                String Ex2 = getInputOfTextFields(R.id.inputEx2S);
                String Ex3 = getInputOfTextFields(R.id.inputEx3S);
                String Ex4 = getInputOfTextFields(R.id.inputEx4S);

                setContentsOfTextView(R.id.inputSets1S, "5");
                setContentsOfTextView(R.id.inputSets2S, "5");
                setContentsOfTextView(R.id.inputSets3S, "5");
                setContentsOfTextView(R.id.inputSets4S, "5");

                setContentsOfTextView(R.id.inputReps1S, "5");
                setContentsOfTextView(R.id.inputReps2S, "5");
                setContentsOfTextView(R.id.inputReps3S, "5");
                setContentsOfTextView(R.id.inputReps4S, "5");

                user.getExerciseNames4(Ex1, Ex2, Ex3, Ex4);

                if (Ex1.equals("Military Shoulder Press"))
                {
                    setContentsOfTextView(R.id.inputWeight1S, user.OPArms(Ex1, "Military Shoulder Press", 0.4, 0.77, 1.3));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }

                if (Ex2.equals("Dumbbell Shoulder Press"))
                {
                    setContentsOfTextView(R.id.inputWeight2S, user.OPArms(Ex2, "Dumbbell Shoulder Press", 0.185, 0.42, 0.7));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex3.equals("Upright Row"))
                {
                    setContentsOfTextView(R.id.inputWeight3S, user.OPArms(Ex3, "Upright Row", 0.3, 0.82, 1.45));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }
                if (Ex4.equals("Shoulder Fly"))
                {
                    setContentsOfTextView(R.id.inputWeight4S, user.OPArms(Ex4, "Shoulder Fly", 0.1, 0.14, 0.17));
                } else
                {
                    toastMessage("Reminder: Custom exercises have no suggested weights.");
                }

            } else
            {
                toastMessage("The optimal weights are listed already!");
            }
        }
    }


    /**
     * When the Recordbutton in back has in click this method excuted
     * This method takes all the Input textfield stores the neccessaary ones in to the database
     * @param view
     */
    public void recordBack(View v) {
        BackDataActivity BDA = new BackDataActivity();
        BDA.record();
    }

    /**
     * When the Recordbutton in chest has in click this method excuted
     * This method takes all the Input textfield stores the neccessaary ones in to the database
     * @param view
     */
    public void recordChest(View v){
        ChestDataActivity CDA = new ChestDataActivity();
        CDA.record();
    }

    /**
     * When the Recordbutton in shoulder has in click this method excuted
     * This method takes all the Input textfield stores the neccessaary ones in to the database
     * @param view
     */
    public void recordShoulder(View v){
        ShoulderDataActivity SDA = new ShoulderDataActivity();
        SDA.record();
    }

    /**
     * When the Recordbutton in Arms has in click this method excuted
     * This method takes all the Input textfield stores the neccessaary ones in to the database
     * @param view
     */
    public void recordArms(View v){
       ArmDataActivity ADA = new ArmDataActivity();
       ADA.record();
    }

    /**
     * When the Recordbutton in Legs has in click this method excuted
     * This method takes all the Input textfield stores the neccessaary ones in to the database
     * @param view
     */
    public void recordLegs(View v){
        LegDataActivity LDA = new LegDataActivity();
        LDA.record();
    }

    public void history(View v){
        Intent intent = new Intent(LiftBroActivity.this, ListDataActivity.class);
        startActivity(intent);
    }



    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void removeALL(View v){
       mDatabaseHelper.removeAll();
        toastMessage("Done!");
    }


}
