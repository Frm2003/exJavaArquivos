package ex02.controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class steamController implements interfaceArqs {
	
	public steamController() {
		super();
	}
	
	@Override
	public void leArq(String path, String nome, String ano, String mes, int media) throws IOException {
		File arq = new File(path, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			System.out.printf("| %-40s | %-30s |", "Nome do jogo", "Média de jogadores ativos");
			System.out.println();

			while (linha != null) {
				String vet[] = linha.trim().split(",");
				if (vet[1].equals(ano) && vet[2].equals(mes) && Double.parseDouble(vet[3]) >= media) {
					System.out.printf("| %-40s | %-30s |", vet[0], vet[5]);
					System.out.println();
				}
				linha = buffer.readLine();
			}
			
			buffer.close(); leitor.close(); fluxo.close();
		} else {
			System.out.println("Arquivo inválido");
		}
	}
	
	public void criaArq(String path, String ano, String mes) throws IOException {
		File dir = new File(path);
		File arq = new File(path, "dadosSteam" + mes + ano + ".csv");
		
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = geraTexto(ano, mes);
			FileWriter fw = new FileWriter(arq, existe);
			PrintWriter p = new PrintWriter(fw);
			p.write(conteudo);
			p.flush();
			p.close();
			fw.close();
		} else {
			System.out.println("Arquivo inválido");
		}
	}
	
	private String geraTexto(String ano, String mes) throws IOException {
		StringBuffer sb = new StringBuffer();

		File leArq = new File("C:\\TEMP", "SteamCharts.csv");
		FileInputStream fluxo = new FileInputStream(leArq);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		
		sb.append("nome do jogo, media dos jogadores ativos \r\n");
		
		while (linha != null) {
			String vet[] = linha.trim().split(",");
			if (vet[1].equals(ano) && vet[2].equals(mes)) {
				sb.append(vet[0] + ", " + vet[3] + "\r\n");
			}
			linha = buffer.readLine();
		}
		
		buffer.close(); leitor.close(); fluxo.close();
		
		return sb.toString();
	}

}
