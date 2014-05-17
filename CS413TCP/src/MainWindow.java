import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class MainWindow extends JFrame implements WindowListener {

	/*
	 * @throws SocketException 
	 */
	
	static Socket clientSocket;
	static ServerSocket serverSocket;
	
	static int port = 7779;
	
	static JTextArea textStream = new JTextArea();
	static JScrollPane streamScroll = new JScrollPane(textStream);
	static JTextField inputField = new JTextField();
	
	static JButton connect = new JButton("Connect");
	static JButton disconnect = new JButton("Disconnect");
	static JButton send = new JButton("Send");
	static JButton exit = new JButton("Exit");

	public static void main(String[] args) throws SocketException {
		new MainWindow();
		
		try{
			serverSocket = new ServerSocket(port);
			
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Problem establishing server socket");
		}

	}
	
	MainWindow(){
		
		//Set fonts for UI
		Font font = new Font("Courier", Font.PLAIN, 11);
		Font font2 = new Font("Courier", Font.PLAIN, 12);
		
		streamScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		streamScroll.setVisible(true);
		streamScroll.scrollRectToVisible(textStream.getBounds());
		
		//textStream textarea
		textStream.setColumns(50);
		textStream.setRows(15);
		textStream.setCaretColor(Color.black);
		textStream.setFont(font);
		textStream.setLineWrap(true);
		textStream.setEditable(false);
		
		//textinput textfield
		inputField.setColumns(40);
		inputField.setFont(font2);
		inputField.setCaretColor(Color.black);
		
		Container c1 = this.getContentPane();

		c1.setBackground(Color.lightGray);
		c1.setLayout(new FlowLayout(FlowLayout.LEFT));
		c1.setSize(500, 500);
		
		c1.add(streamScroll);
		c1.add(inputField);
		c1.add(send);
		c1.add(connect);
		c1.add(disconnect);
		c1.add(exit);
		
		Action action = new Action();
		
		send.addActionListener(action);
		connect.addActionListener(action);
		disconnect.addActionListener(action);
		exit.addActionListener(action);
		
		//JFrame properties
		this.setSize(380, 300);
		this.setLocation(500, 300);
		this.setTitle("CS413 TCP mail Client");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		
		dispose();
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

}
