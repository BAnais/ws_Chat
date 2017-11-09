package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class GUI extends JFrame {

	protected JPanel contentPane;
	protected JTextField textField;
	protected JComboBox comboBox;
	protected JLabel lblNewLabel;
	protected JTextArea textArea;
	protected JTextArea textArea_1;
	private JPanel panel_3;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel;
	private List<String> connectedUsers;
	private List<ViewListener> listeners;
	
	

	/**
	 * Create the frame.
	 */
	public GUI() {
		

		this.connectedUsers = new ArrayList<>();
		this.listeners = new ArrayList<>();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
		);
		
		panel_1 = new JPanel();
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		
		panel_3 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
		);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = textField.getText();
				notifyEvent("onMessageSent", message);
				textField.setText("");
				
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 790, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		lblNewLabel = new JLabel("Quelqu'un");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		comboBox = new JComboBox();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel)
					.addContainerGap(70, Short.MAX_VALUE))
				.addComponent(comboBox, 0, 197, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
		);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		panel_1.setLayout(gl_panel_1);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "name_11251817015348");
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	

	public void addListener(ViewListener listener){
		this.listeners.add(listener);
	}
	
	public void removeListener(ViewListener listener){
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
		
		for(ViewListener listener : this.listeners){
			try {
				methodCall.invoke(listeners, args);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
