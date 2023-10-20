package in.happy.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.EligDetails;

public interface EligyDetailsRepo extends JpaRepository<EligDetails,Serializable> {

}
