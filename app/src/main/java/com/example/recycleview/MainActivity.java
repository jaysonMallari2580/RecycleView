package com.example.recycleview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<String>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Floating Action Button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();

                mWordList.addLast("+ Word "+ wordListSize);

                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);

                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });

        //Get a handle to the Recyclerview
        mRecyclerView = findViewById(R.id.recycleview);

        //Create an adapter and supply the data to be displayed
        // mWordList is the Linkedlist we created in the Activity
        mAdapter = new WordListAdapter(this, mWordList);

        //Connect the adapter with the RecycleView
        mRecyclerView.setAdapter(mAdapter);

        //Give the recyclerview a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //mWordlist
        for(int i=0;i<20;i++){
            mWordList.addLast("word"+i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}