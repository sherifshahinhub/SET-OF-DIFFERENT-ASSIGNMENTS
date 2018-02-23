package hungman;

public interface IHangman {
	public void setDictionary(String[] words);
	public String guess(Character c);
	public void setMaxWrongGuesses(Integer max);
}
