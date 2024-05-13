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



public class AviationAttitudeMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int TimestampMsFieldNum = 0;
    
    public static final int SystemTimeFieldNum = 1;
    
    public static final int PitchFieldNum = 2;
    
    public static final int RollFieldNum = 3;
    
    public static final int AccelLateralFieldNum = 4;
    
    public static final int AccelNormalFieldNum = 5;
    
    public static final int TurnRateFieldNum = 6;
    
    public static final int StageFieldNum = 7;
    
    public static final int AttitudeStageCompleteFieldNum = 8;
    
    public static final int TrackFieldNum = 9;
    
    public static final int ValidityFieldNum = 10;
    

    protected static final  Mesg aviationAttitudeMesg;
    static {
        // aviation_attitude
        aviationAttitudeMesg = new Mesg("aviation_attitude", MesgNum.AVIATION_ATTITUDE);
        aviationAttitudeMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        aviationAttitudeMesg.addField(new Field("timestamp_ms", TimestampMsFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
        
        aviationAttitudeMesg.addField(new Field("system_time", SystemTimeFieldNum, 134, 1, 0, "ms", false, Profile.Type.UINT32));
        
        aviationAttitudeMesg.addField(new Field("pitch", PitchFieldNum, 131, 10430.38, 0, "radians", false, Profile.Type.SINT16));
        
        aviationAttitudeMesg.addField(new Field("roll", RollFieldNum, 131, 10430.38, 0, "radians", false, Profile.Type.SINT16));
        
        aviationAttitudeMesg.addField(new Field("accel_lateral", AccelLateralFieldNum, 131, 100, 0, "m/s^2", false, Profile.Type.SINT16));
        
        aviationAttitudeMesg.addField(new Field("accel_normal", AccelNormalFieldNum, 131, 100, 0, "m/s^2", false, Profile.Type.SINT16));
        
        aviationAttitudeMesg.addField(new Field("turn_rate", TurnRateFieldNum, 131, 1024, 0, "radians/second", false, Profile.Type.SINT16));
        
        aviationAttitudeMesg.addField(new Field("stage", StageFieldNum, 0, 1, 0, "", false, Profile.Type.ATTITUDE_STAGE));
        
        aviationAttitudeMesg.addField(new Field("attitude_stage_complete", AttitudeStageCompleteFieldNum, 2, 1, 0, "%", false, Profile.Type.UINT8));
        
        aviationAttitudeMesg.addField(new Field("track", TrackFieldNum, 132, 10430.38, 0, "radians", false, Profile.Type.UINT16));
        
        aviationAttitudeMesg.addField(new Field("validity", ValidityFieldNum, 132, 1, 0, "", false, Profile.Type.ATTITUDE_VALIDITY));
        
    }

    public AviationAttitudeMesg() {
        super(Factory.createMesg(MesgNum.AVIATION_ATTITUDE));
    }

    public AviationAttitudeMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     * Comment: Timestamp message was output
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Timestamp message was output
     *
     * @param timestamp The new timestamp value to be set
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Fractional part of timestamp, added to timestamp
     *
     * @return timestamp_ms
     */
    public Integer getTimestampMs() {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set timestamp_ms field
     * Units: ms
     * Comment: Fractional part of timestamp, added to timestamp
     *
     * @param timestampMs The new timestampMs value to be set
     */
    public void setTimestampMs(Integer timestampMs) {
        setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Long[] getSystemTime() {
        
        return getFieldLongValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of system_time
     */
    public int getNumSystemTime() {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get system_time field
     * Units: ms
     * Comment: System time associated with sample expressed in ms.
     *
     * @param index of system_time
     * @return system_time
     */
    public Long getSystemTime(int index) {
        return getFieldLongValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set system_time field
     * Units: ms
     * Comment: System time associated with sample expressed in ms.
     *
     * @param index of system_time
     * @param systemTime The new systemTime value to be set
     */
    public void setSystemTime(int index, Long systemTime) {
        setFieldValue(1, index, systemTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Float[] getPitch() {
        
        return getFieldFloatValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of pitch
     */
    public int getNumPitch() {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get pitch field
     * Units: radians
     * Comment: Range -PI/2 to +PI/2
     *
     * @param index of pitch
     * @return pitch
     */
    public Float getPitch(int index) {
        return getFieldFloatValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set pitch field
     * Units: radians
     * Comment: Range -PI/2 to +PI/2
     *
     * @param index of pitch
     * @param pitch The new pitch value to be set
     */
    public void setPitch(int index, Float pitch) {
        setFieldValue(2, index, pitch, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Float[] getRoll() {
        
        return getFieldFloatValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of roll
     */
    public int getNumRoll() {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get roll field
     * Units: radians
     * Comment: Range -PI to +PI
     *
     * @param index of roll
     * @return roll
     */
    public Float getRoll(int index) {
        return getFieldFloatValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set roll field
     * Units: radians
     * Comment: Range -PI to +PI
     *
     * @param index of roll
     * @param roll The new roll value to be set
     */
    public void setRoll(int index, Float roll) {
        setFieldValue(3, index, roll, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Float[] getAccelLateral() {
        
        return getFieldFloatValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of accel_lateral
     */
    public int getNumAccelLateral() {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get accel_lateral field
     * Units: m/s^2
     * Comment: Range -78.4 to +78.4 (-8 Gs to 8 Gs)
     *
     * @param index of accel_lateral
     * @return accel_lateral
     */
    public Float getAccelLateral(int index) {
        return getFieldFloatValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set accel_lateral field
     * Units: m/s^2
     * Comment: Range -78.4 to +78.4 (-8 Gs to 8 Gs)
     *
     * @param index of accel_lateral
     * @param accelLateral The new accelLateral value to be set
     */
    public void setAccelLateral(int index, Float accelLateral) {
        setFieldValue(4, index, accelLateral, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Float[] getAccelNormal() {
        
        return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of accel_normal
     */
    public int getNumAccelNormal() {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get accel_normal field
     * Units: m/s^2
     * Comment: Range -78.4 to +78.4 (-8 Gs to 8 Gs)
     *
     * @param index of accel_normal
     * @return accel_normal
     */
    public Float getAccelNormal(int index) {
        return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set accel_normal field
     * Units: m/s^2
     * Comment: Range -78.4 to +78.4 (-8 Gs to 8 Gs)
     *
     * @param index of accel_normal
     * @param accelNormal The new accelNormal value to be set
     */
    public void setAccelNormal(int index, Float accelNormal) {
        setFieldValue(5, index, accelNormal, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Float[] getTurnRate() {
        
        return getFieldFloatValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of turn_rate
     */
    public int getNumTurnRate() {
        return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get turn_rate field
     * Units: radians/second
     * Comment: Range -8.727 to +8.727 (-500 degs/sec to +500 degs/sec)
     *
     * @param index of turn_rate
     * @return turn_rate
     */
    public Float getTurnRate(int index) {
        return getFieldFloatValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set turn_rate field
     * Units: radians/second
     * Comment: Range -8.727 to +8.727 (-500 degs/sec to +500 degs/sec)
     *
     * @param index of turn_rate
     * @param turnRate The new turnRate value to be set
     */
    public void setTurnRate(int index, Float turnRate) {
        setFieldValue(6, index, turnRate, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public AttitudeStage[] getStage() {
        
        Short[] values = getFieldShortValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        AttitudeStage[] rv = new AttitudeStage[values.length];
        for(int i = 0; i < values.length; i++){
            rv[i] = AttitudeStage.getByValue(values[i]);
        }
        return rv;
        
    }

    /**
     * @return number of stage
     */
    public int getNumStage() {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get stage field
     *
     * @param index of stage
     * @return stage
     */
    public AttitudeStage getStage(int index) {
        Short value = getFieldShortValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return AttitudeStage.getByValue(value);
    }

    /**
     * Set stage field
     *
     * @param index of stage
     * @param stage The new stage value to be set
     */
    public void setStage(int index, AttitudeStage stage) {
        setFieldValue(7, index, stage.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Short[] getAttitudeStageComplete() {
        
        return getFieldShortValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of attitude_stage_complete
     */
    public int getNumAttitudeStageComplete() {
        return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get attitude_stage_complete field
     * Units: %
     * Comment: The percent complete of the current attitude stage. Set to 0 for attitude stages 0, 1 and 2 and to 100 for attitude stage 3 by AHRS modules that do not support it. Range - 100
     *
     * @param index of attitude_stage_complete
     * @return attitude_stage_complete
     */
    public Short getAttitudeStageComplete(int index) {
        return getFieldShortValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set attitude_stage_complete field
     * Units: %
     * Comment: The percent complete of the current attitude stage. Set to 0 for attitude stages 0, 1 and 2 and to 100 for attitude stage 3 by AHRS modules that do not support it. Range - 100
     *
     * @param index of attitude_stage_complete
     * @param attitudeStageComplete The new attitudeStageComplete value to be set
     */
    public void setAttitudeStageComplete(int index, Short attitudeStageComplete) {
        setFieldValue(8, index, attitudeStageComplete, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Float[] getTrack() {
        
        return getFieldFloatValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of track
     */
    public int getNumTrack() {
        return getNumFieldValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get track field
     * Units: radians
     * Comment: Track Angle/Heading Range 0 - 2pi
     *
     * @param index of track
     * @return track
     */
    public Float getTrack(int index) {
        return getFieldFloatValue(9, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set track field
     * Units: radians
     * Comment: Track Angle/Heading Range 0 - 2pi
     *
     * @param index of track
     * @param track The new track value to be set
     */
    public void setTrack(int index, Float track) {
        setFieldValue(9, index, track, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Integer[] getValidity() {
        
        return getFieldIntegerValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of validity
     */
    public int getNumValidity() {
        return getNumFieldValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get validity field
     *
     * @param index of validity
     * @return validity
     */
    public Integer getValidity(int index) {
        return getFieldIntegerValue(10, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set validity field
     *
     * @param index of validity
     * @param validity The new validity value to be set
     */
    public void setValidity(int index, Integer validity) {
        setFieldValue(10, index, validity, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
