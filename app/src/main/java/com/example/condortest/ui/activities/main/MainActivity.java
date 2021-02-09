package com.example.condortest.ui.activities.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.condortest.R;
import com.example.condortest.adapter.TeamAdapter;
import com.example.condortest.data.model.teams.Data;
import com.example.condortest.data.model.teams.Team;
import com.example.condortest.data.rest.endpoint.LeagueEndPoint;
import com.example.condortest.di.BaseApplication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TeamAdapter adapter;
    List<Team> teamList;

    @Inject
    LeagueEndPoint client;

    private static final int LEAGUE_ID= 4335;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpDagger();
        setUpView();
        lanzarPeticion();
    }

    private void setUpDagger() {
        ((BaseApplication)getApplication()).getAplicationComponent().inject(this);
    }

    private void lanzarPeticion(){

        Call<Data> call = client.getTeamList(LEAGUE_ID);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                adapter.setData(response.body().getTeams());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.e("TAG1", "Error: " + t.getMessage());
            }
        });
    }

    private void setUpView() {
        teamList = new ArrayList<>();
        adapter = new TeamAdapter(teamList, this);
        recyclerView = findViewById(R.id.rvTeams);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);
    }
}
