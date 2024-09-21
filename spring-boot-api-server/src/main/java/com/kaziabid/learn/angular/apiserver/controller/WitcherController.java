package com.kaziabid.learn.angular.apiserver.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaziabid.learn.angular.apiserver.dto.WitcherDTO;
import com.kaziabid.learn.angular.apiserver.service.WitcherService;

import reactor.core.publisher.Flux;

/**
 * @author Kazi Abid
 */
@RestController
@RequestMapping(path = "/witchers")
@CrossOrigin(origins = "*")
public class WitcherController {

    private final WitcherService witcherService;

    public WitcherController(WitcherService witcherService) {
        super();
        this.witcherService = witcherService;
    }

    @GetMapping(path = "/any")
    public WitcherDTO getOne() {
        return witcherService.getOne();
    }

    @GetMapping
    public Flux<WitcherDTO> get(@RequestParam(required = false) Integer num) {
        num = num != null ? num : 50;
        return witcherService.get(num);
    }

    @GetMapping("{name}")
    public WitcherDTO getOne(@PathVariable String name) {
        return witcherService.get(name);
    }

    @PostMapping
    public WitcherDTO post(@RequestBody WitcherDTO dto) {
        return witcherService.save(dto);
    }
}
