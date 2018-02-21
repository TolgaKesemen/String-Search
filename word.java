import java.util.ArrayList;
import java.util.Locale;

public class word {
	public static void w(String searchkey, ArrayList<TST> tree){
		Locale trlocale = new Locale("tr-TR");
		String[] st = searchkey.split(" ");
		boolean cond = false;
		for(int k=0; k<st.length; k++){
			cond = false;
			for(int i=0; i<tree.size(); i++){
				ArrayList<Integer> value = tree.get(i).contains(st[k].toLowerCase(trlocale));
				if(!value.isEmpty()){
					for(int j=0; j<value.size(); j++){
						System.out.println("File" + (i+1) + ".txt;" + st[k] + ";" + (value.get(j)+1));
					}
					cond = true;
				}
				
			}
			if(!cond){
				System.out.println("No result found:"+st[k]);
			}
		}	
	}
}
