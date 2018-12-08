package demo.xml.jdom;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import demo.xml.entity.Book;

/**
 * Jdom解析XML
 * @author liya
 *
 */
public class JdomTest {
	
	public static void main(String[] args) throws Exception {
		ArrayList<Book> booksList = jdomParseXml();
		for (Book book : booksList) {
			System.out.println(book);
		}
	}

	/**
	 * jdom2解析xml
	 * @return
	 * @throws Exception 
	 */
	public static ArrayList<Book> jdomParseXml() throws Exception {
		ArrayList<Book> booksList = new ArrayList<>();
		// 创建SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		// 创建输入流将xml加载
		FileInputStream in = new FileInputStream("src/main/resources/books.xml");
		// 解决乱码情况
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		Document document = saxBuilder.build(isr);
		// 获取xml的根节点
		Element rootElement = document.getRootElement();
		// 获取子节点
		List<Element> bookList = rootElement.getChildren();
		// 遍历子节点
		for (Element book : bookList) {
			// 创建Book对象
			Book bookEntity = new Book();
			System.out.println("====开始解析第"+(bookList.indexOf(book)+1)+"本书====");
			List<Attribute> attributes = book.getAttributes();
			for (Attribute attribute : attributes) {
				System.out.println("属性名："+attribute.getName()+" -- 属性值："+attribute.getValue());
				if (attribute.getName().equals("id")) {
					bookEntity.setId(attribute.getValue());
				}
			}
			// 解析子节点和值
			List<Element> bookChildren = book.getChildren();
			for (Element element : bookChildren) {
				String name = element.getName();
				String value = element.getValue();
				System.out.println("节点名："+name+" -- 节点值："+value);
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
			System.out.println("====结束解析第"+(bookList.indexOf(book)+1)+"本书====");
			booksList.add(bookEntity);
		}
		return booksList;
	}
	
}
