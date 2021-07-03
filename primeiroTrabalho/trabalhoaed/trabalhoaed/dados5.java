package trabalhoaed;

import java.awt.Color;
import java.awt.Font;
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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class dados5 
{
	String nome;
	long totalpop;
	static String arq = "crescimentopop.csv";
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
	static long[] valores = new long[tamanho+1];
	static List<String> estados = new ArrayList<String>();
	public void Insere(long gasto,String estado)
	{
		valores[total] = gasto;
		estados.add(estado);
		total ++;
	}
	public double insertionsort()
    {
		long tempoInicio = System.currentTimeMillis();
    	long chave;
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
        int n = valores.length;
        while(h < n) {
                h = h * 3 + 1;
        }
        
        h = h / 3;
        long c;
		int j;
        
        while (h > 0) 
        {
            for (int i = h; i < n; i++) 
            {
                c = valores[i];
                j = i;
                while (j >= h && valores[j - h] > c ) 
                {
                    valores[j] = valores[j - h];
                    j = j - h;
                }
                valores[j] = c;
            }
            h = h / 2;
        }
        return (System.currentTimeMillis()-tempoInicio)/1000;
    }

	public void geragrafico() throws IOException
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		    
	    for(int i=0;i<total;i++)
		{
	    	dataset.setValue(valores[i], "", estados.get(i));
		}
		
		JFreeChart chart = ChartFactory.createLineChart("Previsão Crescimento Populacional 1980 - 2050 ","ANOS ", "QTD POPULAÇÃO", dataset
				,PlotOrientation.VERTICAL,true,true,false);
		chart.setBackgroundPaint(Color.WHITE);
		chart.getTitle().setPaint(Color.red);
		CategoryPlot p = chart.getCategoryPlot();
		ChartFrame frame1 = new ChartFrame("Count",chart);
		frame1.setFont(new Font("Arial", Font.PLAIN, 20));
		frame1.setSize(1366,768);
		RefineryUtilities.centerFrameOnScreen(frame1);
		frame1.setVisible(true);
        
		
		ChartUtilities.saveChartAsJPEG(new File("C://Users//Sanada//Desktop/grafico5.jpeg"), chart, 1366, 768);
	}
	public void Imprimepop()
	{
		int i;
		for(i=0;i<total;i++)
			System.out.println("Estado " +estados.get(i)+" POPULAÇÃO " + valores[i] );
	}

}
