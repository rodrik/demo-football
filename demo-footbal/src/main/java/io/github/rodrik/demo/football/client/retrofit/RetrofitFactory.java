package io.github.rodrik.demo.football.client.retrofit;

import io.github.rodrik.demo.football.client.SeasonService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitFactory {
	
	private static final String SERVICE_URL = "http://api.football-data.org";

	public static SeasonService getSeasonService() {
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl(SERVICE_URL)
			    .addConverterFactory(JacksonConverterFactory.create())
			    .build();

		SeasonService service = retrofit.create(SeasonService.class);
		return service;
	}

}
