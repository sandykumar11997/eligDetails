package in.happy.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Plan_Category")
public class PlanCategoryEntity {

	@Id
	@GeneratedValue
	@Column(name = "CategoryId")
	private Integer categoryId;

	@Column(name = "Category_Name")
	private String categoryName;

	@Column(name = " Active_Sw")
	private String activeSw;

	@Column(name = " Created_by")
	private String createdBy;

	@Column(name = " Updated_By")
	private String updatedBy;

	@Column(name = " Created_Date", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;

	@Column(name = " Updated_Date", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;

}
