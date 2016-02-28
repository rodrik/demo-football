package io.github.rodrik.demo.football.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FixtureWrapper {

	private Collection<Fixture> fixtures;

	public Collection<Fixture> getFixtures() {
		return fixtures;
	}
	public void setFixtures(Collection<Fixture> teams) {
		this.fixtures = teams;
	}
}
