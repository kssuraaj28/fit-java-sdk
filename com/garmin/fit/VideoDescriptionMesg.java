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



public class VideoDescriptionMesg extends Mesg   {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int MessageCountFieldNum = 0;
    
    public static final int TextFieldNum = 1;
    

    protected static final  Mesg videoDescriptionMesg;
    static {
        // video_description
        videoDescriptionMesg = new Mesg("video_description", MesgNum.VIDEO_DESCRIPTION);
        videoDescriptionMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        videoDescriptionMesg.addField(new Field("message_count", MessageCountFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        
        videoDescriptionMesg.addField(new Field("text", TextFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
    }

    public VideoDescriptionMesg() {
        super(Factory.createMesg(MesgNum.VIDEO_DESCRIPTION));
    }

    public VideoDescriptionMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get message_index field
     * Comment: Long descriptions will be split into multiple parts
     *
     * @return message_index
     */
    public Integer getMessageIndex() {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_index field
     * Comment: Long descriptions will be split into multiple parts
     *
     * @param messageIndex The new messageIndex value to be set
     */
    public void setMessageIndex(Integer messageIndex) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get message_count field
     * Comment: Total number of description parts
     *
     * @return message_count
     */
    public Integer getMessageCount() {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_count field
     * Comment: Total number of description parts
     *
     * @param messageCount The new messageCount value to be set
     */
    public void setMessageCount(Integer messageCount) {
        setFieldValue(0, 0, messageCount, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get text field
     *
     * @return text
     */
    public String getText() {
        return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set text field
     *
     * @param text The new text value to be set
     */
    public void setText(String text) {
        setFieldValue(1, 0, text, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
