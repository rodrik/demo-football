package io.github.rodrik.demo.football.client;

import java.io.IOException;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.github.rodrik.demo.football.client.retrofit.RetrofitFactory;
import io.github.rodrik.demo.football.model.Fixture;
import io.github.rodrik.demo.football.model.FixtureWrapper;
import io.github.rodrik.demo.football.model.Season;
import io.github.rodrik.demo.football.model.Team;
import io.github.rodrik.demo.football.model.TeamWrapper;
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
	
	@Test
	public void testGetTeams() throws IOException {
		
		Call<TeamWrapper> callToTeams = sut.getTeams(399L);
		Assertions.assertThat(callToTeams).isNotNull();
		
		TeamWrapper teamWrapper = callToTeams.execute().body();
		Assertions.assertThat(teamWrapper).isNotNull();
		
		Collection<Team> teams = teamWrapper.getTeams();
		Assertions.assertThat(teams).isNotEmpty();
		
		for (Team team : teams) {
			Assertions.assertThat(team.getCrestUrl()).isNotNull();
			Assertions.assertThat(team.getId()).isNotNull();
			Assertions.assertThat(team.getName()).isNotNull();
			Assertions.assertThat(team.getShortName()).isNotNull();
			Assertions.assertThat(team.getSquadMarketValue()).isNotNull();
			System.out.println(team.toString());
		}
	}
	
	@Test
	public void testGetFixtures() throws IOException {
		
		Call<FixtureWrapper> callToFixtures = sut.getFixtures(399L);
		Assertions.assertThat(callToFixtures).isNotNull();
		
		FixtureWrapper fixtureWrapper = callToFixtures.execute().body();
		Assertions.assertThat(fixtureWrapper).isNotNull();
		
		Collection<Fixture> fixtures = fixtureWrapper.getFixtures();
		Assertions.assertThat(fixtures).isNotEmpty();
		
		for (Fixture fixture : fixtures) {
			Assertions.assertThat(fixture.getId()).isNotNull();
			Assertions.assertThat(fixture.getMatchday()).isNotNull();
			Assertions.assertThat(fixture.getStatus()).isNotNull();
			Assertions.assertThat(fixture.getDate()).isNotNull();
			Assertions.assertThat(fixture.getAwayTeamId()).isNotNull();
			Assertions.assertThat(fixture.getHomeTeamId()).isNotNull();
			System.out.println(fixture.toString());
		}
	}

}
