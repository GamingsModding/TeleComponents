package com.gamingsmod.telecomponents.reference;

public enum ArmorType
{

    HELMET(0),

    CHESTPLATE(1),

    LEGGINGS(2),

    BOOTS(3);

    private final int type;

    ArmorType(int type)
    {
        this.type = type;
    }

    public int getType()
    {
        return type;
    }
}
