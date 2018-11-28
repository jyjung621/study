package oracle.java.umyBatis3.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.umyBatis3.dao.DeptDao;
import oracle.java.umyBatis3.dao.EmpDao;
import oracle.java.umyBatis3.dao.Member1Dao;
import oracle.java.umyBatis3.model.Dept;
import oracle.java.umyBatis3.model.DeptVO;
import oracle.java.umyBatis3.model.Emp;
import oracle.java.umyBatis3.model.EmpDept;
import oracle.java.umyBatis3.model.Member1;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;
	@Autowired
	private DeptDao dd;
	@Autowired
	private Member1Dao md;
	
	@Override
	public List<Emp> list(Emp emp) {
		return ed.list(emp);
	}

	@Override
	public int total() {
		return ed.total();
	}
	
	public Emp detail(int empno) {
		Emp emp = ed.detail(empno);
		if(emp != null) {
			System.out.println("emp.getEname() -> " + emp.getEname());
		} else {
			System.out.println("empService data is null...");
		}
		return emp;
		// 위의 코드는 아래 코드와 같음
//		return ed.detail(empno);
	}
	
	public void insertEmp() {
		ed.insertEmp();
	}
	
	public int update(Emp emp) {
		return ed.update(emp);
	}

	@Override
	public List<Emp> listManager() {
		return ed.listManager();
	}

	@Override
	public List<Dept> select() {
		return dd.deptSelect();
	}

	@Override
	public int insert(Emp emp) {
		return ed.insert(emp);
	}

	@Override
	public int delete(int empno) {
		return ed.delete(empno);
		
	}

	@Override
	public List<EmpDept> listEmp(EmpDept empDept) {
		return ed.listEmp(empDept);
	}

	@Override
	public String deptName(int deptno) {
		return dd.deptName(deptno);
	}

	@Override
	public void SelListDept(HashMap<String, Object> map) {
		dd.SelListDept(map);
	}

	@Override
	public void insertDept(DeptVO deptVO) {
		dd.insertDept(deptVO);
	}

	@Override
	public int memCount(String id) {
		return md.memCount(id);
	}

	@Override
	public List<Member1> listMem(Member1 member1) {
		return md.listMem(member1);
	}

}
