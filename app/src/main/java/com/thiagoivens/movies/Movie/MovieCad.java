package com.thiagoivens.movies.Movie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.thiagoivens.movies.Actor.Actor;
import com.thiagoivens.movies.Actor.ActorFragment;
import com.thiagoivens.movies.Director.Director;
import com.thiagoivens.movies.Director.DirectorFragment;
import com.thiagoivens.movies.R;
import java.util.List;

public class MovieCad extends AppCompatActivity {
    //Spinners
    Spinner spinnerActor;
    Spinner spinnerDirector;
    //Lists
    List<Actor> actorList;
    List<Director> directorList;
    //Variables
    String title;
    String genero;
    int ano;
    Actor actor;
    Director director;
    //EditText
    EditText ed_title;
    EditText ed_gender;
    EditText ed_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_movie);

        //Spinner
        spinnerActor = (Spinner) findViewById(R.id.spinActor);
        spinnerDirector = (Spinner) findViewById(R.id.spinDirector);

        actorList = ActorFragment.getListActors();
        ArrayAdapter<Actor> aAdapterActor = new ArrayAdapter<Actor>(this, android.R.layout.simple_spinner_item,  actorList);
        aAdapterActor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActor.setAdapter(aAdapterActor);

        directorList = DirectorFragment.getListDirectors();
        ArrayAdapter<Director> aAdapterDirector = new ArrayAdapter<Director>(this, android.R.layout.simple_spinner_item, directorList);
        aAdapterDirector.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDirector.setAdapter(aAdapterDirector);

        //gets
        ed_title = findViewById(R.id.cad_movie_title_id);
        ed_gender = findViewById(R.id.cad_movie_genero_id);
        ed_age = findViewById(R.id.cad_movie_ano_id);
    }

    public void salvar(View view) {
        title = ed_title.getText().toString();
        genero = ed_gender.getText().toString();
        ano = Integer.valueOf(ed_age.getText().toString());
        actor = (Actor)  spinnerActor.getSelectedItem();
        director = (Director) spinnerDirector.getSelectedItem();

        MovieFragment.addActor(title,genero,ano,actor,director);
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
