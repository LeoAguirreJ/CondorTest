package com.example.condortest.data.rest.endpoint;

import com.example.condortest.data.model.detail.DataDetail;
import com.example.condortest.data.model.event.DataEvent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TeamEndPoint {

    @GET("searchteams.php")
    Call<DataDetail> getTeam(@Query("t") String name);

    @GET("eventsnext.php")
    Call<DataEvent> getTeamEvents(@Query("id") int idTeam);
}
