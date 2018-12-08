package demo.xml.sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import demo.xml.entity.Book;

/**
 * 解析的处理类
 * 
 * @author liya
 *
 */
public class SaxParseHandler extends DefaultHandler {
	String value = null;
	Book book = null;
	private ArrayList<Book> bookList = new ArrayList<>();

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	/**
	 * 遍历xml的开始标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("book")) {
			// 创建book对象
			book = new Book();
			System.out.println("=====开始遍历某一本书=====");
			// 已知属性名称可直接获取
			// System.out.println(attributes.getValue("id"));
			int length = attributes.getLength();
			for (int i = 0; i < length; i++) {
				String attrName = attributes.getQName(i);
				String attrValue = attributes.getValue(i);
				System.out.println("属性名：" + attrName + " -- 属性值：" + attrValue);
				if (attrName.equals("id")) {
					book.setId(attrValue);
				}
			}
		} else if (!qName.equals("bookStore")) {
			System.out.print("节点名：" + qName);
		}
	}

	/**
	 * 遍历xml的结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals("book")) {
			bookList.add(book);
			book = null;
			System.out.println("=====结束遍历某一本书=====");
		} else if (qName.equals("name")) {
			book.setName(value);
		} else if (qName.equals("author")) {
			book.setAuthor(value);
		} else if (qName.equals("year")) {
			book.setYear(value);
		} else if (qName.equals("price")) {
			book.setPrice(value);
		} else if (qName.equals("language")) {
			book.setLanguage(value);
		}
	}

	/**
	 * 获取节点值
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if (!value.trim().equals("")) {
			System.out.println(" -- 节点值：" + value);
		}
	}

	/**
	 * 解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX解析开始");
	}

	/**
	 * 解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX解析结束");
	}

}
