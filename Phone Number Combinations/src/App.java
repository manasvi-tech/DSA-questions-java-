import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void phoneDiary(List<List<String>> ans, List<String> set, int i, HashMap<Character,String> map, String number){
		if(number.length()==i){
			ans.add(new ArrayList<>(set));
			return;
		}
		char c = number.charAt(i);
		String val = map.get(c);
		for(int x =0;x<val.length();x++){
			set.add(val.charAt(x)+"");
			phoneDiary(ans,set,i+1,map,number);
			set.remove(set.size()-1);
		}
	}
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();

		HashMap<Character,String> map = new HashMap<>();
		map.put('1',"abc");
		map.put('2',"def");
		map.put('3',"ghi");
		map.put('4',"jkl");
		map.put('5',"mno");
		map.put('6',"pqrs");
		map.put('7',"tuv");
		map.put('8',"wx");
		map.put('9',"yz");
    
	List<List<String>> ans = new ArrayList<>();
	List<String> set = new ArrayList<>();

	phoneDiary(ans,set,0,map,str);

	StringBuilder result = new StringBuilder();
	

	for(List<String> list : ans){
		for(String st: list){
			result.append(st);
		}
		result.append(" ");
	}

	System.out.println(result.toString());
	System.out.println(ans.size());
    
	}
}
