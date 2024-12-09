package gfg.org.MinorProject1.Digital.Library.repository;

import gfg.org.MinorProject1.Digital.Library.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student , Integer> {
    List<Student> findByName(String value);

    List<Student> findByEmail(String value);

    Student findByStudentId(UUID uuid);


}
