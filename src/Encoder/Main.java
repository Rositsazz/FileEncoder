package Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		FileEncoder f = new FileEncoder();
		String destinationFile = "C:\\FileTest\\newOutputFile.enc";
		String sourceFile = "C:\\FileTest\\test.jpg";
		String keyPath = "C:\\FileTest\\key1.txt";
		String decodedFile = "C:\\FileTest\\decodedFile.jpg";
		LinkedList<Character> key = new LinkedList<Character>();
		File keyfile = new File(keyPath);
		try (FileInputStream fip = new FileInputStream(keyfile)) {
			for (int i = 0; i < 256; i++) {
				key.add((char) fip.read());
			}
			fip.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.encode(sourceFile, destinationFile, key);
		f.decode(destinationFile, decodedFile, key);
	}

}
