package io.hitesh.learning.demo.service;

import io.hitesh.learning.demo.entities.Student;
import io.hitesh.learning.demo.entities.StudentPermit;
import io.hitesh.learning.demo.repo.ReviewRepo;
import io.hitesh.learning.demo.repo.StudentPermitRepo;
import io.hitesh.learning.demo.repo.StudentRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
//@NoArgsConstructor
public class StudentService {
    private final StudentRepo repo;
    private final StudentPermitRepo studentPermitRepo;
    private final ReviewRepo reviewRepo;

//    public StudentService(StudentRepo repo, StudentPermitRepo studentPermitRepo) {
//        this.repo = repo;
//        this.studentPermitRepo = studentPermitRepo;
//    }
    public Student createStudent(Student student){
        student.getReviews().stream().forEach(reviewRepo::save);
       return this.repo.save(student);
    }
    public Student updateStudent(Student student){
        return createStudent(student);
    }
    public boolean deleteStudentByID(Integer id){
         Optional<Student> studentOptional = repo.findById(id);
        if (studentOptional.isPresent()) {
            repo.delete(studentOptional.get());
            return true;
        }
        return false;
    }

    public List<Student> finAll() {
        return repo.findAll();
    }
    //    @Autowired
//    @Autowired
//    @Transactional
//    public void runCode(){
//        StudentPermit permit = StudentPermit.builder().permitName("FullStack Java").build();
//			Student student = Student.builder().name("Hitesh").funnyName("Hitu").permit(permit).build();
//			System.out.println(studentPermitRepo.save(permit));
//			System.out.println(repo.save(student));
////			System.out.println(repo.findById(2));
////			final Optional<Student> byId = repo.findById(2);
////			byId.ifPresent(System.out::println);
////			log.info("Student fetched from from DB-->{}"+byId.get());
////            log.info("Permit fetched from from DB-->{}"+byId.get().getPermit());
////			byId.map(s->s.getPermit()).ifPresent(System.out::println);
//    }
//    @Transactional
//    public void fetchData(){
//        Optional<Student> byId = repo.findById(2);
//        byId.ifPresent(System.out::println);
//        log.info("Student fetched from from DB-->{}"+byId.get());
//        log.info("Permit fetched from from DB-->{}"+byId.get().getPermit());
//        byId.map(s->s.getPermit()).ifPresent(System.out::println);
//    }
}
