package com.example.condortest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.condortest.R;
import com.example.condortest.data.model.event.Event;
import com.example.condortest.data.model.teams.Team;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventAdapterHolder> {


    private List<Event> eventList;
    private Context context;

    public EventAdapter(List<Event> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_event, parent, false);
        return new EventAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapterHolder holder, int position) {
        Event event = eventList.get(position);
        String eventName = event.getStrEvent();
        holder.tvEvent.setText(eventName);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void setData(List<Event> events){
        this.eventList = events;
        notifyDataSetChanged();
    }

    public class EventAdapterHolder extends RecyclerView.ViewHolder{
        private TextView tvEvent;
        public EventAdapterHolder(@NonNull View itemView) {
            super(itemView);
            tvEvent = itemView.findViewById(R.id.tvEvent);
        }
    }
}
