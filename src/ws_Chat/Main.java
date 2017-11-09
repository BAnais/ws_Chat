package ws_Chat;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Client.Controller;
import Client.GUI;
import Client.Model;
import Server.Server;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//lancement du serveur
		Server srv = new Server(500);
		srv.start();
		
		
		//lancement du client
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GUI view = new GUI();
				Model model = new Model();
				Controller ctrl = new Controller(model, view);
				view.setVisible(true);

			}
		});
	}
}