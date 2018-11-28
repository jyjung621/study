package oracle.java.umyBatis3.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.umyBatis3.model.Dept;
import oracle.java.umyBatis3.model.DeptVO;

@Repository
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<Dept> deptSelect() {
		return session.selectList("TKselectDept");
	}

	@Override
	public String deptName(int deptno) {
		return session.selectOne("TKdeptName", deptno);
	}

	@Override
	public void SelListDept(HashMap<String, Object> map) {
		session.selectOne("ProcDeptList", map);
		
	}

	@Override
	public void insertDept(DeptVO deptVO) {
		session.insert("ProcDept",deptVO);
	}

}
