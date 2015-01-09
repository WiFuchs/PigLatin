import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {



public void setup() {
	String lines[] = loadStrings("LowellHymn.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) {
		String[] words = split(lines[i], ' ');
		for(int q=0; q<words.length; q++){
			System.out.print(pigLatin(words[q]) + " ");
		}
	}
}
public void draw()
{
}
public int findFirstVowel(String sWord)
//precondition: sWord is a valid String of length greater than 0.
//postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
{
	for(int i=0; i<sWord.length(); i++){
		char l = sWord.charAt(i);
		// if(l==',' || l=='-' || l== '_'){
		// 	sWord = sWord.substring(0, i-1) + sWord.substring(i+1);
		// }
		if(l=='a' || l=='e' || l=='i' || l=='o' || l=='u'){
			return i;
		}
	}
	return -1;
}

public String pigLatin(String sWord)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{
	if(findFirstVowel(sWord) == 0){
		return sWord + "way";
	}
	else if(findFirstVowel(sWord) == 1 && sWord.substring(0, 2).equals("qu")){
		return sWord.substring(2) + "quay";
	}
	else if(findFirstVowel(sWord)>0){
		return sWord.substring(findFirstVowel(sWord)) + sWord.substring(0, findFirstVowel(sWord)) + "ay";
	}
	else if(findFirstVowel(sWord) == -1)
	{
		return sWord + "ay";
	}
	else
	{
		return "ERROR!";
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
