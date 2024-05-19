package com.example.Myproject.Myproject.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Myproject.Myproject.model.EmployeeModel;
import com.example.Myproject.Myproject.repository.EmployeeRepo;



@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	//save
	public String Data_save(EmployeeModel EmpModel) {
		empRepo.save(EmpModel);
		return "saved Successfully";
	}
	//Open
	public EmployeeModel find_ById(int id) {
		try {
			return empRepo.findById(id).get();
		}catch(Exception e){
			System.out.println( "Invalid Id");
		}
		return null;
	
	}
	//Update
public String updateValuesser(EmployeeModel empupval) {
		
		try {
			EmployeeModel getEmp=empRepo.findById(empupval.getId()).get();
			if(!empupval.getEmp_name().isBlank()) {
			getEmp.setEmp_name(empupval.getEmp_name());
			}
			if(!empupval.getEmp_phone().isBlank()) {
			getEmp.setEmp_num(empupval.getEmp_phone());
			}
			if(!empupval.getEmp_mail().isBlank()) {
				getEmp.setEmp_num(empupval.getEmp_mail());
				}
			empRepo.save(getEmp);
			return "Updated Successfully";
		}catch(Exception e){
			throw e;	
		}
	}

//Delete
public String delete_ByIds(int id) {
	try {
		empRepo.deleteById(id);
		return "Deleted Successfully";
	}catch(Exception e){
		System.out.println( "Invalid Id");
	}
	return null;

}
//List
	public List<EmployeeModel > getValues(){
	return empRepo.findAll();
}
	
}
