package com.bqiao.consul.external.service.impl;

import com.bqiao.consul.external.client.MessageClient;
import com.bqiao.consul.external.domain.Message;
import com.bqiao.consul.external.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {


	private final MessageClient client;

	public MessageServiceImpl(MessageClient client) {
		this.client = client;
	}

	@Override
	public List<Message> getMessages() {
		List<Message> messages = client.findAll();
		return messages;
	}

	@Override
	public Message getMessage(String id) {
		Message found = client.findById(id);
		return found;
	}

	@Override
	public void deleteMessage(String id) {
		client.delete(id);
	}

	@Override
	public Message updateMessage(String id, Message toUpdate) {
		return client.update(id, toUpdate);
	}

	@Override
	public Message createMessage(Message toCreate) {
		if (toCreate == null || StringUtils.isEmpty(toCreate.getMessage())) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "Invalid object");
		}
		return client.create(toCreate);
	}

	@Override
	public String ping() {
		return client.ping();
	}
}
