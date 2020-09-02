package com.application.MyDaily.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.application.MyDaily.Repository.MessageDao;
import com.application.MyDaily.domain.Message;

@RestController
public class MainController {
	
	@Autowired
	private MessageDao mesDao;
    
	@GetMapping("/greeting")
    public ModelAndView greeting() {
		Iterable<Message> messages = mesDao.findAll();
		ModelAndView mav = new ModelAndView("Note");
		mav.addObject("messages", messages);
    	return mav;
    }
	
	@PostMapping("/greeting")
	public ModelAndView write(@RequestParam String text, @RequestParam String tag) {
		Message message = new Message(text, tag);
		mesDao.save(message);
		
		Iterable<Message> messages = mesDao.findAll();
		ModelAndView mav = new ModelAndView("Note");
		mav.addObject("messages", messages);
		return mav;
	}
	
	@PostMapping("filter")
	public ModelAndView filter(@RequestParam String filter) {
		Iterable<Message> messages;
		if(filter != null && !filter.isEmpty()) {
			messages = mesDao.findByTag(filter);
		}else {
			messages = mesDao.findAll();
		}
		ModelAndView mav = new ModelAndView("Note");
		mav.addObject("messages", messages);
		return mav;
	}
	
	@PostMapping("/delete/filter")
	public ModelAndView filterRe(@RequestParam String filter) {
	    ModelAndView mav = new ModelAndView("Note");
	    Iterable<Message> messages;
		if(filter != null && !filter.isEmpty()) {
			messages = mesDao.findByTag(filter);
		}else {
			messages = mesDao.findAll();
		}
		mav.addObject("messages", messages);
	    return mav;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		mesDao.deleteById(id);
		Iterable<Message> messages = mesDao.findAll();
		ModelAndView mav = new ModelAndView("Note");
		mav.addObject("messages", messages);
		return mav;
	}
	@PostMapping("/delete/greeting")
	public ModelAndView ret(@RequestParam String text, @RequestParam String tag) {
		ModelAndView mav = new ModelAndView("Note");
		Message message = new Message(text, tag);
		mesDao.save(message);
		
		Iterable<Message> messages = mesDao.findAll();
		mav.addObject("messages", messages);
		return mav;
	}
}
