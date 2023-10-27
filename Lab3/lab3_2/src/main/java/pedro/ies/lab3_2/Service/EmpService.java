package pedro.ies.lab3_2.Service;


import java.util.List;

import pedro.ies.lab3_2.model.Employee;

public interface EmpService {
    
    Employee creatEmp(Employee emp);

    Employee getEmpById(Long empId);

    List<Employee> getEmpByEmail(String email);

    List<Employee> getAllEmp();

    Employee updateEmp(Employee emp);

    void deleteEmp(Long empId);

}
