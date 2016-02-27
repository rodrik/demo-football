package io.github.rodrik.demo.football.client;

import java.util.Collection;

import io.github.rodrik.demo.football.model.Season;
import io.github.rodrik.demo.football.model.TeamWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SeasonService {

	@GET("soccerseasons")
	Call<Collection<Season>> getSeasons();
	
	@GET("soccerseasons/{id}/teams")
	Call<TeamWrapper> getTeams(@Path("id") Long id);
}
