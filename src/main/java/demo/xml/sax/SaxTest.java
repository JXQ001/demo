package demo.xml.sax;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

import demo.xml.entity.Book;

/**
 * SAX解析xml
 * 
 * @author liya
 *
 */
public class SaxTest {

	public static void main(String[] args) throws Exception {
		List<Book> saxParseXml = saxParseXml();
		for (Book book : saxParseXml) {
			System.out.println(book);
		}
	}

	/**
	 * sax解析xml
	 * 
	 * @return @throws Exception @throws
	 */
	public static List<Book> saxParseXml() throws Exception {
		// 获取SAXParserFactory对象
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		// 获取SAXParser对象
		SAXParser saxParser = saxParserFactory.newSAXParser();
		SaxParseHandler saxParseHandler = new SaxParseHandler();
//		saxParser.parse("src/main/resources/books.xml", saxParseHandler);
		FileInputStream fs = new FileInputStream("src/main/resources/books.xml");
		// 解决乱码问题
		InputStreamReader isr = new InputStreamReader(fs,"UTF-8");
		saxParser.parse(new InputSource(isr), saxParseHandler);
		return saxParseHandler.getBookList();
	}

}
