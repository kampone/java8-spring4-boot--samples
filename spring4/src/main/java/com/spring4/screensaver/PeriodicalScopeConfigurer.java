package com.spring4.screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.*;
import static java.time.LocalTime.now;

/**
 * Created by Uladzislau_Kaminski on 2/15/2017.
 */
@Component
public class PeriodicalScopeConfigurer implements Scope {

    Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (map.containsKey(s)){
            Pair<LocalTime, Object> localTimeObjectPair = map.get(s);
            int secondsSinceLastRequest = now().getSecond() - localTimeObjectPair.getKey().getSecond();
            if (secondsSinceLastRequest > 3){
                map.put(s, new Pair<>(now(), objectFactory.getObject()));
            }
        } else {
            map.put(s, new Pair<>(now(), objectFactory.getObject()));
        }
        return map.get(s).getValue();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
