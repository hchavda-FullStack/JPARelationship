package io.hitesh.learning.demo;

import io.hitesh.learning.demo.entities.Review;
import io.hitesh.learning.demo.entities.ReviewPK;
import io.hitesh.learning.demo.entities.Student;
import io.hitesh.learning.demo.entities.StudentPermit;
import io.hitesh.learning.demo.repo.StudentPermitRepo;
import io.hitesh.learning.demo.repo.StudentRepo;
import io.hitesh.learning.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class JpaRealtionshipApplication {
	@Autowired
	private StudentService service;

//	@Autowired
//	private StudentRepo repo;
//	@Autowired
//	private StudentPermitRepo studentPermitRepo;
	public static void main(String[] args) {
		SpringApplication.run(JpaRealtionshipApplication.class, args);
	}
	@Bean
//	@Transactional
	CommandLineRunner runner(){
		return args -> {
//			StudentPermit permit = StudentPermit.builder().permitName("FullStack Java").build();
//			Student student = Student.builder().name("Hitesh").funnyName("Hitu").permit(permit).build();
//			System.out.println(studentPermitRepo.save(permit));
//			System.out.println(repo.save(student));
////			System.out.println(repo.findById(2));
//			final Optional<Student> byId = repo.findById(2);
//			byId.ifPresent(System.out::println);
//			byId.map(s->s.getPermit()).ifPresent(System.out::println);
//			service.runCode();
//			service.fetchData();
			StudentPermit permit = StudentPermit.builder().permitName("Learning java").build();
			Student student =
					Student.builder()
					.permit(permit)
					.reviews(
							Arrays.asList(
									Review.builder().reviewPK(new ReviewPK(1,1)).programName("Java").reviewText("Very Happy").build(),
									Review.builder().reviewPK(new ReviewPK(1,2)).programName("DevOps").reviewText("Very Happy").build(),
									Review.builder().reviewPK(new ReviewPK(1,3)).programName("Automation").reviewText("Not Happy").build()
							)
					)
					.name("Ankit")
					.build();
			service.createStudent(student);
			service.createStudent(Student.builder()
					.permit(StudentPermit.builder().permitName("NOT ALLOWED TO WORK !").build())
					.reviews(
							Arrays.asList(
									Review.builder().reviewPK(new ReviewPK(1,4)).programName("Java").reviewText("Very Happy").build(),
									Review.builder().reviewPK(new ReviewPK(1,5)).programName("DevOps").reviewText("Very Happy").build(),
									Review.builder().reviewPK(new ReviewPK(1,6)).programName("Automation").reviewText("Not Happy").build()
							)
					)
					.name("Abhimanyu")
					.build());
			service.createStudent(Student.builder()
					.permit(StudentPermit.builder().permitName("Learning Permit").build())
					.name("Ankush")
					.build());
//			service.deleteStudentByID(1);
		};
	}

}
