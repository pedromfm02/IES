package pedro.ies.lab3_2.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pedro.ies.lab3_2.Service.EmpService;
import pedro.ies.lab3_2.model.Employee;

@RestController
@AllArgsConstructor
@RequestMapping("/api/lab3_2")
public class EmpController {
    
    private EmpService empService;


    @PostMapping("/employees") // create employee
    public ResponseEntity<Employee> createEmp(@Valid @RequestBody Employee emp){
        Employee savedEmp = empService.creatEmp(emp);
        return new ResponseEntity<>(savedEmp,HttpStatus.CREATED);
    }


    @GetMapping("{id}") // get employee by id
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long empId){
        Employee emp = empService.getEmpById(empId);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @GetMapping("/employees?email={email}") // get employee by email
    public ResponseEntity<List<Employee>> getEmpByEmail(@PathVariable("email") String email){
        List<Employee> emp = empService.getEmpByEmail(email);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @GetMapping("/employees") // get all employees
    public ResponseEntity<List<Employee>> getAllEmp(){
        List<Employee> emp = empService.getAllEmp();
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @PutMapping("{id}") // update employee
    public ResponseEntity<Employee> updateEmp(@PathVariable("id") Long empId, @RequestBody Employee emp){
        emp.setId(empId);
        Employee updatedEmp = empService.updateEmp(emp);
        return new ResponseEntity<>(updatedEmp,HttpStatus.OK);
    }

    @DeleteMapping("{id}") // delete employee
    public ResponseEntity<String> deleteEmp(@PathVariable("id") Long empId){
        empService.deleteEmp(empId);
        return new ResponseEntity<>("Employee successfully deleted!",HttpStatus.OK);
    }
}
