package trabalhoaed;

import java.io.IOException;
import java.text.ParseException;

import javax.swing.JOptionPane;

public class main {
	public static void main(String args[])
	{
		int opcao;
		// TODO Auto-generated method stub
		opcao=Integer.parseInt( JOptionPane.showInputDialog( "entre com uma op��o n�mero\n1 Gera grafico Distribui��o Renda\n2 Mostra tempo execu��o para ordenar Distribui��o Renda"
				+ "\n3 Gera grafico Popula��o 2010\n4 Mostra tempo para ordenar popula��o 2010 \n5 Gera grafico Total Popula��o Residente \n6 Mostra tempo para ordenar popula��o residente"
				+ "\n7 Gera grafico Taxa de frequencia escolar 2014 \n8 Mostra tempo execu��o para ordenar frequencia escolar \n9 Gera grafico crescimento populacional previsto para 1980 - 2050"+
				"\n10 Mostra tempo execu��o crescimento populacional previsto\n 0 EXIT") );
		while(opcao!=0)
		{
		if(opcao==1|| opcao==2)
			{
				try {
					ordenador.ordenador1(opcao);
				} catch (ParseException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		else if(opcao==3|| opcao==4)
		{
			try {
				ordenador.ordenador2(opcao);
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(opcao==5|| opcao==6)
		{
			try {
				ordenador.ordenador3(opcao);
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(opcao==7|| opcao==8)
		{
			try {
				ordenador.ordenador4(opcao);
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(opcao==9|| opcao==10)
		{
			try {
				ordenador.ordenador5(opcao);
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		opcao=Integer.parseInt( JOptionPane.showInputDialog( "entre com uma op��o n�mero\n1 Gera grafico Distribui��o Renda\n2 Mostra tempo execu��o para ordenar Distribui��o Renda"
				+ "\n3 Gera grafico Popula��o 2010\n4 Mostra tempo para ordenar popula��o 2010 \n5 Gera grafico Total Popula��o Residente \n6 Mostra tempo para ordenar popula��o residente"
				+ "\n7 Gera grafico Taxa de frequencia escolar 2014 \n8 Mostra tempo execu��o para ordenar frequencia escolar \n9 Gera grafico crescimento populacional previsto para 1980 - 2050"+
				"\n10 Mostra tempo execu��o crescimento populacional previsto\n 0 EXIT") );
		}
		JOptionPane.showMessageDialog(null, "EXIT!");
	}

}
