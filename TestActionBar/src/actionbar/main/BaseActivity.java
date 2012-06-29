package actionbar.main;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

/**
 * This is the base Activity for all activities that exist
 * @author ardokusuma
 *
 */
public class BaseActivity extends Activity {
   	@Override
   	public boolean onOptionsItemSelected(MenuItem item) {
   		Intent intent;
   		switch(item.getItemId()) {
   		case android.R.id.home:
   			onBackPressed();
   			return true;
   		case R.id.notificationActivity:
   			intent = new Intent(this, NotificationActivity.class);            
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
            startActivity(intent); 
   			return true;
   		case R.id.editTextActivity:
   			intent = new Intent(this, EditTextActivity.class);            
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
            startActivity(intent);
   			return true;
   		default:
   			return super.onOptionsItemSelected(item);
   		}
   	}
}
