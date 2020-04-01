package analizator_finansowy;
import java.awt.EventQueue;




public class Analizator_finansowy {

	public static void main(String[] args)  {
		 EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Okno_glowne();
				
			}
		}); 
		
		
	
	}
}
