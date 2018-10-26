package com.example.emb_madhtom.inheritancedemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class CollegeListActivity extends BaseActivity {

    RecyclerView recyCollegeList;
    List<University> universities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);

        recyCollegeList = (RecyclerView) findViewById(R.id.recy_college_list);
        new DatabaseAsync().execute();
    }
    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //Let's add some dummy data to the database.

            //Now access all the methods defined in DaoAccess with sampleDatabase object
            universities = sampleDatabase.daoAccess().fetchAllData();


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(CollegeListActivity.this,LinearLayoutManager.VERTICAL,false);
            recyCollegeList.setLayoutManager(layoutManager);
            CollegeListAdapter collegeListAdapter=new CollegeListAdapter(universities);
            recyCollegeList.setAdapter(collegeListAdapter);

            //To after addition operation here.
        }
    }
}
