package ut01.quijote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FicherosTexto implements InterfazFicherosTexto {
	/**
	 * Utilizando el fichero quijote.txt que contiene letras mayúsculas y
	 * minúsculas, con o sin acento o diéresis, cifras y demás caracteres
	 * imprimibles posibles, además de fines de línea y fin de fichero. Crear un
	 * método que devuelva el número de carácteres:
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public long countUTFChars(String path) {

		long numero = 0;
		int letra;
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {
				++numero;
			}
		} catch (IOException e) {

		}

		return numero;
	}

	@Override
	public long countLowCaseChars(String path) {

		long numero = 0;
		int letra;
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {
				if (Character.isLowerCase(letra))
					++numero;
			}
		} catch (IOException e) {

		}

		return numero;
	}

	@Override
	public long countAsciiChars(String path) {
		long numero = 0;
		int letra;
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {
				if (Character.isLetter(letra))
					++numero;
			}
		} catch (IOException e) {

		}

		return numero;
	}

	@Override
	public long countLines(String path) {
		long numero = 0;
		int letra;
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {
				if (letra == '\n')
					++numero;
			}
		} catch (IOException e) {

		}

		return numero;
	}

	@Override
	public long countWords(String path) {
		long numero = 0;
		int letra;
		int palabra = 0;
		
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {

				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra))
					palabra++;
				else {
					if (palabra > 0)
						numero++;
					palabra = 0;
				}

			}
		} catch (IOException e) {

		}

		return numero;
	}

	@Override
	public int countWords(String path, String endText) {
		int numero = 0;
		int letra;
		StringBuilder actual = new StringBuilder();
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {

				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					actual.append((char)letra);
				} else {
					if (actual.toString().contains(endText))
						numero++;
					actual = actual.delete(0, actual.length());
				}

			}
		} catch (IOException e) {

		}

		return numero;
	}

	@Override
	public int countDipWords(String path) {
		int numero = 0;
		int letra;
		String actual = "";
		String[] diptongo = { "ia", "ie", "io", "ua", "ue", "uo", "ai", "au", "ei", "eu", "oi", "ou" };
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {
				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
				} else {
					for (int i = 0; i < diptongo.length; i++) {
						if (actual.contains(diptongo[i]))
							numero++;
					}

					actual = "";
				}

			}
		} catch (IOException e) {

		}

		return numero;
	}

	@Override
	public String longestWords(String path) {
		long numero = 0;
		int letra;
		int palabra = 0;
		long longPosition = 0;
		int longWord = 0;
		String actual = "";
		String largo = "";
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {
				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
					palabra++;
				} else {
					if (palabra > 0) {
						numero++;
						if (palabra > longWord) {
							longWord = palabra;
							longPosition = numero;
							largo = actual;
						}
					}
					actual = "";
					palabra = 0;
				}

			}
		} catch (IOException e) {

		}
		System.out.println("La posición de la palabra mas larga es : " + posWord(null, longPosition));
		return largo;
	}

	@Override
	public long posWord(String path, long pos) {
		return pos;
	}

	@Override
	public int positionTripWord(String path) {
		int numero = 0;
		int letra;
		boolean found = false;
		String actual = "";
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1 && !found) {
				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
					numero++;

				} else {
					if (actual.matches("[a-zA-Z]*(I|U|i|u|Y|y)+h?(a|A|e|E|o|O|é|á|ó|Á|É|Ó)+h?(I|U|i|u|Y|y)[a-z]*"))
						found = true;

					actual = "";
				}

			}
		} catch (IOException e) {

		}

		return found ? numero : 0;
	}

	@Override
	public long positionPentaWord(String path) {
		int numero = 0;
		int letra;
		boolean found = false;
		String actual = "";
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1 && !found) {
				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
					numero++;

				} else {
					if (actual.contains("a") && actual.contains("e") && actual.contains("i") && actual.contains("o")
							&& actual.contains("u"))
						found = true;

					actual = "";
				}

			}
		} catch (IOException e) {

		}

		return found ? numero : 0;
	}

	@Override
	public ArrayList<String> getPentaWords(String path, boolean alfabeticOrder) {
		ArrayList<String> pentaWord = new ArrayList<>();
		int letra;
		String actual = "";
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {
				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);

				} else {
					if (actual.contains("a") && actual.contains("e") && actual.contains("i") && actual.contains("o")
							&& actual.contains("u"))
						pentaWord.add(actual);

					actual = "";
				}

			}
		} catch (IOException e) {

		}

		return pentaWord;
	}

	@Override
	public long getNumberChar(String path, char letter) {

		long numero = 0;
		int letra;
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {
				if (letra == letter)
					++numero;
			}
		} catch (IOException e) {

		}

		return numero;
	}

	@Override
	public Map<Character, Long> getNumberChars(String path) {
		Map<Character, Long> map = new HashMap<Character, Long>();
		char[] alfa = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < alfa.length; i++) {
			map.put(alfa[i], this.getNumberChar(path, alfa[i]));
		}

		return map;
	}

	@Override
	public long getNumberWord(String path, String word) {
		int numero = 0;
		int letra;
		String actual = "";
		try (FileReader fr = new FileReader(path)) {
			while ((letra = fr.read()) != -1) {

				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
				} else {
					if (actual.equals(word))
						numero++;
					actual = "";
				}

			}
		} catch (IOException e) {

		}

		return numero;
	}

	@Override
	public void writeDiptongo(String pathIn, String pathOut) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		int numero = 0;
		int letra;
		String actual = "";
		String[] diptongo = { "ia", "ie", "io", "ua", "ue", "uo", "ai", "au", "ei", "eu", "oi", "ou" };
		try (FileReader fr = new FileReader(pathIn)) {
			fichero = new FileWriter(pathOut);
			pw = new PrintWriter(fichero);
			while ((letra = fr.read()) != -1) {
				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
				} else {
					for (int i = 0; i < diptongo.length; i++) {
						if (actual.contains(diptongo[i]))
							pw.println(actual);
					}

					actual = "";
				}

			}
		} catch (IOException e) {

		}

	}

	@Override
	public void writeTriptongo(String pathIn, String pathOut) {
		int letra;
		String actual = "";
		try (FileReader fr = new FileReader(pathIn)) {
			FileWriter fichero = new FileWriter(pathOut);
			PrintWriter pw = new PrintWriter(fichero);
			while ((letra = fr.read()) != -1) {

				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
				} else {
					if (actual.matches("[a-zA-Z]*(I|U|i|u|Y|y)+h?(a|A|e|E|o|O|é|á|ó|Á|É|Ó)+h?(I|U|i|u|Y|y)[a-z]*"))
						pw.println(actual);
					actual = "";
				}

			}
		} catch (IOException e) {

		}

	}

	@Override
	public void transformUpperCase(String pathIn, String pathOut) {
		int letra;
		String actual = "";
		try (FileReader fr = new FileReader(pathIn)) {
			FileWriter fichero = new FileWriter(pathOut);
			PrintWriter pw = new PrintWriter(fichero);
			while ((letra = fr.read()) != -1) {

				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
				} else {
					pw.println(actual.toUpperCase());
					actual = "";
				}

			}
		} catch (IOException e) {

		}
	}

	@Override
	public void writeUpperCase(String pathIn, String pathOut) {
		int letra;
		String actual = "";
		try (FileReader fr = new FileReader(pathIn)) {
			FileWriter fichero = new FileWriter(pathOut);
			PrintWriter pw = new PrintWriter(fichero);
			while ((letra = fr.read()) != -1) {

				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
				} else {
					if (actual.matches("[A-Z]+[a-z]*"))
						pw.println(actual);
					actual = "";
				}

			}
		} catch (IOException e) {

		}

	}

	@Override
	public void writeLowerCase(String pathIn, String pathOut) {
		int letra;
		String actual = "";
		try (FileReader fr = new FileReader(pathIn)) {
			FileWriter fichero = new FileWriter(pathOut);
			PrintWriter pw = new PrintWriter(fichero);
			while ((letra = fr.read()) != -1) {

				if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
					String con = String.valueOf((char) letra);
					actual = actual.concat(con);
				} else {
					if (!actual.matches("[A-Z]+[a-z]*"))
						pw.println(actual);
					actual = "";
				}

			}
		} catch (IOException e) {

		}

	}

}
