package com.kaziabid.learn.angular.apiserver.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.github.javafaker.Witcher;
import com.kaziabid.learn.angular.apiserver.dto.WitcherDTO;

import reactor.core.publisher.Flux;

/**
 * @author Kazi Abid
 */
@Service
public class WitcherService {

    private final Faker faker;

    public WitcherService(Faker faker) {
        super();
        this.faker = faker;
    }

    public WitcherDTO getOne() {
        Witcher witcher = new Faker().witcher();
        return WitcherDTO.build(witcher);
    }

    @Cacheable(cacheNames = "dbCache")
    public Flux<WitcherDTO> get(int count) {
        AtomicInteger counter = new AtomicInteger(0);
        Flux<WitcherDTO> flux = Flux.generate(WitcherDTO::NULL, (state, sink) -> {
            WitcherDTO dto = WitcherDTO.NULL();
            sink.next(WitcherDTO.build(faker.witcher()));
            if (counter.addAndGet(1) == count)
                sink.complete();
            return dto;
        });
        flux = flux.filter(w -> w != null);
        return flux;
    }

    @Cacheable(cacheNames = "dbCache")
    public WitcherDTO get(String name) {
        final int MAX_TRY = 100;
        int currTry = 1;
        while (currTry <= MAX_TRY) {
            Witcher witcher = faker.witcher();
            String witcherName = witcher.witcher();
            String witcherLocation = witcher.location();
            String witcherSchool = witcher.school();
            String witcherMonster = witcher.monster();
            if (witcherName.toLowerCase().indexOf(name.toLowerCase()) > -1)
                return WitcherDTO
                        .build(witcherName, witcherSchool, witcherLocation,
                                witcherMonster);
            currTry++;
        }
        return null;
    }

    public WitcherDTO save(WitcherDTO dto) {
        return WitcherDTO.build(dto);
    }
}
