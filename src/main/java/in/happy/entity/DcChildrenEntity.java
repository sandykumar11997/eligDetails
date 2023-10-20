package in.happy.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "CHILD_ENTRY")
public class DcChildrenEntity {
	
	@Id
	@GeneratedValue
	private Integer childId;
	private Long caseNum;
	private LocalDate doB;
	private Integer childage;
	private Long childSsn;

}
