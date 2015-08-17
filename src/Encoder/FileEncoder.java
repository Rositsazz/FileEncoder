package Encoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public class FileEncoder implements FileEncoderInterface {

	public void encode(String sourceFile, String destinationFile,
			LinkedList<Character> key) {
		int position = 0;
		int counter = 0;
		FileInputStream inpStream = null;
		try {
			inpStream = new FileInputStream(sourceFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileOutputStream outStream = null;
		try {
			outStream = new FileOutputStream(destinationFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			BufferedInputStream inFile = new BufferedInputStream(inpStream);
			BufferedOutputStream outFile = new BufferedOutputStream(outStream);

			while ((position = inFile.read()) != -1) {
				if (isPrime(counter) || counter == 1) {
					outFile.write(position);
				} else {
					outFile.write(key.get((char) position));
				}
				counter++;
			}

			inFile.close();
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void decode(String encodedFile, String destinationFile,
			LinkedList<Character> key) {
		int position = 0;
		int counter = 0;
		FileInputStream inpStream = null;
		try {
			inpStream = new FileInputStream(encodedFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileOutputStream outStream = null;
		try {
			outStream = new FileOutputStream(destinationFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			BufferedInputStream inFile = new BufferedInputStream(inpStream);
			BufferedOutputStream outFile = new BufferedOutputStream(outStream);

			while ((position = inFile.read()) != -1) {

				if (isPrime(counter) || counter == 1) {
					outFile.write(position);
				} else {
					outFile.write((key.indexOf((char) position)));
				}
				counter++;
			}

			inFile.close();
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean isPrime(int value) {

		if (value == 2) {
			return true;
		}
		if (value % 2 == 0) {
			return false;
		}
		for (int j = 3; j <= Math.sqrt(value); j += 2) {
			if (value % j == 0) {
				return false;
			}
		}
		return true;
	}
}
