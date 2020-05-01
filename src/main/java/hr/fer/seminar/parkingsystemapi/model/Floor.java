package hr.fer.seminar.parkingsystemapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FLOOR")
public class Floor implements Serializable {

	@Id
	@GeneratedValue(generator = "floor-sequence-generator")
	@SequenceGenerator(name="floor-sequence-generator", sequenceName = "FLOOR_SEQ", allocationSize = 1)
	@Column(name = "FLOOR_ID")
	private Long id;

	@Column(name = "FLOOR_LEVEL")
	private Integer level;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(final Integer level) {
		this.level = level;
	}
}
