package guc.imt5401.trackmyteacher;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 *@author Knut Lucas Andersen
 */
public class LocateTeacherActivity extends AppCompatActivity {
    private static Context context;
    private static View viewToDisplay;
    private static ListView lvListView;
    private static ArrayList<String> teacherList;
    private static CheckedTextView chktvChooseAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate_teacher);
        context = this;
        teacherList = new ArrayList<>();
        viewToDisplay = this.findViewById(android.R.id.content);
        chktvChooseAll = (CheckedTextView) findViewById(R.id.chktvChooseAll);
        setSearchFieldListener();
    } //onCreate

    /**
     * Checks all the teachers that are currently listed in the CheckedTextView
     * @param v - View
     */
    public void checkAllListedTeachers(View v) {
        try {
            //change the state of the CheckedTextView,
            //and get the check status of all entries
            chktvChooseAll.toggle();
            boolean checked = chktvChooseAll.isChecked();
            //loop through the content in the ListView
            for (int i = 0; i < lvListView.getCount(); i++) {
                //check/un-check entries
                lvListView.setItemChecked(i, checked);
            } //for
        } catch (Exception ex) {
            ex.printStackTrace();
            String errorMsg = context.getString(R.string.unknown_error_exception);
            Toast.makeText(context, errorMsg + ex.getMessage(), Toast.LENGTH_LONG).show();
        } //try/catch
    } //checkAllListedTeachers

    /**
     * Send tracking request to the selected teacher(s)
     * @param v - View
     */
    public void trackSelectedTeachers(View v) {
        //create intent for requesting selected teachers location
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(context.getString(R.string.intent_locate_teachers));
        //send broadcast
        context.sendBroadcast(broadcastIntent);
    } //sendTrackingRequest

    /**
     * Un-check the selected teacher(s)
     * @param v - View
     */
    public void unCheckSelectedTeachers(View v) {
        //loop through the content in the ListView
        //and un-check everyone
        for (int i = 0; i < lvListView.getCount(); i++) {
            lvListView.setItemChecked(i, false);
        } //for
    } //unCheckSelectedTeachers

    private static void setSearchFieldListener() {
        EditText inputSearch = (EditText) viewToDisplay.findViewById(R.id.inputSearch);
        inputSearch.setHint(context.getString(R.string.search_hint_teacher));
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            } //onTextChanged

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            } //beforeTextChanged

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    fillListViewWithContacts();
                } else {
                    //uses to lowercase to ensure that the input is properly checked
                    String name = s.toString().toLowerCase(Locale.getDefault());
                    ArrayList<String> matchingContactsList = new ArrayList<>();
                    for (int i = 0; i < teacherList.size(); i++) {
                        if (teacherList.get(i).toLowerCase(Locale.getDefault()).contains(name)) {
                            matchingContactsList.add(teacherList.get(i));
                        } //if
                    } //for
                    fillListViewWithSearchResult(matchingContactsList);
                    checkSelectedTeachers();
                } //if
            } //afterTextChanged
        }); //addTextChangedListener
    } //setSearchFieldListener

    /**
     * Fills a ListView with all registered teachers. <br />
     * The teachers selected for tracking is checked.
     */
    protected static void fillListViewWithContacts() {
        try {
            chktvChooseAll.setChecked(false);
            ArrayList<String> arrayList = new ArrayList<>();
            if (teacherList != null) {
                //fill ArrayList with contact names
                for (int i = 0; i < teacherList.size(); i++) {
                    arrayList.add(teacherList.get(i));
                } //for
            } //if
            ArrayAdapter arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_checked, arrayList);
            //find the ListView by using the resource id and connect it to the adapter
            lvListView = (ListView) viewToDisplay.findViewById(R.id.lvEntries);
            lvListView.setAdapter(arrayAdapter);
            checkSelectedTeachers();
        } catch (Exception ex) {
            ex.printStackTrace();
            String errorMsg = context.getString(R.string.unknown_error_exception);
            Toast.makeText(context, errorMsg + ex.getMessage(), Toast.LENGTH_LONG).show();
        } //try/catch
    } //fillListViewWithContacts

    /**
     * Checks the selected teachers for tracking
     */
    private static void checkSelectedTeachers() {
        String name;
        long selectedRowID,
                contactsRowID;
        //TODO: Update code below
        /*
        if (pkContactsList != null) {
            //loop through the ArrayList
            for (int i = 0; i < pkContactsList.size(); i++) {
                //get the rowID of the selected contact
                selectedRowID = pkContactsList.get(i);
                //loop through the ListView so we can check the correct ones
                for (int j = 0; j < contactsList.size(); j++) {
                    //get this contacts rowID and compare it to the selected
                    contactsRowID = contactsList.get(j).getContactID();
                    if (selectedRowID == contactsRowID) {
                        name = contactsList.get(j);
                        isTeacherDisplayedInListView(j, name);
                    } //if
                } //inner for
            } //outer for
        } //if
        */
    } //checkSelectedTeachers

    /**
     * Checks if the selected teacher is selected,
     * and checks them in the ListView
     * @param position - int: The position in the loop of contactsList
     * @param name - String: Name of current contact
     */
   // @SuppressWarnings("unused")
    private static void isTeacherDisplayedInListView(int position, String name) {
        int counter;
        boolean found;
        //is the ListView displaying all the contacts
        if (lvListView.getCount() == teacherList.size()) {
            lvListView.setItemChecked(position, true);
        } else {
            counter = 0;
            found = false;
            //searching for contact(s), loop and see if the selected are among them
            while(counter < lvListView.getCount() && !found) {
                if (lvListView.getItemAtPosition(counter).equals(name)) {
                    found = true;
                    lvListView.setItemChecked(counter, found);
                } //if
                counter++;
            } //while
        } //if
    } //isTeacherDisplayedInListView

    /**
     * Fills a ListView with stored messages from the database
     */
    protected static void fillListViewWithSearchResult(ArrayList<String> matchResult) {
        try {
            ArrayList arrayList = new ArrayList<>();
            arrayList.addAll(matchResult);
            //find the ListView by using the resource id
            lvListView = (ListView) viewToDisplay.findViewById(R.id.lvEntries);
            //connect scAdapter and ArrayList
            ArrayAdapter arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_checked, arrayList);
            //connect adapter and ListView
            lvListView.setAdapter(arrayAdapter);
        } catch (Exception ex) {
            ex.printStackTrace();
            String errorMsg = context.getString(R.string.unknown_error_exception);
            Toast.makeText(context, errorMsg + ex.getMessage(), Toast.LENGTH_LONG).show();
        } //try/catch
    } //fillListViewWithSearchResult
} //LocateTeacherActivity