package oracle.java.umyBatis3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oracle.java.umyBatis3.controller.vo.SampleVO;
import oracle.java.umyBatis3.model.Dept;
import oracle.java.umyBatis3.service.EmpService;

@RestController
@RequestMapping("/sample")
public class EmpRestcontroller {
	@Autowired
	private EmpService es;
	
	@RequestMapping("/sendVO2")
	public SampleVO sendVO2 (int deptno) {
		System.out.println("@RestController detpno -> " + deptno);
		SampleVO vo = new SampleVO();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(1234);
		
		return vo;
	}
	
	@RequestMapping("/sendVO3")
	public List<Dept> sendVO3() {
		System.out.println("@RestController sendVO3 start...");
		List<Dept> deptList = es.select();
		return deptList;
	}
	
	@RequestMapping("/sendVO")
	public SampleVO sendVO () {
		System.out.println("@RestController sendVO() start");
		SampleVO vo = new SampleVO();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(123);
		
		return vo;
	}
}
