package com.d3.common.model.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

import com.d3.common.model.items.Image;

@Entity
@Table(name="player")
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String username;
	
	@Column
	private String btag;
	
	@Column
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Image image;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<UnidBunch> unids;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<UnidBunch> getUnids() {
		if(null == unids) unids = new ArrayList<UnidBunch>();
		return unids;
	}

	public void setUnids(List<UnidBunch> unids) {
		this.unids = unids;
	}
	
}
