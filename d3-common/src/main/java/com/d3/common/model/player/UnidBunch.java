package com.d3.common.model.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.d3.common.model.items.UnidentifiedItem;

@Entity
@Table(name = "unids")
public class UnidBunch {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Player owner;
	
	@ManyToOne
	private UnidentifiedItem item;
	
	@Column
	private double price;

	@Column
	private int quantity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public UnidentifiedItem getItem() {
		return item;
	}

	public void setItem(UnidentifiedItem item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
