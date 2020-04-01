package analizator_finansowy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Menu extends JPanel implements ActionListener {
	 

	
	private static final long serialVersionUID = 212751;
	public static final int HEIGHT = 100;
	public static final int WIDTH = 400;
	private JButton WybierzPlik;
	private JButton Test;
	private JButton Odczytaj;
	private String Sciezka="0";
	private JLabel zrodlo = new JLabel("Brak œcie¿ki");
	private ArrayList<String> dane;

	
	
	
	public Menu() {
		WybierzPlik = new JButton("Wybierz Plik");
		Test = new JButton("Tryb testowy");
		Odczytaj = new JButton("Odczytaj Plik");
		

		WybierzPlik.addActionListener(this);
		Test.addActionListener(this);
		Odczytaj.addActionListener(this);
		

		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(WybierzPlik);
		add(Test);
		add(Odczytaj);
		add(zrodlo);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if(source == WybierzPlik) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Wybierz Sprawozdanie w formacie PDF");
			jfc.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki PDF", "pdf");
			jfc.addChoosableFileFilter(filter);

			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				System.out.println(jfc.getSelectedFile().getAbsolutePath());
				Sciezka=jfc.getSelectedFile().getPath();
				//Sciezka = Sciezka.replace("\\","/");
				zrodlo.setText("Wybrano: "+ Sciezka);
			}

		}
		
			

		else if(source == Test) {
			
				
				 EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							new Test();
							
						}
					}); 
					
					
			}
	
			
			
		
			
		else if(source == Odczytaj)
			if(Sciezka=="0") {
				JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, proszê wybraæ plik do operacji", "Œcie¿ka pliku jest pusta", JOptionPane.ERROR_MESSAGE);

			}else
				try {
					
					dane = OdczytPDF.readPDF(new File (Sciezka));
					 EventQueue.invokeLater(new Runnable() {
							@Override
							public void run() {
								new Wyniki(dane);
								
							}
						}
						); 
					
						
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	
	}
}