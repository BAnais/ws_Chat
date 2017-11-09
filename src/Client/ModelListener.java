package Client;

public interface ModelListener {

	public void onServerConnectionChanged(boolean status);
	
	public void onUserConnected(String nickname, String ip_address, boolean newConnection);
	
	public void onUserDisconnected(String nickname, String ip);
	
	public void onMessageReceived(String nickname, String ip, String message);
}
