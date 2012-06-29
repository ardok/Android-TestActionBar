package actionbar.main;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class EditTextActivity extends BaseActivity {
	private LinearLayout ll;
	private ArrayList<EditText> forms;
	
	private int id;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.et);
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        id = 0;
        ll = (LinearLayout) this.findViewById(R.id.linearLayout1);
        
        forms = new ArrayList<EditText>();
    }
    
    @Override
   	public boolean onCreateOptionsMenu(Menu menu) {
   		MenuInflater inflater = getMenuInflater();
   		inflater.inflate(R.menu.et_menu, menu);
   		return super.onCreateOptionsMenu(menu);
   	}

   	@Override
   	public boolean onOptionsItemSelected(MenuItem item) {
   		Intent intent;
   		switch(item.getItemId()) {
   		case R.id.addEditText:
   			// Just add EditText to the layout
   			final LinearLayout ell = new LinearLayout(this);
   			LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 6.0f);
   			ell.setOrientation(LinearLayout.HORIZONTAL);
   			ell.setLayoutParams(params);
   			ell.setId(id); ++id;
   			
   			final EditText et = new EditText(this);
   			et.setGravity(Gravity.LEFT);
   			params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 5.9f);
   			et.setLayoutParams(params);
   			et.setHint("Enter something here...");
   			et.setId(id); ++id;
   			forms.add(et);
   			ell.addView(et);
   			
   			final ImageView iv = new ImageView(this);
   			iv.setBackgroundResource(R.drawable.x);
   			params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0.1f);
   			iv.setLayoutParams(params);
   			iv.setId(id); ++id;
   			iv.setClickable(true);
   			
   			// If the X button is pressed, remove the particular EditText
   			iv.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					ell.removeAllViews();
					ll.invalidate();
					forms.remove(et);
				}
			});
   			
   			ell.addView(iv);
   			
   			ll.addView(ell);
   			return true;
   		case R.id.done:
   			// Well, go to the HOME activity (i.e. TestActionBarActivity) and show the texts entered into
   			//   existing EditTexts
   			String toView = "";
   			for (EditText tempET : forms) {
   				toView += tempET.getText().toString() + " ";
   			}
   			
   			intent = new Intent(this, TestActionBarActivity.class);
   			intent.putExtra("message", toView);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
            startActivity(intent);
   			return true;
   		default:
   			return super.onOptionsItemSelected(item);
   		}
   	}
}
