package hr.fer.seminar.parkingsystemapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractResponse {

	private String error;

	public String getError() {
		return error;
	}

	public void setError(final String error) {
		this.error = error;
	}
}
