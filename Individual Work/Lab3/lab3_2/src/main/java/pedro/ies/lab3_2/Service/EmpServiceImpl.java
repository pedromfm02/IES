package pedro.ies.lab3_2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pedro.ies.lab3_2.Repositories.EmpRepository;
import pedro.ies.lab3_2.model.Employee;

@Service
@AllArgsConstructor
public class EmpServiceImpl implements EmpService{
    
    private EmpRepository empRepository;
    

    @Override
    public Employee creatEmp(Employee emp){
        return empRepository.save(emp);
    }

    @Override
    public Employee getEmpById(Long empId){
        Optional<Employee> optionalEmp = empRepository.findById(empId);
        return optionalEmp.get();
    }

    @Override
    public List<Employee> getEmpByEmail(String email){
        return empRepository.findByEmail(email);
    }

    @Override
    public List<Employee> getAllEmp(){
        return empRepository.findAll();
    }

    @Override
    public Employee updateEmp(Employee emp){
        Employee existingEmp = empRepository.findById(emp.getId()).get();
        existingEmp.setFirstName(emp.getFirstName());
        existingEmp.setLastName(emp.getLastName());
        existingEmp.setEmail(emp.getEmail());
        Employee updatedEmp = empRepository.save(existingEmp);
        return updatedEmp;
    }

    @Override
    public void deleteEmp(Long emoId){
        empRepository.deleteById(emoId);
    }
}
