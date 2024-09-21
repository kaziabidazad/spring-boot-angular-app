package com.kaziabid.learn.angular.apiserver.dto;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.javafaker.Witcher;

/**
 * @author Kazi Abid
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public record WitcherDTO(
        Integer id, String name, String school, String location, String monsterKilled) {

    private static final Random random = new SecureRandom();
    public static WitcherDTO NULL() {
        return new WitcherDTO(null, null, null, null, null);
    }

    public static WitcherDTO build(String name, String schoool, String location,
            String monsterKilled) {
        return new WitcherDTO(random.nextInt(1, 10000), name, schoool, location,
                monsterKilled);
    }

    public static WitcherDTO build(Integer id, String name, String schoool,
            String location, String monsterKilled) {
        return new WitcherDTO(id, name, schoool, location, monsterKilled);
    }

    public static WitcherDTO build(WitcherDTO witcher) {
        return new WitcherDTO(random.nextInt(1, 10000), witcher.name(), witcher.school(),
                witcher.location(), witcher.monsterKilled());
    }

    public static WitcherDTO build(Witcher witcher) {
        return new WitcherDTO(random.nextInt(1, 10000), witcher.witcher(),
                witcher.school(), witcher.location(), witcher.monster());
    }

    public static WitcherDTO build(Integer id, Witcher witcher) {
        return new WitcherDTO(id, witcher.witcher(), witcher.school(), witcher.location(),
                witcher.monster());
    }

    public static List<WitcherDTO> build(List<Witcher> witchers) {
        List<WitcherDTO> witcherDTOs = new ArrayList<>();
        int id = 1;
        for (Witcher witcher : witchers)
            witcherDTOs.add(build(id++, witcher));
        return witcherDTOs;
    }
}
