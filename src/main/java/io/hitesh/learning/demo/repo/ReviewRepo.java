package io.hitesh.learning.demo.repo;

import io.hitesh.learning.demo.entities.Review;
import io.hitesh.learning.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Integer> {

}
