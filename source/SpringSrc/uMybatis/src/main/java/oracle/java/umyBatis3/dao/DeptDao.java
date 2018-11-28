package oracle.java.umyBatis3.dao;

import java.util.HashMap;
import java.util.List;

import oracle.java.umyBatis3.model.Dept;
import oracle.java.umyBatis3.model.DeptVO;

public interface DeptDao {
	List<Dept> deptSelect();

	String deptName(int deptno);

	void SelListDept(HashMap<String, Object> map);

	void insertDept(DeptVO deptVO);
}
