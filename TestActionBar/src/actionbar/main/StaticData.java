package actionbar.main;

public class StaticData {
	/**
	 * These are needed to handle the event when user goes to TestActionBarActivity (HOME) after pressing
	 *   the Show Notification button inside NotificationActivity.
	 * With these static instances, we can handle this event inside onResume() of TestActionBarActivity
	 */
	public static DisplayNotification NOTIFICATION = null;
	public static String NAME = null;
}
