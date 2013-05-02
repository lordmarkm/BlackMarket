package com.d3.web.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RegForm {

	@NotNull
	@Min(6)
	private String btag;
	
	@NotNull
	private String password;

	public String getBtag() {
		return btag;
	}

	public void setBtag(String btag) {
		this.btag = btag;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
