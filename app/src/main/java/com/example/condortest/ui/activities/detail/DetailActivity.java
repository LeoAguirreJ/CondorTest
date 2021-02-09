package com.example.condortest.ui.activities.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.condortest.R;
import com.example.condortest.adapter.EventAdapter;
import com.example.condortest.data.model.detail.DataDetail;
import com.example.condortest.data.model.detail.TeamDetail;
import com.example.condortest.data.model.event.DataEvent;
import com.example.condortest.data.model.event.Event;
import com.example.condortest.data.rest.endpoint.TeamEndPoint;
import com.example.condortest.di.BaseApplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetailName;
    private TextView tvDetailDescription;
    private TextView tvDetailFormedYear;
    private ImageView ivDBadge;
    private ImageView ivDJersey;

    private TextView tvFb;
    private TextView tvWeb;
    private TextView tvTwitter;
    private TextView tvInstagram;

    RecyclerView recyclerView;
    EventAdapter adapter;
    List<Event> eventList;

    @Inject
    TeamEndPoint client;

    String teamName;
    String idTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                teamName= null;
                idTeam= null;
            } else {
                if (extras.getString("id") != null){
                    teamName= extras.getString("name");
                }
                if (extras.getString("name") != null){
                    idTeam= extras.getString("id");
                }
            }
        }

        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailDescription = findViewById(R.id.tvDetailDescription);
        tvDetailFormedYear = findViewById(R.id.tvDetailFormedYear);
        ivDBadge = findViewById(R.id.ivDBadge);
        ivDJersey = findViewById(R.id.ivDJersey);
        tvFb = findViewById(R.id.tvFb);
        tvWeb = findViewById(R.id.tvWeb);
        tvTwitter = findViewById(R.id.tvTwitter);
        tvInstagram = findViewById(R.id.tvInstagram);
        setUpDagger();
        setUpView();
        lanzarPeticion();
    }

    private void setUpDagger() {
        ((BaseApplication)getApplication()).getAplicationComponent().inject(this);
    }
    private void lanzarPeticion(){

        Call<DataDetail> call = client.getTeam(teamName);
        call.enqueue(new Callback<DataDetail>() {
            @Override
            public void onResponse(Call<DataDetail> call, Response<DataDetail> response) {
                String formedYear = "Formed Year: ";
                TeamDetail teamDetail = response.body().getTeams().get(0);
                tvDetailName.setText(teamDetail.getStrTeam());
                tvDetailDescription.setText(teamDetail.getStrDescriptionEN());
                tvDetailFormedYear.setText(String.format("%s%s", formedYear, String.format("%d", teamDetail.getIntFormedYear())));
                tvFb.setText(teamDetail.getStrFacebook());
                tvWeb.setText(teamDetail.getStrWebsite());
                tvTwitter.setText(teamDetail.getStrTwitter());
                tvInstagram.setText(teamDetail.getStrInstagram());
                Glide
                        .with(DetailActivity.this)
                        .load(teamDetail.getStrTeamBadge())
                        .into(ivDBadge);
                Glide
                        .with(DetailActivity.this)
                        .load(teamDetail.getStrTeamJersey())
                        .into(ivDJersey);
            }

            @Override
            public void onFailure(Call<DataDetail> call, Throwable t) {
                Log.e("TAG1", "Error: " + t.getMessage());
            }
        });

        Call<DataEvent> callEvent = client.getTeamEvents(Integer.parseInt(idTeam));
        callEvent.enqueue(new Callback<DataEvent>() {
            @Override
            public void onResponse(Call<DataEvent> call, Response<DataEvent> response) {
                adapter.setData(response.body().getEvents());
            }

            @Override
            public void onFailure(Call<DataEvent> call, Throwable t) {
                Log.e("TAG1", "Error: " + t.getMessage());

            }
        });
    }

    private void setUpView() {
        eventList = new ArrayList<>();
        adapter = new EventAdapter(eventList, this);
        recyclerView = findViewById(R.id.rvEvents);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);
    }

}
