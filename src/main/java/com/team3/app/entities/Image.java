package com.team3.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Images")
public class Image {
	@Id
	@Column(name = "id_image")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="id_product")
	private int idProduct;
	@Column(name="link_image")
	private String linkImage;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getLinkImage() {
		return linkImage;
	}
	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}
	
	
}
