// Class that handles the dictionary words, utilizing a hash table.
public class HashTable 
{
	private static final int M = 100; // number of different values for the hash function
	private DictionaryWord[] hArr; // array to hold the beginning of each hash value linked list
	
	public HashTable()
	{
		hArr = new DictionaryWord[M];
	}

    // the hash function. hash value = the sum of ASCII values of all the characters that make up the word --> modulu M.
	private int hashFunc (String word)
	{
		int sum = 0;
		for (int i=0;i < word.length();i++)
		{
			sum += (int)word.charAt(i);
		}
		return sum % M;
	}

    // method for adding a word to the dictionary
	public void insertWord (String word)
	{
		DictionaryWord dWord = new DictionaryWord(word);
		int hKey = hashFunc(word);
		if (hArr[hKey] == null) // first with this hash value that is added to the dictionary
		{
			hArr[hKey] = dWord;
		}
		else // there already are words in the dictionary with this hash value. adding this one to the linked list.
		{
			hArr[hKey].setPrev(dWord);
			dWord.setNext(hArr[hKey]);
			hArr[hKey] = dWord;
		}
	}

    // method for looking up a word in the dictionary. returns pointer of the word reached. null if the word is not in the dictionary
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

}
