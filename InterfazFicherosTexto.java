package ut01.quijote;

import java.util.ArrayList;
import java.util.Map;

public interface InterfazFicherosTexto {

	/**
	 * Utilizando el fichero quijote.txt que contiene letras mayúsculas y
	 * minúsculas, con o sin acento o diéresis, cifras y demás caracteres
	 * imprimibles posibles, además de fines de línea y fin de fichero. Crear un
	 * método que devuelva el número de carácteres:
	 * 
	 * @param path
	 * @return
	 */
	abstract long countUTFChars(String path);

	/**
	 * Contar el número de letras minúsculas puras (sin acentuar ni diéresis)
	 * 
	 * @param path
	 * @return
	 */
	long countLowCaseChars(String path);

	/**
	 * Contar el número de letras (todas incluidas minúsculas, mayúsculas,
	 * acentuadas, etc., pero no los signos de puntuación, cifras y otros
	 * caracteres)
	 * 
	 * @param path
	 * @return
	 */
	long countAsciiChars(String path);

	/**
	 * Contar el número de líneas del fichero de texto.
	 * 
	 * @param path
	 * @return
	 */
	long countLines(String path);

	/**
	 * Contar el número de palabras
	 * 
	 * @param path
	 * @return
	 */
	long countWords(String path);

	/**
	 * Contar el número de palabras terminadas en una palabra (por ejemplo
	 * “cion”) (con o sin acentos, en minúsculas o mayúsculas)
	 * 
	 * @param path
	 * @param text
	 * @return
	 */
	int countWords(String path, String endText);

	/**
	 * Contar el número de diptongos (ojo con los acentos que deshacen
	 * diptongos). Ej: ai, oi, ei, au, ou, eu, io, ia, ie, uo, ua, ue, iu, ui.
	 * 
	 * @param path
	 * @return
	 */
	int countDipWords(String path);

	/**
	 * Obtener la palabra más larga y en otro método su posición (número de
	 * orden en la secuencia de palabras). Si hay más de una se toma la primera.
	 * Nota: El número de orden o posición de la palabra en el texto es el lugar
	 * que ocupa, una vez contadas todas.
	 * 
	 * @param path
	 * @return
	 */
	String longestWords(String path);

	/**
	 * Devuelve la posición de una palabra
	 * 
	 * @param path
	 * @return
	 */
	long posWord(String path, long pos);

	/**
	 * Encontrar la primera palabra que tiene un triptongo indicando el número
	 * tiene en la secuencia de palabras, si no existe devolverá 0.
	 * 
	 * @param path
	 * @return
	 */
	int positionTripWord(String path);

	/**
	 * Encontrar la primera palabra pentavocálica, si existe devolver el número
	 * tiene en la secuencia de palabras y cero si no existe ninguna.
	 * 
	 * @param path
	 * @return
	 */
	long positionPentaWord(String path);

	/**
	 * Devolver un array con todas las palabras pentavocálicas por orden de
	 * aparición.
	 * 
	 * @param path
	 * @param alfabeticOrder
	 * @return
	 */
	ArrayList<String> getPentaWords(String path, boolean alfabeticOrder);
	
	/**
	 * Obtener la frecuencia de una letra.
	 * 
	 * @param path
	 * @param letter
	 * @return
	 */
	long getNumberChar(String path, char letter);

	/**
	 * Obtener la frecuencia de las 27 letras del alfabeto en un Map en orden
	 * descendiente según la aparicion
	 */
	Map<Character, Long> getNumberChars(String path);

	/**
	 * 	Obtener la frecuencia de una palabra.

	 * @param ath
	 * @return
	 */
	long getNumberWord(String path, String word);

	/**
	 * Crear un nuevo fichero “DIPTONGO.TXT” con todas las palabras que
	 * contengan al menos un diptongo.
	 * 
	 * @param pathIn
	 * @param pathOut
	 */
	void writeDiptongo(String pathIn, String pathOut);

	/**
	 * Crear un nuevo fichero“TRIPTONGO.TXT” con todas las palabras que
	 * contengan al menos un triptongo.
	 * 
	 * @param in
	 * @param out
	 */
	void writeTriptongo(String pathIn, String pathOut);

	/**
	 * Crear un nuevo fichero “QUIMAYUS.TXT” que cambie todas las letras a
	 * mayúsculas.
	 * 
	 * @param pathIn
	 * @param pathOut
	 */
	void transformUpperCase(String pathIn, String pathOut);

	/**
	 * Crear fichero “PALMAYUS.TXT” con todas las palabras que empiezan por
	 * letra mayúscula, cada palabra en una línea).
	 * 
	 * @param pathIn
	 * @param pathOut
	 */
	void writeUpperCase(String pathIn, String pathOut);

	/**
	 * Crear fichero “PALMINUS.TXT”, con todas las palabras que empiezan por
	 * letra mayúscula y minúscula, respectivamente (cada palabra en una línea).
	 * 
	 * @param pathIn
	 * @param pathOut
	 */
	void writeLowerCase(String pathIn, String pathOut);

}
