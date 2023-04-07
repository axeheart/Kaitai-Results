package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService{
	@Autowired
	private HelloRepository repository;

	/**従業員を1人取得する*/
	public Employee getEmployee(String id){
		//検索    
		Map<String,Object> map = repository.findById(id);
		
		//Mapから値を取得    
		String employeeId = (String)map.get("id");
		String name = (String)map.get("name");
		int age = (Integer)map.get("age");
		
		//Employeeクラスに値をセット    
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
		
		return employee;
	}
}
		
