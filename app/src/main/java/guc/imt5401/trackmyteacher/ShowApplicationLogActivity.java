package guc.imt5401.trackmyteacher;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Class that reads and displays system logs,
 * and the possibility to delete the log. <br />
 * System log contains events: <br />
 * - Error Messages <br />
 * - Registration at the server / GCM <br />
 * - Unregisters from server / GCM <br />
 * - Received messages from server / GCM
 * @author Knut Lucas Andersen
 */
public class ShowApplicationLogActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systemlog);
        fillListView();
    } //onCreate

    /**
     * Fills a ListView with the applications system log
     */
    private void fillListView() {
        ArrayList<String> logList;
        ArrayAdapter<String> adapter;
        ListView lvSystemlog;
        try {
            //read the data and find the ListView
            logList = Filestorage.readLogFromFile(this);
            lvSystemlog = (ListView) findViewById(R.id.lvSystemlog);
            //connect adapter and ListView
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, logList);
            lvSystemlog.setAdapter(adapter);
        } catch (Exception ex) {
            //unknown error, display error message
            String errorMsg = getString(R.string.unknown_error_exception);
            Toast.makeText(this, errorMsg + ex.getMessage(), Toast.LENGTH_LONG).show();
        } //try/catch
    } //fillListView

    /**
     * Deletes the system logs and then displays the emptied listview
     * @param V - View:
     */
    public void deleteSystemLog(View V) {
        Filestorage.deleteLog(this);
        fillListView();
    } //deleteSystemLog
} //ShowApplicationLogActivity