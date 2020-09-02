package com.application.MyDaily.Services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.MyDaily.Dao.DayDao;
import com.application.MyDaily.Services.DayService;
import com.application.MyDaily.domain.Day;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DayServiceImpl implements DayService {
	
	private final DayDao dayDao;

	@Override
	public Day saveDay(Day day) {
		Day savedDay = dayDao.save(day);
		return savedDay;
	}

	@Override
	public Day findByValue(int value) {
		return dayDao.findByValue(value);
	}

	@Override
	public void deleteDayById(Long id) {
		dayDao.deleteById(id);
	}

	@Override
	public List<Day> findAll() {
		return dayDao.findAll();
	}

}
