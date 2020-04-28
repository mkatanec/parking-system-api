package hr.fer.seminar.parkingsystemapi.model;

import javax.persistence.*;

@Entity
@Table(name="PARKING_SPACE")
public class ParkingSpace {

	@Id
	@GeneratedValue(generator = "parking-space-sequence-generator")
	@SequenceGenerator(name="PARKING_SPACE_SEQ")
	@Column(name="PARKING_SPACE_ID")
	private Long id;

	@Column(name="PARKING_SPACE_SECTION")
	private String section;

	@Column(name="PARKING_SPACE_NUMBER")
	private Integer spaceNumber;

	@Column(name="PARKING_SPACE_FLOOR")
	private Integer floor;

	@Column(name="PARKING_SPACE_OCCUPIED")
	private Boolean occupied;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getSection() {
		return section;
	}

	public void setSection(final String section) {
		this.section = section;
	}

	public Integer getSpaceNumber() {
		return spaceNumber;
	}

	public void setSpaceNumber(final Integer spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(final Integer floor) {
		this.floor = floor;
	}

	public Boolean getOccupied() {
		return occupied;
	}

	public void setOccupied(final Boolean occupied) {
		this.occupied = occupied;
	}
}
