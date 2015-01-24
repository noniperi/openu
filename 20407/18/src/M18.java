
public class M18 
{

	public static void main(String[] args) 
	{
		String w;
		//FileHandler F = new FileHandler("/Users/Alon/Documents/Temp/InputFiles/alon.txt");
		try
		{
			//tree test
			RBTree T = new RBTree();
			TreeNode N = new TreeNode("abcd");
			T.RBInsert(N);
			N = new TreeNode("acdd");
			T.RBInsert(N);
			N = new TreeNode("acas");
			T.RBInsert(N);
			N = new TreeNode("aces");
			T.RBInsert(N);
			
			//dictionary test
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