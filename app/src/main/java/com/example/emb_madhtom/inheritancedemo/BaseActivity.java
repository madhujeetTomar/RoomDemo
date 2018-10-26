package com.example.emb_madhtom.inheritancedemo;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected  RoomSampleDatabase sampleDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sampleDatabase = Room.databaseBuilder(getApplicationContext(),
                RoomSampleDatabase.class, "sample-db").build();

    }
}
