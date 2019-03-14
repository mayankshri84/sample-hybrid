package com.util;

import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Utils {

	public static void main(String[] args) {
		new Utils().xmlParser(System.getProperty("user.dir")+"/src/files/object_repository.xml");
	}
	
	public void xmlParser(String xmlPath) {
		try
		{
			File fXmlFile = new File(xmlPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList list = doc.getElementsByTagName("screen");
			System.out.println(list);
			for(int i=0; i<list.getLength();i++){
				Node n = list.item(i);
				System.out.println(n.getUserData("id"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void readFile(String filePath) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(filePath)));
			String currentLine = null;
			while ((currentLine = br.readLine()) == null) {
				System.out.println(currentLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
