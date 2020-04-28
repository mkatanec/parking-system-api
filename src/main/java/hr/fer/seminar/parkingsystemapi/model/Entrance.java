package hr.fer.seminar.parkingsystemapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ENTRANCE")
public class Entrance implements Serializable {

	@Id
	@GeneratedValue(generator = "entrance-sequence-generator")
	@SequenceGenerator(name="ENTRANCE_SEQ")
	@Column(name="ENTRANCE_ID")
	private Long id;
	@Column(name="ENTRANCE_NAME")
	private String entranceName;
	@Column(name="ENTRANCE_FLOOR")
	private Integer floor;

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

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(final Integer floor) {
		this.floor = floor;
	}
}
