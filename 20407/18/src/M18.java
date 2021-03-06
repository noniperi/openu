
public class M18 
{

	public static void main(String[] args) 
	{
		String w;

		try
		{
			
			//build dictionary
			FileHandler F = new FileHandler("/Users/noni/openu/20407/18/dict.1000.txt");
			HashTable H = new HashTable();
			//System.out.println("File read");
			for (int j=0;j < F.words.length;j++)
			{
				w = F.words[j];
				H.insertWord(w);
				//System.out.println(w + "\n");
				
			}
			//Build Tree
			FileHandler TF = new FileHandler("/Users/noni/openu/20407/18/given_text.txt");
            //FileHandler TF = new FileHandler("/Users/noni/openu/20407/18/other_text.txt");
			RBTree T = new RBTree();
			for (int j=0;j < TF.words.length;j++)
			{
				w = TF.words[j];
				TreeNode N = new TreeNode(w);
				T.RBInsert(N);	
			}
			
			//Scan tree and delete recognized words
			TreeNode node = T.TreeMinimum(T.getRoot());
			TreeNode next, temp;
			while (node != T.getNull())
			{
				next = T.TreeSuccessor(node);
				if (H.searchWord(node.getWord()) != null)
				{
					temp = T.TreePredecessor(node);
                    T.RBDelete(node);
                    if (temp.getWord() != null)
                    {
                        next = T.TreeSuccessor(temp);
                    }
                    else
                    {
                        next = T.TreeMinimum(T.getRoot());
                    }
                    node = next;
				}
                else
                {
                    node = T.TreeSuccessor(node);
                }
			}
			
			//Print the unrecognized words to the console
			T.InorderTreeWalk(T.getRoot());
			

		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		
	}
}