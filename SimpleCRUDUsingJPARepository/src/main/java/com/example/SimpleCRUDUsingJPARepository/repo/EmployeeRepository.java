package com.example.SimpleCRUDUsingJPARepository.repo;

import com.example.SimpleCRUDUsingJPARepository.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByAgeGreaterThanEqual(int age);

    @Query("select e from Employee e where e.name = :name and e.email = :email")
   // @Query(value = "select * from employee e where e.employee_name = :name and e.email = :email", nativeQuery = true)
    Employee getByNameAndEmail(String name, String email);
}
