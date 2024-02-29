package com.ckk.springbootproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ckk.springbootproject.models.Student;
import com.ckk.springbootproject.services.ApiServices;

@RestController
public class ApiRestController {

	@Autowired
	private ApiServices apiServices;

	@GetMapping("/get-allstudent/")
	public List<Student> findStudent() {

		return apiServices.allStudents();
	}

	@GetMapping("/searchname/{cr}")
	public List getsearchname(@PathVariable CharSequence cr) {

		return apiServices.getStuBasedonCha(cr);
	}

	@GetMapping("/get-ListBasedonSalayRange/{s}/{e}/")
	public List ListBasedonSalayRange(@PathVariable int s, @PathVariable int e) {

		return apiServices.getBasedonSalayRange(s, e);
	}
	
	@GetMapping("/get-maxsalary/")
	public Optional<Student> maxsalary() {

		return apiServices.maxSalary();
	}
	
	@GetMapping("/get-minsalary/")
	public Optional<Student> minsalary() {

		return apiServices.minSalary();
	}
	
	@GetMapping("/get-salayIncrement/{i}")
	public List<Float> salayIncrementList(@PathVariable float i) {
		System.out.println(i);

		return apiServices.salayIncrementList(i);
	}

}
