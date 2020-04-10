package com.bqiao.consul.external.service;

import com.bqiao.consul.external.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMessages();
    Message getMessage(String id);
    void deleteMessage(String id);
    Message updateMessage(String id, Message toUpdate);
    Message createMessage(Message toCreate);
    String ping();
}
