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
	
	private JLabel ply_stat = new JLabel("<html><font size = 4><font color='red'>P³ynnoœæ w ujêciu statycznym </font></html>");
	
	private JLabel ply_dyn = new JLabel("<html><font size = 4><font color='red'> P³ynnoœæ w ujêciu dynamicznym</font></html>");
	
	private JLabel rent_wzg = new JLabel("<html><font size = 4><font color='red'> Rentownoœæ w wyniku wzglêdnym </font></html>");
	
	private JLabel przy_rent = new JLabel("<html><font size = 4><font color='red'> Analiza przyczynowa rentownoœci</font></html>");
		

	private JLabel maj_kap = new JLabel("<html><font size = 4><font color='red'> Analiza sytuacji maj¹tkowo-kapita³owej</font></html>");
	

	private static DecimalFormat df = new DecimalFormat("0.00");
	 
	public Rezultat(ArrayList<String> dane) {
		
	
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		add(ply_stat); //naglowek
		
		double ao=Ekstraktor.znajdz(dane, "AKTYWA OBROTOWE",6);
		double zok=Ekstraktor.znajdz(dane, "ZOBOWI¥ZANIA KRÓTKOTERMINOWE",6);
		double kon=(ao - zok);
		JLabel ply_stat_1 = new JLabel("Kapita³ obrotowy netto = " + kon + " tys z³");
		add(ply_stat_1); //aktywa obrotowe
		
		double skondao=kon/ao;
		JLabel ply_stat_2 = new JLabel("Stosunek kapita³u obrotowego netto do aktywów obrotowych = " + df.format(skondao));
		add(ply_stat_2);
		
		
		
		//zapasy + nale¿noœci + krótkoterminowe rozliczenia miêdzyokresowe + gotówka operacyjna
		double zap = Ekstraktor.znajdz(dane, "Zapasy 18",3);
		double nal = Ekstraktor.znajdz(dane, "Nale¿noœci handlowe 21,41",5) + Ekstraktor.znajdz(dane, "Nale¿noœci z tytu³u bie¿¹cego podatku dochodowego ",4) + Ekstraktor.znajdz(dane, "Pozosta³e nale¿noœci 22",5);
		double krm = Ekstraktor.znajdz(dane, "Rozliczenia miêdzyokresowe 23",5);
		double go = Ekstraktor.znajdz(dane, "Œrodki pieniê¿ne i ekwiwalenty œrodków pieniê¿nych 24,41 ",6);
		double okob = zap + nal + krm + go;
		JLabel ply_stat_3 = new JLabel("Operacyjny kapita³ obrotowy brutto = " + okob + " tys z³");
		add(ply_stat_3);
		
		double pzf = Ekstraktor.znajdz(dane, "Pozosta³e zobowi¹zania finansowe 31,37,41",3); //zobowi¹zania nieoperacyjne (czyli odestkowane)
		double okon = okob - (zok - pzf);
		JLabel ply_stat_4 = new JLabel("Operacyjny kapita³ obrotowy netto = " + okon + " tys z³");
		add(ply_stat_4);
		
		double nkon=kon-okon;
		JLabel ply_stat_5 = new JLabel("Nieoperacyjny kapita³ obrotowy netto = " + nkon + " tys z³");
		add(ply_stat_5);
		
		double ik=Ekstraktor.znajdz(dane, "Lokaty bankowe powy¿ej 3 miesiêcy 41",6);
		double wp1s=(ik+go)/zok;
		JLabel ply_stat_6 = new JLabel("WskaŸnik p³ynnoœci I stopnia = " + df.format(wp1s));
		add(ply_stat_6);
		
		double wp2s=(ik+go+nal)/zok;
		JLabel ply_stat_7 = new JLabel("WskaŸnik p³ynnoœci II stopnia = " + df.format(wp2s));
		add(ply_stat_7);
		
		double wp3s=ao/zok;
		JLabel ply_stat_8 = new JLabel("WskaŸnik p³ynnoœci III stopnia = " + df.format(wp3s));
		add(ply_stat_8);
		
		add(new JLabel (" "));//przerwa
		
		add(ply_dyn); //nag³ówek
		
		
		//JLabel ply_dyn_1 = new JLabel("Dynamiczny wskaŸnik p³ynnoœci"); //jest to ogólna postaæ wskaznika, nie konkretna wartosc
		//add(ply_dyn_1);
		
		double zn =   Ekstraktor.znajdz(dane, "Zysk/(strata) netto  ",6);
		double ppnzdo = Ekstraktor.znajdz(dane, "Przep³ywy pieniê¿ne netto z dzia³alnoœci operacyjnej",6);
		double iuzn = zn/ppnzdo; 
		JLabel ply_dyn_2 = new JLabel("Indeks udzia³u zysku netto = " + df.format(iuzn));
		add(ply_dyn_2);
		
		double am1= Ekstraktor.znajdz(dane, "oraz nak³adów na prace rozwojowe ",4);
		double am2= Ekstraktor.znajdz(dane, "Amortyzacja prac rozwojowych ujêta jako koszt w³asny sprzeda¿y ",5);
		double am=am1+am2;
		double iua = am/ppnzdo;
		JLabel ply_dyn_3 = new JLabel("Indeks udzia³u amortyzacji = " + df.format(iua));
		//String testowy_string = Ekstraktor.linia(dane, "oraz nak³adów na prace rozwojowe ",4);
		//JLabel ply_dyn_3 = new JLabel (testowy_string);
		add(ply_dyn_3);
		
		
		
		double ako =  Ekstraktor.znajdz(dane, "AKTYWA RAZEM ",7);
		double wwgm = ppnzdo/ako;
		JLabel ply_dyn_4 = new JLabel("WskaŸnik wydajnoœci gotówkowej maj¹tku = " + df.format(wwgm));
		add(ply_dyn_4);
		
		double pzsn =Ekstraktor.znajdz(dane, "Przychody ze sprzeda¿y  ",6);
		double wwgs = ppnzdo/pzsn;
		JLabel ply_dyn_5 = new JLabel("WskaŸnik wydajnoœci gotówkowej sprzeda¿y = " + df.format(wwgs));
		add(ply_dyn_5);
		add(new JLabel (" "));//przerwa
		
		
		add(rent_wzg);//naglowek
		
		double zb = Ekstraktor.znajdz(dane, "Zysk/(strata) brutto na sprzeda¿y ",6);
		double pzs = Ekstraktor.znajdz(dane, "Przychody ze sprzeda¿y  ",6);
		double ppo =Ekstraktor.znajdz(dane, "Pozosta³e przychody operacyjne 1,3 ",4);
		double pf = Ekstraktor.znajdz(dane, "Przychody finansowe 1,4 ",4);
		double wrob = zb/(pzs+ppo+pf);
		JLabel rent_wzg_1 = new JLabel("WskaŸnik rentownoœci obrotu brutto = " + df.format(wrob));
		add(rent_wzg_1);
	
		
		double wron = zn/(pzs+ppo+pf);
		JLabel rent_wzg_2 = new JLabel("WskaŸnik rentownoœci obrotu netto = " + df.format(wron));
		add(rent_wzg_2);

		double smb = zb/pzs;
		JLabel rent_wzg_3 = new JLabel("Stopa mar¿y brutto = " + df.format(smb));
		add(rent_wzg_3);
		
		double rmo = zn/ako;
		JLabel rent_wzg_4 = new JLabel("Rentownoœæ maj¹tku ogó³em = " + df.format(rmo));
		add(rent_wzg_4);
		
		double zzdo = Ekstraktor.znajdz(dane, "Zysk/(strata) na dzia³alnoœci operacyjnej",6);
		double anieop =  Ekstraktor.znajdz(dane, "Lokaty bankowe powy¿ej 3 miesiêcy 41",6);  //aktywa nieoperacyjne, czyli lokaty 
		double wroa = zzdo/(ako-anieop);
		JLabel rent_wzg_5 = new JLabel("WskaŸnik rentownoœci operacyjnej aktywów = " + df.format(wroa));
		add(rent_wzg_5);
		
		double kw = Ekstraktor.znajdz(dane, "KAPITA£ W£ASNY",7); 
		double roe = zn/kw;
		JLabel rent_wzg_6 = new JLabel("WskaŸnik rentownoœci kapita³u w³asnego = " + df.format(roe));
		add(rent_wzg_6);
		
		
		double la = Ekstraktor.znajdz(dane, "Liczba akcji w tysi¹cach sztuk ",5); 
		double wa= Ekstraktor.znajdz(dane, "Wartoœæ ksiêgowa na akcjê (w PLN/EUR) ",5);  
		double swa = la * wa *1000; //sumaryczna wartosc akcji
		double wrka = (zn*1000/swa) ;
		JLabel rent_wzg_7 = new JLabel("WskaŸnik rentownoœci kapita³u akcyjnego = " + df.format(wrka) );
		add(rent_wzg_7);
		
		 double odsetki = Ekstraktor.znajdz(dane, "Odsetki i udzia³y w zyskach (dywidendy)  ",6); 
		double zd = Ekstraktor.znajdz(dane, "ZOBOWI¥ZANIA D£UGOTERMINOWE  ",4);
		double ks = zd + kw; //kapitaly stale to suma zobowiazan dlugoterminowych i kapitalow wlasnych
		double wrks = (zn+odsetki)/ks;
		JLabel rent_wzg_8 = new JLabel("WskaŸnik rentownoœci kapita³ów sta³ych = " + df.format(wrks));
		add(rent_wzg_8);
		
		
		add(new JLabel (" "));//przerwa
		
		add(przy_rent);//nag³ówek
		
		double iupzswpo = pzs/(pzs+ppo+pf);
		JLabel przy_rent_1 = new JLabel("Indeks udzia³u przychodów ze sprzeda¿y w przychodach ogó³em = " + df.format(iupzswpo));
		add(przy_rent_1);
		
		double iupfwpo = pf/(pzs+ppo+pf);
		JLabel przy_rent_2 = new JLabel("Indeks udzia³u przychodów finansowych w przychodach ogó³em = " + df.format(iupfwpo));
		add(przy_rent_2);
		
		
		double kosztysprzedazy = Ekstraktor.znajdz(dane, "Koszty sprzeda¿y 2",6);
		double koz = Ekstraktor.znajdz(dane, "Koszty ogólnego zarz¹du 2",5);
		double kof = Ekstraktor.znajdz(dane, "Koszty finansowe 4",3);
		double pko = Ekstraktor.znajdz(dane, "Pozosta³e koszty operacyjne 3",3);
		
		double iuokwpzswko = kosztysprzedazy/(kosztysprzedazy+koz+kof+pko);
		JLabel przy_rent_3 = new JLabel("Indeks udzia³u ogó³em kosztu w³asnego przychodów ze sprzeda¿y w koszcie ogó³em = " + df.format(iuokwpzswko));
		add(przy_rent_3);
		
		double iukfwko = kof/(kosztysprzedazy+koz+kof+pko);
		JLabel przy_rent_4 = new JLabel("Indeks udzia³u kosztów finansowych w koszcie ogó³em = " + df.format(iukfwko));
		add(przy_rent_4);
		
		add(new JLabel (" ")); //przerwa
		

		add(maj_kap); //naglowek
		
		double wzkw = kw/(ako-ao); //kapital wlasny / aktywa ogolem minus aktywa obrotowe
		JLabel maj_kap_1 = new JLabel("WskaŸnik zastosowania kapita³ów w³asnych  = " + df.format(wzkw));
		add(maj_kap_1);
		
		double pr = Ekstraktor.znajdz(dane, "PASYWA RAZEM",7);
		double wzko = (pr - kw)/ao;
		JLabel maj_kap_2 = new JLabel("WskaŸnik zastosowania kapita³ów obcych = " + df.format(wzko));
		add(maj_kap_2);
		
		
		double wosf = wzkw/wzko;
		JLabel maj_kap_3 = new JLabel("WskaŸnik ogólnej sytuacji finansowej = " + df.format(wosf));		
		add(maj_kap_3);		
		
		double skddmzw = ks/(ako-ao);
		JLabel maj_kap_4 = new JLabel("Stosunek kapita³u d³ugoterminowego do maj¹tku zwi¹zanego d³ugoterminowo = " + df.format(skddmzw));		
		add(maj_kap_4);
		
		
		double skkdmk = zok/ao;
		JLabel maj_kap_5 = new JLabel("Stosunek kapita³u krótkoterminowego do maj¹tku krótkoterminowego = " + df.format(skkdmk));
		add(maj_kap_5);
		
		add(new JLabel (" "));
	}

	
}