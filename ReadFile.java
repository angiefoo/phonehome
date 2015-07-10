import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Charset charset = Charset.forName("US-ASCII");
		Path path = FileSystems.getDefault().getPath("src/angie_phonehome_01/sample", "sample.txt");
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		
	}

}
