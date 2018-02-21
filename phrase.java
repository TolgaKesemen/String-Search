import java.util.ArrayList;
import java.util.Locale;

public class phrase {
	public static void W(String searchkey, ArrayList<TST> tree){
		Locale trlocale = new Locale("tr-TR");
		String[] phrase = searchkey.split(" ");
		boolean cond = false;
		for(int m=0; m<tree.size(); m++){
			ArrayList<ArrayList<Integer>> lis = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<phrase.length; i++){
				lis.add(new ArrayList<Integer>());
				lis.get(i).addAll(tree.get(m).contains(phrase[i].toLowerCase(trlocale)));
			}
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i=0; i<phrase.length-1; i++){
				for(int j=0; j<lis.get(i).size(); j++){
					for(int k=0; k<lis.get(i+1).size(); k++){
						if(lis.get(i+1).get(k) == (lis.get(i).get(j)+1)){
							temp.add(lis.get(i+1).get(k));
						}
					}
				}
				lis.get(i+1).clear();
				lis.get(i+1).addAll(temp);
				temp.clear();
			}
			if(!lis.get(phrase.length-1).isEmpty()){
				for(int i=0; i<lis.get(phrase.length-1).size(); i++){
					System.out.println("File" + (m+1) + ".txt;" + searchkey + ";" + (lis.get(phrase.length-1).get(i)+1-(phrase.length-1)));
				}
				cond = true;
			}
		}
		if(!cond){
			System.out.println("No result found:"+searchkey);
		}
	}
}
