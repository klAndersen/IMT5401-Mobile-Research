package guc.imt5401.trackmyteacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

/**
 * Displays, records and sends measured Wi-Fi data to server database.
 *@author Knut Lucas Andersen
 */
public class RegisterAccessPointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_access_points);
    } //onCreate

    private void displayWiFiData() {
        WiFiObjectClass wifiObject = getCurrentWiFiData();
        //TODO: retrieve existing resources and add WiFi data
    } //displayWiFiData

    private WiFiObjectClass getCurrentWiFiData() {
        WiFiObjectClass wifiObject = null;
        try {
            //TODO: retrieve data and add it to the object
        } catch (Exception ex) {
            ex.printStackTrace();
        } //try/catch
        return wifiObject;
    } //

    /**
     *
     * @param v - View
     */
    public void startRecordingWiFiSignal(View v) {
        ArrayList<WiFiObjectClass> wifiObjectList = new ArrayList<>();
        //TODO: Create this function
    } //startRecordingWiFiSignal

    /**
     *
     * @param v - View
     */
    public void stopRecordingWiFiSignal(View v) {
        //TODO: Create this function
    } //stopRecordingWiFiSignal
} //RegisterAccessPointsActivity
