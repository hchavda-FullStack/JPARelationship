package io.hitesh.learning.demo.repo;

import io.hitesh.learning.demo.entities.StudentPermit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPermitRepo extends JpaRepository<StudentPermit, Integer> {

}
