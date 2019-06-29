package application.services;

import application.json.Actor;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Hashtable;

public class CacheService {

    @Autowired
    private Hashtable<String, Object> Actors = new Hashtable<>();

    public boolean existe(String id){
        return Actors.containsKey(id);
    }

    public void add(String id, Object actor){
        Actors.put(id,actor);
    }

    public Object get(String id){
        return Actors.get(id);
    }

}
