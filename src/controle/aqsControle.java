package controle;

import java.io.File;
import java.io.*;

public class aqsControle implements intManiArqs {

	public aqsControle() {
		super();
	}

	@Override
	public void leArq(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			System.out.printf("| %-30s | %-50s | %-20s |", "NOME", "NOME CIENTIÍFICO", "SUB GRUPO");
			System.out.println("\n");

			while (linha != null) {
				String vet[] = linha.trim().split(",");
				if (vet[2].equals("Fruits")) {
					System.out.printf("| %-30s | %-50s | %-20s |", vet[0], vet[1], vet[3]);
					System.out.println();
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			System.out.println("Arquivo inválido");
		}
	}

}
