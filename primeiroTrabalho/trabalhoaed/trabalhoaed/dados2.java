package trabalhoaed;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class dados2 
{
	String nome;
	long totalpop=0;
	static String arq = "populacao.csv";
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
	static int tamanho = Tamarq(file),total=0;
	int[] valores = new int[tamanho];
	static List<String> estados = new ArrayList<String>();
	int[] valoresS = new int[tamanho];
	static List<String> estadosS = new ArrayList<String>();
	public void Insere(int gasto,String estado)
	{
		valores[total] = gasto;
		estados.add(estado);
		total ++;
		totalpop = totalpop+gasto;
	}
	public double insertionsort()
    {
		double tempoInicio = System.currentTimeMillis();
    	int chave;
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
        int n = valores.length;
        while(h < n) {
                h = h * 3 + 1;
        }
        
        h = h / 3;
        int c;
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
		int leftIndex = 0;
		int rightIndex = total;
		int k = 0;
		for(int m = leftIndex; m < rightIndex; m++){
			if(valores[m] > k){
				k = valores[m];
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
			vetorTemporario[valores[j]] += 1;
		}
		
		//Fazendo o  complemento do numero anterior 
		for(int i = leftIndex; i < k; i++){
			vetorTemporario[i] = vetorTemporario[i] + vetorTemporario[i - 1];
		}
		
		//Ordenando o array da direita para a esquerda
		int[] vetorAuxiliar = new int[valores.length];
		for(int j = rightIndex; j > leftIndex; j--) {
			vetorAuxiliar[vetorTemporario[valores[j]]] = valores[j];
			vetorTemporario[valores[j]] -= 1; 
		}
		
		//Retornando os valores ordenados para o vetor de entrada
		for (int i = leftIndex; i < rightIndex; i++){
			valores[i] = vetorAuxiliar[i];
		}

		return System.currentTimeMillis()-tempoInicio/1000;
	}

	public void geragrafico() throws IOException
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		    
	    for(int i=0;i<total;i++)
		{
	    	dataset.setValue(valores[i], "", estados.get(i));
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("População 2010","ESTADOS ", "QTD POPULAÇÃO", dataset
				,PlotOrientation.VERTICAL,false,true,false);
		chart.setBackgroundPaint(Color.WHITE);
		chart.getTitle().setPaint(Color.ORANGE);
		CategoryPlot p = chart.getCategoryPlot();
		ChartFrame frame1 = new ChartFrame("Count",chart);
		frame1.setSize(1366,768);
		RefineryUtilities.centerFrameOnScreen(frame1);
		frame1.setVisible(true);
		
		ChartUtilities.saveChartAsJPEG(new File("C://Users//Sanada//Desktop/grafico2.jpeg"), chart, 1366, 768);
	}
	public void Imprimepop()
	{
		int i;
		for(i=0;i<total;i++)
			System.out.println("Estado " +estados.get(i)+" POPULAÇÃO" + valores[i] );
	}

}
