package com.thiagoivens.movies.Actor;

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

import com.thiagoivens.movies.R;

import java.util.ArrayList;
import java.util.List;

public class ActorFragment extends Fragment {
    View v;
    private RecyclerView mrvActor;
    private static List<Actor> listActors;
    private Button btnAdd;
    ActorRecyclerViewAdapter rAdapterActor;
    Intent intent;

    public ActorFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_actor, container, false);
        mrvActor = (RecyclerView) v.findViewById(R.id.actor_recycler_id);
        rAdapterActor = new ActorRecyclerViewAdapter(getContext(), listActors);
        mrvActor.setLayoutManager(new LinearLayoutManager(getActivity()));
        mrvActor.setAdapter(rAdapterActor);
        btnAdd = (Button) v.findViewById(R.id.actor_btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActorCad.class);
                startActivityForResult(intent, 0);
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listActors = new ArrayList<>();
        if (listActors.size()==0){
            listActors.add(new Actor("Brad Pitt", 56, R.drawable.bradpitt));
            listActors.add(new Actor("Tom Cruise", 57, R.drawable.tomcruise));
            listActors.add(new Actor("Will Smith", 51, R.drawable.willsmith));
            listActors.add(new Actor("Robert Downey Jr.", 55, R.drawable.robertdowney));
            listActors.add(new Actor("Jamie Foxx", 52, R.drawable.jamiefoxx));
            listActors.add(new Actor("Leonardo DiCaprio", 45, R.drawable.leonardodicaprio));
        }
    }

    public static List<Actor> getListActors() {
        return listActors;
    }

    public static void setListActors(List<Actor> listActors) {
        ActorFragment.listActors = listActors;
    }

    public static void addActor(String name, int age){
        listActors.add(new Actor(name, age, R.drawable.semfoto));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        rAdapterActor = new ActorRecyclerViewAdapter(getContext(), listActors);
        mrvActor.setAdapter(rAdapterActor);
    }

    public static Actor findActor(String name){
        for (int i = 0; i<listActors.size();i++){
            if (listActors.get(i).getNome().equals(name)){
                return listActors.get(i);
            }
        }
        return null;
    }
}
