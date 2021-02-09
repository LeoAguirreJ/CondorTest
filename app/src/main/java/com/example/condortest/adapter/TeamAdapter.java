package com.example.condortest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.condortest.R;
import com.example.condortest.data.model.teams.Team;
import com.example.condortest.ui.activities.detail.DetailActivity;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamAdapterHolder>{

    private List<Team> teamLists;
    private Context context;
    public TeamAdapter(List<Team> teamLists, Context context) {
        this.teamLists = teamLists;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_team, parent, false);
        return new TeamAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapterHolder holder, int position) {
        Team team = teamLists.get(position);
        String teamName = team.getStrTeam();
        int idTeam = team.getIdTeam();
        holder.tvName.setText(teamName);
        holder.tvStadium.setText(team.getStrStadium());
        Glide
                .with(context)
                .load(team.getStrTeamBadge())
                .into(holder.ivTeam);
        holder.itemView.setOnClickListener(view -> {
            openActivity(teamName, idTeam);
        });
    }

    @Override
    public int getItemCount() {
        return teamLists.size();
    }

    public void setData(List<Team> teams){
        this.teamLists = teams;
        notifyDataSetChanged();
    }

    public class TeamAdapterHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvStadium;
        private ImageView ivTeam;
        public TeamAdapterHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvStadium = itemView.findViewById(R.id.tvStadium);
            ivTeam = itemView.findViewById(R.id.ivBadge);
        }
    }

    public void openActivity(String teamName, int idTeam) {
        Intent detail = new Intent(context.getApplicationContext(), DetailActivity.class);
        detail.putExtra("id", idTeam+"");
        detail.putExtra("name", teamName);
        context.startActivity(detail);
    }
}
