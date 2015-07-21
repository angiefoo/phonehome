package angie_phonehome_01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

public class FilterFile2 {
	
    private static final String REGEX =
            "svcAgent";
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	        String filename = "src/angie_phonehome_01/sample/diagnostics_australia_2015_07_20_021303.csv.gz";
	        Charset charset = Charset.forName("US-ASCII");
	        
	        InputStream fileStream = null;
	        
			try {
				fileStream = new FileInputStream(filename);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			InputStream gzipStream = new GZIPInputStream(fileStream);
	        Reader decoder = new InputStreamReader(gzipStream, charset);
	        BufferedReader buffered = new BufferedReader(decoder);
	        
	        String line;
			while ((line = buffered.readLine()) != null) {
		        //System.out.println(line);
		        
		        Pattern p = Pattern.compile(REGEX);           
	            Matcher m = p.matcher(line);
	            while(m.find()) {
	            	System.out.println(line);
	            }

			}

	}
}
