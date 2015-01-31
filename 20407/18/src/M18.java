
public class M18 
{

	public static void main(String[] args) 
	{
		String w;
		//FileHandler F = new FileHandler("/Users/Alon/Documents/Temp/InputFiles/alon.txt");
		try
		{
			
			//build dictionary
			FileHandler F = new FileHandler("alon.txt");
			HashTable H = new HashTable();
			//System.out.println("File read");
			for (int j=0;j < F.words.length;j++)
			{
				w = F.words[j];
				H.insertWord(w);
				//System.out.println(w + "\n");
				
			}
			//Build Tree
			FileHandler TF = new FileHandler("alon1.txt");
			RBTree T = new RBTree();
			for (int j=0;j < TF.words.length;j++)
			{
				w = TF.words[j];
				TreeNode N = new TreeNode(w);
				T.RBInsert(N);	
			}
			
			//Scan tree and delete recognized words
			TreeNode node = T.TreeMinimum(T.getRoot());
			TreeNode next;
			while (node != T.getNull())
			{
				next = T.TreeSuccessor(node);
				if (H.searchWord(node.getWord()) != null)
				{
					T.RBDelete(node);
				}
				node = next;
			}
			
			//Print the unrecognized words to the console
			T.InorderTreeWalk(T.getRoot());
			
			
			
//			//tree test
//			TreeNode x = T.TreeSearch(T.getRoot(), "dangur");
//			T.InorderTreeWalk(T.getRoot());
//			T.RBDelete(x);
//			T.InorderTreeWalk(T.getRoot());
//			
//			TreeNode N = new TreeNode("abcd");
//			T.RBInsert(N);
//			N = new TreeNode("acdd");
//			T.RBInsert(N);
//			N = new TreeNode("acas");
//			T.RBInsert(N);
//			N = new TreeNode("aces");
//			T.RBInsert(N);
//			N = new TreeNode("ades");
//			T.RBInsert(N);
//			N = new TreeNode("bces");
//			T.RBInsert(N);
//			N = new TreeNode("abes");
//			T.RBInsert(N);
//			
//			
//			//dictionary test
////			FileHandler F = new FileHandler("alon.txt");
////			HashTable H = new HashTable();
////			System.out.println("File read");
////			for (int j=0;j < F.words.length;j++)
////			{
////				w = F.words[j];
////				H.insertWord(w);
////				System.out.println(w + "\n");
////				
////			}
//			if (H.searchWord("aoln") != null)
//			{
//				System.out.println("found!");
//				H.deleteWord(H.searchWord("aoln"));
//				System.out.println("Deleted!");
//			}
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		
	}
}