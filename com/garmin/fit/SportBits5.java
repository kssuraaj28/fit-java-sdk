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

import java.util.HashMap;
import java.util.Map;

public class SportBits5  {
    public static final short WATER_SKIING = 0x01;
    public static final short KAYAKING = 0x02;
    public static final short RAFTING = 0x04;
    public static final short WINDSURFING = 0x08;
    public static final short KITESURFING = 0x10;
    public static final short TACTICAL = 0x20;
    public static final short JUMPMASTER = 0x40;
    public static final short BOXING = 0x80;
    public static final short INVALID = Fit.UINT8Z_INVALID;

    private static final Map<Short, String> stringMap;

    static {
        stringMap = new HashMap<Short, String>();
        stringMap.put(WATER_SKIING, "WATER_SKIING");
        stringMap.put(KAYAKING, "KAYAKING");
        stringMap.put(RAFTING, "RAFTING");
        stringMap.put(WINDSURFING, "WINDSURFING");
        stringMap.put(KITESURFING, "KITESURFING");
        stringMap.put(TACTICAL, "TACTICAL");
        stringMap.put(JUMPMASTER, "JUMPMASTER");
        stringMap.put(BOXING, "BOXING");
    }


    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum contsant
     */
    public static String getStringFromValue( Short value ) {
        if( stringMap.containsKey( value ) ) {
            return stringMap.get( value );
        }

        return "";
    }

    /**
     * Returns the enum constant with the specified name.
     * @param value The enum string value
     * @return The enum constant or INVALID if unknown
     */
    public static Short getValueFromString( String value ) {
        for( Map.Entry<Short, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }

}
