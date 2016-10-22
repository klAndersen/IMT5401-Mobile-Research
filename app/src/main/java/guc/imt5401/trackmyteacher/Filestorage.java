package guc.imt5401.trackmyteacher;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Class that saves values related to settings in SharedPreferences,
 * and reads/writes to files internally and externally (SD-Card).
 * @author Knut Lucas Andersen
 */
public final class Filestorage {
    /**
     * SharedPreference value key: GCM token
     **/
    public static final String SENT_TOKEN_TO_SERVER = "sentTokenToServer";
    /**
     * SharedPreference value key: GCM registration
     **/
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    /**
     * SharedPreference value key: The time for tracking to stop (if set on timed intervals)
     **/
    protected static final String STOP_APPLICATION_TIME_KEY = "stopTime";
    /**
     * SharedPreference value key: The time for tracking to start (if set on timed intervals)
     **/
    protected static final String START_APPLICATION_TIME_KEY = "startTime";
    /**
     * SharedPreference value key: How often the tracking is supposed to run
     **/
    protected static final String RUN_TIME_OPTION_KEY = "runtimeOption";
    /**
     * SharedPreference value key: Start this application after boot completed
     **/
    protected static final String START_SERVICE_AFTER_BOOT_KEY = "startOnBoot";
    /**
     * SharedPreference value key: Allow service to constantly run in background even after message(s) is sent
     **/
    protected static final String ALLOW_SERVICE_TO_RUN_IN_BACKGROUND_KEY = "runServiceInBackground";
    /**
     * SharedPreference value key: Stores the registrationID for this device
     */
    protected static final String REGISTRATIONID_KEY = "registrationID";
    /**
     * SharedPreference value key: Automatically accept and return current position to those requiring it
     */
    protected static final String SEND_CURRENT_POSITION_AUTOMATICALLY_KEY = "acceptAllTrackingRequests";
    /**
     * This applications SharedPreference
     **/
    protected static final String SHARED_PREFERENCES_SETTINGS = "settingsPreference";

    private Filestorage() {
        throw new UnsupportedOperationException();
    } //constructor

    /**
     * Returns an object of SharedPreferences that contains the chosen settings for the application
     *
     * @param context - Context
     * @return SharedPreferences: The object that contains the settings displayed on SettingsActivity
     */
    protected static SharedPreferences getSharedPreferances(Context context) {
        //only this application shall use this sharedpreference
        int modus = Context.MODE_PRIVATE;
        //create and retrieve the sharedpreference
        SharedPreferences SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_SETTINGS, modus);
        return SharedPreferences;
    } //getSharedPreferances

    /**
     * Saves the value for whether or not the application is to start automatically
     * after boot is completed.
     * @param context - Context
     * @param startOnBoot - boolean: True - start service after boot completed, <br />
     * false - start service manually or based on user settings
     */
    public static void saveStartAtBootOption(Context context, final boolean startOnBoot) {
        //create an editor to edit the SharedPreferences and store them
        SharedPreferences.Editor spEditor = getSharedPreferances(context).edit();
        spEditor.putBoolean(START_SERVICE_AFTER_BOOT_KEY, startOnBoot);
        spEditor.apply();
    } //saveRunAutoReplyOption

    /**
     * Saves the value for whether or not the applications service is to run continuously
     * or to be stopped after finishing tasks.
     * @param context - Context
     * @param runInBackground - boolean: True - service continues to run in background, <br />
     * False - service stops after finishing tasks
     */
    public static void saveOptionAllowServiceToRunInBackground(Context context, final boolean runInBackground) {
        //create an editor to edit the SharedPreferences and store them
        SharedPreferences.Editor spEditor = getSharedPreferances(context).edit();
        spEditor.putBoolean(ALLOW_SERVICE_TO_RUN_IN_BACKGROUND_KEY, runInBackground);
        spEditor.apply();
    } //saveOptionAllowServiceToRunInBackground

    /**
     * Saves the option value for when tracking is enabled (use constant values from integers.xml); <br />
     * - never run <br />
     * - always run <br />
     * - timed interval
     * @param context - Context
     * @param runOption - int: The selected option
     */
    public static void saveOptionForRunningTracking(Context context, final int runOption) {
        //create an editor to edit the SharedPreferences and store them
        SharedPreferences.Editor spEditor = getSharedPreferances(context).edit();
        spEditor.putInt(RUN_TIME_OPTION_KEY, runOption);
        spEditor.apply();
    } //saveOptionForRunningTracking
    /**
     * Saves the time to start/turn on the tracking function.
     * @param context - Context
     * @param startTimeIndex - int: Index for the time to turn on tracking
     */
    public static void saveNewStartTime(Context context, final int startTimeIndex) {
        //create an editor to edit the SharedPreferences and store them
        SharedPreferences.Editor spEditor = getSharedPreferances(context).edit();
        spEditor.putInt(START_APPLICATION_TIME_KEY, startTimeIndex);
        spEditor.apply();
    } //saveNewStartTime

    /**
     * Saves the time to stop/turn off the tracking function.
     * @param context - Context
     * @param stopTimeIndex - int: Index for the time to turn off tracking
     */
    public static void saveNewStopTime(Context context, final int stopTimeIndex) {
        //create an editor to edit the SharedPreferences and store them
        SharedPreferences.Editor spEditor = getSharedPreferances(context).edit();
        spEditor.putInt(STOP_APPLICATION_TIME_KEY, stopTimeIndex);
        spEditor.apply();
    } //saveNewStopTime

    /**
     * Saves the value for whether or not position should be returned automatically
     * @param context - Context
     * @param acceptAllTrackingRequests - boolean: Index for the time to turn off tracking
     */
    public static void saveAcceptAllTrackingRequests(Context context, final boolean acceptAllTrackingRequests) {
        //create an editor to edit the SharedPreferences and store them
        SharedPreferences.Editor spEditor = getSharedPreferances(context).edit();
        spEditor.putBoolean(SEND_CURRENT_POSITION_AUTOMATICALLY_KEY, acceptAllTrackingRequests);
        spEditor.apply();
    } //saveAcceptAllTrackingRequests

    /**
     * Store the device GCM registration ID
     * @param context - Context
     * @param registrationID - String: This device registrationID
     */
    protected static void storeDeviceRegistrationID(Context context, String registrationID) {
        //create an editor to edit the SharedPreferences and store them
        SharedPreferences.Editor spEditor = getSharedPreferances(context).edit();
        spEditor.putString(REGISTRATIONID_KEY, registrationID);
        spEditor.commit();
    } //storeDeviceRegistrationID

    /**
     * Creates an ArrayList&lt;String&gt containing the system log <br />
     * If the file doesn't exist, it will be created. <br />
     * If file is empty, only a blank line is returned
     * @param context - Context
     * @return ArrayList&lt;String&gt: File content
     */
    protected static synchronized ArrayList<String> readLogFromFile(Context context) {
        String oneLine;
        ArrayList<String> logList = new ArrayList<>();
        try {
            Resources res = context.getResources();
            String fileName = res.getString(R.string.filename);
            File file = context.getFileStreamPath(fileName);
            //does the file exist?
            if (!file.exists()) {
                //file doesn't exist, create it
                createFile(context, fileName);
            } //if
            //does the file have content?
            if (file.length() > 0) {
                //try to open and read from the file
                FileInputStream fileInputStream = context.openFileInput(fileName);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferReader = new BufferedReader(inputStreamReader);
                //read the first line from the file
                oneLine = bufferReader.readLine();
                //as long as the file has content...
                while (oneLine != null) {
                    //add current line to ArrayList
                    logList.add(oneLine);
                    //and read the next line
                    oneLine = bufferReader.readLine();
                } //while
                inputStreamReader.close();
                bufferReader.close();
                fileInputStream.close();
            } //if
        } catch (Exception ex) {
            //unknown error, display error message
            String errorMsg =  context.getString(R.string.unknown_error_exception);
            Toast.makeText(context, errorMsg + ex.getMessage(), Toast.LENGTH_LONG).show();
        } //try/catch
        return logList;
    } //readFromLog

    /**
     * Write system log to file. <br />
     * If the file doesn't exist, it will be created.
     * @param context - Context
     * @param logList - ArrayList&lt;String&gt: ArrayList containing the system log
     */
    protected static synchronized void writeLogToFile(Context context, ArrayList<String> logList) {
        try {
            Resources res = context.getResources();
            String fileName = res.getString(R.string.filename);
            File file = context.getFileStreamPath(fileName);
            //does the file exist?
            if (!file.exists()) {
                //file doesn't exist, create it
                createFile(context, fileName);
            } //if
            //attempt to open the file and write content to it
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            //loop through the content of the ArrayList and write content to file
            for (int i = 0; i < logList.size(); i++) {
                outputStreamWriter.write(logList.get(i) + '\n');
            } //for
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (Exception ex) {
            //unknown error, display error message
            String errorMsg =  context.getString(R.string.unknown_error_exception);
            Toast.makeText(context, errorMsg + ex.getMessage(), Toast.LENGTH_LONG).show();
        } //try/catch
    } //writeLogToFile

    /**
     * Deletes the system log by just writing blank ("") to the file
     * @param context - Context
     */
    protected static void deleteLog(Context context) {
        try {
            Resources res = context.getResources();
            String fileName = res.getString(R.string.filename);
            File file = context.getFileStreamPath(fileName);
            //does the file exist?
            if (!file.exists()) {
                //file doesn't exist, create it
                createFile(context, fileName);
            } //if
            //attempt to open the file and write content to it
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            //write blank ("") to file
            outputStreamWriter.write("");
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (Exception ex) {
            //unknown error, display error message
            String errorMsg =  context.getString(R.string.unknown_error_exception);
            Toast.makeText(context, errorMsg + ex.getMessage(), Toast.LENGTH_LONG).show();
        } //try/catch
    } //deleteLog

    /**
     * Creates a new file based on the directory passed through Context (context.getFilesDir())
     * where filename is based on the passed value
     * @param context - Context
     * @param fileName - Name of the file to create
     */
    private static void createFile(Context context, String fileName) {
        @SuppressWarnings("unused")
        File file = new File(context.getFilesDir(), fileName);
    } //createFile
} //Filestorage