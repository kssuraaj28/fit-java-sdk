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

public class CalfRaiseExerciseName  {
    public static final int _3_WAY_CALF_RAISE = 0;
    public static final int _3_WAY_WEIGHTED_CALF_RAISE = 1;
    public static final int _3_WAY_SINGLE_LEG_CALF_RAISE = 2;
    public static final int _3_WAY_WEIGHTED_SINGLE_LEG_CALF_RAISE = 3;
    public static final int DONKEY_CALF_RAISE = 4;
    public static final int WEIGHTED_DONKEY_CALF_RAISE = 5;
    public static final int SEATED_CALF_RAISE = 6;
    public static final int WEIGHTED_SEATED_CALF_RAISE = 7;
    public static final int SEATED_DUMBBELL_TOE_RAISE = 8;
    public static final int SINGLE_LEG_BENT_KNEE_CALF_RAISE = 9;
    public static final int WEIGHTED_SINGLE_LEG_BENT_KNEE_CALF_RAISE = 10;
    public static final int SINGLE_LEG_DECLINE_PUSH_UP = 11;
    public static final int SINGLE_LEG_DONKEY_CALF_RAISE = 12;
    public static final int WEIGHTED_SINGLE_LEG_DONKEY_CALF_RAISE = 13;
    public static final int SINGLE_LEG_HIP_RAISE_WITH_KNEE_HOLD = 14;
    public static final int SINGLE_LEG_STANDING_CALF_RAISE = 15;
    public static final int SINGLE_LEG_STANDING_DUMBBELL_CALF_RAISE = 16;
    public static final int STANDING_BARBELL_CALF_RAISE = 17;
    public static final int STANDING_CALF_RAISE = 18;
    public static final int WEIGHTED_STANDING_CALF_RAISE = 19;
    public static final int STANDING_DUMBBELL_CALF_RAISE = 20;
    public static final int INVALID = Fit.UINT16_INVALID;

    private static final Map<Integer, String> stringMap;

    static {
        stringMap = new HashMap<Integer, String>();
        stringMap.put(_3_WAY_CALF_RAISE, "_3_WAY_CALF_RAISE");
        stringMap.put(_3_WAY_WEIGHTED_CALF_RAISE, "_3_WAY_WEIGHTED_CALF_RAISE");
        stringMap.put(_3_WAY_SINGLE_LEG_CALF_RAISE, "_3_WAY_SINGLE_LEG_CALF_RAISE");
        stringMap.put(_3_WAY_WEIGHTED_SINGLE_LEG_CALF_RAISE, "_3_WAY_WEIGHTED_SINGLE_LEG_CALF_RAISE");
        stringMap.put(DONKEY_CALF_RAISE, "DONKEY_CALF_RAISE");
        stringMap.put(WEIGHTED_DONKEY_CALF_RAISE, "WEIGHTED_DONKEY_CALF_RAISE");
        stringMap.put(SEATED_CALF_RAISE, "SEATED_CALF_RAISE");
        stringMap.put(WEIGHTED_SEATED_CALF_RAISE, "WEIGHTED_SEATED_CALF_RAISE");
        stringMap.put(SEATED_DUMBBELL_TOE_RAISE, "SEATED_DUMBBELL_TOE_RAISE");
        stringMap.put(SINGLE_LEG_BENT_KNEE_CALF_RAISE, "SINGLE_LEG_BENT_KNEE_CALF_RAISE");
        stringMap.put(WEIGHTED_SINGLE_LEG_BENT_KNEE_CALF_RAISE, "WEIGHTED_SINGLE_LEG_BENT_KNEE_CALF_RAISE");
        stringMap.put(SINGLE_LEG_DECLINE_PUSH_UP, "SINGLE_LEG_DECLINE_PUSH_UP");
        stringMap.put(SINGLE_LEG_DONKEY_CALF_RAISE, "SINGLE_LEG_DONKEY_CALF_RAISE");
        stringMap.put(WEIGHTED_SINGLE_LEG_DONKEY_CALF_RAISE, "WEIGHTED_SINGLE_LEG_DONKEY_CALF_RAISE");
        stringMap.put(SINGLE_LEG_HIP_RAISE_WITH_KNEE_HOLD, "SINGLE_LEG_HIP_RAISE_WITH_KNEE_HOLD");
        stringMap.put(SINGLE_LEG_STANDING_CALF_RAISE, "SINGLE_LEG_STANDING_CALF_RAISE");
        stringMap.put(SINGLE_LEG_STANDING_DUMBBELL_CALF_RAISE, "SINGLE_LEG_STANDING_DUMBBELL_CALF_RAISE");
        stringMap.put(STANDING_BARBELL_CALF_RAISE, "STANDING_BARBELL_CALF_RAISE");
        stringMap.put(STANDING_CALF_RAISE, "STANDING_CALF_RAISE");
        stringMap.put(WEIGHTED_STANDING_CALF_RAISE, "WEIGHTED_STANDING_CALF_RAISE");
        stringMap.put(STANDING_DUMBBELL_CALF_RAISE, "STANDING_DUMBBELL_CALF_RAISE");
    }


    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum contsant
     */
    public static String getStringFromValue( Integer value ) {
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
    public static Integer getValueFromString( String value ) {
        for( Map.Entry<Integer, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }

}
