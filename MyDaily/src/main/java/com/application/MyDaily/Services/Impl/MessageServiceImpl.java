package com.application.MyDaily.Services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.MyDaily.Dao.MessageDao;
import com.application.MyDaily.Services.MessageService;
import com.application.MyDaily.domain.Message;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
	
	private final MessageDao mesDao;

	@Override
	public Message saveMessage(Message message) {
		Message savedMessage = mesDao.save(message);
		return savedMessage;
	}

	@Override
	public List<Message> findByTag(String tag) {
		return mesDao.findByTag(tag);
	}

	@Override
	public void deleteMessageById(Long id) {
		mesDao.deleteById(id);
		
	}

	@Override
	public List<Message> findAll() {
		return mesDao.findAll();
	}

}
