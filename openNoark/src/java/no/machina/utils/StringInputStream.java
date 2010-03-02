/*
    This file is part of Friark.

    Friark is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Friark is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Friark.  If not, see <http://www.gnu.org/licenses/>.
*/

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
