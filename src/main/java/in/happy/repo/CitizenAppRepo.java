package in.happy.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.CitizenAppEntity;

public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity, Serializable> {

}
