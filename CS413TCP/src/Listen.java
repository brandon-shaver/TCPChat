import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class Listen implements Runnable {

	static Socket receivedSocket = MainWindow.clientSocket;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Started listening");
		
		while (true){
			try{
				DataInputStream input = new DataInputStream(receivedSocket.getInputStream());
				MainWindow.textStream.append("\nServer : "+input.readUTF());
				
				MainWindow.textStream.setCaretPosition(MainWindow.textStream.getDocument().getLength());
				MainWindow.textStream.requestFocus();
				
			}catch(SocketTimeoutException t){
				System.out.println("Socket timed out!");
				MainWindow.textStream.append("\nThe connection has timed out!");
				break;
				
			}catch(IOException e){
				
				e.printStackTrace();
				break;
			}
			
		}

	}

}
