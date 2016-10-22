package guc.imt5401.trackmyteacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

/**
 * This only displays the settings available by using fragments.
 * @author Knut Lucas Andersen
 */
public final class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    } //onCreate

    public void allowServiceToRunInBackground(View v) {
        CheckBox chkRunBackgroundService = (CheckBox) v.findViewById(R.id.chkRunBackgroundService);
        boolean status = chkRunBackgroundService.isChecked();
        Filestorage.saveOptionAllowServiceToRunInBackground(this, status);
    } //allowServiceToRunInBackground

    public void selectRunAlways(View v) {
        int alwaysRun = getResources().getInteger(R.integer.option_always_run_tracking);
        RadioButton rb = (RadioButton) findViewById(R.id.rbRunAlways);
        Filestorage.saveOptionForRunningTracking(this, alwaysRun);
        SettingsFragment.selectRadioButton(this, rb);
    } //selectRunAlways

    public void selectRunNever(View v) {
        int neverRun = getResources().getInteger(R.integer.option_never_run_tracking);
        RadioButton rb = (RadioButton) findViewById(R.id.rbRunNever);
        Filestorage.saveOptionForRunningTracking(this, neverRun);
        SettingsFragment.selectRadioButton(this, rb);
        //create an intent related to the service class
        Intent serviceIntent = new Intent(this, AutomaticService.class);
        //stop the service
        stopService(serviceIntent);
    } //selectRunNever

    public void selectRunTimeInterval(View v) {
        int timedRun = getResources().getInteger(R.integer.option_run_timed_tracking);
        RadioButton rb = (RadioButton) findViewById(R.id.rbRunTimedInterval);
        Filestorage.saveOptionForRunningTracking(this, timedRun);
        SettingsFragment.selectRadioButton(this, rb);
    } //selectRunTimeInterval

    public void startAtBootUp(View v) {
        CheckBox chkStartAtBoot = (CheckBox) v.findViewById(R.id.chkStartAtBoot);
        boolean status = chkStartAtBoot.isChecked();
        Filestorage.saveStartAtBootOption(this, status);
    } //startAtBootUp

    public void setAcceptAllTrackingRequests(View v) {
        CheckBox chkAcceptAllRequests = (CheckBox) v.findViewById(R.id.chkAcceptAllRequests);
        boolean status = chkAcceptAllRequests.isChecked();
        Filestorage.saveAcceptAllTrackingRequests(this, status);
    } //setAcceptAllTrackingRequests
} //SettingsActivity