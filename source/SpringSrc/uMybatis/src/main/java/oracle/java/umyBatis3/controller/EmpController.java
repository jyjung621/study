package oracle.java.umyBatis3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.java.umyBatis3.model.Dept;
import oracle.java.umyBatis3.model.DeptVO;
import oracle.java.umyBatis3.model.Emp;
import oracle.java.umyBatis3.model.EmpDept;
import oracle.java.umyBatis3.model.Member1;
import oracle.java.umyBatis3.service.EmpService;
import oracle.java.umyBatis3.service.Paging;


@Controller
public class EmpController {
	@Autowired
	private EmpService es;
	

	@RequestMapping(value="list")
	public String list(Emp emp, String currentPage, Model model) {
	int total = es.total();
	System.out.println("total =>" + total);
	System.out.println("currentPage =>" + currentPage);
	Paging pg = new Paging(total, currentPage);
	emp.setStart(pg.getStart());
	emp.setEnd(pg.getEnd());
	List<Emp> list = es.list(emp);

	model.addAttribute("list", list);
	model.addAttribute("pg", pg);
	return "list";
	}
	
	@RequestMapping(value="detail")
	public String detail(int empno, Model model) {
		Emp emp = es.detail(empno);
		model.addAttribute("emp", emp);
		return "detail";
	}
	
	@RequestMapping(value="insertEmp")
	public String insertEmp(Model model) {
		es.insertEmp();
		return "redirect:list.do";
	}
	
	@RequestMapping(value="updateForm")
	public String updateForm(int empno, Model model) {
		Emp emp = es.detail(empno);
		model.addAttribute("emp", emp);
		return "updateForm";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Emp emp, Model model) {
		int k = es.update(emp);
		return "redirect:list.do";
	}
	
	@RequestMapping(value="writeForm")
	public String writeForm(Model model) {
		List<Emp> list = es.listManager();
		model.addAttribute("empMngList",list);
		List<Dept> deptlist = es.select();
		model.addAttribute("deptList",deptlist);

		return "writeForm";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Emp emp, Model model) {
		int result = es.insert(emp);
		if(result > 0) {
			return "redirect:list.do";
		} else {
			model.addAttribute("msg","입력실패.. 확인필요");
			return "forward:writeForm.do";
		}
	}

	@RequestMapping(value="confirm")
	public String confirm(int empno, Model model) {
		Emp emp = es.detail(empno);
		model.addAttribute("empno", empno);
		System.out.println("emp --> " + emp);

		if(emp != null) {
			model.addAttribute("msg", "중복된 사번입니다.");
			return "forward:writeForm.do";
		} else {
			model.addAttribute("msg", "사용가능한 사번입니다.");
			return "forward:writeForm.do";
		}
	}
	
	@RequestMapping(value="delete")
	public String delete(int empno, Model model) {
		es.delete(empno);

		return "redirect:list.do";
	}
	
	@RequestMapping(value="listEmp")
	public String listEmp(Model model) {
		EmpDept empDept = null;
		List<EmpDept> listEmp = es.listEmp(empDept);
		model.addAttribute("listEmp", listEmp);

		return "listEmp";
	}

	@RequestMapping(value="listEmpAjax2")
	public String listEmpAjax2(Model model) {
		EmpDept empDept = null;
		List<EmpDept> listEmp = es.listEmp(empDept);
		model.addAttribute("result", "kkk");
		model.addAttribute("listEmp", listEmp);

		return "listEmpAjax2";
	}

	// Ajax Test
	@RequestMapping(value="getDeptName", produces="application/text;charset=utf-8")
	@ResponseBody	// VIEW로 이동하는게 아니고 호출한 곳으로 다시 이동하는것
	public String getDeptName(int deptno, Model model) {
		System.out.println("getDeptName() start... deptno -> " + deptno);
		return es.deptName(deptno);
	}
	
	// Procedure Cursor Test (Map, Dto, VO 등등 여러방식 다 사용함)
	@RequestMapping(value="writeDeptCursor", method=RequestMethod.GET)
	public String writeDeptCursor(Model model) {
		System.out.println("writeDeptCursor Start");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sDeptno", 10);
		map.put("eDeptno", 80);
		es.SelListDept(map);
		
		List<Dept> deptList = (List<Dept>) map.get("dept");
		System.out.println("deptList.dname[0].getDname -> " + deptList.get(0).getDname());
		System.out.println("deptList.dname[0].getLoc -> " + deptList.get(0).getLoc());
		System.out.println("deptList Size -> " + deptList.size());
		model.addAttribute("deptList", deptList);
		
		return "writeDeptCursor";
		
	}
	
	// Procedure Cursor Test (Map, Dto, VO 등등 여러방식 다 사용함)
	@RequestMapping(value="writeDeptIn", method=RequestMethod.GET)
	public String writeDeptIn(Locale locale, Model model) {
		System.out.println("writeDeptIn() start...");
		
		return "writeDept3";
	}
	
	// Procedure Test 입력 후, VO 전달 Test
	@RequestMapping(value="writeDept", method=RequestMethod.POST)
	public String writeDept(DeptVO deptVO, Model model) {
		es.insertDept(deptVO);
		if(deptVO == null) {
			System.out.println("deptVO null...");
		} else {
			System.out.println("RdeptVo.getOdetpno() -> " + deptVO.getOdeptno());
			System.out.println("RdeptVo.getOdname() -> " + deptVO.getOdname());
			System.out.println("RdeptVo.getOloc() -> " + deptVO.getOloc());
			model.addAttribute("msg", "정상 입력 되었습니다^^");
			model.addAttribute("dept", deptVO);
		}
		return "writeDept3";
	}
	
	// interCepter 시작 화면
	@RequestMapping(value="interCepterForm", method=RequestMethod.GET) 
	public String interCepterForm(Model model) {
		System.out.println("interCepterForm Start...");
		
		return "interCepterForm";
	}
	
	// interCepter 진행 Test
	@RequestMapping(value="interCepter")
	public String interCepter(String id, Model model) {
		System.out.println("interCepter Test Start");
		System.out.println("interCepter id -> " + id);
		
		int memCnt = es.memCount(id);
		System.out.println("memCnt -> " + memCnt);
		
//		List<EmpDept> listEmp = es.listEmp(EmpDept); User 가져오는 Service
		// member1의 count가져오는 
//		member.serId("kkk");
		
		model.addAttribute("id", id);
		model.addAttribute("memCnt", memCnt);
		System.out.println("interCepter Test End");
		
		return "interCepter";
	}
	
	// SampleInterceptor 내용을 받아 처리
	@RequestMapping(value="doMemberWrite", method=RequestMethod.POST)
	public String doMemberWrite(Model model, HttpServletRequest request) {
		String ID = (String)request.getSession().getAttribute("ID");
		System.out.println("doMemberWrite________");
		
		model.addAttribute("id", ID);
		
		return "doMemberWrite";
	}
	
	// interCepter 진행 Test
	@RequestMapping(value="doMemberList")
	public String doMemberList(Model model, HttpServletRequest request) {
		String ID = (String)request.getSession().getAttribute("ID");
		System.out.println("doMemberList Test Start ID -> " + ID);
		Member1 member1 = null;
		// Member1 List Get Service
		List<Member1> listMem = es.listMem(member1);
		
		model.addAttribute("ID", ID);
		model.addAttribute("listMem", listMem);
		
		return "doMemberList";
	}
}
