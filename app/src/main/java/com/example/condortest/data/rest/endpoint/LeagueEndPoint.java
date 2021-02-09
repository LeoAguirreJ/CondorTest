package com.example.condortest.data.rest.endpoint;

import com.example.condortest.data.model.teams.Data;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LeagueEndPoint {

    @GET("lookup_all_teams.php")
    Call<Data> getTeamList( @Query("id") int id);

    @GET("lookup_all_teams.php")
    Single<Data> getTeamListS(@Query("id") int id);
}
