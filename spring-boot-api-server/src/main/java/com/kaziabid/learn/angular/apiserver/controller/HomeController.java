package com.kaziabid.learn.angular.apiserver.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kazi Abid
 */
@RestController
@RequestMapping(path = "/")
public class HomeController {

    @GetMapping
    public Object home() {
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "Up!");
        response.put("message", "Angular Api Server is Up and Running!");
        return response;
    }
}
