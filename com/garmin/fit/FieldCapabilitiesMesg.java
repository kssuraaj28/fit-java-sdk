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



public class FieldCapabilitiesMesg extends Mesg   {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int FileFieldNum = 0;
    
    public static final int MesgNumFieldNum = 1;
    
    public static final int FieldNumFieldNum = 2;
    
    public static final int CountFieldNum = 3;
    

    protected static final  Mesg fieldCapabilitiesMesg;
    static {
        // field_capabilities
        fieldCapabilitiesMesg = new Mesg("field_capabilities", MesgNum.FIELD_CAPABILITIES);
        fieldCapabilitiesMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        fieldCapabilitiesMesg.addField(new Field("file", FileFieldNum, 0, 1, 0, "", false, Profile.Type.FILE));
        
        fieldCapabilitiesMesg.addField(new Field("mesg_num", MesgNumFieldNum, 132, 1, 0, "", false, Profile.Type.MESG_NUM));
        
        fieldCapabilitiesMesg.addField(new Field("field_num", FieldNumFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        
        fieldCapabilitiesMesg.addField(new Field("count", CountFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        
    }

    public FieldCapabilitiesMesg() {
        super(Factory.createMesg(MesgNum.FIELD_CAPABILITIES));
    }

    public FieldCapabilitiesMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get message_index field
     *
     * @return message_index
     */
    public Integer getMessageIndex() {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_index field
     *
     * @param messageIndex The new messageIndex value to be set
     */
    public void setMessageIndex(Integer messageIndex) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get file field
     *
     * @return file
     */
    public File getFile() {
        Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return File.getByValue(value);
    }

    /**
     * Set file field
     *
     * @param file The new file value to be set
     */
    public void setFile(File file) {
        setFieldValue(0, 0, file.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get mesg_num field
     *
     * @return mesg_num
     */
    public Integer getMesgNum() {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set mesg_num field
     *
     * @param mesgNum The new mesgNum value to be set
     */
    public void setMesgNum(Integer mesgNum) {
        setFieldValue(1, 0, mesgNum, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get field_num field
     *
     * @return field_num
     */
    public Short getFieldNum() {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set field_num field
     *
     * @param fieldNum The new fieldNum value to be set
     */
    public void setFieldNum(Short fieldNum) {
        setFieldValue(2, 0, fieldNum, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get count field
     *
     * @return count
     */
    public Integer getCount() {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set count field
     *
     * @param count The new count value to be set
     */
    public void setCount(Integer count) {
        setFieldValue(3, 0, count, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
