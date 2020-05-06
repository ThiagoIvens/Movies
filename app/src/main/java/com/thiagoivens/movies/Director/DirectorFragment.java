package com.thiagoivens.movies.Director;

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

public class DirectorFragment extends Fragment {


    View v;
    private RecyclerView mrvDirector;
    DirectorRecyclerViewAdapter recyclerAdapterDirector;
    private static List<Director> listDirectors;
    Button btnAdd;

    public DirectorFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_director, container, false);
        mrvDirector = (RecyclerView) v.findViewById(R.id.director_recycler_id);
        recyclerAdapterDirector = new DirectorRecyclerViewAdapter(getContext(),listDirectors);
        mrvDirector.setLayoutManager(new LinearLayoutManager(getActivity()));
        mrvDirector.setAdapter(recyclerAdapterDirector);
        btnAdd = (Button) v.findViewById(R.id.director_btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DirectorCad.class);
                startActivityForResult(intent, 1);
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listDirectors = new ArrayList<>();

        if (listDirectors.size() == 0) {
            listDirectors.add(new Director("Quentin Tarantino",57, R.drawable.quentintarantino));
            listDirectors.add(new Director("Martin Scorsese",77, R.drawable.martinscorsese));
            listDirectors.add(new Director("Steven Spielberg",73, R.drawable.stevenspielberg));
            listDirectors.add(new Director("Woody Allen",84, R.drawable.woodyallen));
            listDirectors.add(new Director("David Fincher",57, R.drawable.davidfincher));
        }

    }

    public static List<Director> getListDirectors() {
        return listDirectors;
    }

    public static void setListDirectors(List<Director> listDirectors) {
        DirectorFragment.listDirectors = listDirectors;
    }

    public static void addDirector(String name, int age){
        listDirectors.add(new Director(name, age, R.drawable.semfoto));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        recyclerAdapterDirector = new DirectorRecyclerViewAdapter(getContext(), listDirectors);
        mrvDirector.setAdapter(recyclerAdapterDirector);
    }

    public static Director findDirector(String name){
        for (int i = 0; i<listDirectors.size();i++){
            if (listDirectors.get(i).getNome().equals(name)){
                return listDirectors.get(i);
            }
        }
        return null;
    }

}
