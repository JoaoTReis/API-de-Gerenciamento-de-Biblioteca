package com.joaoreis.demo.entities.enums;

public enum Literary_genre {

    SCIENCE_FICTION(1),
    FANTASY(2),
    ROMANCE(3),
    SUSPENCE(4),
    DRAMA(5),
    HISTORICAL_FICTION(6),
    HORROR_LITERATURE(7),
    ACTION(8);

    private int code;

    private Literary_genre(int code){
        this.code= code;
    }

    public int getCode(){
        return code;
    }

    public static Literary_genre valueOf(int code){
        for(Literary_genre value : Literary_genre.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
