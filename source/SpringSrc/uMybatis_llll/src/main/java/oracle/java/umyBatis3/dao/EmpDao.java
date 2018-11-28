package oracle.java.umyBatis3.dao;

import java.util.List;

import oracle.java.umyBatis3.model.Emp;

public interface EmpDao {
	List<Emp> list(Emp emp);
	int total();
}
