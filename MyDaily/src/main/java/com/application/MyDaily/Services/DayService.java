package com.application.MyDaily.Services;

import java.util.List;

import com.application.MyDaily.domain.Day;

public interface DayService {
	Day saveDay(Day day);
    Day findByValue(int value);
    void deleteDayById(Long id);
    List<Day> findAll();
}
