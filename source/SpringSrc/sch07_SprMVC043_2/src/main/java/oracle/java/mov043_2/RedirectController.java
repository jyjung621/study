package oracle.java.mov043_2;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@RequestMapping("/studentConfirm")
	public String studentRedirrect(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Model model) {
//	public String studentRedirrect(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("studentRedirrect() start...");
		
		String id = httpServletRequest.getParameter("id");
		// DAO에서 가져온 값  
		String pw = "1234";
		System.out.println("ID : " + id);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
//		model.addAttribute("id", id);
//		redirectAttributes.addAttribute("id", id);
		redirectAttributes.addFlashAttribute("map", map);

		
		if(id.equals("abc")) {
			// redirect로 return 할경우 -> view로 가는게 아니라 바로 서버에서 서버로 이동함
			return "redirect:studentOk";
		}
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk() {
//	public String studentOk(@RequestParam(value="id", defaultValue="")  String id ,Model model) {
//	public String studentOk(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("studentOk() start...");

//		String id = httpServletRequest.getParameter("id");
//		System.out.println("ID : " + id);
//		model.addAttribute("id", id);

		return "student/studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		System.out.println("studentNg() start...");
		
		return "student/studentNg";
	}
}
