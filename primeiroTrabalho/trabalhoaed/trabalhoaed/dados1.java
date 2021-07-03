package trabalhoaed;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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

public class dados1 
{
	static String nome="Distribuição fundos por estado 2014";
	static String arq = "distribuicaoestado.csv";
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
	static int tamanho = Tamarq(file);
	int total=0;
	public static BigDecimal[] valor = new BigDecimal[tamanho];
	static List<String> estados = new ArrayList<String>();
	public static BigDecimal[] valorS = new BigDecimal[tamanho];
	static List<String> estadosS = new ArrayList<String>();
	
	public void Insere(BigDecimal gasto,String estado)
	{
		valor[total] = gasto;
		estados.add(estado);
		valorS[total] = gasto;
		estadosS.add(estado);
		total ++;
	}
	
    public double insertionsort()
    {
    	double tempoInicio = System.currentTimeMillis();
    	BigDecimal chave;
    	String estadoC;
        int i,j = 0;
        
        for (i=1; i<dados1.tamanho-1; i++)
        {
            chave = valor[i];
            estadoC = estados.get(i);
            for	 (j=i-1;j>=0 && chave.compareTo(valor[j])==1;j--)
            {
                valor[j+1] =valor[j];
                estados.set(j+1, estados.get(j));
            }
            valor[j+1] = chave;
            estados.set(j+1,estadoC);
            
        }
        return (System.currentTimeMillis()-tempoInicio)/1000;
    }
    public double shellSort() 
    {
    	double tempoInicio = System.currentTimeMillis();
        int h = 1;
    	String estadoC;
        int n = valorS.length-2;
        while(h < n) 
        {
                h = h * 3 + 1;
        }
        
        h = h / 3;
        BigDecimal c;
		int j;
        
        while (h > 0) 
        {
            for (int i = h; i < n; i++) 
            {
                c = valorS[i];
                estadoC = estadosS.get(i);
                j = i;
                while (j >= h && valorS[j - h].compareTo(c)==1) 
                {
                    valorS[j] = valorS[j - h];
                    estadosS.set(j, estadosS.get(j-h));
                    j = j - h;
                }
                valorS[j] = c;
                estadosS.set(j,estadoC);
            }
            h = h / 2;
        }

        return (System.currentTimeMillis()-tempoInicio)/1000;
    }
    
    
	public void Imprime()
	{
		int i;
		for(i=tamanho-2;i>=0;i--)
		{
			System.out.println("Estado " +estados.get(i)+" GASTO: R$" + valor[i] );
		}
	}
	public void geragrafico() throws IOException
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		    
	    for(int i=tamanho-2;i>0;i--)
		{
	    	BigDecimal cem = new BigDecimal(100);
	    	valor[i]=valor[i].divide(valor[0],new MathContext(2,RoundingMode.HALF_EVEN));
	    	valor[i]=valor[i].multiply(cem);
	    	dataset.setValue(valor[i], "", estados.get(i));
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("Distribuição por Estado 2014","ESTADOS ", "%", dataset,
				PlotOrientation.VERTICAL,false,false,true);
		chart.setBackgroundPaint(Color.white);
		chart.getTitle().setPaint(Color.black);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.RED);
		ChartFrame frame1 = new ChartFrame("Count",chart);
		frame1.setSize(1366,768);
		RefineryUtilities.centerFrameOnScreen(frame1);
		frame1.setVisible(true);
		
		ChartUtilities.saveChartAsJPEG(new File("C://Users//Sanada//Desktop/grafico1.jpeg"), chart, 1366,768);
	}

}
