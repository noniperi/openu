import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Handle reading from files and splitting in to words. Normalization to lowecase also takes place in this class.
public class FileHandler 
{
	private String fileContent;
	public String[] words;

	public FileHandler(String fileName)
	{
		try
		{
			fileContent = readFile(fileName);
			fileContent = fileContent.toLowerCase();
			words = fileContent.split("( )|(\n)");
		}
		catch (IOException ex)
		{
			System.out.println("Error: " + ex);
			throw new RuntimeException(ex);
		}
	}
	
	String readFile(String fileName) throws IOException 
	{
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) 
	        {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } 
	    finally 
	    {
	        br.close();
	    }
	}
}
