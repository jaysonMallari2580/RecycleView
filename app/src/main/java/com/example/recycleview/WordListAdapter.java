package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordlist ;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> mWordlist) {
        mInflater = LayoutInflater.from(context);
        this.mWordlist = mWordlist;
    }


    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.word_list_item, parent,false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
            String mCurrent = mWordlist.get(position);
            holder.wordItemview.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordlist.size();
    }



    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final MaterialTextView wordItemview;
        final WordListAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter mAdapter) {
            super(itemView);
            this.wordItemview = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            //Get the position of the item that was clicked
            int mPosition = getLayoutPosition();

            // use that to access the affected item in the mWordList
            String element = mWordlist.get(mPosition);

            //Change the word in the mWordList
            mWordlist.set(mPosition, "Clicked "+ element);

            //Notify the adapter that the data has change so it can update the RecyclerView to display the data
            mAdapter.notifyDataSetChanged();


        }
    }
}
