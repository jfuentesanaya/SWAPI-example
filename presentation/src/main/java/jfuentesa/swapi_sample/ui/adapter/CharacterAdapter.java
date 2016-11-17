package jfuentesa.swapi_sample.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jfuentesa on 16/11/2016.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {


    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(CharacterAdapter.CharacterViewHolder holder, int position) {

    }

    class CharacterViewHolder extends RecyclerView.ViewHolder{

        public CharacterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
