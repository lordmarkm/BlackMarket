package com.d3.common.model.items;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class UnidentifiedItem {

	@Id
	private long id;
	
	@Column
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Image image;
}
