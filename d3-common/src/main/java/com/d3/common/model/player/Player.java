package com.d3.common.model.player;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

import com.d3.common.model.items.Image;

@Entity
@Table(name="player")
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private String username;
	
	@Column
	private String btag;
	
	@Column
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Image image;

	@Override
	public String toString() {
		return new ToStringCreator(this)
			.append("username", username)
			.append("btag", btag)
			.append("password", password)
			.toString();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
