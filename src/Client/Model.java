package Client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private String nickname = null;
	private String cypherMethod = null;
	private String serverAdress = null; 
	private List<String> connectedUsers;
	private List<ModelListener> listeners;
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCypherMethod() {
		return cypherMethod;
	}

	public void setCypherMethod(String cypherMethod) {
		this.cypherMethod = cypherMethod;
	}

	public String getServerAdress() {
		return serverAdress;
	}

	public void setServerAdress(String serverAdress) {
		this.serverAdress = serverAdress;
	}

	public List<String> getConnectedUsers() {
		return connectedUsers;
	}

	public void addConnectedUsers(String user) {
		this.connectedUsers.add(user);
	}
	public void removeConnectedUsers(List<String> user) {
		this.connectedUsers.remove(user);
	}

	public List<ModelListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<ModelListener> listeners) {
		this.listeners = listeners;
	}

	public Model(){
		this.connectedUsers = new ArrayList<>();
		this.listeners = new ArrayList<>();
	}

	public void addListener(ModelListener listener){
		this.listeners.add(listener);
	}
	
	public void removeListener(ModelListener listener){
		this.listeners.remove(listener);
	}
	
	public void notifyEvent(String methodName, Object... args) {
		// "..." = elipse 
		//Object... = Object[n]
		//parcours liste d'observateurs
		
		//cherche la bonne methode dans l'interface
		Method methodCall = null;
		for (Method method : ModelListener.class.getMethods()){
			//System.out.println("ModelListener::" + method.getName());
			if (methodName.equals(method.getName())){
				methodCall = method;
				break;	
			}
		}
		
		if (methodCall == null){
			throw new IllegalArgumentException("Event" + methodName + "doesn't exist");
		}
		
		for(ModelListener listener : this.listeners){
			try {
				methodCall.invoke(listeners, args);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
