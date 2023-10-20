package in.happy.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.PlanCategoryEntity;

public interface PlanCategoryRepo extends JpaRepository<PlanCategoryEntity,Serializable> {

}
