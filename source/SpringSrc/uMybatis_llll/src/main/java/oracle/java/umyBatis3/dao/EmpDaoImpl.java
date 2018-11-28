package oracle.java.umyBatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.umyBatis3.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Emp> list(Emp emp) {
		//	emp.xml -> id(listAll), parameterType(emp), return List
		return session.selectList("listAll", emp);
	}

	@Override
	public int total() {
		//	emp.xml -> id(total), return int
		return session.selectOne("total");
	}

}
