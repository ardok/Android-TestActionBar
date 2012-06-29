package actionbar.main;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * This class is to display notification
 * @author ardokusuma
 *
 */
public class DisplayNotification {
	private Activity act;
	private NotificationManager mNotificationManager;
	private int id;
	private ArrayList<Intent> intents;
	
	public DisplayNotification() {
		// initialize with random and null
		this.id = (new Random()).nextInt();
		this.act = null;
		this.intents = null;
	}

	public DisplayNotification(int id, Activity a) {
		this.id = id;
		this.act = a;
		this.intents = new ArrayList<Intent>();
	}
	
	public void displayNotification(String tickerText, String title, String name) {
		String ns = Context.NOTIFICATION_SERVICE;
		mNotificationManager = (NotificationManager) act.getSystemService(ns);
		
		int icon = R.drawable.ic_launcher;
		long when = System.currentTimeMillis();

		Notification notification = new Notification(icon, tickerText, when);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		
		Context context = act.getApplicationContext();
		CharSequence contentTitle = title;
		CharSequence contentText = name;
		
		PendingIntent contentIntent = PendingIntent.getActivities(act, 0, intents.toArray(new Intent[intents.size()]), PendingIntent.FLAG_CANCEL_CURRENT);
		
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		
		mNotificationManager.notify(id, notification);
	}
	
	public void addIntent(Intent intent) {
		intents.add(intent);
	}
	
	public void clearIntents() {
		intents.clear();
	}
	
	public NotificationManager getNotificationManager() {
		return mNotificationManager;
	}
	
	public int getId() {
		return id;
	}
}
