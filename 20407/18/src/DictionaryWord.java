// Object to contain each dictionary word.
public class DictionaryWord 
{
	private String _word;
	private DictionaryWord _prev;
	private DictionaryWord _next;
	
	public DictionaryWord(String newWord)
	{
		_word = newWord;
		_prev = null;
		_next = null;
	}
	
	public DictionaryWord getNext()
	{
		return _next;
	}
	
	public void setNext(DictionaryWord next)
	{
		_next = next;
	}
	
	public DictionaryWord getPrev()
	{
		return _prev;
	}
	
	public void setPrev(DictionaryWord prev)
	{
		_prev = prev;
	}
	
	public String getWord()
	{
		return _word;
	}
	
}
