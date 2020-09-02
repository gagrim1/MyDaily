package com.application.MyDaily.Services;

import java.util.List;

import com.application.MyDaily.domain.Message;

public interface MessageService {
    
	Message saveMessage(Message message);
	List<Message> findByTag(String tag);
	void deleteMessageById(Long id);
	List<Message> findAll();
}
