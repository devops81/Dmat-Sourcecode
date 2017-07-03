package com.devopps.portal.controller;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;

import com.devopps.portal.exception.JSONException;
import com.devopps.portal.util.JSONObject;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;
import com.devopps.portal.util.XML;
import com.devopps.portal.util.XmlCharacterHandler;

public class AbstractController {

private Jaxb2Marshaller jaxbMarshaller;
	
	private static final Log LOGGER = LogFactory.getLog(AbstractController.class);
	
	public Jaxb2Marshaller getJaxbMarshaller() {
		return jaxbMarshaller;
	}
	
	
	/**
	 * For setting the JaxbMarshaller object
	 * @param Jaxb2Marshaller
	 */
	@SuppressWarnings("unchecked")
	@Autowired
	public void setJaxbMarshaller(Jaxb2Marshaller jaxbMarshaller) {
		this.jaxbMarshaller = jaxbMarshaller;
		Map marshallerProperties = new HashMap();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshallerProperties.put(Marshaller.JAXB_FRAGMENT, true);
		marshallerProperties.put("com.sun.xml.bind.characterEscapeHandler", new XmlCharacterHandler());
		this.jaxbMarshaller.setMarshallerProperties(marshallerProperties);
	}
	
	/**
	 * This method instantiates the JaxbMarshaller object
	 * @param Object
	 */
	public String marshal(Object graph) {
		try {		
			LOGGER.info("AbstractController: marshal: graph - " + graph );
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlFileResult = new StreamResult(stringWriter);
			getJaxbMarshaller().marshal(graph, xmlFileResult);
			return stringWriter.toString();
		} catch (Exception e) {
			LOGGER.error( "AbstractController: marshal: Error :: " + e );
			return "";
		}
	}
	
	public String convertXMlToJson(String xmlResponse) {
		JSONObject jsonObject = new JSONObject();
		int indentFactor = 4;
		String indentedJson = null;
		try {
			jsonObject = XML.toJSONObject(xmlResponse);
			indentedJson = jsonObject.toString(indentFactor);
		} catch (JSONException jse) {
			LOGGER.error( "AbstractController: convertXMlToJson: Error :: " + jse );
		}
		return indentedJson;
	}
}
