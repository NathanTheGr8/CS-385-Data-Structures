package lab08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Hash {

	HashMap<String,Integer> map = new HashMap<String,Integer>();

	public static void main(String[] args) throws FileNotFoundException {
		Hash lab = new Hash();
		lab.addLetters("data.in");
		lab.countLetters();
		

	}

	public void addLetters(String file) throws FileNotFoundException {
		// FileReader file = new FileReader("data.in");
		File fileObj = new File(file);
		Scanner in = new Scanner(fileObj);
		
		while(in.hasNextLine())
        {
            String letter = in.nextLine();
            
            if(map.containsKey(letter)){
            	map.put(letter,map.get(letter)+1);
            }
            else {
            	map.put(letter,1);
            }
        }

	}

	public void countLetters() {
		for(char alpha = 'a'; alpha <= 'z';alpha++) {
			System.out.println("('"+alpha+"', "+map.get(""+alpha)+")");
		}
		
	}

}
