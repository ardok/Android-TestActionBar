package actionbar.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * This is the main Activity (HOME)
 * @author ardokusuma
 *
 */
public class TestActionBarActivity extends BaseActivity {
	private TextView messageTV;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        messageTV = (TextView) this.findViewById(R.id.textView1);
        
        /**
         * This is a sample code to change the background of the action bar programmatically
         */
//        BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.background_gray));
//        background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
//        actionBar.setBackgroundDrawable(background);
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	Bundle extras = getIntent().getExtras();
        if (extras != null) {
        	if (extras.containsKey(Keys.KEY_MESSAGE)) {
        		// Get data from EditTextActivity
        		String msg = extras.getString(Keys.KEY_MESSAGE);
        		if (msg != null) messageTV.setText(msg.trim());
        	} else if (extras.containsKey(Keys.KEY_NAME)) {
        		// Get data from NotificationActivity
        		String name = extras.getString(Keys.KEY_NAME);
        		if (name != null) messageTV.setText(name.trim());
        		if (StaticData.NOTIFICATION != null)
        			StaticData.NOTIFICATION.getNotificationManager().cancel(StaticData.NOTIFICATION.getId());
        	}
        } else {
        	// This is when user presses the back button (i.e. show notification then go to TestActionBarActivity
        	//   by pressing the back button instead of through the notification)
        	if ((StaticData.NAME != null) && (StaticData.NAME.length() != 0)) {
        		if (StaticData.NOTIFICATION != null)
        			StaticData.NOTIFICATION.getNotificationManager().cancel(StaticData.NOTIFICATION.getId());
        		messageTV.setText(StaticData.NAME.trim());
        	}
        }
    }
    
    @Override
   	public boolean onCreateOptionsMenu(Menu menu) {
   		MenuInflater inflater = getMenuInflater();
   		inflater.inflate(R.menu.main_menu, menu);
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