package com.demo.employees.service.impl;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.employees.model.Colleagues;
import com.demo.employees.model.Data;
import com.demo.employees.service.Calculator;

@Service
public class CalculatorImpl implements Calculator {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	private List<Colleagues> colleaguesList = new ArrayList<>();

	@Override
	public void calculateLongestWorkingTeam(Data[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if ((data[i].getEmployeeID() != data[j].getEmployeeID())
						&& (data[i].getProjectID() == data[j].getProjectID())) {
					Data e1 = data[i];
					Data e2 = data[j];
					LocalDate e1From = e1.getDateFrom();
					LocalDate e1To = e1.getDateTo();
					LocalDate e2From = e2.getDateFrom();
					LocalDate e2To = e2.getDateTo();
					if (!((e1To.isBefore(e2From) || e1To.equals(e2From))
							|| (e1From.isAfter(e2To) || e1From.equals(e2To)))) {
						long daysWorkTogether = 0;
						if (e2From.isBefore(e1From) && e1From.isBefore(e2To) && e2To.isBefore(e1To))
							daysWorkTogether += ChronoUnit.DAYS.between(e1From, e2To);
						else if (e1From.isBefore(e2From) && e2From.isBefore(e1To) && e1To.isBefore(e2To))
							daysWorkTogether += ChronoUnit.DAYS.between(e2From, e1To);
						else if ((e1From.isBefore(e2From) || e1From.equals(e2From))
								&& (e2To.isBefore(e1To) || e2To.equals(e1To)))
							daysWorkTogether += ChronoUnit.DAYS.between(e2From, e2To);
						else if ((e2From.isBefore(e1From) || e2From.isBefore(e1From)) && e1To.isBefore(e2To))
							daysWorkTogether += ChronoUnit.DAYS.between(e1From, e1To);
						else if (e1From.equals(e2From) && e1To.equals(e2To))
							daysWorkTogether += ChronoUnit.DAYS.between(e1From, e1To);
						Colleagues colleagues = new Colleagues(e1.getEmployeeID(), e2.getEmployeeID(),
								e2.getProjectID(), daysWorkTogether);
						colleaguesList.add(colleagues);
					}
				}
			}
		}
	}

	@Override
	public void clearColleaguesList() {
		colleaguesList.clear();
	}

	@Override
	public Colleagues getLongestWorkingTeam() {
		Map<Colleagues, Long> multipleFieldsMap = colleaguesList.stream().collect(Collectors.groupingBy(
				col -> new Colleagues(col.getEmpId1(), col.getEmpId2()), Collectors.summingLong(Colleagues::getDays)));
		Colleagues longestWorkingTeam = multipleFieldsMap.entrySet().stream().max(Map.Entry.comparingByValue()).get()
				.getKey();
		Long days = multipleFieldsMap.get(longestWorkingTeam);
		return new Colleagues(longestWorkingTeam.getEmpId1(), longestWorkingTeam.getEmpId2(), days);
	}

	@Override
	public List<Colleagues> getColleaguesList() {
		return colleaguesList.stream().sorted(comparing(Colleagues::getDays).reversed()).collect(toList());
	}

}
