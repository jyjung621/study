package oracle.java.umyBatis3.dao;

import java.util.List;

import oracle.java.umyBatis3.model.Emp;
import oracle.java.umyBatis3.model.EmpDept;

public interface EmpDao {
	List<Emp> list(Emp emp);
	int total();
	Emp detail(int empno);
	void insertEmp();
	int update(Emp emp);
	List<Emp> listManager();
	int insert(Emp emp);
	int delete(int empno);
	List<EmpDept> listEmp(EmpDept empDept);
	
}
