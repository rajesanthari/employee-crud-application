package com.ranthari.app.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7458788956232589777L;

	private final String token;

	public String getToken() {
		return token;
	}

}
