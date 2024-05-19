package com.example.Myproject.Myproject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Myproject.Myproject.Service.EmployeeService;
import com.example.Myproject.Myproject.model.EmployeeModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService EmpSer;
	
	//Save
	@PostMapping("/save")
	public String create (@RequestBody EmployeeModel EmpModel ) {
		return EmpSer.Data_save(EmpModel);
	}
	
	//Open by id
	@GetMapping("/openById")
	public EmployeeModel find_ById(@RequestParam("id") int id) {
		return EmpSer.find_ById(id);
	}
	//Update
	@PostMapping("/update")
	public String updateValues(@RequestBody EmployeeModel empupval){
		return EmpSer.updateValuesser(empupval);
	}
	
	
	@DeleteMapping("/delete")
	public String delete_ById(@RequestParam("id") int id) {
		return EmpSer.delete_ByIds(id);
	}
	
	@GetMapping("/list")	
	public List<EmployeeModel > getEmployee(){
		return EmpSer.getValues();
	}
}
