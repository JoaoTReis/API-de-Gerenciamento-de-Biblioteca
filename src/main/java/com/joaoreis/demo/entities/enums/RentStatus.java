package com.joaoreis.demo.entities.enums;

public enum RentStatus {

    RESERVED(1),
    IN_PROGRESS(2),
    RETURNED(3),
    OVERDUE(4),
    CANCELLED(5),
    PENDING_APPROVAL(6),
    RENEWED(7),
    LOST(8),
    DAMAGED(9),
    EXPIRED(10);

    private int code;

    private RentStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static RentStatus valueOf(int code){
        for(RentStatus value : RentStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
