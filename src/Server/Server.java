package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable{

	private int port;
	private ServerSocket socket;
	private Thread acceptThread;
	private List<Client> connectedClient;

	public Server(int port){
		if (port <1 || port > 65535){
			throw new IllegalArgumentException("Invalid port");
		}
		this.port = port;
	}
	
	public void start() throws IOException{
		//on ouvre le socjet sur le port donnee
		this.socket = new ServerSocket(this.port);
		
		//on fabrique un thread 
		this.acceptThread  = new Thread(this);
		this.acceptThread.start();
		
		this.connectedClient = new ArrayList<>();

	}

	@Override
	public void run() {
		while (true){
			try {
				
				//Cette methode sert a attendre a attendre la connexion d'un 
				//nouveau client. Elle bloquera jusqu'a l'arrivée d'une connexion
				//Quand un client se connectera, la methode renverra  le socket de connexion au client
				Socket s = socket.accept();
				//Arrive ici, cela signifie q'une connexion a ete recu sur le port du serveur
				System.out.println("[SERVER] Connection received from "+s.getInetAddress());
				//creer un objet pour representer le client
				Client c = new Client(this, s);
				
				//On lance le thread qui se charge de lire 
				c.startPollingThread();
				this.connectedClient.add(c);
				
				
			} catch (IOException e) {
				System.out.println("[SERVER] Accept error ");
				e.printStackTrace();
			}
		}		
	}
	
	public void onMessageReceived(Client client, String message){
		System.out.println("[SERVER][" + client.getSocket().getInetAddress() + "] Received message "+ message);
	}
	
	public void onClientDisconnected(Client client){
		//log
		System.out.println("[SERVER][ " + client.getSocket().getInetAddress()+"] Client has just been disconnected");
		
	}
	
}
