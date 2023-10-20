package in.happy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "DC_CASES")
public class DcCaseEntity {
	
	@Id
	@GeneratedValue
	private Long caseNum;
	private Integer appId;
	private Integer planId;

}
