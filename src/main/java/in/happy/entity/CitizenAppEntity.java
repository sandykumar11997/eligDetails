package in.happy.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class CitizenAppEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	private String name;
	private String mail;
	private Long number;
	private LocalDate doB;
	private Integer age;
	private String gender;
	private Long ssn;
	private String stateName;
	private LocalDate createdDate;
	private LocalDate updatedDate;
}
