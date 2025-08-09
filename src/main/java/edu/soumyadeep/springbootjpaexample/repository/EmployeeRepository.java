package edu.soumyadeep.springbootjpaexample.repository;

import edu.soumyadeep.springbootjpaexample.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    //fetches all employees from database
    //persist employees to database
    //updating employees in database
    //find employees
}
