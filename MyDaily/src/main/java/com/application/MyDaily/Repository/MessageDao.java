package com.application.MyDaily.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.MyDaily.domain.Message;

public interface MessageDao extends JpaRepository<Message, Long> {

}
