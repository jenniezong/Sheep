package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) {

	writeToFile();
	readFromFile();
	
    }
    
    private static void writeToFile() {
	File file = new File("d:\\nan.csv");
	try {
	    if(!file.exists()) {
		file.createNewFile();
	    }
	    FileWriter fw = new FileWriter(file);
	    fw.write("a,b,c\\n e,f,g");
	    fw.flush();
	    fw.close();
//	    BufferedOutputStream bos = new BufferedOutputStream(fw);
	    
	    
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    private static void readFromFile() {
	File file = new File("d:\\nan.csv");
	try {
	    FileReader reader = new FileReader(file);
	    char[] buff = new char[10];
	    int n;
	    StringBuffer sb = new StringBuffer();
	    while( (n = reader.read(buff)) != -1) {
		sb.append(buff,0,n);
		System.out.println(sb.toString());
	    }
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }

}
