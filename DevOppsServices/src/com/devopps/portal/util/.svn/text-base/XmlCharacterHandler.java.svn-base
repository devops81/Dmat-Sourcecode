package com.devopps.portal.util;
import java.io.IOException;
import java.io.Writer;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

public class XmlCharacterHandler implements CharacterEscapeHandler{

	public void escape(char[] buffer, int start, int length,
			boolean isAttValue, Writer out) throws IOException {
		for (int loopCounter = start; loopCounter < start + length; loopCounter++) {
			char ch = buffer[loopCounter];
			out.write(ch);
		}

	}
}
