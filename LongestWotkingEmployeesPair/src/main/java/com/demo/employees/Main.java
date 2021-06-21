package com.demo.employees;

import java.io.IOException;

import com.demo.employees.service.FileReader;
import com.demo.employees.service.impl.CalculatorImpl;
import com.demo.employees.service.impl.FileReaderImpl;

public class Main {
	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReaderImpl(new CalculatorImpl());
		reader.readFile("src/main/resources/uploads/employees-projects.txt");
	}
}
