
public class HashTable 
{
	private static final int M = 100;
	private DictionaryWord[] hArr;
	
	public HashTable()
	{
		hArr = new DictionaryWord[M];
	}
	
	private int hashFunc (String word)
	{
		int sum = 0;
		for (int i=0;i < word.length();i++)
		{
			sum += (int)word.charAt(i);
		}
		return sum % M;
	}
	
	public void insertWord (String word)
	{
		DictionaryWord dWord = new DictionaryWord(word);
		int hKey = hashFunc(word);
		if (hArr[hKey] == null)
		{
			hArr[hKey] = dWord;
		}
		else
		{
			hArr[hKey].setPrev(dWord);
			dWord.setNext(hArr[hKey]);
			hArr[hKey] = dWord;
		}
	}
	
	public DictionaryWord searchWord(String word)
	{
		int hKey = hashFunc(word);
		DictionaryWord dWord = hArr[hKey];
		while (dWord != null && !dWord.getWord().equals(word))
		{
				dWord = dWord.getNext();	
		}
		return dWord;
	}
	
	public void deleteWord(DictionaryWord word)
	{
		word.getPrev().setNext(word.getNext());
		word.getNext().setPrev(word.getPrev());
	}
	
}
