package Encoder;

import java.util.LinkedList;

public interface FileEncoderInterface {

	public void encode(String sourceFile, String destinationFile,
			LinkedList<Character> key);

	public void decode(String encodedFile, String destinationFile,
			LinkedList<Character> key);
}
