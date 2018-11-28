package oracle.java.umyBatis3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.umyBatis3.dao.EmpDao;
import oracle.java.umyBatis3.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao ed;
	
	@Override
	public List<Emp> list(Emp emp) {
	
		return ed.list(emp);
	}

	@Override
	public int total() {
		
		return ed.total();
	}

}
