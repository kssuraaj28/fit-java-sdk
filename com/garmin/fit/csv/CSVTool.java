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


package com.garmin.fit.csv;

import com.garmin.fit.*;
import com.garmin.fit.plugins.ActivityFileValidationPlugin;
import com.garmin.fit.plugins.ActivityFileValidationResult;
import com.garmin.fit.util.StreamHelpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

public class CSVTool {

    public boolean runningFromConsole = false;
    private final int DATA_OR_DEFINITION_SEARCH_COUNT = 2;
    private ByteArrayOutputStream byteArrayOutputStream = null;
    private ByteArrayOutputStream dataWriterByteArrayOutputStream = null;
    private MesgDataCSVWriter dataMesgWriter = null;
    private MesgCSVWriter mesgWriter;
    private MesgFilter mesgFilter;
    private CSVDataMesgFieldCounter csvDataMesgFieldCounter;
    private int numUnknownFields = 0;
    private int numUnknownMesgs = 0;

    private final Decode decode = new Decode();

    private HashSet<String> mesgDefinitionsToOutput = new HashSet<>();
    private HashSet<String> dataMessagesToOutput = new HashSet<>();

    private boolean bytesAsHex = false;
    private boolean dateTimeAsISO8601 = false;
    private boolean semicirclesAsDegrees = false;
    private boolean verificationTests = false;
    private boolean checkIntegrity = false;
    private boolean showInvalidValues = false;
    private boolean showInvalidsAsEmpty = false;
    private boolean hideUnknownData = false;
    private boolean generateDataFile = false;
    private boolean enumsAsStrings = false;
    private boolean removeExpandedFields = false;
    private boolean excludeMesgList = false; // by default, the --defn and --data are include filters.
    private Fit.ProtocolVersion protocolVersion = Fit.ProtocolVersion.V2_0;

    public CSVTool() {
    }

    public static void main(String[] args) {
        CSVTool csvTool = new CSVTool();
        csvTool.runningFromConsole = true;
        int arg = 0;

        String inputFileName = null;
        String outputFileName = null;
        boolean fitToCsv = false;
        boolean csvToFit = false;

        int nextArgumentDefinition = 0;
        int nextArgumentData = 0;

        System.out.printf("FIT CSV Tool - Protocol %d.%d Profile %d.%d %s\n\n", Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR, Fit.PROFILE_VERSION_MAJOR, Fit.PROFILE_VERSION_MINOR, Fit.PROFILE_TYPE);

        while (arg < args.length) {
            if (args[arg].equals("-b")) {
                if ((args.length - arg) < 3) {
                    printUsage();
                    return;
                }

                fitToCsv = true;
                inputFileName = args[arg + 1];
                outputFileName = args[arg + 2];

                arg += 2;
            }
            else if (args[arg].equals("-c")) {
                if ((args.length - arg) < 3) {
                    printUsage();
                    return;
                }

                csvToFit = true;
                inputFileName = args[arg + 1];
                outputFileName = args[arg + 2];

                arg += 2;
            }
            else if (args[arg].equals("-t")) {
                csvTool.enableVerificationTests(true);
            }
            else if (args[arg].equals("-d")) {
                csvTool.enableFitSdkDebugging(true);
                csvTool.enableVerificationTests(true);
            }
            else if (args[arg].equals("-i")) {
                csvTool.enableCheckIntegrity(true);
            }
            else if (args[arg].equals("-ex")) {
                csvTool.setExcludeMesgList(true);
            }
            else if (args[arg].equals("--defn")) {
                nextArgumentDefinition = csvTool.DATA_OR_DEFINITION_SEARCH_COUNT;
            }
            else if (args[arg].equals("--data")) {
                nextArgumentData = csvTool.DATA_OR_DEFINITION_SEARCH_COUNT;
                csvTool.enableGenerateDataFile(true);
            }
            else if (args[arg].charAt(0) != '-') {

                if (nextArgumentDefinition > 0) {
                    csvTool.setMesgDefinitionFilter(new HashSet<>(Arrays.asList(args[arg].toLowerCase().split(","))));
                }
                else if (nextArgumentData > 0) {
                    csvTool.setDataMessagesFilter(new HashSet<>(Arrays.asList(args[arg].toLowerCase().split(","))));
                }
                else {
                    inputFileName = args[arg];
                    if (inputFileName.endsWith(".fit")) {
                        fitToCsv = true;
                        outputFileName = inputFileName.substring(0, inputFileName.length() - 4) + ".csv";
                    }
                    else if (inputFileName.endsWith(".csv")) {
                        csvToFit = true;
                        outputFileName = inputFileName.substring(0, inputFileName.length() - 4) + ".fit";
                    }
                    else {
                        System.out.println("Invalid file provided " + inputFileName + " is not a .fit or .csv file");
                        printUsage();
                        return;
                    }
                }
            }
            else if (args[arg].equals("-s")) {
                csvTool.enableShowInvalidValues(true);
            }
            else if (args[arg].equals("-se")) {
                csvTool.enableShowInvalidValues(true);
                csvTool.enableShowInvalidsAsEmpty(true);
            }
            else if (args[arg].equals("-u")) {
                csvTool.enableHideUnknownData(true);
            }
            else if (args[arg].equals("-x")) {
                csvTool.enableBytesAsHex(true);
            }
            else if (args[arg].startsWith("-p")) {
                if (args[arg].endsWith("1")) {
                    csvTool.setProtocolVersion(Fit.ProtocolVersion.V1_0);
                }
                else if (args[arg].endsWith("2")) {
                    csvTool.setProtocolVersion(Fit.ProtocolVersion.V2_0);
                }
                else {
                    System.out.println("Unknown Protocol Version.");
                }
            }
            else if (args[arg].equals("-e")) {
                csvTool.enableEnumsAsStrings(true);
            }
            else if (args[arg].equals("-re")) {
                csvTool.enableRemoveExpandedFields(true);
            }
            else if (args[arg].equals("-deg")) {
                csvTool.enableSemicirclesAsDegrees(true);
            }
            else if (args[arg].equals("-iso8601")) {
                csvTool.enableDateTimeAsISO8601(true);
            }

            if (nextArgumentDefinition > 0) {
                nextArgumentDefinition--;
                if ((nextArgumentDefinition == 0) && (csvTool.mesgDefinitionsToOutput.isEmpty())) {
                    System.out.println("No mesg definitions defined for --defn option.  Use 'none' if no definitions are desired.");
                    return;
                }
            }

            if (nextArgumentData > 0) {
                nextArgumentData--;
                if ((nextArgumentData == 0) && (csvTool.dataMessagesToOutput.isEmpty())) {
                    System.out.println("No data messages defined for --data option.");
                    return;
                }
            }
            arg++;
        }

        if (inputFileName == null || inputFileName.isEmpty()) {
            System.out.println("No input file was provided!");
            printUsage();
            return;
        }
        File file = new File(inputFileName);
        if (!file.exists()) {
            System.out.println("File does not exist: " + inputFileName);
            return;
        }

        if (fitToCsv) {
            if (outputFileName.length() >= 4 && outputFileName.substring(outputFileName.length() - 4, outputFileName.length()).compareTo(".csv") == 0) {
                outputFileName = outputFileName.substring(0, outputFileName.length() - 4);
            }

            System.out.printf("Decoding FIT binary file %s to %s*.csv files.\n", inputFileName, outputFileName);
            try {
                ByteArrayInputStream byteArrayInputStream = StreamHelpers.byteStreamFromFile(inputFileName);
                csvTool.convertFitToCsv(byteArrayInputStream);
            } catch (java.lang.OutOfMemoryError e) {
                System.out.printf("\n\nThere is insufficient memory available to process the file. Please increase the available memory by using the -Xmx<size> option when running the FIT CSV Tool.\ni.e. java -Xmx1G -jar FitCsvTool.jar %s\n", inputFileName);
            } catch (Exception e) {
                System.out.printf("Error: A problem occurred while decoding the file. The decoded CSV file may be truncated %s*.csv files.\n", outputFileName);
            }

            try {
                ByteArrayOutputStream csvByteArrayOutputStream = csvTool.getByteArrayOutputStream();
                if (csvByteArrayOutputStream.toString().equals("")) {
                    if (csvTool.getDataMessagesFilter().size() != 0 || csvTool.getMesgDefinitionsFilter().size() != 0) {
                        System.out.println("Warning: No filtered messages or filtered message definitions found.");
                    }
                    else {
                        System.out.println("Warning: No messages or message definitions found.");
                    }
                    return;
                }

                StreamHelpers.writeByteStreamToFile(csvByteArrayOutputStream, outputFileName + ".csv", true);

                if (csvTool.isGenerateDataFileEnabled()) {
                    ByteArrayOutputStream dataCsvStream = csvTool.getDataWriterByteArrayOutputStream();
                    StreamHelpers.writeByteStreamToFile(dataCsvStream, outputFileName + "_data.csv", false);
                }

                if (csvTool.isHideUnknownDataEnabled()) {
                    System.out.printf("Hid %d unknown field(s) and %d unknown message(s).\n", csvTool.getNumUnknownFields(), csvTool.getNumUnknownMesgs());
                }
            } catch (Exception e) {
                System.out.println("Error: A problem occurred while writing the output CSV files.");
            }
        }
        else if (csvToFit) {
            if (outputFileName.length() >= 4 && outputFileName.substring(outputFileName.length() - 4, outputFileName.length()).compareTo(".fit") == 0) {
                outputFileName = outputFileName.substring(0, outputFileName.length() - 4);
            }

            System.out.printf("Encoding %s into FIT binary file %s.fit.\n", inputFileName, outputFileName);
            try {
                ByteArrayInputStream byteArrayInputStream = StreamHelpers.byteStreamFromFile(inputFileName);
                csvTool.convertCsvToFit(byteArrayInputStream);
            } catch (Exception e) {
                System.out.printf("Error: A problem occurred while encoding the file. The encoded FIT file %s.fit may be a truncated.\n", outputFileName);
                if(e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
            }

            try {
                ByteArrayOutputStream fitByteArrayOutputStream = csvTool.getByteArrayOutputStream();
                StreamHelpers.writeByteStreamToFile(fitByteArrayOutputStream, outputFileName + ".fit", false);

            } catch (Exception e) {
                System.out.println("Error: A problem occurred while writing the output FIT file.");
            }
        }
        else {
            printUsage();
        }
    }

    /**
     * Converts the given FIT file to a CSV.
     *
     * @param byteArrayInputStream a java.io.ByteArrayInputStream of the given FIT file
     * @return a java.io.ByteArrayOutputStream containing the CSV data
     * @throws Exception if an error occurs while decoding a FIT file to a CSV file
     */
    public ByteArrayOutputStream convertFitToCsv(ByteArrayInputStream byteArrayInputStream) throws Exception {
        if (checkIntegrity) {
            if (!decode.checkFileIntegrity(byteArrayInputStream)) {
                if (!decode.getInvalidFileDataSize()) {
                    throw new FitRuntimeException("FIT file integrity failure.");
                }
                else {
                    println("FIT file integrity failure. Invalid file size in header.");
                    println("Trying to continue...");
                }
            }
            byteArrayInputStream.reset();
        }

        if (verificationTests) {
            runVerificationTests(byteArrayInputStream);
        }

        try {
            // CSV Writer writes all messages to the csv file
            setupCsvWriter();
            if (generateDataFile) {
                // Data Writer writes the data filtered messages
                setupDataWriter();
            }
            if (showInvalidValues) {
                decode.showInvalidValues();
            }

            mesgFilter = new MesgFilter();
            csvDataMesgFieldCounter = new CSVDataMesgFieldCounter();
            if (excludeMesgList) {
                mesgFilter.setMesgDefinitionsToIgnore(mesgDefinitionsToOutput);
                mesgFilter.setDataMessagesToIgnore(dataMessagesToOutput);
            }
            else {
                mesgFilter.setMesgDefinitionsToOutput(mesgDefinitionsToOutput);
                mesgFilter.setDataMessagesToOutput(dataMessagesToOutput);
            }

            registerListenersForCsvWriter();
            registerListenersForDataWriter();

            while (decode.bytesAvailable(byteArrayInputStream)) { // Try to read a file while more data is available.
                try {
                    decode.read(byteArrayInputStream);
                    decode.nextFile(); // Initialize to read next file (if any).
                } catch (FitRuntimeException e) {
                    if (decode.getInvalidFileDataSize()) {
                        // The exception might be due to a bad file size written
                        // by a device. Retry the decoding process.
                        decode.nextFile();
                    }
                    else {
                        // An actual exception has occurred.
                        throw e;
                    }
                }
            }
            if (dataMesgWriter != null) {
                dataMesgWriter.setMaxNumFields(csvDataMesgFieldCounter.getMaxNumFields());
            }
            csvDataMesgFieldCounter.flushMesgs();

        } catch (IOException e) {
            if (isFitSdkDebugEnabled()) {
                e.printStackTrace(System.out);
            }
            throw e;
        } finally {
            numUnknownFields = mesgWriter.getNumUnknownFields();
            numUnknownMesgs = mesgWriter.getNumUnknownMesgs();

            cleanupCsvWriter();
            cleanupDataWriter();
        }
        return this.byteArrayOutputStream;
    }

    /**
     * Converts the given CSV file to a FIT file.
     *
     * @param byteArrayInputStream a java.io.ByteArrayInputStream of the given CSV file
     * @return a java.io.ByteArrayOutputStream containing the encoded FIT file data
     * @throws Exception if an error occurs while encoding a CSV file to a FIT file
     */
public ByteArrayOutputStream convertCsvToFit(ByteArrayInputStream byteArrayInputStream) throws Exception {
        BufferEncoder encoder = new BufferEncoder(protocolVersion);

        try {
            if(!CSVReader.read(byteArrayInputStream, encoder, encoder, protocolVersion)) {
                throw new FitRuntimeException("FIT encoding error.");
            }
        } finally {
            byte[] fitFileBytes = encoder.close();

            byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(fitFileBytes);
        }

        return byteArrayOutputStream;
    }

    private void setupCsvWriter() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        mesgWriter = new MesgCSVWriter(byteArrayOutputStream);

        if (bytesAsHex) {
            mesgWriter.enableBytesAsHex(true);
        }
        if (dateTimeAsISO8601) {
            mesgWriter.enableDateTimeAsISO8601(true);
        }
        if (showInvalidsAsEmpty) {
            mesgWriter.enableShowInvalidsAsEmpty(true);
        }
        if (hideUnknownData) {
            mesgWriter.enableHideUnknownData(true);
        }
        if (enumsAsStrings) {
            mesgWriter.enableEnumsAsStrings(true);
        }
        if (removeExpandedFields) {
            mesgWriter.enableRemoveExpandedFields(true);
        }
        if (semicirclesAsDegrees) {
            mesgWriter.enableSemicirclesAsDegrees(true);
        }
    }

    private void setupDataWriter() {
        dataWriterByteArrayOutputStream = new ByteArrayOutputStream();
        dataMesgWriter = new MesgDataCSVWriter(dataWriterByteArrayOutputStream);

        if (bytesAsHex) {
            dataMesgWriter.enableBytesAsHex(true);
        }
        if (dateTimeAsISO8601) {
            dataMesgWriter.enableDateTimeAsISO8601(true);
        }
        if (showInvalidsAsEmpty) {
            dataMesgWriter.enableShowInvalidsAsEmpty(true);
        }
        if (hideUnknownData) {
            dataMesgWriter.enableHideUnknownData(true);
        }
        if (enumsAsStrings) {
            dataMesgWriter.enableEnumsAsStrings(true);
        }
        if (removeExpandedFields) {
            dataMesgWriter.enableRemoveExpandedFields(true);
        }
        if (semicirclesAsDegrees) {
            dataMesgWriter.enableSemicirclesAsDegrees(true);
        }
    }

    private void registerListenersForCsvWriter() {
        mesgFilter.addListener((MesgDefinitionListener) mesgWriter);
        mesgFilter.addListener((MesgListener) mesgWriter);

        decode.addListener((MesgDefinitionListener) mesgFilter);
        decode.addListener((MesgListener) mesgFilter);
    }

    private void registerListenersForDataWriter() {
        if (dataMesgWriter != null && csvDataMesgFieldCounter != null) {
            mesgFilter.addListener(csvDataMesgFieldCounter);
            csvDataMesgFieldCounter.addListener(dataMesgWriter);
        }
    }

    private void cleanupCsvWriter() {
        mesgWriter.close();
    }

    private void cleanupDataWriter() {
        if (dataMesgWriter != null) {
            dataMesgWriter.close();
        }
    }

    private void runVerificationTests(ByteArrayInputStream byteArrayInputStream) {
        System.out.println("Running FIT verification tests...");

        ActivityFileValidationPlugin plugin = new ActivityFileValidationPlugin();

        try {
            FitDecoder fitDecoder = new FitDecoder();
            fitDecoder.decode(byteArrayInputStream, plugin);
        } catch (FitRuntimeException e) {
            System.out.println("FitRuntimeException decoding file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception decoding file: " + e.getMessage());
        } finally {
            // If an exception occurred before onBroadcast() was called,
            // then the validation checks would not have been executed.
            // There may still be decoded messages that are worth validating,
            // so force the validation checks to execute. Some tests may be
            // skipped or fail.
            if (plugin.getResults().size() == 0) {
                plugin.repeatValidation();
            }

            System.out.println("Message Count: " + plugin.getMesgCount());

            for (ActivityFileValidationResult result : plugin.getResults()) {
                System.out.println(result);
                if (result.getDescription() != null) {
                    System.out.println("\t" + result.getDescription());
                }
            }

            byteArrayInputStream.reset();
        }
    }

    private void println(String string) {
        if (this.runningFromConsole) {
            System.out.println(string);
        }
    }

    /**
     * @return a java.io.ByteArrayOutputStream containing the converted contents of the FIT file
     */
    public ByteArrayOutputStream getByteArrayOutputStream() {
        return byteArrayOutputStream;
    }

    /**
     * @return a java.io.ByteArrayOutputStream containing data_csv contents of the converted FIT file if the data_csv
     * conversion option was enabled
     */
    public ByteArrayOutputStream getDataWriterByteArrayOutputStream() {
        return dataWriterByteArrayOutputStream;
    }

    /**
     * Encode file using the given Protocol Version. Default: Fit.ProtocolVersion.V2_0
     *
     * @param protocolVersion the protocol version to use when encoding files
     */
    public void setProtocolVersion(Fit.ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }
    /**
     * @return the Protocol Version used to encode FIT files. Default: Fit.ProtocolVersion.V2_0
     */
    public Fit.ProtocolVersion getProtocolVersion() {
        return protocolVersion;
    }

    /**
     * Sets the list of message definitions to filter from the FIT file when decoding. <p>
     * Note: if excludeMesgList is set to "true", this list is all the messages to exclude. Default behavior is
     * inclusive. </p>
     *
     * @param mesgDefinitionsToOutput a map of message definitions to filter when decoding a file
     */
    public void setMesgDefinitionFilter(HashSet<String> mesgDefinitionsToOutput) {
        this.mesgDefinitionsToOutput = mesgDefinitionsToOutput;
    }
    /**
     * @return the list of messages definitions to filter from the FIT file when decoding <p>
     * Note: if excludeMesgList is set to "true", this list is all the messages to exclude. Default behavior is
     * inclusive </p>
     */
    public HashSet<String> getMesgDefinitionsFilter() {
        return this.mesgDefinitionsToOutput;
    }

    /**
     * Sets the list of messages to filter from the FIT file when decoding. <p>
     * Note: if excludeMesgList is set to "true", this list is all the messages to exclude. Default behavior is
     * inclusive. </p>
     *
     * @param dataMessagesToOutput a map of data messages to filter when decoding a file
     */
    public void setDataMessagesFilter(HashSet<String> dataMessagesToOutput) {
        this.dataMessagesToOutput = dataMessagesToOutput;
    }
    /**
     * @return the list of data messages to filter from the FIT file when decoding <p>
     * Note: if excludeMesgList is set to "true", this list is all the messages to exclude. Default behavior is
     * inclusive </p>
     */
    public HashSet<String> getDataMessagesFilter() {
        return this.dataMessagesToOutput;
    }

    /**
     * @return the total number of unknown message fields
     */
    public int getNumUnknownFields() {
        return numUnknownFields;
    }

    /**
     * @return the total number of unknown messages
     */
    public int getNumUnknownMesgs() {
        return numUnknownMesgs;
    }

    /**
     * Hide unknown data and save the number of unknown values and messages encountered. Default: false
     *
     * @param enable if true then unknown data will be hidden; if false then unknown data will be shown
     */
    public void enableHideUnknownData(boolean enable) {
        this.hideUnknownData = enable;
    }
    /**
     * @return true if unknown data will be hidden. Default: false
     */
    public boolean isHideUnknownDataEnabled() {
        return hideUnknownData;
    }

    /**
     * Generate a data file during conversion from FIT to CSV. Messages and message definitions provided in
     * setMesgDefinitionFilter and setDataMessagesFilter will be printed to the data file unless excluded using
     * setExcludeMesgList. Default: false
     *
     * @param enable if true then a data file will be generated; if false then a data file will not be generated
     */
    public void enableGenerateDataFile(boolean enable) {
        this.generateDataFile = enable;
    }
    /**
     * @return true if a data file will be generated while decoding the input FIT file. Default: false
     */
    public boolean isGenerateDataFileEnabled() {
        return generateDataFile;
    }

    /**
     * Enable running file verification tests while decoding a FIT file. Default: false
     *
     * @param enable if true then verification tests will be run; if false tests will not be run
     */
    public void enableVerificationTests(boolean enable) {
        this.verificationTests = enable;
    }
    /**
     * @return true if verification tests are to be run when decoding a FIT file. Default: false
     */
    public boolean isVerificationTestsEnabled() {
        return verificationTests;
    }

    /**
     * Output byte values and arrays to hexadecimal values. Default: false
     *
     * @param enable if true then byte values will be output as hexadecimal values; if false byte values will be output as decimals
     */
    public void enableBytesAsHex(boolean enable) {
        this.bytesAsHex = enable;
    }
    /**
     * @return true if byte values will be output as hexadecimal values. Default: false
     */
    public boolean isBytesAsHexEnabled() {
        return bytesAsHex;
    }

    /**
     * Output date-time values as ISO-8601 formatted strings. Default: false
     *
     * @param enable if true date-time values will be output as ISO-8601 formatted strings; if false date times will be output as FIT timestamps
     */
    public void enableDateTimeAsISO8601(boolean enable) {
        this.dateTimeAsISO8601 = enable;
    }
    /**
     * @return true date-time values will be output as ISO-8601 formatted strings. Default: false
     */
    public boolean isDateTimeAsISO8601Enabled() {
        return dateTimeAsISO8601;
    }

    /**
     * Output semicircle values as degrees. Default: false
     *
     * @param enable if true semicircle values will be output as degrees; if false semicircle values will remain unchanged
     */
    public void enableSemicirclesAsDegrees(boolean enable) {
        this.semicirclesAsDegrees = enable;
    }
    /**
     * @return true if semicircle values will be output as degrees. Default: false
     */
    public boolean isSemicirclesAsDegreesEnabled() {
        return semicirclesAsDegrees;
    }

    /**
     * Check the integrity of the FIT file before decoding and converting it to a CSV file. Default: false
     *
     * @param enable if true the integrity of the FIT file will be checked before converting it to a CSV file; if false the file integrity will not be checked
     */
    public void enableCheckIntegrity(boolean enable) {
        this.checkIntegrity = enable;
    }
    /**
     * @return true if integrity of the FIT file will be checked before converting it to a CSV file. Default: false
     */
    public boolean isCheckIntegrityEnabled() {
        return checkIntegrity;
    }

    /**
     * Show invalid field values in the CSV output. Default: false
     *
     * @param enable if true the invalid values will be included in the output CSV; if false invalid values will not be included in the output CSV
     */
    public void enableShowInvalidValues(boolean enable) {
        this.showInvalidValues = enable;
    }
    /**
     * @return true if invalid field values will be included in the output CSV. Default: false
     */
    public boolean isShowInvalidValuesEnabled() {
        return showInvalidValues;
    }

    /**
     * Show invalid field values as empty cells in the CSV output. Default: false
     *
     * @param enable if true invalid values will be shown as empty cells in the output CSV; if false cells with invalid values will not be included in the output CSV
     */
    public void enableShowInvalidsAsEmpty(boolean enable) {
        this.showInvalidsAsEmpty = enable;
        if (this.showInvalidsAsEmpty) {
            this.showInvalidValues = true;
        }
    }
    /**
     * @return true if invalid field values will be shown as empty cells in the output CSV. Default: false
     */
    public boolean isShowInvalidsAsEmptyEnabled() {
        return showInvalidsAsEmpty;
    }

    /**
     * Output enum values as their corresponding string labels when possible. Default: false <p>
     * Note: CSV files generated with this option will not be able to be converted back into .FIT files. </p>
     *
     * @param enable if true invalid enum values will be output as strings; if false enum values will be output as numeric values
     */
    public void enableEnumsAsStrings(boolean enable) {
        this.enumsAsStrings = enable;
    }
    /**
     * @return true if enum field values will be output as a string. Default: false
     */
    public boolean isEnumsAsStringsEnabled() {
        return enumsAsStrings;
    }

    /**
     * Remove expanded fields from CSV output. This removes fields that have been generated through component expansion. Default: false
     *
     * @param enable if true expanded fields will not be shown in the CSV output; if false expanded fields will be shown in the CSV output
     */
    public void enableRemoveExpandedFields(boolean enable) {
        this.removeExpandedFields = enable;
    }
    /**
     * @return true if expanded fields values will not be shown in the CSV output. This removes fields that have been
     * generated from component expansion. Default: false
     */
    public boolean isRemoveExpandedFieldsEnabled() {
        return removeExpandedFields;
    }

    /**
     * Sets message filter list to be interpreted as messages and definitions to exclude during conversion. Default: false
     *
     * Changes the behaviour of the MesgDefinitionFilter and DataMessagesFilter options to
     * filter out the messages listed. The default behaviour without this is to exclude all messages except those
     * provided in mesgDefinitionsToOutput and dataMessagesToOutput.
     *
     * @param excludeMesgList if true the MesgDefinitionFilter list and DataMessagesFilter list will exclude all provided messages from CSV output; if false the filters will exclude all messages not specified in the filter lists
     */
    public void setExcludeMesgList(boolean excludeMesgList) {
        this.excludeMesgList = excludeMesgList;
    }
    /**
     * Changes the behaviour of the MesgDefinitionFilter and DataMessagesFilter options to
     * filter out the messages listed. The default behaviour without this is to exclude all messages except those
     * provided in mesgDefinitionsToOutput and dataMessagesToOutput.
     *
     * @return true messages and message definitions supplied to the filter lists are to be excluded from CSV output. Default: false
     */
    public boolean isExcludeMesgListEnabled() {
        return excludeMesgList;
    }

    /**
     * Enable debugging print statements when decoding and encoding using the FIT SDK. Default: false <p>
     * Note: This will slow down the CSVTool and prints numerous messages to the console. </p>
     *
     * @param enable if true debug statements will be printed to the console; if false debug statements will not be printed to the console
     */
    public void enableFitSdkDebugging(boolean enable) {
        Fit.debug = enable;
    }
    /**
     * @return true if debug statements will be printed to the console. Default: false <p>
     * Note: This will slow down the CSVTool and prints numerous messages to the console </p>
     */
    public boolean isFitSdkDebugEnabled() {
        return Fit.debug;
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar FitCSVTool.jar <options> <file>");
        System.out.println("      -b <FIT FILE> <CSV FILE>  FIT binary to CSV.");
        System.out.println("      -c <CSV FILE> <FIT FILE>  CSV to FIT binary.");
        System.out.println("      -t Enable file verification tests.");
        System.out.println("      -d Enable debug output.");
        System.out.println("      -i Check integrity of FIT file before decoding.");
        System.out.println("      -s Show invalid fields in the CSV file.");
        System.out.println("      -se Show invalid fields in the CSV file as empty cells.");
        System.out.println("      -u Hide unknown data and report statistics on how much is hidden.");
        System.out.println("      -x Print byte values as hexadecimal.");
        System.out.println("      -deg Print semicircle values as degrees.");
        System.out.println("      -iso8601 Print date-time values as ISO 8601 formatted strings.");
        System.out.println("      -ex Changes the behaviour of the --defn and --data options to");
        System.out.println("          filter out the messages listed. The default behaviour without");
        System.out.println("          this flag is to exclude all messages except those listed");
        System.out.println("          after the --defn and the --data options.");
        System.out.println("      -pN Encode file using Protocol Version <N>. Default: 2");
        System.out.println("      -e Print enum values as their corresponding String labels when");
        System.out.println("          possible. Note: CSV files generated with this option will not");
        System.out.println("          be able to be converted back into .FIT files.");
        System.out.println("      -re Remove expanded fields from CSV output. This removes fields");
        System.out.println("          that have been generated through component expansion and");
        System.out.println("          which do not exist in the source .FIT file");
        System.out.println("      --defn <MESSAGE_STRING_0,MESSAGE_STRING_1,...> Narrows down the");
        System.out.println("          definitions output to CSV. Use 'none' for no definitions");
        System.out.println("          When this option is used only the message definitions");
        System.out.println("          in the comma separated list will be written to the CSV.");
        System.out.println("          eg. --defn file_capabilities,record,file_creator");
        System.out.println("          Note: This option is only compatible with the -b option.");
        System.out.println("      --data <MESSAGE_STRING_0,MESSAGE_STRING_1,...> Narrows down the");
        System.out.println("          data output to CSV. When this option is used only the data");
        System.out.println("          in the comma separated list will be written to the csv.");
        System.out.println("          eg. --data file_capabilities,record,file_creator");
        System.out.println("          Note: This option is only compatible with the -b option.");
    }
}