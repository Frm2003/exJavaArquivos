package ex01.view;

import ex01.controle.*;

public class principal {
	public static void main(String[] args) {
		intManiArqs p = new aqsControle();
		
		String dir = "C:\\TEMP", name = "generic_food.csv";
		
		try {
			p.leArq(dir, name);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
