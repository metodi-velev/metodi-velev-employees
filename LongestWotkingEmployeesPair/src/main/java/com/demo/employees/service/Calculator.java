package com.demo.employees.service;

import java.util.List;

import com.demo.employees.model.Colleagues;
import com.demo.employees.model.Data;

public interface Calculator {
	public void calculateLongestWorkingTeam(Data[] data);
	public void clearColleaguesList();
	public Colleagues getLongestWorkingTeam();
	public List<Colleagues> getColleaguesList();
}
