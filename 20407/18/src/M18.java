
public class M18 
{

	public static void main(String[] args) 
	{
		String w;
		//FileHandler F = new FileHandler("/Users/Alon/Documents/Temp/InputFiles/alon.txt");
		try
		{
			FileHandler F = new FileHandler("alon.txt");
			HashTable H = new HashTable();
			System.out.println("File read");
			for (int j=0;j < F.words.length;j++)
			{
				w = F.words[j];
				H.insertWord(w);
				System.out.println(w + "\n");
				
			}
			if (H.searchWord("aoln") != null)
			{
				System.out.println("found!");
				H.deleteWord(H.searchWord("aoln"));
				System.out.println("Deleted!");
			}
		}
		catch (Exception ex)
		{
			
		}
		
	}
}