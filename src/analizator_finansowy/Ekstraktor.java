package analizator_finansowy;

import java.util.List;

public class Ekstraktor {
	
	public static void main () {
		
	}
	
	public static double znajdz(List<String> dokument, String slowo, int dlugosc) {
	int znaleziono=0;
	int i=0;
	String zwrot="0";
	double wartosc=0;
	
	
		while (i<dokument.size()&&znaleziono==0) {
			if (dokument.get(i).contains(slowo)) {
				znaleziono=1;
				zwrot=dokument.get(i);
				if (zwrot.length()==slowo.length()) {zwrot = zwrot + dokument.get(i+1);} //jesli znaleziony zwrot jest dokladnie tej samej dlugosci co szukane wyrazenie to znaczy ze dane liczbowe sa w nastepnym wierszu
				
			}
			else {
				i++;
			}
			
		}
		
		
		zwrot = zwrot.replaceAll(" ","");
		slowo = slowo.replaceAll(" ","");
		
		zwrot = zwrot.substring(slowo.length(),slowo.length()+dlugosc );
		zwrot = zwrot.replaceAll(",",".");
		zwrot = zwrot.replaceAll("\\(","-");
		wartosc= Double.parseDouble(zwrot);
		
		return wartosc;
	}
	
	public static String linia(List<String> dokument, String slowo, int dlugosc) {
		int znaleziono=0;
		int i=0;
		String zwrot="0";
		
		
		
			while (i<dokument.size()&&znaleziono==0) {
				if (dokument.get(i).contains(slowo)) {
					znaleziono=1;
					zwrot=dokument.get(i);
					if (zwrot.length()==slowo.length()) {zwrot = zwrot + dokument.get(i+1);} //jesli znaleziony zwrot jest dokladnie tej samej dlugosci co szukane wyrazenie to znaczy ze dane liczbowe sa w nastepnym wierszu

				}
				else {
					i++;
				}
				
			}
			//zwrot = zwrot.replaceAll(" ","");
			//slowo = slowo.replaceAll(" ","");
					
			return zwrot;
		}

	
}
