/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2023 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.126.0Release
// Tag = production/release/21.126.0-0-g0576dfe
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;


public enum SwimStroke  {
    FREESTYLE((short)0),
    BACKSTROKE((short)1),
    BREASTSTROKE((short)2),
    BUTTERFLY((short)3),
    DRILL((short)4),
    MIXED((short)5),
    IM((short)6),
    INVALID((short)255);

    protected short value;

    private SwimStroke(short value) {
        this.value = value;
    }

    public static SwimStroke getByValue(final Short value) {
        for (final SwimStroke type : SwimStroke.values()) {
            if (value == type.value)
                return type;
        }

        return SwimStroke.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( SwimStroke value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
