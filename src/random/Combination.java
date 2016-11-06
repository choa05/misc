package random;
import java.util.*;
import java.io.*;

public class Combination {
	private static Map<Integer, Things[]> inventory;
	private static Set<String> result;
	
	public static void main(String[] args){
		Things[][] arr = {};
		initialize(arr);
		recurse(0, "");
		printResult();
		
	}

	
	public static void initialize (Things[][] given) {
		inventory = new HashMap<Integer, Things[]>();
		result = new HashSet<String>();
		for (int i = 0; i < given.length; i++) {
			inventory.put(i, given[i]);
		}
	}
	
	
	
	public static void recurse (int level, String str) {
		if (level == inventory.keySet().size() - 1){
			// stop and store what it has
			for (int i = 0; i < inventory.get(level).length; i++){
				String resultString = str + inventory.get(level)[i]; 
				result.add(resultString);
			}
		} 
		else {
			for (int i = 0; i < inventory.get(level).length; i++){
				String temp = str + inventory.get(level)[i]; 
				recurse (level + 1, temp);
			}
		}
	}
	
	public static void printResult () throws IOException {
		FileWritter out = null;

		try {
			out = new FileWriter("output.txt");
			if (result.size() != 0) {
				for (String s : result) {
					out.write(s);
				}
			}
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
