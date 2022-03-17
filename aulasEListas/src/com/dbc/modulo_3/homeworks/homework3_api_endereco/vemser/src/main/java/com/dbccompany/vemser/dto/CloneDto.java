package com.dbccompany.vemser.dto;

public class CloneDto implements Cloneable{
    @Override
    public CloneDto clone() {
        try {
            return (CloneDto) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
