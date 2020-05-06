package com.thiagoivens.movies.Actor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.thiagoivens.movies.R;

public class ActorCad extends AppCompatActivity {

    EditText ed_name;
    EditText ed_idade;
    String name;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_actor);

        ed_name = findViewById(R.id.cad_actor_name_id);
        ed_idade = findViewById(R.id.cad_actor_age_id);

    }

    public void salvar(View view) {
        name = ed_name.getText().toString();
        age = Integer.valueOf(ed_idade.getText().toString());
        ActorFragment.addActor(name,age);
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
