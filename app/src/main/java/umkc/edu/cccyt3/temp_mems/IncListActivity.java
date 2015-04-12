package umkc.edu.cccyt3.temp_mems;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import java.util.ArrayList;

import junit.framework.Assert;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class IncListActivity extends ActionBarActivity implements OnClickListener, OnItemClickListener {

    private ArrayAdapter<String> adapter;

    // Any List Interface Data Structure
    private ArrayList<String> listItems = new ArrayList<String>();
    private ArrayList<Course> courses;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inc_list);

        View prevButton = findViewById(R.id.add_list_button);
        prevButton.setOnClickListener(this);

        ListView listView = (ListView)this.findViewById(R.id.listOfSomething);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        Model model = Model.instance(getApplicationContext());
        courses = model.getCourses();

        // If no courses, add some
        if (courses.size() == 0) {
            long SE1_course_id = model.insertCourse("CS449");
            long SE2_course_id = model.insertCourse("CS451");
//string modelText = modelTextField.gettext
//  model.insterCourse(modelText);
            model.insertAssignment(SE1_course_id, "Iteration 1");
            model.insertAssignment(SE1_course_id, "Iteration 2");

            model.insertAssignment(SE2_course_id, "Lab 1");

            courses = model.getCourses();
        }

    }

    // This is for button clicks
    @Override
    public void onClick(View arg0) {
        Assert.assertNotNull(arg0);
        // Get string entered
         TextView tv = (TextView) findViewById(R.id.editText1);
        // Add string to underlying data structure
        listItems.add(tv.getText().toString());
        // Notify adapter that underlying data structure changed
        adapter.notifyDataSetChanged();

    }

    // This is for selecting an item from the list
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Use a toast message to show which item selected
        String text = "You selected item " + position;
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
        ///Added 3/14/15
        Intent SpecEntryIntent = new Intent(this,SpecEntry.class);
        this.startActivity(SpecEntryIntent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_backhome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
