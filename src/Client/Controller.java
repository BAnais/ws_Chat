package Client;

import java.io.IOException;
import java.net.Socket;

public class Controller implements ModelListener, ViewListener{
	
	private Model model;
	private GUI view;
	
	public Controller(Model model, GUI view){
		this.model= model;
		this.view = view;
		
		view.addListener(this);
		model.addListener(this);
	}

	@Override
	public void onNicknameChanged(String newNickname) {

		
	}

	@Override
	public void onMessageSent(String message) {
		System.out.println("On renvoie le message" + message);
		try {
			Socket sock = new Socket("127.0.0.1",500);
		} catch (Exception e) {
			System.out.println("[CLIENT] Impossible de se connecter");
		}
	}

	@Override
	public void onCypherMethodChanged(String cypherMethod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerConnectionChanged(boolean status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserConnected(String nickname, String ip_address, boolean newConnection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserDisconnected(String nickname, String ip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageReceived(String nickname, String ip, String message) {
		// TODO Auto-generated method stub
		
	}

	
	
}
