package com.thiagoivens.movies.Director;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thiagoivens.movies.R;

import java.util.List;

public class DirectorRecyclerViewAdapter extends RecyclerView.Adapter<DirectorRecyclerViewAdapter.MyViewHolder>{

    Context mContext;
    List<Director> directorData;

    public DirectorRecyclerViewAdapter(Context mContext, List<Director> directorData) {
        this.mContext = mContext;
        this.directorData = directorData;
    }

    @NonNull
    @Override
    public DirectorRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_director, parent, false);
        final DirectorRecyclerViewAdapter.MyViewHolder vHolder = new DirectorRecyclerViewAdapter.MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DirectorRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tv_name_director.setText(directorData.get(position).getNome());
        holder.tv_age_director.setText(String.valueOf(directorData.get(position).getIdade())+" anos");
        holder.img_director.setImageResource(directorData.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return directorData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name_director;
        private TextView tv_age_director;
        private ImageView img_director;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name_director = (TextView) itemView.findViewById(R.id.name_director);
            tv_age_director = (TextView) itemView.findViewById(R.id.age_director);
            img_director = (ImageView) itemView.findViewById(R.id.img_director);
        }
    }
}
