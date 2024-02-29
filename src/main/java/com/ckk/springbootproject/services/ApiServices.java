package com.ckk.springbootproject.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ckk.springbootproject.daos.ApiDao;
import com.ckk.springbootproject.models.Student;

@Service
public class ApiServices {

	@Autowired
	private ApiDao apidao;

	public List<Student> allStudents() {

		return apidao.get();

	}

	public List getStuBasedonCha(CharSequence cr) {

		return apidao.get().stream().filter(x -> x.getSname().contains(cr)).collect(Collectors.toList());

	}

	public List getBasedonSalayRange(int s, int e) {

		return apidao.get().stream().filter(x -> x.getSalary() >= s && x.getSalary() <= e).collect(Collectors.toList());

	}

	public Optional<Student> maxSalary() {

		return apidao.get().stream().collect(Collectors.maxBy(Comparator.comparing(Student::getSalary)));

	}

	public Optional<Student> minSalary() {

		return apidao.get().stream().collect(Collectors.minBy(Comparator.comparing(Student::getSalary)));

	}

	public List<Float> salayIncrementList(float i) {

		return apidao.get().stream().map(x -> x.getSalary() * i).collect(Collectors.toList());
	}
}
