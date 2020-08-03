package com.imusica.desafio.rpgbattle.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranking {
    private static HashMap<String, Integer> ranking = new HashMap<>();
    private static Ranking instance = getInstance();

    private Ranking() {
    }

    public static Ranking getInstance() {
        if (instance == null) {
            instance = new Ranking();
        }
        return instance;
    }

    public void add(User user) {
        if (ranking.containsKey(user.getNickname().toLowerCase())) {
            ranking.replace(user.getNickname(), user.getTotalPoints());
        } else {
            ranking.put(user.getNickname(), user.getTotalPoints());
        }
    }

    public HashMap<String, Integer> get() {
        return ranking
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
