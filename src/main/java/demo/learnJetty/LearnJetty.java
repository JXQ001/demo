package demo.learnJetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;

/**
 * 测试main函数启动jetty容器
 * @author liya
 *
 */
public class LearnJetty {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setResourceBase("C:\\Users\\liya");
		resourceHandler.setDirectoriesListed(true);
		server.setHandler(resourceHandler);
		server.start();
	}
}
