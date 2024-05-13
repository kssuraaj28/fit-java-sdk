/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2024 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.141.0Release
// Tag = production/release/21.141.0-0-g2aa27e1
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;


public enum ActivityClass  {
    LEVEL((short)0x7F),
    LEVEL_MAX((short)100),
    ATHLETE((short)0x80),
    INVALID((short)255);

    protected short value;

    private ActivityClass(short value) {
        this.value = value;
    }

    public static ActivityClass getByValue(final Short value) {
        for (final ActivityClass type : ActivityClass.values()) {
            if (value == type.value)
                return type;
        }

        return ActivityClass.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( ActivityClass value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
