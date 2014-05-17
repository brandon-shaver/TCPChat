import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Connect implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String ipString = MainWindow.inputField.getText();
		MainWindow.textStream.append("\nTrying to connect to "+ ipString);
		
		int port = 7779;
		

		
		try{
			
			MainWindow.clientSocket = new Socket(ipString, port);
			MainWindow.clientSocket.setSoTimeout(30000);
			
			MainWindow.textStream.append("\nSuccesfully connected to "+ MainWindow.clientSocket.getRemoteSocketAddress());
			
			OutputStream os = MainWindow.clientSocket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			dos.writeUTF("Connection established!");
			dos.flush();
			
			Thread listen = new Thread(new Listen());
			listen.start();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

		

	}

}
