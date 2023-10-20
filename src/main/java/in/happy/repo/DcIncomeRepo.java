package in.happy.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.DcIncomeEntity;

public interface DcIncomeRepo extends JpaRepository<DcIncomeEntity , Serializable> {
	DcIncomeEntity findByCaseNum(Long CaseNum);
}
