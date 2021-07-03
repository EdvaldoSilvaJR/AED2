package trabalhoaed;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

public class dados4 
{
	String nome;
	long totalpop;
	static String arq = "taxafrequenciabruta.csv";
	static File file = new File(arq);
		//Pega o numero de linhas do arquivo
	public static int Tamarq(File arquivo) 
    {
    	LineNumberReader linhaLeitura = null;
		try {
			linhaLeitura = new LineNumberReader(new FileReader(arquivo));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			linhaLeitura.skip(arquivo.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int qtdLinha = linhaLeitura.getLineNumber();
    	return qtdLinha;
    }
	static int tamanho = Tamarq(file) + 2,total=0;
	static float[] valores = new float[tamanho];
	static List<String> estados = new ArrayList<String>();
	public void Insere(float gasto,String estado)
	{
		valores[total] = gasto;
		estados.add(estado);
		total ++;
	}
	public double insertionsort()
    {
		double tempoInicio = System.currentTimeMillis();
    	float chave;
    	String estadoC;
        int i,j = 0;
        
        for (i=1; i<total; i++)
        {
            chave = valores[i];
            estadoC = estados.get(i);
            for	 (j=i-1;j>=0 && chave<valores[j];j--)
            {
                valores[j+1] =valores[j];
                estados.set(j+1, estados.get(j));
            }
            valores[j+1] = chave;
            estados.set(j+1,estadoC);
        }
        return (System.currentTimeMillis()-tempoInicio)/1000;
    }
	public double shellSort() 
    {
		double tempoInicio = System.currentTimeMillis();
        int h = 1;
    	String estadoC;
        int n = valores.length-3;
        while(h < n) {
                h = h * 3 + 1;
        }
        
        h = h / 3;
        float c;
		int j;
        
        while (h > 0) 
        {
            for (int i = h; i < n; i++) 
            {
                c = valores[i];
                estadoC = estados.get(i);
                j = i;
                while (j >= h && valores[j - h] > c ) 
                {
                    valores[j] = valores[j - h];
                    estados.set(j, estados.get(j-h));
                    j = j - h;
                }
                valores[j] = c;
                estados.set(j,estadoC);
            }
            h = h / 2;
        }
        return (System.currentTimeMillis()-tempoInicio)/1000;
    }
	public double CountingSort() 
	{
			double tempoInicio = System.currentTimeMillis();
			//Encontrar o maior valor 
			int leftIndex = (int) valores[0];
			int rightIndex = (int) valores[total];
			int k = 0;
			for(int m = leftIndex; m < rightIndex; m++){
				if(valores[m] > k){
					k = (int) valores[m];
				}
			}
			
			//Cria vetor com o tamanho do maior elemento
			int[] vetorTemporario = new int[k];
			
			//Inicializar com zero o vetor temporario
			for(int i = 0; i < vetorTemporario.length; i++){
				vetorTemporario[i] = 0;
			}
			
			//Contagem das ocorrencias no vetor desordenado
			for(int j = leftIndex; j < rightIndex; j++){
				vetorTemporario[(int) valores[j]] += 1;
			}
			
			//Fazendo o  complemento do numero anterior 
			for(int i = leftIndex; i < k; i++){
				vetorTemporario[i] = vetorTemporario[i] + vetorTemporario[i - 1];
			}
			
			//Ordenando o array da direita para a esquerda
			int[] vetorAuxiliar = new int[valores.length];
			for(int j = rightIndex; j > leftIndex; j--) {
				vetorAuxiliar[vetorTemporario[(int) valores[j]]] = (int) valores[j];
				vetorTemporario[(int) valores[j]] -= 1; 
			}
			
			//Retornando os valores ordenados para o vetor de entrada
			for (int i = leftIndex; i < rightIndex; i++){
				valores[i] = vetorAuxiliar[i];
			}

			return (System.currentTimeMillis()-tempoInicio)/1000;
		}
	public void Imprime()
	{
		int i;
		for(i=0;i<total;i++)
			System.out.println("REGIAO " +estados.get(i)+" TAXA FREQUENCIA " + valores[i] );
		for( i=0;i<total;i++)
		{
			System.out.println("TESTANDO PORC "+valores[i]);
		}
	}

	float [] porc = new float[tamanho];
	public void geragraficopizza() throws IOException
	{
		DefaultPieDataset pie = new DefaultPieDataset() ;
		
		for(int i=0;i<total-1;i++)
		{
			pie.setValue(estados.get(i)+"\n%"+valores[i],valores[i]);
		}
		JFreeChart grafico = ChartFactory.createPieChart3D("População Residente",pie,true,true,true);
		grafico.setBackgroundPaint(Color.lightGray);
		grafico.getTitle().setPaint(Color.black);
		ChartFrame frame1 = new ChartFrame("Grafico Frequencia Escolar Bruta por Região",grafico);
		frame1.setSize(1366,768);
		RefineryUtilities.centerFrameOnScreen(frame1);
		frame1.setVisible(true);
		
		ChartUtilities.saveChartAsJPEG(new File("C://Users//Sanada//Desktop/grafico4.jpeg"), grafico, 1366, 768);
	}

}
