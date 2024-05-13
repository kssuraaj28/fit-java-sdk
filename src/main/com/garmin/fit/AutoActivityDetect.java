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

import java.util.HashMap;
import java.util.Map;

public class AutoActivityDetect  {
    public static final long NONE = 0x00000000;
    public static final long RUNNING = 0x00000001;
    public static final long CYCLING = 0x00000002;
    public static final long SWIMMING = 0x00000004;
    public static final long WALKING = 0x00000008;
    public static final long ELLIPTICAL = 0x00000020;
    public static final long SEDENTARY = 0x00000400;
    public static final long INVALID = Fit.UINT32_INVALID;

    private static final Map<Long, String> stringMap;

    static {
        stringMap = new HashMap<Long, String>();
        stringMap.put(NONE, "NONE");
        stringMap.put(RUNNING, "RUNNING");
        stringMap.put(CYCLING, "CYCLING");
        stringMap.put(SWIMMING, "SWIMMING");
        stringMap.put(WALKING, "WALKING");
        stringMap.put(ELLIPTICAL, "ELLIPTICAL");
        stringMap.put(SEDENTARY, "SEDENTARY");
    }


    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum contsant
     */
    public static String getStringFromValue( Long value ) {
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
    public static Long getValueFromString( String value ) {
        for( Map.Entry<Long, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }

}
