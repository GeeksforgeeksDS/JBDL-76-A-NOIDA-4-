package gfg.org.SpringJDBCTemplateJbdl.repository;

import gfg.org.SpringJDBCTemplateJbdl.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Student save(Student student) {
        String sql = "insert into student(NAME, AGE, ADDRESS) values(?,?,?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge(),student.getAddress() );
        return student;
    }

    public Student getByID(int id) {
        String sql = "select * from student where id = ?";
         return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
    }


    public List<Student> getAll() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }


    public Student update(Student student, int id) {
        String sql = "update student set name = ?, age = ?, address = ? where id = ?";
         jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getAddress(), id);
         return student;
    }


    public String delete(int id) {
        String sql = "delete from student where id = ?";
        jdbcTemplate.update(sql, id);
        return "Deleted Successfully";
    }
}
