package com.demo.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.employees.service.FileReader;

@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	private FileReader fileReader;

    @Override
    public void run(String... args) throws Exception 
    {
       fileReader.readFile("src/main/resources/uploads/employees-projects.txt");
    }
}
