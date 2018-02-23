package hungman;
import java.text.DecimalFormat;
import java.util.Random;

public class H_Class implements IHangman {

	private Integer MaxWrongGuesses;
	private String Secret_Word;
	private int[] recorder;
	private char[] Arr;
	private char[] GeussingArrray;
	private int R = 0;
	private String hashWord;
	private int count = 0;
	private String Dictionary[];
	private char[] HASH;
	private boolean First_Time = true;

	@Override
	public void setDictionary(String[] words) {
		if (words != null) {
			Dictionary = new String[words.length];
			Dictionary = words;
		} else
			Dictionary = null;

	}

	public String selectRandomSecretWord() {
       if (Dictionary != null && Dictionary.length != 0){
		Random t = new Random();
		Secret_Word = Dictionary[t.nextInt(Dictionary.length)];
		HASH = new char[Secret_Word.length()];
		GeussingArrray = new char[Secret_Word.length()];
		Arr = new char[Secret_Word.length()];
		recorder = new int[Secret_Word.length()];
		for (int i = 0; i < Secret_Word.length(); i++) {
			HASH[i] = '-';
			GeussingArrray[i] = '-';
			recorder[i] = -1;
		}
		hashWord = String.valueOf(HASH);
		return Secret_Word;
       }
       else {
    	    HASH = null;
			GeussingArrray = null;
			recorder = null;
    	   return null;
       }
	}

	@Override
	public String guess(Character c) {
		if (First_Time == true) {
			First_Time = false;
			if (HASH != null)
				return String.valueOf(HASH);
			else
				return null ;
		} 
		else {
		 if (c != null) {
			if (Character.isLowerCase(c) && Character.isUpperCase(Secret_Word.charAt(0))){
				c = Character.toUpperCase(c);
			}
			else if (Character.isLowerCase(Secret_Word.charAt(0)) && Character.isUpperCase(c)){
				c = Character.toLowerCase(c);
			}
		    String guess = String.valueOf(c);
			Arr = Secret_Word.toCharArray();
			if (count <= MaxWrongGuesses) {
				if (Secret_Word.contains(guess)) {
					for (int i = 0; i < Secret_Word.length(); i++) {
						boolean flage = false;
						for (int j = 0; j < Secret_Word.length(); j++) {
							if (recorder[j] == i)
								flage = true;
						}

						if (flage) {
							continue;
						}

						if (Arr[i] == c) {
							GeussingArrray[i] = c;
							recorder[R++] = i;
						} else {
							GeussingArrray[i] = '-';
						}
					}
					hashWord = String.valueOf(GeussingArrray);
					return hashWord;
				} 
				else {
					count++;
					if (count <= MaxWrongGuesses) {
					return hashWord;
					}
					else 
						return null ;
				}
			}
			else {
				return null;
			}
		}
		 else 
			return null ;
		}
		
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if (max != null) {
			MaxWrongGuesses = max;
		} else {
			MaxWrongGuesses = 0;
		}
	}

}
