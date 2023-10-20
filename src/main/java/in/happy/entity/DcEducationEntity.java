package in.happy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DC_EDUCATION")
public class DcEducationEntity {
	
	@Id
	@GeneratedValue
	private Integer caseId;
	private Long caseNum;
	private String qualification;
	private Integer graduationYear;
	

}
