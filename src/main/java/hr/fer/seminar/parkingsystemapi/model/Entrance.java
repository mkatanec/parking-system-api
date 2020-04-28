package hr.fer.seminar.parkingsystemapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ENTRANCE")
public class Entrance implements Serializable {

	@Id
	@GeneratedValue(generator = "entrance-sequence-generator")
	@SequenceGenerator(name="entrance-sequence-generator", sequenceName = "ENTRANCE_SEQ", allocationSize = 1)
	@Column(name="ENTRANCE_ID")
	private Long id;

	@Column(name="ENTRANCE_NAME")
	private String entranceName;

	@JoinColumn(name="ENTRANCE_FLOOR")
	@ManyToOne(fetch = FetchType.EAGER)
	private Floor floor;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getEntranceName() {
		return entranceName;
	}

	public void setEntranceName(final String entranceName) {
		this.entranceName = entranceName;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(final Floor floor) {
		this.floor = floor;
	}
}
