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

import java.util.HashMap;
import java.util.Map;

public class LanguageBits0  {
    public static final short ENGLISH = 0x01;
    public static final short FRENCH = 0x02;
    public static final short ITALIAN = 0x04;
    public static final short GERMAN = 0x08;
    public static final short SPANISH = 0x10;
    public static final short CROATIAN = 0x20;
    public static final short CZECH = 0x40;
    public static final short DANISH = 0x80;
    public static final short INVALID = Fit.UINT8Z_INVALID;

    private static final Map<Short, String> stringMap;

    static {
        stringMap = new HashMap<Short, String>();
        stringMap.put(ENGLISH, "ENGLISH");
        stringMap.put(FRENCH, "FRENCH");
        stringMap.put(ITALIAN, "ITALIAN");
        stringMap.put(GERMAN, "GERMAN");
        stringMap.put(SPANISH, "SPANISH");
        stringMap.put(CROATIAN, "CROATIAN");
        stringMap.put(CZECH, "CZECH");
        stringMap.put(DANISH, "DANISH");
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
