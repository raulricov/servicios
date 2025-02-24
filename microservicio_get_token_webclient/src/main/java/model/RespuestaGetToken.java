package model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"auth-vivelibre-token", "date"})
public class RespuestaGetToken {

	@JsonProperty("auth-vivelibre-token")
	private String authVivelibreToken;
	private String date;
	
	public RespuestaGetToken() {
		super();
	}
	
	public RespuestaGetToken(String authVivelibreToken, String date) {
		super();
		this.authVivelibreToken = authVivelibreToken;
		this.date = date;
	}

	public String getAuthVivelibreToken() {
		return authVivelibreToken;
	}

	public void setAuthVivelibreToken(String authVivelibreToken) {
		this.authVivelibreToken = authVivelibreToken;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	
}