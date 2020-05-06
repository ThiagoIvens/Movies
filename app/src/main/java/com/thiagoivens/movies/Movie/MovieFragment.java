package com.thiagoivens.movies.Movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.thiagoivens.movies.Actor.Actor;
import com.thiagoivens.movies.Actor.ActorFragment;
import com.thiagoivens.movies.Director.Director;
import com.thiagoivens.movies.Director.DirectorFragment;
import com.thiagoivens.movies.R;
import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {
    View v;
    private RecyclerView myrecyclerview;
    private static List<Movie> listMovies;
    Button btnAddMovie;
    MovieRecyclerViewAdapter recyclerAdapter;

    public MovieFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_movie, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.movies_recycler_id);
        recyclerAdapter = new MovieRecyclerViewAdapter(getContext(),listMovies);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        btnAddMovie = v.findViewById(R.id.movie_btnAdd_id);
        btnAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MovieCad.class);
                startActivityForResult(intent, 1);
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listMovies = new ArrayList<>();
        if (listMovies.size() == 0){
            listMovies.add(new Movie("Django Livre", "Faroeste/Drama", 2013, ActorFragment.findActor("Jamie Foxx"), DirectorFragment.findDirector("Quentin Tarantino"),R.drawable.djangolivre));
            listMovies.add(new Movie("O Lobo de Wall Street", "Comédia/Drama", 2013, ActorFragment.findActor("Leonardo DiCaprio"), DirectorFragment.findDirector("Martin Scorsese"), R.drawable.olobodewallstreet));
        }
    }

    public static void addActor(String title, String genero, int ano, Actor actor, Director director){
        listMovies.add(new Movie(title, genero, ano, actor, director, R.drawable.semimagem));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        recyclerAdapter = new MovieRecyclerViewAdapter(getContext(), listMovies);
        myrecyclerview.setAdapter(recyclerAdapter);
    }
}