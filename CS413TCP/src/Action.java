import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Action implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == MainWindow.send){
			//MainWindow.textStream.append("\nSend button pressed.");
				
			Thread send = new Thread(new Send());
			send.start();
			
		}else if (e.getSource() == MainWindow.connect){
			
			//MainWindow.textStream.append("\nConnect code goes here");
			Thread connect = new Thread(new Connect());
			connect.start();

	
		}else if(e.getSource() == MainWindow.disconnect){
			
			System.out.println("Disconnect code goes here");
			
		}else if(e.getSource() == MainWindow.exit){
			System.exit(0);
		}else{
			
			MainWindow.textStream.append("\nError: Unknown source of action listener.");
		}
		
		MainWindow.textStream.setCaretPosition(MainWindow.textStream.getDocument().getLength());
		MainWindow.textStream.requestFocus();


	}

}
