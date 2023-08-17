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


public enum AntNetwork  {
    PUBLIC((short)0),
    ANTPLUS((short)1),
    ANTFS((short)2),
    PRIVATE((short)3),
    INVALID((short)255);

    protected short value;

    private AntNetwork(short value) {
        this.value = value;
    }

    public static AntNetwork getByValue(final Short value) {
        for (final AntNetwork type : AntNetwork.values()) {
            if (value == type.value)
                return type;
        }

        return AntNetwork.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( AntNetwork value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
