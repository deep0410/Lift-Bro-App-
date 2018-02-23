package eecs1022.liftbro;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Deep on 2/21/18.
 */
public class ListDataActivity extends AppCompatActivity
{
    private static final String TAG = "ListDataActivity";
    DatabaseHelper mDatabaseHelper;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // we want to set this list layout view which we will populate later on.
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        //Where we call the method to populate the list
        populateListView();
    }

    private void populateListView()
    {
        //Just logging for Programming purpose
        Log.d(TAG,"populateListView: Displaying data in the ListView.");

        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();

        //get the data and append it to the list
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }

        //create the list list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapter);

        // Set an onItemClickListener to the ListView
        // For future editing the database purpose
        // From below, notice all it does is just log the item that is being clicked on.
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

            }
        });
    }


    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
