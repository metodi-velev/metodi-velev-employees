package com.demo.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.employees.service.Calculator;
import com.demo.employees.service.FileReader;
import com.demo.employees.service.impl.CalculatorImpl;
import com.demo.employees.service.impl.FileReaderImpl;

@Component
public class MyRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Calculator calculator = new CalculatorImpl();
		FileReader reader = new FileReaderImpl(calculator);
		reader.readFile("src/main/resources/uploads/employees-projects.txt");
		calculator.getLongestWorkingTeam();
	}
}
