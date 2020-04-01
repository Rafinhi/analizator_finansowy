package analizator_finansowy;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Rezultat extends JPanel {
	 

	
	private static final long serialVersionUID = 212751;
	public static final int HEIGHT = 650;
	public static final int WIDTH = 550;
	
	private JLabel ply_stat = new JLabel("<html><font size = 4><font color='red'>P�ynno�� w uj�ciu statycznym </font></html>");
	
	private JLabel ply_dyn = new JLabel("<html><font size = 4><font color='red'> P�ynno�� w uj�ciu dynamicznym</font></html>");
	
	private JLabel rent_wzg = new JLabel("<html><font size = 4><font color='red'> Rentowno�� w wyniku wzgl�dnym </font></html>");
	
	private JLabel przy_rent = new JLabel("<html><font size = 4><font color='red'> Analiza przyczynowa rentowno�ci</font></html>");
		

	private JLabel maj_kap = new JLabel("<html><font size = 4><font color='red'> Analiza sytuacji maj�tkowo-kapita�owej</font></html>");
	

	private static DecimalFormat df = new DecimalFormat("0.00");
	 
	public Rezultat(ArrayList<String> dane) {
		
	
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		add(ply_stat); //naglowek
		
		double ao=Ekstraktor.znajdz(dane, "AKTYWA OBROTOWE",6);
		double zok=Ekstraktor.znajdz(dane, "ZOBOWI�ZANIA KR�TKOTERMINOWE",6);
		double kon=(ao - zok);
		JLabel ply_stat_1 = new JLabel("Kapita� obrotowy netto = " + kon + " tys z�");
		add(ply_stat_1); //aktywa obrotowe
		
		double skondao=kon/ao;
		JLabel ply_stat_2 = new JLabel("Stosunek kapita�u obrotowego netto do aktyw�w obrotowych = " + df.format(skondao));
		add(ply_stat_2);
		
		
		
		//zapasy + nale�no�ci + kr�tkoterminowe rozliczenia mi�dzyokresowe + got�wka operacyjna
		double zap = Ekstraktor.znajdz(dane, "Zapasy 18",3);
		double nal = Ekstraktor.znajdz(dane, "Nale�no�ci handlowe 21,41",5) + Ekstraktor.znajdz(dane, "Nale�no�ci z tytu�u bie��cego podatku dochodowego ",4) + Ekstraktor.znajdz(dane, "Pozosta�e nale�no�ci 22",5);
		double krm = Ekstraktor.znajdz(dane, "Rozliczenia mi�dzyokresowe 23",5);
		double go = Ekstraktor.znajdz(dane, "�rodki pieni�ne i ekwiwalenty �rodk�w pieni�nych 24,41 ",6);
		double okob = zap + nal + krm + go;
		JLabel ply_stat_3 = new JLabel("Operacyjny kapita� obrotowy brutto = " + okob + " tys z�");
		add(ply_stat_3);
		
		double pzf = Ekstraktor.znajdz(dane, "Pozosta�e zobowi�zania finansowe 31,37,41",3); //zobowi�zania nieoperacyjne (czyli odestkowane)
		double okon = okob - (zok - pzf);
		JLabel ply_stat_4 = new JLabel("Operacyjny kapita� obrotowy netto = " + okon + " tys z�");
		add(ply_stat_4);
		
		double nkon=kon-okon;
		JLabel ply_stat_5 = new JLabel("Nieoperacyjny kapita� obrotowy netto = " + nkon + " tys z�");
		add(ply_stat_5);
		
		double ik=Ekstraktor.znajdz(dane, "Lokaty bankowe powy�ej 3 miesi�cy 41",6);
		double wp1s=(ik+go)/zok;
		JLabel ply_stat_6 = new JLabel("Wska�nik p�ynno�ci I stopnia = " + df.format(wp1s));
		add(ply_stat_6);
		
		double wp2s=(ik+go+nal)/zok;
		JLabel ply_stat_7 = new JLabel("Wska�nik p�ynno�ci II stopnia = " + df.format(wp2s));
		add(ply_stat_7);
		
		double wp3s=ao/zok;
		JLabel ply_stat_8 = new JLabel("Wska�nik p�ynno�ci III stopnia = " + df.format(wp3s));
		add(ply_stat_8);
		
		add(new JLabel (" "));//przerwa
		
		add(ply_dyn); //nag��wek
		
		
		//JLabel ply_dyn_1 = new JLabel("Dynamiczny wska�nik p�ynno�ci"); //jest to og�lna posta� wskaznika, nie konkretna wartosc
		//add(ply_dyn_1);
		
		double zn =   Ekstraktor.znajdz(dane, "Zysk/(strata) netto  ",6);
		double ppnzdo = Ekstraktor.znajdz(dane, "Przep�ywy pieni�ne netto z dzia�alno�ci operacyjnej",6);
		double iuzn = zn/ppnzdo; 
		JLabel ply_dyn_2 = new JLabel("Indeks udzia�u zysku netto = " + df.format(iuzn));
		add(ply_dyn_2);
		
		double am1= Ekstraktor.znajdz(dane, "oraz nak�ad�w na prace rozwojowe ",4);
		double am2= Ekstraktor.znajdz(dane, "Amortyzacja prac rozwojowych uj�ta jako koszt w�asny sprzeda�y ",5);
		double am=am1+am2;
		double iua = am/ppnzdo;
		JLabel ply_dyn_3 = new JLabel("Indeks udzia�u amortyzacji = " + df.format(iua));
		//String testowy_string = Ekstraktor.linia(dane, "oraz nak�ad�w na prace rozwojowe ",4);
		//JLabel ply_dyn_3 = new JLabel (testowy_string);
		add(ply_dyn_3);
		
		
		
		double ako =  Ekstraktor.znajdz(dane, "AKTYWA RAZEM ",7);
		double wwgm = ppnzdo/ako;
		JLabel ply_dyn_4 = new JLabel("Wska�nik wydajno�ci got�wkowej maj�tku = " + df.format(wwgm));
		add(ply_dyn_4);
		
		double pzsn =Ekstraktor.znajdz(dane, "Przychody ze sprzeda�y  ",6);
		double wwgs = ppnzdo/pzsn;
		JLabel ply_dyn_5 = new JLabel("Wska�nik wydajno�ci got�wkowej sprzeda�y = " + df.format(wwgs));
		add(ply_dyn_5);
		add(new JLabel (" "));//przerwa
		
		
		add(rent_wzg);//naglowek
		
		double zb = Ekstraktor.znajdz(dane, "Zysk/(strata) brutto na sprzeda�y ",6);
		double pzs = Ekstraktor.znajdz(dane, "Przychody ze sprzeda�y  ",6);
		double ppo =Ekstraktor.znajdz(dane, "Pozosta�e przychody operacyjne 1,3 ",4);
		double pf = Ekstraktor.znajdz(dane, "Przychody finansowe 1,4 ",4);
		double wrob = zb/(pzs+ppo+pf);
		JLabel rent_wzg_1 = new JLabel("Wska�nik rentowno�ci obrotu brutto = " + df.format(wrob));
		add(rent_wzg_1);
	
		
		double wron = zn/(pzs+ppo+pf);
		JLabel rent_wzg_2 = new JLabel("Wska�nik rentowno�ci obrotu netto = " + df.format(wron));
		add(rent_wzg_2);

		double smb = zb/pzs;
		JLabel rent_wzg_3 = new JLabel("Stopa mar�y brutto = " + df.format(smb));
		add(rent_wzg_3);
		
		double rmo = zn/ako;
		JLabel rent_wzg_4 = new JLabel("Rentowno�� maj�tku og�em = " + df.format(rmo));
		add(rent_wzg_4);
		
		double zzdo = Ekstraktor.znajdz(dane, "Zysk/(strata) na dzia�alno�ci operacyjnej",6);
		double anieop =  Ekstraktor.znajdz(dane, "Lokaty bankowe powy�ej 3 miesi�cy 41",6);  //aktywa nieoperacyjne, czyli lokaty 
		double wroa = zzdo/(ako-anieop);
		JLabel rent_wzg_5 = new JLabel("Wska�nik rentowno�ci operacyjnej aktyw�w = " + df.format(wroa));
		add(rent_wzg_5);
		
		double kw = Ekstraktor.znajdz(dane, "KAPITA� W�ASNY",7); 
		double roe = zn/kw;
		JLabel rent_wzg_6 = new JLabel("Wska�nik rentowno�ci kapita�u w�asnego = " + df.format(roe));
		add(rent_wzg_6);
		
		
		double la = Ekstraktor.znajdz(dane, "Liczba akcji w tysi�cach sztuk ",5); 
		double wa= Ekstraktor.znajdz(dane, "Warto�� ksi�gowa na akcj� (w PLN/EUR) ",5);  
		double swa = la * wa *1000; //sumaryczna wartosc akcji
		double wrka = (zn*1000/swa) ;
		JLabel rent_wzg_7 = new JLabel("Wska�nik rentowno�ci kapita�u akcyjnego = " + df.format(wrka) );
		add(rent_wzg_7);
		
		 double odsetki = Ekstraktor.znajdz(dane, "Odsetki i udzia�y w zyskach (dywidendy)  ",6); 
		double zd = Ekstraktor.znajdz(dane, "ZOBOWI�ZANIA D�UGOTERMINOWE  ",4);
		double ks = zd + kw; //kapitaly stale to suma zobowiazan dlugoterminowych i kapitalow wlasnych
		double wrks = (zn+odsetki)/ks;
		JLabel rent_wzg_8 = new JLabel("Wska�nik rentowno�ci kapita��w sta�ych = " + df.format(wrks));
		add(rent_wzg_8);
		
		
		add(new JLabel (" "));//przerwa
		
		add(przy_rent);//nag��wek
		
		double iupzswpo = pzs/(pzs+ppo+pf);
		JLabel przy_rent_1 = new JLabel("Indeks udzia�u przychod�w ze sprzeda�y w przychodach og�em = " + df.format(iupzswpo));
		add(przy_rent_1);
		
		double iupfwpo = pf/(pzs+ppo+pf);
		JLabel przy_rent_2 = new JLabel("Indeks udzia�u przychod�w finansowych w przychodach og�em = " + df.format(iupfwpo));
		add(przy_rent_2);
		
		
		double kosztysprzedazy = Ekstraktor.znajdz(dane, "Koszty sprzeda�y 2",6);
		double koz = Ekstraktor.znajdz(dane, "Koszty og�lnego zarz�du 2",5);
		double kof = Ekstraktor.znajdz(dane, "Koszty finansowe 4",3);
		double pko = Ekstraktor.znajdz(dane, "Pozosta�e koszty operacyjne 3",3);
		
		double iuokwpzswko = kosztysprzedazy/(kosztysprzedazy+koz+kof+pko);
		JLabel przy_rent_3 = new JLabel("Indeks udzia�u og�em kosztu w�asnego przychod�w ze sprzeda�y w koszcie og�em = " + df.format(iuokwpzswko));
		add(przy_rent_3);
		
		double iukfwko = kof/(kosztysprzedazy+koz+kof+pko);
		JLabel przy_rent_4 = new JLabel("Indeks udzia�u koszt�w finansowych w koszcie og�em = " + df.format(iukfwko));
		add(przy_rent_4);
		
		add(new JLabel (" ")); //przerwa
		

		add(maj_kap); //naglowek
		
		double wzkw = kw/(ako-ao); //kapital wlasny / aktywa ogolem minus aktywa obrotowe
		JLabel maj_kap_1 = new JLabel("Wska�nik zastosowania kapita��w w�asnych  = " + df.format(wzkw));
		add(maj_kap_1);
		
		double pr = Ekstraktor.znajdz(dane, "PASYWA RAZEM",7);
		double wzko = (pr - kw)/ao;
		JLabel maj_kap_2 = new JLabel("Wska�nik zastosowania kapita��w obcych = " + df.format(wzko));
		add(maj_kap_2);
		
		
		double wosf = wzkw/wzko;
		JLabel maj_kap_3 = new JLabel("Wska�nik og�lnej sytuacji finansowej = " + df.format(wosf));		
		add(maj_kap_3);		
		
		double skddmzw = ks/(ako-ao);
		JLabel maj_kap_4 = new JLabel("Stosunek kapita�u d�ugoterminowego do maj�tku zwi�zanego d�ugoterminowo = " + df.format(skddmzw));		
		add(maj_kap_4);
		
		
		double skkdmk = zok/ao;
		JLabel maj_kap_5 = new JLabel("Stosunek kapita�u kr�tkoterminowego do maj�tku kr�tkoterminowego = " + df.format(skkdmk));
		add(maj_kap_5);
		
		add(new JLabel (" "));
	}

	
}