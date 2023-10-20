package in.happy.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.DcChildrenEntity;

public interface DcChildrenRepo extends JpaRepository<DcChildrenEntity, Serializable> {
	public List<DcChildrenEntity> findByCaseNum(Long caseNumber);
}
