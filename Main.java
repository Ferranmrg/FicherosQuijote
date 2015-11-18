package ut01.quijote;

import java.util.ArrayList;

public class Main {

	final static String fichero = "res/quijote.txt";
	final static String ficheroDiptongo = "res/DIPTONGO.txt";
	final static String ficheroTriptongo = "res/TRIPTONGO.txt";
	final static String ficheroMayus = "res/QUIMAYUS.txt";
	final static String ficheroPalMayus = "res/PALMAYUS.txt";
	final static String ficheroPalMinus = "res/PALMINUS.txt";

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		long total = 0;
		// System.out.printf("%s tiene %d caracteres \n", fichero,new
		// FicherosTexto().countUTFChars(fichero));
		// new FicherosTexto().countWords(fichero));
		// System.out.format("%s tiene %d palabras\n", fichero,
		// new FicherosTexto().countWords(fichero));
		// System.out.format("%s tiene %d caracteres en minusculas\n", fichero,
		// new FicherosTexto().countLowCaseChars(fichero));
		// System.out.format("%s tiene %d caracteres \n", fichero, new
		// FicherosTexto().countAsciiChars(fichero));
		// System.out.format("%s tiene %d lineas \n", fichero, new
		// FicherosTexto().countLines(fichero));
		// System.out.format("%s tiene %d palabras \n", fichero, new
		// FicherosTexto().countWords(fichero));
		// System.out.format("%s tiene %d palabras que contengan esta cadena
		// \n", fichero,
		// new FicherosTexto().countWords(fichero, "pueblo"));
		// System.out.format("%s tiene %d palabras que tienen diptongo \n",
		// fichero,
		// new FicherosTexto().countDipWords(fichero));
		// System.out.format("En %s la palabra mas larga es: %s \n", fichero,
		// new FicherosTexto().longestWords(fichero));
		// System.out.format("En %s el primer triptongo se encuentra en: %d \n",
		// fichero,
		// new FicherosTexto().positionTripWord(fichero));
		// System.out.format("En %s el primer pentasilábico se encuentra en: %d
		// \n", fichero,
		// new FicherosTexto().positionPentaWord(fichero));
		// for(String s : new FicherosTexto().getPentaWords(fichero, false)){
		// System.out.println(s);
		// }
		// System.out.format("%s tiene %d veces este caracter\n", fichero,new
		// FicherosTexto().getNumberChar(fichero, 'a'));
		// System.out.format("%s tiene %d veces este caracter\n", fichero, new
		// FicherosTexto().getNumberChars(fichero).get('b'));
		// System.out.format("%s tiene %d veces esta palabra\n", fichero, new
		// FicherosTexto().getNumberWord(fichero, "pueblo"));
		// new FicherosTexto().writeDiptongo(fichero, ficheroDiptongo);
		// new FicherosTexto().writeTriptongo(fichero, ficheroTriptongo);
		// new FicherosTexto().transformUpperCase(fichero, ficheroMayus);
		// new FicherosTexto().writeUpperCase(fichero, ficheroPalMayus);
		// new FicherosTexto().writeLowerCase(fichero, ficheroPalMinus);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;

		System.out.format("Ejecutado en %d milisegundos", elapsedTime);
	}

}
