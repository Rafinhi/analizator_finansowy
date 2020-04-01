package analizator_finansowy;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DaneTestowe extends JPanel {
	 

	
	private static final long serialVersionUID = 212751;
	public static final int HEIGHT = 850;
	public static final int WIDTH = 450;
	
	private JLabel panel1 = new JLabel ("<html><font size = 4><font color='red'> Uwaga! Nie wprowadzenie danych bêdzie<br> traktowane jak wpisanie wartoœci 0!</font></html>");
	
	private JTextField dana_1 = new JTextField("Aktywa obrotowe");
	private JTextField dana_2 = new JTextField("Zobowi¹zania krótkoterminowe");
	private JTextField dana_3 = new JTextField("Zapasy");
	private JTextField dana_4 = new JTextField("Nale¿noœci krótkoterminowe");
	private JTextField dana_5 = new JTextField("Rozliczenia miêdzyokresowe krótkoterminowe");
	private JTextField dana_6 = new JTextField("Gotówka");
	private JTextField dana_7 = new JTextField("Zobowi¹zania finansowe nieoperacyjne");
	private JTextField dana_8 = new JTextField("Lokaty bankowe");
	private JTextField dana_9 = new JTextField("Zysk/Strata netto");
	private JTextField dana_10 = new JTextField("Przyp³ywy z dzia³alnoœci operacyjnej");
	private JTextField dana_11 = new JTextField("Amortyzacja");
	private JTextField dana_12 = new JTextField("Aktywa razem");
	private JTextField dana_13 = new JTextField("Przychody ze sprzeda¿y");
	private JTextField dana_14 = new JTextField("Zysk/Strata brutto na sprzeda¿y");
	private JTextField dana_15 = new JTextField("Przychody ze sprzeda¿y");
	private JTextField dana_16 = new JTextField("Przychody operacyjne");
	private JTextField dana_17 = new JTextField("Przychody finansowe");
	private JTextField dana_18 = new JTextField("Zysk/Strata na dzia³alnoœci operacyjnej");
	private JTextField dana_19 = new JTextField("Kapita³ w³asny");
	private JTextField dana_20 = new JTextField("Wartoœæ akcyjna");
	private JTextField dana_21 = new JTextField("Zobowi¹zania d³ugoterminowe");
	private JTextField dana_22 = new JTextField("Koszty sprzeda¿y");
	private JTextField dana_23 = new JTextField("Koszty finansowe");
	private JTextField dana_24 = new JTextField("Koszty zarz¹du ogólnego");
	private JTextField dana_25 = new JTextField("Pasywa razem");
	private JButton ok = new JButton("Akceptuj");

	
	public DaneTestowe() {
		
	
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(panel1);
		add (new JLabel (" "));
		add(dana_1);
		add(dana_2);
		add(dana_3);
		add(dana_4);
		add(dana_5);
		add(dana_6);
		add(dana_7);
		add(dana_8);
		add(dana_9);
		add(dana_10);
		add(dana_11);
		add(dana_12);
		add(dana_13);
		add(dana_14);
		add(dana_15);
		add(dana_16);
		add(dana_17);
		add(dana_18);
		add(dana_19);
		add(dana_20);
		add(dana_21);
		add(dana_22);
		add(dana_23);
		add(dana_24);
		add(dana_25);
		
		add(new JLabel (" "));
		
			add(ok);
	}

	
}