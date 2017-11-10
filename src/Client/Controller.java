package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
		try {
			//ouverture connexion au server
			Socket sock = new Socket("127.0.0.1",500);
			//envoie message
			PrintWriter out = new PrintWriter(sock.getOutputStream(),true);			
			out.println(message);
			//reception prochain message 
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String rcvd = in.readLine();
			System.out.println("[CLIENT] Message received :"+rcvd);
			//fermeture
			out.close();
			sock.close();
			
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
