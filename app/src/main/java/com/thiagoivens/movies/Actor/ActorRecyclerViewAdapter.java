package com.thiagoivens.movies.Actor;

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

public class ActorRecyclerViewAdapter extends RecyclerView.Adapter<ActorRecyclerViewAdapter.MyViewHolder>{
    Context mContext;
    List<Actor> actorData;

    public ActorRecyclerViewAdapter(Context mContext, List<Actor> actorData) {
        this.mContext = mContext;
        this.actorData = actorData;
    }

    @NonNull
    @Override
    public ActorRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_actor, parent, false);
        final ActorRecyclerViewAdapter.MyViewHolder vHolder = new ActorRecyclerViewAdapter.MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActorRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tv_name_actor.setText(actorData.get(position).getNome());
        holder.tv_age_actor.setText(String.valueOf(actorData.get(position).getIdade())+" anos");
        holder.img_actor.setImageResource(actorData.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return actorData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name_actor;
        private TextView tv_age_actor;
        private ImageView img_actor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name_actor = (TextView) itemView.findViewById(R.id.name_actor);
            tv_age_actor = (TextView) itemView.findViewById(R.id.age_actor);
            img_actor = (ImageView) itemView.findViewById(R.id.img_actor);
        }
    }
}
