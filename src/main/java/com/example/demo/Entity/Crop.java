package com.example.demo.Entity;
import jakarta.persistence.*;
@Entity
public class Crop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String cropName;
	private float waterPerFeddan;
	private float minutesPerFeddan;

	public Crop() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Crop(Long id, String cropName, float waterPerFeddan, float minutesPerFeddan) {
		super();
		this.id = id;
		this.cropName = cropName;
		this.waterPerFeddan = waterPerFeddan;
		this.minutesPerFeddan = minutesPerFeddan;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public float getWaterPerFeddan() {
		return waterPerFeddan;
	}

	public void setWaterPerFeddan(float waterPerFeddan) {
		this.waterPerFeddan = waterPerFeddan;
	}

	public float getMinutesPerFeddan() {
		return minutesPerFeddan;
	}

	public void setMinutesPerFeddan(float minutesPerFeddan) {
		this.minutesPerFeddan = minutesPerFeddan;
	}

}
