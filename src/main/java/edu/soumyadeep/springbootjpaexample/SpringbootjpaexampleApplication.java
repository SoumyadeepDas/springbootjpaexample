package edu.soumyadeep.springbootjpaexample;

import edu.soumyadeep.springbootjpaexample.models.Employee;
import edu.soumyadeep.springbootjpaexample.models.EmployeeType;
import edu.soumyadeep.springbootjpaexample.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootjpaexampleApplication {

    @Autowired
    EmployeeRepository employeeRepository;

//    @PersistenceUnit //This annotation indicates we need a PersistenceUnit bean to be injected.
//    private EntityManagerFactory emf;

//    @PersistenceContext
//    private EntityManager entityManager;
    //This is a shared entity manager. This is a problem as it is not thread safe and we even can't create
    //transactions on this entity manager.

//    @PersistenceContext(type = PersistenceContextType.EXTENDED)
//    private EntityManager entityManager;
    //This is a thread-safe entity manager. We can create transactions on this entity manager.
    //This is also not recommended.

	public static void main(String[] args) {
        SpringApplication.run(SpringbootjpaexampleApplication.class, args);
	}

    @PostConstruct
    @Transactional(readOnly = true)
    public void start(){
 //       Employee employee1 = new Employee();
//        employee1.setName("Rajiv");
//        employee1.setSsn("123-456-789");
//        employee1.setType(EmployeeType.FULL_TIME);
//        employee1.setDateOfBirth(LocalDate.of(1990, 1, 1));

//        EntityManager entityManager = emf.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.persist(employee1);
//        transaction.commit();


        Optional<Employee> employee1 = employeeRepository.findById(1);
        if (employee1.isPresent()) {
            System.out.println("Employee found: " + employee1.get());
            updateEmployee(employee1.get());
        } else {
            System.out.println("Employee not found");
        }

    }


    @Transactional(rollbackFor = SQLException.class)
    protected void updateEmployee(Employee employee) {
        employee.setName("Soumyadeep");
        employeeRepository.save(employee);
    }
}
