package ex02.view;

import ex02.controle.*;
import java.io.IOException;
import javax.swing.JOptionPane;

public class principal {

	public static void main(String[] args) throws IOException {
		interfaceArqs m = new steamController();

		int opc = 0;
		String ano, mes, dir, arq;
		
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - exibir por parâmetro \n2 - criar arquivo \n9 - System.exit(0)"));
			
			try {
				switch (opc) {
				case 1:
					ano = JOptionPane.showInputDialog("Digite o ano: ");
					mes = JOptionPane.showInputDialog("Digite o mes: ");
					int media = Integer.parseInt(JOptionPane.showInputDialog("Digite a media esperada: "));
					m.leArq("C:\\TEMP", "SteamCharts.csv", ano, mes, media);
					break;
				case 2:
					//dir = JOptionPane.showInputDialog("diretório válido: ");
					ano = JOptionPane.showInputDialog("Digite o ano: ");
					mes = JOptionPane.showInputDialog("Digite o mes: ");
					m.criaArq("C:\\TEMP", ano, mes);
					break;
				case 9:
					opc = 9; 
					System.exit(0);
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}

	}

}
