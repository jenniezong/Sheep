package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class TestIO {

	public static void main(String[] args) {

		Reader reader = new Reader() {
			
			@Override
			public int read(char[] cbuf, int off, int len) throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void close() throws IOException {
				// TODO Auto-generated method stub
				
			}
		};
		
		InputStream inputStream = new InputStream() {
			
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}

}
