package oracle.java.umyBatis3.service;

import java.util.List;

import oracle.java.umyBatis3.model.Emp;

public interface EmpService {
	List<Emp> list(Emp emp);
	int total();
}
