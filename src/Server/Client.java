package Server;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

	private Server parent;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private Thread thread;

	public Client(Server parent, Socket socket) throws IOException{
		//memorise le socket
		this.socket = socket;
		this.parent = parent;
		//J'initialise le flux de sortie (write) 
		this.out = new PrintWriter(socket.getOutputStream(),true);
		//J'initialise le flux d'entree (read)
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public Socket getSocket(){
		return socket;	
	}

	public void startPollingThread() {

		this.thread = new Thread(this);
		this.thread.start();
	}

	@Override
	public void run() {
		//Tant que l'application tourne 
		while(true){
			//Lire this.in pour la prochaine ligne 
			String message;
			try {
				//Ecoute active sur le flux d'entrée
				message = this.in.readLine();
				//Le client vient de se déconnecter
				if (message == null){
					//fermer le socket et le thread de poolling 
					close();
					// TODO prevenir la classe Server
					return;
				}
				write("ECHO -> " + message);
				parent.onMessageReceived(this, message);
				
				//TODO temp 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("[SERVER]["+socket.getInetAddress() + "] Error while receiving message");			}	
		}
	}
	
	public boolean write(String data){
		try{
			this.out.println(data);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean close(){
		try{
		this.parent.onClientDisconnected(this);
		//arreter le thread
		thread.interrupt();
		//Fermer les flux 
		this.in.close();
		this.out.close();
		//Fermer le socket
		this.socket.close();
		return true;
	}
		catch(Exception e){
		
		return false;
		}
		
	}
}
