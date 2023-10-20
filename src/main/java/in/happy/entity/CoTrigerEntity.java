package in.happy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CO_TRIGGERS")
@Data
public class CoTrigerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trgId;
	
	private Long caseNum;
	
	@Lob
	private byte[] copdf;
	
	private String trgStatus;
	

}
