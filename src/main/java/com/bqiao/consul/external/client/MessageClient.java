package com.bqiao.consul.external.client;

import com.bqiao.consul.external.domain.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("consul-internal")
public interface MessageClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/message/{id}")
    Message findById(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/message")
    List<Message> findAll();

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/message", consumes = "application/json")
    Message create(Message message);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/message/{id}", consumes = "application/json")
    Message update(@PathVariable("id") String id, Message message);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/message/{id}")
    void delete(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/message/ping")
    String ping();
}
