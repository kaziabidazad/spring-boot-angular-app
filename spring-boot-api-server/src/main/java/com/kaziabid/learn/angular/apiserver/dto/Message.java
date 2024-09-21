package com.kaziabid.learn.angular.apiserver.dto;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.github.javafaker.Witcher;

/**
 * @author Kazi Abid
 */
public record Message(String name, String email, String message) {
    public static List<Message> generateMessages(int numMessages) {
        Faker faker = Faker.instance(new SecureRandom());
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < numMessages; i++) {
            Witcher witcher = faker.witcher();
            String fullname = witcher.character();
            String email = faker.bothify(fullname + "_??_###@gmail.com");
            String message = witcher.monster();
            messages.add(new Message(fullname, email, message));
        }
        System.out.println("in generateMessages()");
        return messages;
    }

    public static Message generateMessage() {
        return generateMessages(1).get(0);
    }
}
