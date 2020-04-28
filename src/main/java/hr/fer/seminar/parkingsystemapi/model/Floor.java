package hr.fer.seminar.parkingsystemapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "FLOOR")
public class Floor implements Serializable {

	@Id
	@Column(name = "LEVEL")
	private Integer level;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(final Integer level) {
		this.level = level;
	}
}
