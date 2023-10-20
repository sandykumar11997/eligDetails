package in.happy.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.CoTrigerEntity;

public interface CotrigerRepo extends JpaRepository<CoTrigerEntity,Serializable> {

}
