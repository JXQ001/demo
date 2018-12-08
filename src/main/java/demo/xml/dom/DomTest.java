package demo.xml.dom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import demo.xml.entity.Book;

/**
 * Dom解析xml
 * @author liya
 *
 */
public class DomTest {

	public static void main(String[] args) throws Exception {
		List<Book> domParseXml = domParseXml();
		for (Book book : domParseXml) {
			System.out.println(book);
		}
	}
	
	/**
	 * dom解析xml
	 * @return 对象集合
	 * @throws Exception
	 */
	public static List<Book> domParseXml() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/main/resources/books.xml");
		// 创建list
		List<Book> booksList = new ArrayList<>();
		// 根据节点名称获取book节点集合
		NodeList bookList = document.getElementsByTagName("book");
		// 遍历所有的book节点
		for (int i = 0; i < bookList.getLength(); i++) {
			System.out.println("==========第" + (i+1) + "本书==========");
			Book bookEntity = new Book();
			// 获取book节点
			Node book = bookList.item(i);
			// 获取book节点的所有属性
			NamedNodeMap attributes = book.getAttributes();
			// 遍历所有的属性
			for (int j = 0; j < attributes.getLength(); j++) {
				// 获取属性对象
				Node attr = attributes.item(j);
				System.out.println("属性名称："+attr.getNodeName()+" -- 属性值："+attr.getNodeValue());
				if ("id".equals(attr.getNodeName())) {
					bookEntity.setId(attr.getNodeValue());
				}
			}
			// 获取当前book节点的所有的子节点
			NodeList childNodes = book.getChildNodes();
			// 遍历所有的子节点
			for (int k = 0; k < childNodes.getLength(); k++) {
				Node item = childNodes.item(k);
				if (item.getNodeType() == Node.ELEMENT_NODE) {
					// 以下两个方法注意使用场景
					//System.out.println("节点名称："+item.getNodeName()+" -- 节点值："+item.getFirstChild().getTextContent());
					String value = item.getTextContent();
					String name = item.getNodeName();
					System.out.println("节点名称："+name+" -- 节点值："+value);
					if ("name".equals(name)) {
						bookEntity.setName(value);
					}else if ("author".equals(name)) {
						bookEntity.setAuthor(value);
					}else if ("year".equals(name)) {
						bookEntity.setYear(value);
					}else if ("price".equals(name)) {
						bookEntity.setPrice(value);
					}else if ("language".equals(name)) {
						bookEntity.setLanguage(value);
					}
				}
			}
			System.out.println("==========第" + (i+1) + "本书==========");
			booksList.add(bookEntity);
		}
		return booksList;
	}
}
