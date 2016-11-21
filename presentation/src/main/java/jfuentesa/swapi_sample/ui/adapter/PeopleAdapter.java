package jfuentesa.swapi_sample.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jfuentesa.swapi_sample.R;
import jfuentesa.swapi_sample.model.PeopleModel;

/**
 * Created by jfuentesa on 16/11/2016.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {


    public interface OnItemClickListener {
        void onPeopleItemClicked(PeopleModel peopleModel);
    }

    private List<PeopleModel> peopleList;
    private OnItemClickListener onItemClickListener;

    public PeopleAdapter(Context context, Collection<PeopleModel> peopleList) {
        this.validatePeopleCollection(peopleList);
        this.peopleList = (List<PeopleModel>) peopleList;
    }

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new PeopleViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        final PeopleModel post = peopleList.get(position);
        holder.bindPost(holder.itemView.getContext(), post);
    }

    public void setPeopleCollection(Collection<PeopleModel> peopleCollection) {
        this.validatePeopleCollection(peopleCollection);
        this.peopleList = (List<PeopleModel>) peopleCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    private void validatePeopleCollection(Collection<PeopleModel> peopleCollection) {
        if (peopleCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    class PeopleViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_txt_name)
        TextView txtName;

        PeopleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindPost(Context context, final PeopleModel peopleModel) {
            txtName.setText(peopleModel.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener != null){
                        onItemClickListener.onPeopleItemClicked(peopleModel);
                    }
                }
            });
        }
    }
}
