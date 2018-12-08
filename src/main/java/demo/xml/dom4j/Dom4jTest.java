package demo.xml.dom4j;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import demo.xml.entity.Book;

/**
 * dom4j解析XML
 * 
 * @author liya
 *
 */
public class Dom4jTest {

	public static void main(String[] args) throws Exception {
		ArrayList<Book> booksList = dom4jParseXml();
		for (Book book : booksList) {
			System.out.println(book);
		}
	}

	/**
	 * dom4j解析xml
	 * 
	 * @return
	 */
	public static ArrayList<Book> dom4jParseXml() throws Exception {
		ArrayList<Book> booksList = new ArrayList<>();
		// 创建SAXReader
		SAXReader saxReader = new SAXReader();
		FileInputStream fs = new FileInputStream("src/main/resources/books.xml");
		// 解决乱码
		InputStreamReader isr = new InputStreamReader(fs, "UTF-8");
		// 加载xml文件
		Document document = saxReader.read(new InputSource(isr));
		// 获取根节点
		Element rootElement = document.getRootElement();
		// 获取子节点
		Iterator bookIterator = rootElement.elementIterator();
		while (bookIterator.hasNext()) {
			Book bookEntity = new Book();
			Element book = (Element) bookIterator.next();
			// 获取属性名和属性值
			List<Attribute> attributes = book.attributes();
			for (Attribute attribute : attributes) {
				String name = attribute.getName();
				String value = attribute.getValue();
				System.out.println("属性名：" + name + " -- 属性值：" + value);
				if (name.equals("id")) {
					bookEntity.setId(value);
				}
			}
			// 获取子节点名称和值
			Iterator bookChildrenIterator = book.elementIterator();
			while (bookChildrenIterator.hasNext()) {
				Element bookChild = (Element) bookChildrenIterator.next();
				String name = bookChild.getName();
				String value = bookChild.getStringValue();
				System.out.println("节点名：" + name + " -- 节点值：" + value);
				if (name.equals("name")) {
					bookEntity.setName(value);
				}else if (name.equals("author")) {
					bookEntity.setAuthor(value);
				}else if (name.equals("year")) {
					bookEntity.setYear(value);
				}else if (name.equals("price")) {
					bookEntity.setPrice(value);
				}else if (name.equals("language")) {
					bookEntity.setLanguage(value);
				}
			}
			booksList.add(bookEntity);
		}
		return booksList;
	}

}
