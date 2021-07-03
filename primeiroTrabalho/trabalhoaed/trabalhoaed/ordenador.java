package trabalhoaed;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class ordenador 
{
    
	public static void ordenador1(int opc) throws ParseException, IOException
	{
		String arq = "distribuicaoestado.csv";
		File file = new File(arq);
		try
		{
			String passar;
			Scanner InputStream = new Scanner(file);
			InputStream.next();
			double contS = 0,contI;
			dados1 distribuicao=new dados1();
			String distribuicaoS = InputStream.next();
			
			while(InputStream.hasNext())
			{
				distribuicaoS = InputStream.next();
				distribuicaoS=distribuicaoS.replace(",","x");
				distribuicaoS=distribuicaoS.replace(".","");
				distribuicaoS=distribuicaoS.replace("x", ".");
				distribuicaoS=distribuicaoS.replace("-3", "TT");
				passar = distribuicaoS.substring(0,2);
				distribuicaoS=distribuicaoS.substring(4, distribuicaoS.length()-1);
				
				//valor[i] = new BigDecimal(dados);
				BigDecimal valorpassar = new BigDecimal(distribuicaoS);
				distribuicao.Insere(valorpassar,passar);
				//distribuicao2.Insere(valorpassar,passar);
			}
			contS=distribuicao.shellSort();
			contI=distribuicao.insertionsort();
			if(opc==1)
				distribuicao.geragrafico();
			else
			{
				JOptionPane.showMessageDialog(null,"TEMPO DE EXECU플O\n SHELLSORT:"+contS+"s"+"\nINSERTIONSORT "+contI+"s");
			}
			InputStream.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static void ordenador2(int op) throws ParseException, IOException
	{
		String arq = "populacao.csv";
		File file = new File(arq);
		double contS = 0,contI;
		try
		{
			String estado;
			Scanner InputStream = new Scanner(file);
			InputStream.next();
			
			dados2 arquivo2=new dados2();
			String dados = InputStream.next();
			
			while(InputStream.hasNext())
			{
				dados = InputStream.next();
				estado = dados.substring(0,2);
				dados=dados.substring(3, dados.length());
				int valorpassar=Integer.parseInt(dados);
				arquivo2.Insere(valorpassar,estado);
				
			}
			contS = arquivo2.shellSort();
			contI = arquivo2.insertionsort();
			if(op==3)
			arquivo2.geragrafico();
			else
			{
				
				JOptionPane.showMessageDialog(null,"TEMPO DE EXECU플O\n SHELLSORT:"+contS+"s"+"\nINSERTIONSORT "+contI);
				
			}
			InputStream.close();
			//testandodados.geragrafico();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static void ordenador3(int op) throws ParseException, IOException
	{
		String arq = "residentes.csv";
		File file = new File(arq);
		try
		{
			String estado;
			@SuppressWarnings("resource")
			Scanner InputStream = new Scanner(file);
			
			dados3 arquivo3=new dados3();
			String dados;
			while(InputStream.hasNext())
			{
				dados = InputStream.next();
				String[] partes = dados.split(",");
				estado = partes[0];
				int valorpassar=Integer.parseInt(partes[1]);
				arquivo3.Insere(valorpassar,estado);
			}
			
			double contS = arquivo3.shellSort();
			double contI = arquivo3.insertionsort();
			if(op == 5)
			arquivo3.geragraficopizza();
			else
				JOptionPane.showMessageDialog(null,"TEMPO DE EXECU플O\n SHELLSORT:"+contS+"s"+"\nINSERTIONSORT "+contI+"s");
				
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static void ordenador4(int op) throws ParseException, IOException
	{
		String arq = "taxafrequenciabruta.csv";
		File file = new File(arq);
		try
		{
			String estado;
			@SuppressWarnings("resource")
			Scanner InputStream = new Scanner(file);
			
			dados4 arquivo4=new dados4();
			String dados=InputStream.next();
			while(InputStream.hasNext())
			{
				dados = InputStream.next();
				String[] partes = dados.split(",");
				estado = partes[0];
				float valorpassar=Float.parseFloat(partes[1]);
				arquivo4.Insere(valorpassar,estado);
			}
			double contI = arquivo4.insertionsort();
			double contS = arquivo4.shellSort();
			double contC = arquivo4.CountingSort();
			if(op == 7)
			arquivo4.geragraficopizza();
			else
			JOptionPane.showMessageDialog(null,"TEMPO DE EXECU플O\n SHELLSORT:"+contS+"s"+"\nINSERTIONSORT "+contI+"s"+"\nCOUNTING "+contC+"s");
			
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static void ordenador5(int op) throws ParseException, IOException
	{
		String arq = "crescimentopop.csv";
		File file = new File(arq);
		try
		{
			String estado;
			Scanner InputStream = new Scanner(file);
			InputStream.next();
			
			dados5 arquivo5=new dados5();
			String dados = InputStream.next();
			
			while(InputStream.hasNext())
			{
				dados = InputStream.next();
				dados=dados.replace(".", "");
				estado = dados.substring(0,4);
				dados=dados.substring(5, dados.length());
				int valorpassar=Integer.parseInt(dados);
				arquivo5.Insere(valorpassar,estado);
				
			}
			double contI = arquivo5.insertionsort();
			if(op==9)
			{
				arquivo5.geragrafico();
			}
			double contS = arquivo5.shellSort();
			
			if(op!=9)
				JOptionPane.showMessageDialog(null,"TEMPO DE EXECU플O\n SHELLSORT:"+contS+"s"+"\nINSERTIONSORT "+contI+"s");
			
				InputStream.close();
			//testandodados.geragrafico();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
