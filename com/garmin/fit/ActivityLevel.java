/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2023 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.120Release
// Tag = production/release/21.120.00-0-g2d77811
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;


public enum ActivityLevel  {
    LOW((short)0),
    MEDIUM((short)1),
    HIGH((short)2),
    INVALID((short)255);

    protected short value;

    private ActivityLevel(short value) {
        this.value = value;
    }

    public static ActivityLevel getByValue(final Short value) {
        for (final ActivityLevel type : ActivityLevel.values()) {
            if (value == type.value)
                return type;
        }

        return ActivityLevel.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( ActivityLevel value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}