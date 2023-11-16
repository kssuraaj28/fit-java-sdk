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



public class DiveAlarmMesg extends Mesg   {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int DepthFieldNum = 0;
    
    public static final int TimeFieldNum = 1;
    
    public static final int EnabledFieldNum = 2;
    
    public static final int AlarmTypeFieldNum = 3;
    
    public static final int SoundFieldNum = 4;
    
    public static final int DiveTypesFieldNum = 5;
    
    public static final int IdFieldNum = 6;
    
    public static final int PopupEnabledFieldNum = 7;
    
    public static final int TriggerOnDescentFieldNum = 8;
    
    public static final int TriggerOnAscentFieldNum = 9;
    
    public static final int RepeatingFieldNum = 10;
    
    public static final int SpeedFieldNum = 11;
    

    protected static final  Mesg diveAlarmMesg;
    static {
        // dive_alarm
        diveAlarmMesg = new Mesg("dive_alarm", MesgNum.DIVE_ALARM);
        diveAlarmMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        diveAlarmMesg.addField(new Field("depth", DepthFieldNum, 134, 1000, 0, "m", false, Profile.Type.UINT32));
        
        diveAlarmMesg.addField(new Field("time", TimeFieldNum, 133, 1, 0, "s", false, Profile.Type.SINT32));
        
        diveAlarmMesg.addField(new Field("enabled", EnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        
        diveAlarmMesg.addField(new Field("alarm_type", AlarmTypeFieldNum, 0, 1, 0, "", false, Profile.Type.DIVE_ALARM_TYPE));
        
        diveAlarmMesg.addField(new Field("sound", SoundFieldNum, 0, 1, 0, "", false, Profile.Type.TONE));
        
        diveAlarmMesg.addField(new Field("dive_types", DiveTypesFieldNum, 0, 1, 0, "", false, Profile.Type.SUB_SPORT));
        
        diveAlarmMesg.addField(new Field("id", IdFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        
        diveAlarmMesg.addField(new Field("popup_enabled", PopupEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        
        diveAlarmMesg.addField(new Field("trigger_on_descent", TriggerOnDescentFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        
        diveAlarmMesg.addField(new Field("trigger_on_ascent", TriggerOnAscentFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        
        diveAlarmMesg.addField(new Field("repeating", RepeatingFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        
        diveAlarmMesg.addField(new Field("speed", SpeedFieldNum, 133, 1000, 0, "mps", false, Profile.Type.SINT32));
        
    }

    public DiveAlarmMesg() {
        super(Factory.createMesg(MesgNum.DIVE_ALARM));
    }

    public DiveAlarmMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get message_index field
     * Comment: Index of the alarm
     *
     * @return message_index
     */
    public Integer getMessageIndex() {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_index field
     * Comment: Index of the alarm
     *
     * @param messageIndex The new messageIndex value to be set
     */
    public void setMessageIndex(Integer messageIndex) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get depth field
     * Units: m
     * Comment: Depth setting (m) for depth type alarms
     *
     * @return depth
     */
    public Float getDepth() {
        return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set depth field
     * Units: m
     * Comment: Depth setting (m) for depth type alarms
     *
     * @param depth The new depth value to be set
     */
    public void setDepth(Float depth) {
        setFieldValue(0, 0, depth, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get time field
     * Units: s
     * Comment: Time setting (s) for time type alarms
     *
     * @return time
     */
    public Integer getTime() {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set time field
     * Units: s
     * Comment: Time setting (s) for time type alarms
     *
     * @param time The new time value to be set
     */
    public void setTime(Integer time) {
        setFieldValue(1, 0, time, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get enabled field
     * Comment: Enablement flag
     *
     * @return enabled
     */
    public Bool getEnabled() {
        Short value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set enabled field
     * Comment: Enablement flag
     *
     * @param enabled The new enabled value to be set
     */
    public void setEnabled(Bool enabled) {
        setFieldValue(2, 0, enabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get alarm_type field
     * Comment: Alarm type setting
     *
     * @return alarm_type
     */
    public DiveAlarmType getAlarmType() {
        Short value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DiveAlarmType.getByValue(value);
    }

    /**
     * Set alarm_type field
     * Comment: Alarm type setting
     *
     * @param alarmType The new alarmType value to be set
     */
    public void setAlarmType(DiveAlarmType alarmType) {
        setFieldValue(3, 0, alarmType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sound field
     * Comment: Tone and Vibe setting for the alarm
     *
     * @return sound
     */
    public Tone getSound() {
        Short value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Tone.getByValue(value);
    }

    /**
     * Set sound field
     * Comment: Tone and Vibe setting for the alarm
     *
     * @param sound The new sound value to be set
     */
    public void setSound(Tone sound) {
        setFieldValue(4, 0, sound.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public SubSport[] getDiveTypes() {
        
        Short[] values = getFieldShortValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        SubSport[] rv = new SubSport[values.length];
        for(int i = 0; i < values.length; i++){
            rv[i] = SubSport.getByValue(values[i]);
        }
        return rv;
        
    }

    /**
     * @return number of dive_types
     */
    public int getNumDiveTypes() {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get dive_types field
     * Comment: Dive types the alarm will trigger on
     *
     * @param index of dive_types
     * @return dive_types
     */
    public SubSport getDiveTypes(int index) {
        Short value = getFieldShortValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return SubSport.getByValue(value);
    }

    /**
     * Set dive_types field
     * Comment: Dive types the alarm will trigger on
     *
     * @param index of dive_types
     * @param diveTypes The new diveTypes value to be set
     */
    public void setDiveTypes(int index, SubSport diveTypes) {
        setFieldValue(5, index, diveTypes.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get id field
     * Comment: Alarm ID
     *
     * @return id
     */
    public Long getId() {
        return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set id field
     * Comment: Alarm ID
     *
     * @param id The new id value to be set
     */
    public void setId(Long id) {
        setFieldValue(6, 0, id, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get popup_enabled field
     * Comment: Show a visible pop-up for this alarm
     *
     * @return popup_enabled
     */
    public Bool getPopupEnabled() {
        Short value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set popup_enabled field
     * Comment: Show a visible pop-up for this alarm
     *
     * @param popupEnabled The new popupEnabled value to be set
     */
    public void setPopupEnabled(Bool popupEnabled) {
        setFieldValue(7, 0, popupEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get trigger_on_descent field
     * Comment: Trigger the alarm on descent
     *
     * @return trigger_on_descent
     */
    public Bool getTriggerOnDescent() {
        Short value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set trigger_on_descent field
     * Comment: Trigger the alarm on descent
     *
     * @param triggerOnDescent The new triggerOnDescent value to be set
     */
    public void setTriggerOnDescent(Bool triggerOnDescent) {
        setFieldValue(8, 0, triggerOnDescent.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get trigger_on_ascent field
     * Comment: Trigger the alarm on ascent
     *
     * @return trigger_on_ascent
     */
    public Bool getTriggerOnAscent() {
        Short value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set trigger_on_ascent field
     * Comment: Trigger the alarm on ascent
     *
     * @param triggerOnAscent The new triggerOnAscent value to be set
     */
    public void setTriggerOnAscent(Bool triggerOnAscent) {
        setFieldValue(9, 0, triggerOnAscent.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get repeating field
     * Comment: Repeat alarm each time threshold is crossed?
     *
     * @return repeating
     */
    public Bool getRepeating() {
        Short value = getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set repeating field
     * Comment: Repeat alarm each time threshold is crossed?
     *
     * @param repeating The new repeating value to be set
     */
    public void setRepeating(Bool repeating) {
        setFieldValue(10, 0, repeating.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get speed field
     * Units: mps
     * Comment: Ascent/descent rate (mps) setting for speed type alarms
     *
     * @return speed
     */
    public Float getSpeed() {
        return getFieldFloatValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set speed field
     * Units: mps
     * Comment: Ascent/descent rate (mps) setting for speed type alarms
     *
     * @param speed The new speed value to be set
     */
    public void setSpeed(Float speed) {
        setFieldValue(11, 0, speed, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
