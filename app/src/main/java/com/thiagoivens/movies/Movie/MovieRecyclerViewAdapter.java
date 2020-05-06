package com.thiagoivens.movies.Movie;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.thiagoivens.movies.R;
import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Movie> movieData;
    Dialog myDialog;

    public MovieRecyclerViewAdapter(Context mContext, List<Movie> movieData) {
        this.mContext = mContext;
        this.movieData = movieData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_movie);

        vHolder.item_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_name_tv = myDialog.findViewById(R.id.details_movie_title_id);
                TextView dialog_gender_tv = myDialog.findViewById(R.id.details_movie_gender_id);
                TextView dialog_actor_tv = myDialog.findViewById(R.id.details_movie_actor_id);
                TextView dialog_director_tv = myDialog.findViewById(R.id.details_movie_director_id);
                TextView dialog_ano_tv = myDialog.findViewById(R.id.details_movie_age_id);
                ImageView dialog_img = myDialog.findViewById(R.id.details_img_id);

                dialog_name_tv.setText(movieData.get(vHolder.getAdapterPosition()).getTitle());
                dialog_gender_tv.setText(movieData.get(vHolder.getAdapterPosition()).getGenero());
                dialog_actor_tv.setText(movieData.get(vHolder.getAdapterPosition()).getActor().getNome());
                dialog_director_tv.setText(movieData.get(vHolder.getAdapterPosition()).getDirector().getNome());
                dialog_ano_tv.setText(String.valueOf(movieData.get(vHolder.getAdapterPosition()).getAno()));
                dialog_img.setImageResource(movieData.get(vHolder.getAdapterPosition()).getImg());
                myDialog.show();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(movieData.get(position).getTitle());
        holder.img_movie.setImageResource(movieData.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout item_movie;
        private TextView tv_name;
        private ImageView img_movie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_movie= (LinearLayout) itemView.findViewById(R.id.item_movie_id);
            tv_name = (TextView) itemView.findViewById(R.id.name_movie);
            img_movie = (ImageView) itemView.findViewById(R.id.img_movie);
        }
    }
}