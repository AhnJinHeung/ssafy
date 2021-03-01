package com.ssafy.news;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO {
	List<News> list;
	
	public List<News> getNewsList(String url) {
		list = new ArrayList<>();
		connectNews(url);
		return list;
	}
	
	public News search(int index) {
		return list.get(index);
	}
	
	private void connectNews(String url) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXHandler handler = new SAXHandler();
		try {
			SAXParser parser = factory.newSAXParser();
			URL u = new URL(url);
			InputStream is = u.openConnection().getInputStream();
			parser.parse(is, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Handler
	public class SAXHandler extends DefaultHandler {
		StringBuilder b;
		boolean flag;
		News n;
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) {
			if(qName.equals("item")){
				n = new News();
				flag = true;
			}
			b = new StringBuilder();
		}
		
		public void characters(char[] ch, int start, int length) {
			b.append(new String(ch, start, length));
		}
		
		
		public void endElement(String uri, String localName, String qName) {
			if (flag) {
				if(qName.equals("title")) {
					n.setTitle(b.toString());
				}
				else if(qName.equals("description")) { 
					n.setDesc(b.toString());
				}
				else if(qName.equals("link")) {
					n.setLink(b.toString());
				}
				else if(qName.equals("item")) {
					list.add(n);
					flag = false;
				}
			}
		}
	}
}