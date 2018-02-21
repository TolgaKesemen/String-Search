import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Exp4 {
	
	public static void main(String[] args) {
		
		try{
			File folder = new File(args[0]);
			File[] listOfFiles = folder.listFiles();
			ArrayList<TST> tree = new ArrayList<TST>();
			Locale trlocale = new Locale("tr-TR");
			for (int i = 0; i < listOfFiles.length; i++) {
			  File file = listOfFiles[i];
			  TST t = new TST();
			  if (file.isFile() && file.getName().endsWith(".txt")) {
				  Scanner scanner = new Scanner(file);
				  while(scanner.hasNextLine()){
					  String string = scanner.nextLine();
					  String[] words = string.split("\n| |\t|, |\r");
					  for(int j=0; j<words.length; j++){
							t.put(words[j].toLowerCase(trlocale), j);
						}
				  }
				  tree.add(t);
				  scanner.close();
			  }
			  System.out.println("File"+(i+1)+".txt indexed");
			}
			System.out.println();
			String[] s;
			while(true){
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter key and search method:");
				s = scan.nextLine().split(" ");
				if(s[0].equals("q") || s[0].equals("Q")){
					scan.close();
					System.out.println("You exited successfully!!!");
					break;
					}
				String searchkey = "";
				searchkey += s[2];
				for(int i=3; i<s.length; i++){
					searchkey += " " + s[i];
				}
				if(s[1].equals("-w")){
					System.out.println();
					word.w(searchkey, tree);
					System.out.println();
				}
				else if(s[1].equals("-W")){
					System.out.println();
					phrase.W(searchkey, tree);
					System.out.println();
				}
			}
		}
		catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
		}
	}
}
