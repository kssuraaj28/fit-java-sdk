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



public class SleepLevelMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int SleepLevelFieldNum = 0;
    

    protected static final  Mesg sleepLevelMesg;
    static {
        // sleep_level
        sleepLevelMesg = new Mesg("sleep_level", MesgNum.SLEEP_LEVEL);
        sleepLevelMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        sleepLevelMesg.addField(new Field("sleep_level", SleepLevelFieldNum, 0, 1, 0, "", false, Profile.Type.SLEEP_LEVEL));
        
    }

    public SleepLevelMesg() {
        super(Factory.createMesg(MesgNum.SLEEP_LEVEL));
    }

    public SleepLevelMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sleep_level field
     *
     * @return sleep_level
     */
    public SleepLevel getSleepLevel() {
        Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return SleepLevel.getByValue(value);
    }

    /**
     * Set sleep_level field
     *
     * @param sleepLevel The new sleepLevel value to be set
     */
    public void setSleepLevel(SleepLevel sleepLevel) {
        setFieldValue(0, 0, sleepLevel.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
