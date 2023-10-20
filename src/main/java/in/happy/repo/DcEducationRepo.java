package in.happy.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.DcEducationEntity;

public interface DcEducationRepo extends JpaRepository<DcEducationEntity , Serializable> {
	public DcEducationEntity findByCaseNum(Long caseNumber);
}
