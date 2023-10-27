package pedro.ies.lab3_2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pedro.ies.lab3_2.model.Employee;
import java.util.List;


@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>{

    List<Employee> findByEmail(String email);
}