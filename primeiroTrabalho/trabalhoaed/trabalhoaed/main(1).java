package trabalhoaed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main 
{
	public static void main(String args[])
	{
		String arq = "distribuicaoEstado.csv";
		File file = new File(arq);
		try
		{
			Scanner InputStream = new Scanner(file);
			InputStream.next();
			while(InputStream.hasNext())
			{
				String dados = InputStream.next();
				dados.split(";");
				
			}
			InputStream.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
