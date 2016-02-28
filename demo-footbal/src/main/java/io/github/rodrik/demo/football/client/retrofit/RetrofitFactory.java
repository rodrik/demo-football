package io.github.rodrik.demo.football.client.retrofit;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.github.rodrik.demo.football.client.SeasonService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitFactory {
	
	private static final String SERVICE_URL = "http://api.football-data.org";

	public static SeasonService getSeasonService() {
		Retrofit retrofit = new Retrofit.Builder()
				.client(httpClient().build())
			    .baseUrl(SERVICE_URL)
			    .addConverterFactory(jacksonConverterFactory())
			    .build();

		SeasonService service = retrofit.create(SeasonService.class);
		return service;
	}

	private static OkHttpClient.Builder httpClient() {
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		httpClient.addInterceptor(headersInterceptor());
		httpClient.addInterceptor(loggingInterceptor());
		return httpClient;
	}

	private static HttpLoggingInterceptor loggingInterceptor() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();  
		logging.setLevel(HttpLoggingInterceptor.Level.BODY);
		return logging;
	}

	private static JacksonConverterFactory jacksonConverterFactory() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		
		return JacksonConverterFactory.create(mapper);
	}
	
	private static final Interceptor headersInterceptor() {
		Interceptor requestInterceptor = new Interceptor() {  
		    @Override
		    public Response intercept(Interceptor.Chain chain) throws IOException {
		        Request original = chain.request();

		        Request request = original.newBuilder()
		            .header("X-Response-Control", "minified")
		            .method(original.method(), original.body())
		            .build();

		        return chain.proceed(request);
		    }
		};
		return requestInterceptor;
	}

}
