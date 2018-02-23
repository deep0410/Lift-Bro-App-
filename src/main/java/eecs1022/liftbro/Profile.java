package eecs1022.liftbro;

import android.support.annotation.StringRes;

/**
 * Created by user on 2/21/18.
 */
public class Profile
{
    String name, experience;
    String Ex1, Ex2, Ex3, Ex4, Ex5;
    double age, height, weight;

    public Profile(){

    }
    public void addInformation(String n, double a, double h, double w, String e){
        this.name = n;
        this.age = a;
        this.height = h;
        this.weight = w;
        this.experience = e;
    }
    public void getExerciseNames4(String Ex1, String Ex2, String Ex3, String Ex4)
    {
        this.Ex1 = Ex1;
        this.Ex2 = Ex2;
        this.Ex3 = Ex3;
        this.Ex4 = Ex4;
    }
    public void getExerciseNames5(String Ex1, String Ex2, String Ex3, String Ex4, String Ex5){
        this.Ex1 = Ex1;
        this.Ex2 = Ex2;
        this.Ex3 = Ex3;
        this.Ex4 = Ex4;
        this.Ex5 = Ex5;
    }

    public double AgeMultiplier()
    {
        if (age >= 13 && age <= 17 )
        {
            return 0.87;
        }

        else if (age >= 18 && age <= 23 )
        {
            return 0.98;
        }

        else if (age >= 24 && age <= 39 )
        {
            return 1.00;
        }
        else if (age >= 40 && age <= 49 )
        {
            return 0.95;
        }
        else if (age >= 50 && age <= 59 )
        {
            return 0.83;
        }
        else if (age >= 60 && age <= 69 )
        {
            return 0.69;
        }
        else
        {
            return 0.55;
        }
    }

    public String OPArms(String Exercise, String Content, double rateBeg , double rateInt , double rateVet)
    {
        if (Exercise.equals(Content))
        {
            if (experience.equals("Beginner"))
            {
                double weightconvert = this.weight * 2.2;
                double OPweight = (weightconvert * rateBeg);
                OPweight = OPweight * AgeMultiplier();
                double math = 5 * Math.round(OPweight / 5);
                String OPweightStr = String.valueOf(math);
                return OPweightStr;
            } else if (experience.equals("Intermediate"))
            {
                double weightconvert = this.weight * 2.2;
                double OPweight = (weightconvert * rateInt);
                OPweight = OPweight * AgeMultiplier();
                double math = 5 * Math.round(OPweight / 5);
                String OPweightStr = String.valueOf(math);
                return OPweightStr;
            } else if (experience.equals("Veteran"))
            {
                double weightconvert = this.weight * 2.2;
                double OPweight = (weightconvert * rateVet);
                OPweight = OPweight * AgeMultiplier();
                double math = 5 * Math.round(OPweight / 5);
                String OPweightStr = String.valueOf(math);
                return OPweightStr;
            }
            else
            {
                return "0.0";
            }
        }

        else
        {
            return "Error";
        }

    }
    @Override
    public String toString(){
        String post ="";
        post += this.name;

        if (this.age < 13)
        {
            post += "\n Be advised recommend function works for users aged 13 and above";
        }
        return post;
    }

}



