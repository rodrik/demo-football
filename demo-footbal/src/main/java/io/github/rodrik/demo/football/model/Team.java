package io.github.rodrik.demo.football.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Team {

	private Long id;
	private String name;
    private String code;
    private String shortName;
    private String squadMarketValue;
    private String crestUrl;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getSquadMarketValue() {
		return squadMarketValue;
	}
	public void setSquadMarketValue(String squadMarketValue) {
		this.squadMarketValue = squadMarketValue;
	}
	public String getCrestUrl() {
		return crestUrl;
	}
	public void setCrestUrl(String crestUrl) {
		this.crestUrl = crestUrl;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
    	
}
