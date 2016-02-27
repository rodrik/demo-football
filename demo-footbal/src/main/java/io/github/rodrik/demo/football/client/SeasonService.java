package io.github.rodrik.demo.football.client;

import java.util.Collection;

import io.github.rodrik.demo.football.model.Season;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SeasonService {

	@GET("soccerseasons")
	Call<Collection<Season>> getSeasons();
}
