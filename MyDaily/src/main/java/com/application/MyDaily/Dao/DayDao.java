package com.application.MyDaily.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.MyDaily.domain.Day;

public interface DayDao extends JpaRepository<Day, Long> {
    Day findByValue(int value);
}
