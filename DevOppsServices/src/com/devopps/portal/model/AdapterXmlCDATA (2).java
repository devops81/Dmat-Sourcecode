package com.devopps.portal.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdapterXmlCDATA extends XmlAdapter<String, String> {
	
	private static final String CDATA_END = "]]>";
	
	private static final String CDATA_BEGIN = "<![CDATA[";
	
	@Override
    public String marshal(String value) throws Exception {
		return CDATA_BEGIN + value + CDATA_END;
    }
	
	@Override
    public String unmarshal(String value) throws Exception {
		if (value.startsWith(CDATA_BEGIN) && value.endsWith(CDATA_END)) {
			value=value.substring(CDATA_BEGIN.length(), value.length() - CDATA_END.length());
		}
        return value;
    }

}