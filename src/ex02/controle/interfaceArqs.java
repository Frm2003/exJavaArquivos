package ex02.controle;

import java.io.IOException;

public interface interfaceArqs {
	public void leArq(String path, String nome, String ano, String mes, int media) throws IOException;
	public void criaArq(String path, String ano, String mes) throws IOException;
}
