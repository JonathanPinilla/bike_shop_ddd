package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class Id extends Identity {

    private Id(String uuid){
        super(uuid);
    }

    public Id(){

    }

    public static Id of(String uuid){
        return new Id(uuid);
    }
}
