import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketTimeoutException;



public class Send implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		String message = MainWindow.inputField.getText();
		
		try{
			OutputStream sendOut = MainWindow.clientSocket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(sendOut);
			dos.writeUTF("Client : " + message);
			dos.flush();
			MainWindow.textStream.append("\nClient : "+message);
		
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Problem sending output from client socket");
		}
		
	}

}
