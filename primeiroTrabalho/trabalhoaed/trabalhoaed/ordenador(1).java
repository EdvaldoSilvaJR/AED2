package trabalhoaed;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class ordenador 
{
	/*Function to sort array using insertion sort*/
    public void sort(int vetor[])
    {
        int tam = vetor.length;
        for (int i=1; i<tam; ++i)
        {
            int chave = vetor[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && vetor[j] > chave)
            {
                vetor[j+1] = vetor[j];
                j = j-1;
            }
            vetor[j+1] = chave;
        }
    }
    public static int Tamarq(File arquivo) throws IOException
    {
    	@SuppressWarnings("resource")
		LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(arquivo));
    	linhaLeitura.skip(arquivo.length());
    	int qtdLinha = linhaLeitura.getLineNumber();
    	return qtdLinha;
    }
	@SuppressWarnings("null")
	public static void main(String args[]) throws ParseException, IOException
	{
		String arq = "distribuicaoEstadonormal.csv";
		File file = new File(arq);
		try
		{
			int i=0;
			Scanner InputStream = new Scanner(file);
			InputStream.next();
			InputStream.next();
			BigDecimal[] valor = new BigDecimal[Tamarq(file)];
			while(InputStream.hasNext())
			{
				String dados = InputStream.next();
				//dados = InputStream.next();
				dados=dados.replace(",","x");
				dados=dados.replace(".","");
				dados=dados.replace("x", ".");
				dados=dados.substring(4, dados.length()-1);
				valor[i] = new BigDecimal(dados);
				System.out.println(valor[i]);
				i++;
				//System.out.println(valores[0].substring(4, valores[0].length()-1));
				
			}
			for(i=0;i<valor.length;i++)
			{
				System.out.println("TESTANDO SAIDA "+valor[i] );
			}
			InputStream.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
