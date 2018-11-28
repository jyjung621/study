package oracle.java.springMVCBoard.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oracle.java.springMVCBoard.command.BCommand;
import oracle.java.springMVCBoard.command.BContentCommand;
import oracle.java.springMVCBoard.command.BDeleteCommand;
import oracle.java.springMVCBoard.command.BListCommand;
import oracle.java.springMVCBoard.command.BReplyComand;
import oracle.java.springMVCBoard.command.BReplyViewCommand;
import oracle.java.springMVCBoard.command.BWriteCommand;
import oracle.java.springMVCBoard.command.BmodifyCommand;

@Controller
public class BController {
	BCommand command = null;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list() start...");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}

//	@RequestMapping("/modify")
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");	
		
		model.addAttribute("request", request);
		command = new BmodifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("write_view")
	public String write_view(HttpServletRequest request, Model model) {
		System.out.println("write_view()");	
		
		return "write_view";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");	
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");	
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");	
		
		model.addAttribute("request", request);
		command = new BReplyComand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");	
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
}
