package applicatioUtility;

public interface ApplicationUtlityForLinksModule {
	
	public void changewindow(int tabno);
	public void close();
	public void quit();
	public void accept_alert();
	public void dismiss_alert();
	public void sendkeys_alert(String value);

}
