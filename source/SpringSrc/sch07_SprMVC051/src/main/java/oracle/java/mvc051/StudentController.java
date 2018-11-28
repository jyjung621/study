package oracle.java.mvc051;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("/studentForm")
	public String studentForm() {
		
		return "createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(HttpServletRequest request, @ModelAttribute("st3") Student stu1, BindingResult result) {
		
		String page = "createDonePage";
		System.out.println("/student/create   Start...");
		
		StudentValidator validator = new StudentValidator();
		validator.validate(stu1, result);
		System.out.println("result Message --> " + result.toString());
		if(result.hasErrors()) {
			page = "createPage";
		}
		System.out.println("result Message --> End");
		
		return page;
	}
}
