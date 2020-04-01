package analizator_finansowy;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

	public class Wyniki extends JFrame {

		private static final long serialVersionUID = 212751;

		public Wyniki(ArrayList <String> dane) {
			
			super("Analizator_finansowy_212751"); //wywo³ujemy konstruktor klasy nadrzednej z nazw¹ mojego indeksu
			JPanel rezultat = new Rezultat(dane);
			add(rezultat);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //krzy¿yk zamyka
			setVisible(true); //okno jest widoczne
			//setSize(new Dimension(600, 500)); //wielkoœæ okna na sztywno
			//setPreferredSize(new Dimension(400, 400)); //wielkosc okna preferowana
			pack(); //ustawiamy wielkosc okna na preferowan¹ LUB wiêksz¹ by zmieœciæ zawartoœæ
			setLocation(200,200); //po³o¿enie okna na ekranie
			
		
		}
	
}
