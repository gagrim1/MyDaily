package com.application.MyDaily.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.MyDaily.Repository.MessageDao;
import com.application.MyDaily.domain.Message;

@Controller
public class MainController {
	
	@Autowired
	private MessageDao mesDao;
    
	@GetMapping("/greeting")
    public String greeting(Map<String, Object> model) {
		Iterable<Message> messages = mesDao.findAll();
		model.put("messages", messages);
    	return "Note";
    }
	
	@PostMapping("/greeting")
	public String write(
			@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
		Message message = new Message(text, tag);
		mesDao.save(message);
		
		Iterable<Message> messages = mesDao.findAll();
		model.put("messages", messages);
		return "Note";
	}
	
	@PostMapping("filter")
	public String filter(@RequestParam String filter, Map<String, Object> model) {
		Iterable<Message> messages;
		if(filter != null && !filter.isEmpty()) {
			messages = mesDao.findByTag(filter);
		}else {
			messages = mesDao.findAll();
		}
		
		model.put("messages", messages);
		return "Note";
	}
}
