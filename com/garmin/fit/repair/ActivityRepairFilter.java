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


package com.garmin.fit.repair;

import com.garmin.fit.ActivityMesg;
import com.garmin.fit.BufferedMesgListener;
import com.garmin.fit.DateTime;
import com.garmin.fit.DeviceIndex;
import com.garmin.fit.DeviceInfoMesg;
import com.garmin.fit.File;
import com.garmin.fit.FileIdMesg;
import com.garmin.fit.FitListener;
import com.garmin.fit.FitMessages;
import com.garmin.fit.LapMesg;
import com.garmin.fit.Manufacturer;
import com.garmin.fit.Mesg;
import com.garmin.fit.MesgListener;
import com.garmin.fit.MesgNum;
import com.garmin.fit.MesgSource;
import com.garmin.fit.RecordMesg;
import com.garmin.fit.SessionMesg;
import com.garmin.fit.Sport;
import com.garmin.fit.SportMesg;
import com.garmin.fit.SubSport;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityRepairFilter implements BufferedMesgListener, MesgSource {
    private final FitListener fitListener = new FitListener();
    private final ArrayList<MesgListener> mesgListeners = new ArrayList<MesgListener>();
    private final ArrayList<Mesg> filteredRecordMesgs = new ArrayList<>();
    private long serialNumber = 123456789;
    private RecordMesg previousMesg = null;
    private boolean continueFilteringRecordMesgs = true;
    private boolean continueCheckingForFileIdMesg = true;
    private FileIdMesg fileIdMesgFromFile = null;

    public ActivityRepairFilter() {
    }

    /**
     * MesgListener implementation.
     * @param mesg the incoming Mesg to be processed
     */
    @Override
    public void onMesg(Mesg mesg) {
        mesg.removeExpandedFields();

        fitListener.onMesg(mesg);

        if (mesg.getNum() == MesgNum.RECORD) {
            filterIncomingRecordMessages();
        }

        checkForFileIdMesg(mesg);
    }

    /**
     * Adds a MesgListener to the MesgSource.
     * @param mesgListener the mesgListener to add to the MesgSource
     */
    @Override
    public void addListener(MesgListener mesgListener) {
        if ((mesgListener != null) && !mesgListeners.contains(mesgListener)) {
            mesgListeners.add(mesgListener);
        }
    }

    /**
     * @return true if the file can be repaired; false if it cannot.
     */
    public boolean canRepairFile() {
        return filteredRecordMesgs.size() != 0;
    }

    /**
     * Call once all Mesgs from the MesgSource have been received. This method then repairs the Activity file and
     * passes all Mesgs to the registered MesgListeners.
     */
    @Override
    public void flushMesgs() {
        if (filteredRecordMesgs.size() == 0) {
            return;
        }

        FitMessages fitMessages = fitListener.getFitMessages();

        RecordMesg start = (RecordMesg) filteredRecordMesgs.get(0);
        RecordMesg end = (RecordMesg) filteredRecordMesgs.get(filteredRecordMesgs.size() - 1);

        DateTime startTime = start.getTimestamp();

        FileIdMesg fileIdMesg = createFileIdMesg(startTime);

        DeviceInfoMesg deviceInfoMesg = createDeviceIdMesg(fitMessages.getDeviceInfoMesgs(), startTime);

        LapMesg lapMesg = createLapMesg(start, end);

        SessionMesg sessionMesg = createSessionMesg(start, end, fitMessages);

        ActivityMesg activityMesg = createActivityMesg(start, end);

        flushMesg(fileIdMesg);
        flushMesg(deviceInfoMesg);
        flushMesgs(fitMessages.getDeveloperDataIdMesgs());
        flushMesgs(fitMessages.getFieldDescriptionMesgs());
        flushMesgs(filteredRecordMesgs);
        flushMesg(lapMesg);
        flushMesg(sessionMesg);
        flushMesg(activityMesg);
    }

    private void checkForFileIdMesg(Mesg mesg) {
        if (!continueCheckingForFileIdMesg) {
            return;
        }

        if (mesg.getNum() == MesgNum.PAD) {
            return;
        }

        if (mesg.getNum() == MesgNum.FILE_ID) {
            fileIdMesgFromFile = new FileIdMesg(mesg);
        }

        continueCheckingForFileIdMesg = false;
    }

    private void filterIncomingRecordMessages() {
        if (!continueFilteringRecordMesgs) {
            return;
        }

        List<RecordMesg> recordMesgs = fitListener.getFitMessages().getRecordMesgs();
        RecordMesg currentMesg = recordMesgs.get(recordMesgs.size() - 1);

        if (!hasValidTimestamp(currentMesg)) {
            return;
        }

        if (filteredRecordMesgs.size() == 0) {
            filteredRecordMesgs.add(currentMesg);
            previousMesg = currentMesg;
            return;
        }

        if (!isSequential(previousMesg, currentMesg)) {
            return;
        }

        if (!isReasonableSpan(previousMesg, currentMesg)) {
            continueFilteringRecordMesgs = false;
            return;
        }

        filteredRecordMesgs.add(currentMesg);
        previousMesg = currentMesg;
    }

    private FileIdMesg createFileIdMesg(DateTime timeCreated) {
        FileIdMesg fileIdMesg = fileIdMesgFromFile;

        if (fileIdMesg == null) {
            fileIdMesg = new FileIdMesg();
            fileIdMesg.setType(File.ACTIVITY);
            fileIdMesg.setProduct(0);
            fileIdMesg.setSerialNumber(serialNumber);
        }

        if (fileIdMesg.getManufacturer() == null) {
            fileIdMesg.setManufacturer(Manufacturer.DEVELOPMENT);
        }
        if (fileIdMesg.getTimeCreated() == null) {
            fileIdMesg.setTimeCreated(new DateTime(timeCreated));
        }
        return fileIdMesg;
    }

    private DeviceInfoMesg createDeviceIdMesg(List<DeviceInfoMesg> deviceInfoMesgs, DateTime startTime) {
        DeviceInfoMesg deviceInfoMesg = deviceInfoMesgs.stream()
                .filter(mesg -> mesg.getDeviceIndex() != null)
                .filter(mesg -> mesg.getDeviceIndex() == DeviceIndex.CREATOR)
                .findFirst()
                .orElse(null);

        if (deviceInfoMesg == null) {
            deviceInfoMesg = new DeviceInfoMesg();
            deviceInfoMesg.setDeviceIndex(DeviceIndex.CREATOR);
            deviceInfoMesg.setManufacturer(Manufacturer.DEVELOPMENT);
            deviceInfoMesg.setProduct(0);
            deviceInfoMesg.setProductName("File Activity Repair"); // Max 20 Chars
            deviceInfoMesg.setSerialNumber(serialNumber);
            deviceInfoMesg.setSoftwareVersion(1.0f);
            deviceInfoMesg.setTimestamp(new DateTime(startTime));
        }

        if (deviceInfoMesg.getTimestamp() == null) {
            deviceInfoMesg.setTimestamp(new DateTime(startTime));
        }

        return deviceInfoMesg;
    }

    private LapMesg createLapMesg(RecordMesg start, RecordMesg end) {
        LapMesg lapMesg = new LapMesg();
        lapMesg.setMessageIndex(0);
        lapMesg.setStartTime(start.getTimestamp());
        lapMesg.setTimestamp(end.getTimestamp());
        lapMesg.setTotalElapsedTime((float) (end.getTimestamp().getTimestamp() - start.getTimestamp().getTimestamp()));
        lapMesg.setTotalTimerTime((float) (end.getTimestamp().getTimestamp() - start.getTimestamp().getTimestamp()));

        if (end.getDistance() != null) {
            lapMesg.setTotalDistance(end.getDistance());
        }

        return lapMesg;
    }

    SessionMesg createSessionMesg(RecordMesg start, RecordMesg end, FitMessages fitMessages) {
        SessionMesg sessionMesg = new SessionMesg();
        sessionMesg.setMessageIndex(0);
        sessionMesg.setStartTime(start.getTimestamp());
        sessionMesg.setTimestamp(end.getTimestamp());
        sessionMesg.setTotalElapsedTime((float) (end.getTimestamp().getTimestamp() - start.getTimestamp().getTimestamp()));
        sessionMesg.setTotalTimerTime((float) (end.getTimestamp().getTimestamp() - start.getTimestamp().getTimestamp()));
        sessionMesg.setFirstLapIndex(0);
        sessionMesg.setNumLaps(1);

        SportMesg sportMesg = fitMessages.getSportMesgs().stream()
                .filter(mesg -> mesg.getSport() != null)
                .filter(mesg -> mesg.getSubSport() != null)
                .findFirst()
                .orElse(null);
        if (sportMesg != null) {
            sessionMesg.setSport(sportMesg.getSport());
            sessionMesg.setSubSport(sportMesg.getSubSport());
            return sessionMesg;
        }

        LapMesg lapMesg = fitMessages.getLapMesgs().stream()
                .filter(mesg -> mesg.getSport() != null)
                .filter(mesg -> mesg.getSubSport() != null)
                .findFirst()
                .orElse(null);
        if (lapMesg != null) {
            sessionMesg.setSport(lapMesg.getSport());
            sessionMesg.setSubSport(lapMesg.getSubSport());
            return sessionMesg;
        }

        sessionMesg.setSport(Sport.GENERIC);
        sessionMesg.setSubSport(SubSport.GENERIC);
        return sessionMesg;
    }

    private ActivityMesg createActivityMesg(RecordMesg start, RecordMesg end) {
        ActivityMesg activityMesg = new ActivityMesg();
        activityMesg.setTimestamp(end.getTimestamp());
        activityMesg.setNumSessions(1);

        int timezoneOffset = ZonedDateTime.now().getOffset().getTotalSeconds();

        activityMesg.setLocalTimestamp(end.getTimestamp().getTimestamp() + timezoneOffset);
        activityMesg.setTotalTimerTime((float) (end.getTimestamp().getTimestamp() - start.getTimestamp().getTimestamp()));
        return activityMesg;
    }

    private boolean hasValidTimestamp(Mesg mesg) {
        Long timestamp = mesg.getFieldLongValue(253);
        return timestamp != null && timestamp >= DateTime.MIN;
    }

    private boolean isSequential(RecordMesg previousRecordMesg, RecordMesg recordMesg) {
        return (previousRecordMesg.getTimestamp().getTimestamp() <= recordMesg.getTimestamp().getTimestamp());
    }

    private boolean isReasonableSpan(RecordMesg previousRecordMesg, RecordMesg recordMesg) {
        final int TWO_DAYS_IN_SECONDS = 172800;
        return (recordMesg.getTimestamp().getTimestamp() < previousRecordMesg.getTimestamp().getTimestamp() + TWO_DAYS_IN_SECONDS);
    }

    private void flushMesg(Mesg mesg) {
        mesgListeners.forEach(mesgListener -> mesgListener.onMesg(mesg));
    }

    private void flushMesgs(List<? extends Mesg> mesgs) {
        mesgs.forEach(mesg -> flushMesg(mesg));
    }
}

