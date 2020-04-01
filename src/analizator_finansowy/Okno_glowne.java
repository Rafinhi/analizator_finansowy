package analizator_finansowy;


import javax.swing.JFrame;
import javax.swing.JPanel;

	public class Okno_glowne extends JFrame {

		private static final long serialVersionUID = 212751;

		public Okno_glowne() {
			
			super("Analizator_finansowy_212751"); //wywo³ujemy konstruktor klasy nadrzednej z nazw¹ mojego indeksu
			JPanel guziki_glowne = new Menu();
			add(guziki_glowne);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //krzy¿yk zamyka
			setVisible(true); //okno jest widoczne
						pack(); 
			setLocation(50,50); //po³o¿enie okna na ekranie
			
		
		}
	
}
