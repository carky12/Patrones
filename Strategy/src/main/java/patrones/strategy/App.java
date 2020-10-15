package patrones.strategy;

import patrones.strategy.strategy.AntivirusAvanzado;
import patrones.strategy.strategy.Contexto;

public class App {
	
	public static void main(String[] args) {
		Contexto contexto = new Contexto(new AntivirusAvanzado());
		contexto.ejecutar();
	}

}
