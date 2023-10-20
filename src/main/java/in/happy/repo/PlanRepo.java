package in.happy.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity,Serializable> {
	
	public PlanEntity findByCaseNum(Long caseNumber);

}
