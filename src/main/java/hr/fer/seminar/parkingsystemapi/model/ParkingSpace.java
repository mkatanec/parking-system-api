package hr.fer.seminar.parkingsystemapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PARKING_SPACE")
public class ParkingSpace implements Serializable {

	@Id
	@GeneratedValue(generator = "parking-space-sequence-generator")
	@SequenceGenerator(name = "parking-space-sequence-generator", sequenceName = "PARKING_SPACE_SEQ", allocationSize = 1)
	@Column(name = "PARKING_SPACE_ID")
	private Long id;

	@Column(name = "PARKING_SPACE_SECTION")
	private String section;

	@Column(name = "PARKING_SPACE_NUMBER")
	private Integer spaceNumber;

	@JoinColumn(name = "PARKING_SPACE_FLOOR")
	@ManyToOne(fetch = FetchType.EAGER)
	private Floor floor;

	@Column(name = "PARKING_SPACE_OCCUPIED")
	private Boolean occupied;

	@Column(name = "PARKING_SPACE_RESERVED")
	private Boolean reserved;

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

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(final Floor floor) {
		this.floor = floor;
	}

	public Boolean getOccupied() {
		return occupied;
	}

	public void setOccupied(final Boolean occupied) {
		this.occupied = occupied;
	}

	public Boolean getReserved() {
		return reserved;
	}

	public void setReserved(final Boolean reserved) {
		this.reserved = reserved;
	}
}
