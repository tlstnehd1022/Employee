package com.hybrid.bean;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;

public class DocumentFactoryBean implements FactoryBean<Document> {

	DocumentBuilderFactory factory;
	
	Document document;
	
	ClassPathResource resource;
	
	public DocumentFactoryBean(DocumentBuilderFactory dbf) {
		this.factory = dbf;
		
	}
	
	public void setPath(String path) {
		resource = new ClassPathResource(path);
	}
	
	
	
	public Document getObject() throws Exception {
		if (document ==null) {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(resource.getInputStream());
		}
		return document;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Document.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
