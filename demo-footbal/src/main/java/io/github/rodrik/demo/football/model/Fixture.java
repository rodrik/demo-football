package io.github.rodrik.demo.football.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Fixture {

	private Long id;
    private String date;
    private String status;
    private Integer matchday;
    private Long homeTeamId;
    private Long awayTeamId;
    
    private Long goalsHomeTeam;
    private Long goalsAwayTeam;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getMatchday() {
		return matchday;
	}
	public void setMatchday(Integer matchday) {
		this.matchday = matchday;
	}
	public Long getHomeTeamId() {
		return homeTeamId;
	}
	public void setHomeTeamId(Long homeTeamId) {
		this.homeTeamId = homeTeamId;
	}
	public Long getAwayTeamId() {
		return awayTeamId;
	}
	public void setAwayTeamId(Long awayTeamId) {
		this.awayTeamId = awayTeamId;
	}
	public Long getGoalsHomeTeam() {
		return goalsHomeTeam;
	}
	public void setGoalsHomeTeam(Long goalsHomeTeam) {
		this.goalsHomeTeam = goalsHomeTeam;
	}
	public Long getGoalsAwayTeam() {
		return goalsAwayTeam;
	}
	public void setGoalsAwayTeam(Long goalsAwayTeam) {
		this.goalsAwayTeam = goalsAwayTeam;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
