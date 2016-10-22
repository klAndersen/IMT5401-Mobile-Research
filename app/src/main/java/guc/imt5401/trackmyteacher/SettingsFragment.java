package guc.imt5401.trackmyteacher;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Displays the various settings for this application.
 * @author Knut Lucas Andersen
 */
public class SettingsFragment extends Fragment {
    private static Context context;
    private static View viewToDisplay;
    private static Spinner spinnerEndTime;
    private static Spinner spinnerStartTime;
    private static ArrayList<RadioButton> rbList;
    private static RadioButton rbRunTimedInterval;
    private static SharedPreferences SharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewToDisplay = null;
        try {
            context = getActivity();
            SharedPreferences = Filestorage.getSharedPreferances(getActivity());
            viewToDisplay = inflater.inflate(R.layout.fragment_settings, container, false);
            setValuesCheckboxes();
            initializeRadioButtons();
        } catch (Exception ex) {
            ex.printStackTrace();
        } //try/catch
        return viewToDisplay;
    } //onCreateView

    /**
     * Enables/disables the spinners based on the parameter received.
     * @param enabled - boolean: True - spinners enabled, <br />
     * false - spinners disabled
     */
    private static void enableSpinners(boolean enabled) {
        //create objects of the spinners to disable them
        spinnerStartTime = (Spinner) viewToDisplay.findViewById(R.id.spinnerStartTime);
        spinnerEndTime = (Spinner) viewToDisplay.findViewById(R.id.spinnerEndTime);
        spinnerStartTime.setEnabled(enabled);
        spinnerEndTime.setEnabled(enabled);
    } //enableSpinners

    /**
     * Initializes the RadioButtons by creating the objects and setting values. <br />
     * It also enables/disables the spinner according to saved selected RadioButton value.
     */
    private static void initializeRadioButtons() {
        //get option values from string_buttons.xml
        int optionNeverRun = context.getResources().getInteger(R.integer.option_never_run_tracking);
        int optionRunAlways = context.getResources().getInteger(R.integer.option_always_run_tracking);
        int optionTimedInterval = context.getResources().getInteger(R.integer.option_run_timed_tracking);

        //create an ArrayList and get the buttons from resources
        rbList = new ArrayList<>();
        RadioButton rbRunNever = (RadioButton) viewToDisplay.findViewById(R.id.rbRunNever);
        RadioButton rbRunAlways = (RadioButton) viewToDisplay.findViewById(R.id.rbRunAlways);
        rbRunTimedInterval = (RadioButton) viewToDisplay.findViewById(R.id.rbRunTimedInterval);

        //add the RadioButtons to the ArrayList (only these three, since they don't have a radiogroup)
        rbList.add(rbRunNever);
        rbList.add(rbRunAlways);
        rbList.add(rbRunTimedInterval);
        boolean enabled = false;
        final int defValue = context.getResources().getInteger(R.integer.option_never_run_tracking);
        final int storedOption = SharedPreferences.getInt(Filestorage.RUN_TIME_OPTION_KEY, defValue);
        //what value was saved? check the correct RadioButton
        if (storedOption == optionNeverRun) {
            selectRadioButton(context, rbRunNever);
        } else if (storedOption == optionRunAlways) {
            selectRadioButton(context, rbRunAlways);
        } else if (storedOption == optionTimedInterval) {
            enabled = true;
            selectRadioButton(context, rbRunTimedInterval);
        } //if
        enableSpinners(enabled);
        setSpinnerValueAndListener();
    } //initializeRadioButtons

    /**
     * Checks the selected RadioButton and enables/disables the spinners
     * based on selected RadioButton.
     * @param context - Context
     * @param rbSelected - RadioButton: The checked RadioButton
     */
    protected static void selectRadioButton(Context context, RadioButton rbSelected) {
        try {
            //loop through the RadioButtons in the ArrayList
            for (RadioButton rb : rbList) {
                //is the current RadioButton the selected?
                if (rbSelected == rb) {
                    rb.setChecked(true);
                } else {
                    rb.setChecked(false);
                } //if
            } //for
            if (rbSelected == rbRunTimedInterval) {
                enableSpinners(true);
            } else {
                enableSpinners(false);
            } //if
        } catch (Exception ex) {
            String errorMsg = context.getString(R.string.unknown_error_exception);
            Toast.makeText(context, errorMsg + ex.getMessage(), Toast.LENGTH_LONG).show();
        } //try/catch
    } //selectRadioButton

    /**
     * Sets the values in spinners (default if nothing is stored) and
     * sets listeners to the spinners.
     * @see Spinner#setOnItemSelectedListener(OnItemSelectedListener)
     */
    private static void setSpinnerValueAndListener() {
        //get the values, if any from SharedPreferences
        int index = SharedPreferences.getInt(Filestorage.START_APPLICATION_TIME_KEY, 0);
        spinnerStartTime.setSelection(index);
        index = SharedPreferences.getInt(Filestorage.STOP_APPLICATION_TIME_KEY, 0);
        spinnerEndTime.setSelection(index);
        //create listener for when tracking should start
        spinnerStartTime.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                //get the index for the selected element and save the index in SharedPreferences
                int item = spinnerStartTime.getSelectedItemPosition();
                Filestorage.saveNewStartTime(context, item);
            } //onItemSelected

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //nothing chosen, do nothing
            } //onNothingSelected
        }); //setOnItemSelectedListener
        //create listener for when tracking should stop
        spinnerEndTime.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                //get the index for the selected element and save the index in SharedPreferences
                int item = spinnerEndTime.getSelectedItemPosition();
                Filestorage.saveNewStopTime(context, item);
            } //onItemSelected

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //nothing is selected, do nothing
            } //onNothingSelected
        }); //setOnItemSelectedListener
    } //setSpinnerValueAndListener

    /**
     * Sets the values in the checkboxes
     */
    private static void setValuesCheckboxes() {
        //checkbox for whether or not the application should start at boot
        boolean checked = SharedPreferences.getBoolean(Filestorage.START_SERVICE_AFTER_BOOT_KEY, false);
        CheckBox chkStartAtBoot = (CheckBox) viewToDisplay.findViewById(R.id.chkStartAtBoot);
        chkStartAtBoot.setChecked(checked);
        //checkbox for whether or not the application should always run in the background
        checked = SharedPreferences.getBoolean(Filestorage.ALLOW_SERVICE_TO_RUN_IN_BACKGROUND_KEY, false);
        CheckBox chkRunBackgroundService = (CheckBox) viewToDisplay.findViewById(R.id.chkRunBackgroundService);
        chkRunBackgroundService.setChecked(checked);
        //checkbox for whether or not the application should always return current position
        checked = SharedPreferences.getBoolean(Filestorage.SEND_CURRENT_POSITION_AUTOMATICALLY_KEY, false);
        CheckBox chkAcceptAllRequests = (CheckBox) viewToDisplay.findViewById(R.id.chkAcceptAllRequests);
        chkAcceptAllRequests.setChecked(checked);
    } //setValuesCheckboxes
} //SettingsFragment