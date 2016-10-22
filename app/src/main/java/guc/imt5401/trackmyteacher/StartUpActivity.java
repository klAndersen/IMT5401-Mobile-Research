package guc.imt5401.trackmyteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * The main activity that launches the application.
 * @author Knut Lucas Andersen
 */
public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
    } //onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_up, menu);
        return true;
    } //onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } //if
        return super.onOptionsItemSelected(item);
    } //onOptionsItemSelected

    /**
     * Displays the Application settings
     * @param v - View
     */
    public void showLocateTeacher(View v) {
        Intent intent = new Intent(this, LocateTeacherActivity.class);
        startActivity(intent);
    } //showSettings

    /**
     * Displays the Application log
     * @param v - View
     */
    public void showApplicationLog(View v) {
        Intent intent = new Intent(this, ShowApplicationLogActivity.class);
        startActivity(intent);
    } //showApplicationLog

    /**
     * Displays the Application settings
     * @param v - View
     */
    public void showSettings(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    } //showSettings

    /**
     * Displays the activity for registering access points
     * @param v - View
     */
    public void showRegisterAccessPoints(View v) {
        Intent intent = new Intent(this, RegisterAccessPointsActivity.class);
        startActivity(intent);
    } //showRegisterAccessPoints

    public void acceptTrackingRequest(View v) {
        //TODO: add code for accepting tracking
    } //acceptTrackingRequest

    public void denyTrackingRequest(View v) {
        //TODO: add code for accepting tracking
    } //denyTrackingRequest
} //StartUpActivity
