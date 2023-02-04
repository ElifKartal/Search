package MovieSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("PLEASE WAIT...");
		Tree tree = new Tree();
		String text = "C:\\Users\\Elif\\Desktop\\movie.txt";
		BufferedReader read =new BufferedReader((new FileReader(text)));// text dosyası tanıtıldı ve okundu.
		String okunan;
		
		
		
		while((okunan =read.readLine()) != null) { //Klavyeden gelen veri okunarak okunan satır eklenir.
			tree.insert(okunan);
			
		}
		
		
		Scanner scan =new Scanner(System.in); //Kullanıcıdan gelen veri okunur.
		
		System.out.println("---------------------------------");
		
		while(true) {  
		
			System.out.println("ARADIGINIZ KELIMEYI YAZINIZ:");  
			String word = scan.nextLine(); 
			
			
			
			
			List<String> t = tree.autocomplete(word.toUpperCase(Locale.ROOT));
			
			if (t.size() !=0) {    //Olası kelimeler bulunup sıralanır.
				System.out.println("BUNU MU ARADINIZ ?" );
				
			}
			else {
				System.out.println("LISTEDE BULUNAMADI"); //Benzer kelime bulunamazsa çalışır.
				
			}
			
			for (int i =0 ;i< t.size(); i++) { // Kelimeler sırasıyla getirilir.
				System.out.println(t.get(i));
				
			}
			System.out.println("                             ");
		}
	}

}

