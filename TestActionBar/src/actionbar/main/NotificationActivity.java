package actionbar.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotificationActivity extends BaseActivity {
	private EditText nameET;
	private Button showNotifB;
	private int id;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        
        id = 0;
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        nameET = (EditText) this.findViewById(R.id.editText1);
        showNotifB = (Button) this.findViewById(R.id.button1);
        showNotifB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Display the notification
				String name = nameET.getText().toString().trim();
				DisplayNotification dn = new DisplayNotification(id, NotificationActivity.this);
				++id;
				Intent intent = new Intent(NotificationActivity.this, TestActionBarActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				/**
				 * This extra is actually not needed because we have StaticData.NAME :(
				 * Just for fun, put the name to the extra as well :)
				 */
				intent.putExtra("name", name); 
				dn.addIntent(intent);
				dn.displayNotification("New Notification Created!", "Hello there!", name);
				StaticData.NOTIFICATION = dn;
				StaticData.NAME = name;
			}
		});
    }
    
    @Override
   	public boolean onCreateOptionsMenu(Menu menu) {
   		MenuInflater inflater = getMenuInflater();
   		inflater.inflate(R.menu.notification_menu, menu);
   		return super.onCreateOptionsMenu(menu);
   	}

   	@Override
   	public boolean onOptionsItemSelected(MenuItem item) {
   		switch(item.getItemId()) {
   		default:
   			return super.onOptionsItemSelected(item);
   		}
   	}
}
