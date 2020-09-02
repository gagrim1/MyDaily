package com.application.MyDaily.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.MyDaily.Services.Impl.DayServiceImpl;
import com.application.MyDaily.domain.Day;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DayController {
	
	private final DayServiceImpl dayServ;
    
	@GetMapping("/day")
	public List<Day> findAll(){
		return dayServ.findAll();
	}
}
