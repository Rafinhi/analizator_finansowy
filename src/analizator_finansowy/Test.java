package analizator_finansowy;

import javax.swing.JFrame;
import javax.swing.JPanel;

	public class Test extends JFrame {

		private static final long serialVersionUID = 212751;

		public Test() {
			
			super("Analizator_finansowy_212751"); //wywo�ujemy konstruktor klasy nadrzednej z nazw� mojego indeksu
			JPanel testowanie = new DaneTestowe();
			add(testowanie);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //krzy�yk zamyka
			setVisible(true); //okno jest widoczne
			//setSize(new Dimension(600, 500)); //wielko�� okna na sztywno
			//setPreferredSize(new Dimension(400, 400)); //wielkosc okna preferowana
			pack(); //ustawiamy wielkosc okna na preferowan� LUB wi�ksz� by zmie�ci� zawarto��
			setLocation(200,200); //po�o�enie okna na ekranie
			
		
		}
	
}
