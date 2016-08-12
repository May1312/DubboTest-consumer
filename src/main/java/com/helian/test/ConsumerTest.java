package com.helian.test;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.helian.beans.User;
import com.helian.interf.IDemoService;
import com.helian.interf.TwoDemo;
import com.helian.service.DubboService;


/**
 * telnet 192.168.88.123 20880  测试连接主机的端口
 * @author An
 */
@Controller
@RequestMapping("/hang")
public class ConsumerTest{

	@Autowired    //测试调用dubbo的接口
	private IDemoService demoService;
	
	@Autowired    //测试调用dubbo的接口2
	private TwoDemo twoDemo;
	
	@Autowired
	private DubboService dubboService;
	
	@RequestMapping("/run")
	public String run(HttpServletRequest request,Model model) { 
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { */
		//java代码加载spring的配置文件
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-applicationContext.xml");
		//IDemoService bean = (IDemoService) context.getBean("demoService");
		//System.out.println(bean.sayHello("lumanmanqixiuyuanxi"));
		System.out.println(dubboService.run());
		System.out.println(demoService.sayHello("lumanmanqixiuyuanxi"));
		List<Object> list = twoDemo.run();
		/*User user = new User();
		user.setName("雷布斯");
		user.setAge(18);*/
		User user = (User) list.get(0);
		model.addAttribute("user", user);
		return "show";
		
    }   
	
	//public static void main(String[] args) {
	//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
	//			"file:D:/eclipse-workspace/DubboTest2/WebContent/WEB-INF/dubbo-consumer.xml");
	//	context.start();
		// 获取远程服务代理
		//IDemoService service = (IDemoService) context.getBean("demoService");
		
		//System.out.println(service.sayHello("雷布斯"));
	//}
	
	//public void init(){
		//System.out.println("servlet 初始化了。。。");
		//ServletContext sc = this.getServletContext();
		//WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(sc);
		//IDemoService bean = (IDemoService) wc.getBean("demoService");
		//System.out.println(bean);
	//}
}
