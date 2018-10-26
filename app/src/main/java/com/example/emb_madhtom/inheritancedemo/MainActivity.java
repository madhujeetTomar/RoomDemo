package com.example.emb_madhtom.inheritancedemo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
findViewById(R.id.btn_next).setOnClickListener(this);
        findViewById(R.id.btn_add).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                //TODO implement
                new DatabaseAsync().execute();
                break;
            case R.id.btn_next:
                //TODO implement
                startActivity(new Intent(MainActivity.this,CollegeListActivity.class));
                break;
        }
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
            University university = new University();
            university.setName("MyUniversity");

            College college = new College();
            college.setId(Integer.parseInt(getEtCollegeId().getText().toString()));
            college.setName(getEtCollegeName().getText().toString());

            university.setCollege(college);

            //Now access all the methods defined in DaoAccess with sampleDatabase object
            sampleDatabase.daoAccess().insertOnlySingleRecord(university);


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //To after addition operation here.
        }
    }

    private EditText getEtSlNo() {
        return (EditText) findViewById(R.id.et_sl_no);
    }

    private EditText getEtCollegeId() {
        return (EditText) findViewById(R.id.et_college_id);
    }

    private EditText getEtCollegeName() {
        return (EditText) findViewById(R.id.et_college_name);

    }
}
