package com.example.em_project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
 //@RequestMapping("/api/items")
//@CrossOrigin(origins = "http://localhost:3000/")
//@CrossOrigin(" Access-Control-Allow-Origin:http://localhost:3000/") 

/*@CrossOrigin("         Access-Control-Allow-Origin: http://localhost:3000/\n" + //
    "        //Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS\n" + //
    "        Access-Control-Allow-Headers: Content-Type, Authorization") 
*/


@CrossOrigin("http://localhost:3000/")


//@CrossOrigin("Access-Control-Allow-Origin: *")
public class Controller {
  @Autowired
    EmployeeService employeeService = new EmployeeServiceImpl();  


@GetMapping("employees")
public List<Employee> getAllEmployees()
{   
    System.out.println("in controller");
     return employeeService.readEmployees();
}

@GetMapping("employees/{id}")
public Employee getAllEmployeesById(@PathVariable Long id)
{   
    System.out.println("in controller");
     return employeeService.readEmployee(id);
}


@PostMapping("employees")
public String createEmployee(@RequestBody Employee employee) {
     System.out.println("in controller post");
    employeeService.createEmployee(employee);
    return "Saved Successfully";
}

@DeleteMapping("employees/{id}")
public String deleteEmployee(@PathVariable Long id) {

  
    if (employeeService.deleteEmployee(id)) {
        return "Deleted Successfully";
      }
      else{
    return "Employee not found";
      }
}


@PutMapping("employees/{id}")
public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) 
{
    
    
    return employeeService.updateEmployee(id, employee);
}
}