package com.kaziabid.learn.angular.apiserver.controller;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaziabid.learn.angular.apiserver.dto.Message;

/**
 * @author Kazi Abid
 */
@RestController
@RequestMapping(path = "/message")
public class MesageController {

    @GetMapping
    @Cacheable(cacheNames = "itemCache")
    public List<Message> getAll() {
        return Message.generateMessages(50);
    }
}
