package trabalhoaed;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class testegraf {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(100 , "", "job 1 ");
		dataset.setValue(500 , "", "job 2 ");
		JFreeChart chart = ChartFactory.createBarChart("Job Resources","", "Executation times", dataset,
				PlotOrientation.VERTICAL,false,true,false);
		chart.setBackgroundPaint(Color.white);
		chart.getTitle().setPaint(Color.blue);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.RED);
		ChartFrame frame1 = new ChartFrame("Count",chart);
		frame1.setVisible(true);
		frame1.setSize(1500,1500);
		ChartUtilities.saveChartAsJPEG(new File("C://Users//Sanada//Desktop/teste.jpeg"), chart, 1000, 1000);
	}

}
