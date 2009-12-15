package no.machina.utils;

import java.io.InputStream;

public class StringInputStream extends InputStream {

	private byte[] s;
	private int idx;


	public StringInputStream(String s){
		this.s = s.getBytes();
	}

	public int read(){
		if(s.length <= idx) return -1;
		return (int) s[idx++];
	}
	
	public int available() {
		return s.length - idx;
	}
	
}
