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


public enum GoalSource  {
    AUTO((short)0),
    COMMUNITY((short)1),
    USER((short)2),
    INVALID((short)255);

    protected short value;

    private GoalSource(short value) {
        this.value = value;
    }

    public static GoalSource getByValue(final Short value) {
        for (final GoalSource type : GoalSource.values()) {
            if (value == type.value)
                return type;
        }

        return GoalSource.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( GoalSource value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
