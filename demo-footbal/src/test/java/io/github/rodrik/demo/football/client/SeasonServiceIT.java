package io.github.rodrik.demo.football.client;

import java.io.IOException;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.github.rodrik.demo.football.client.retrofit.RetrofitFactory;
import io.github.rodrik.demo.football.model.Season;
import retrofit2.Call;

public class SeasonServiceIT {
	
	private static SeasonService sut;
	
	@BeforeClass
	public static void setUp() {
		sut = RetrofitFactory.getSeasonService();
	}
	
	@Before
	public void testThatSutIsRunning() {
		Assertions.assertThat(sut).isNotNull();
	}

	@Test
	public void testGetSeasons() throws IOException {
		
		Call<Collection<Season>> callToSeasons = sut.getSeasons();
		Assertions.assertThat(callToSeasons).isNotNull();
		
		Collection<Season> seasons = callToSeasons.execute().body();
		Assertions.assertThat(seasons).isNotEmpty();
		
		for (Season season : seasons) {
			Assertions.assertThat(season.getId()).isNotNull();
			Assertions.assertThat(season.getCaption()).isNotNull();
			Assertions.assertThat(season.getLeague()).isNotNull();
			Assertions.assertThat(season.getYear()).isNotNull();
			System.out.println(season.toString());
		}
	}

}
