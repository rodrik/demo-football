package io.github.rodrik.demo.football.client.retrofit;

import io.github.rodrik.demo.football.client.SeasonService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitFactory {
	
	private static final String SERVICE_URL = "http://api.football-data.org";

	public static SeasonService getSeasonService() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();  
		logging.setLevel(HttpLoggingInterceptor.Level.BODY);
		
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();  
		httpClient.addInterceptor(logging);
		
		Retrofit retrofit = new Retrofit.Builder()
				.client(httpClient.build())
			    .baseUrl(SERVICE_URL)
			    .addConverterFactory(JacksonConverterFactory.create())
			    .build();

		SeasonService service = retrofit.create(SeasonService.class);
		return service;
	}

}
