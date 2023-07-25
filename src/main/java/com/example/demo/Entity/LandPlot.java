package com.example.demo.Entity;
import java.time.LocalTime;
import jakarta.persistence.*;
@Entity
public class LandPlot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private Integer areaInFeddan;
	private LocalTime timeSlot;
	private int xCoordinate;
	private int yCoordinate;
	@OneToOne
	private Crop crop;

	public LandPlot() {
		super();
	}

	public LandPlot(Long id, Integer areaInFeddan, LocalTime timeSlot, int xCoordinate, int yCoordinate, Crop crop) {
		super();
		this.id = id;
		this.areaInFeddan = areaInFeddan;
		this.timeSlot = timeSlot;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.crop = crop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAreaInFeddan() {
		return areaInFeddan;
	}

	public void setAreaInFeddan(Integer areaInFeddan) {
		this.areaInFeddan = areaInFeddan;
	}

	public LocalTime getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(LocalTime timeSlot) {
		this.timeSlot = timeSlot;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public void setYCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

}
