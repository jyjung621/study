package oracle.java.umyBatis3.service;

import java.util.HashMap;
import java.util.List;

import oracle.java.umyBatis3.model.Dept;
import oracle.java.umyBatis3.model.DeptVO;
import oracle.java.umyBatis3.model.Emp;
import oracle.java.umyBatis3.model.EmpDept;
import oracle.java.umyBatis3.model.Member1;

public interface EmpService {
	List<Emp> list(Emp emp);
	int total();
	Emp detail(int empno);
	void insertEmp();
	int update(Emp emp);
	List<Emp> listManager();
	List<Dept> select();
	int insert(Emp emp);
	int delete(int empno);
	List<EmpDept> listEmp(EmpDept empDept);
	String deptName(int deptno);
	void SelListDept(HashMap<String, Object> map);
	void insertDept(DeptVO deptVO);
	int memCount(String id);
	List<Member1> listMem(Member1 member1);
}
 