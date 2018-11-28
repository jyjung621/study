package oracle.java.umyBatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.umyBatis3.model.Emp;
import oracle.java.umyBatis3.model.EmpDept;

@Repository
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private SqlSession session;
	
	public List<Emp> list(Emp emp) {
		// emp.xml -> id(listALL), parameterType(emp), return List
		return session.selectList("listAll", emp);
	}
	public int total() {
		// emp.xml -> id(total), return int
		return session.selectOne("total");
	}
	
	public Emp detail(int empno) {
		Emp emp = session.selectOne("detail", empno);
		if(emp != null) {
			System.out.println("emp.getEname() -> " + emp.getEname());
		} else {
			System.out.println("empDao data is null...");
		}
		return emp;
		// 위에 코드는 아래와 동일함
//		return session.selectOne("detail", empno);
	}
	public void insertEmp() {
		Emp emp = new Emp();
		for (int i=3001; i<=3120; i++) {
			emp.setEmpno(i);
			emp.setEname("동범" + i);
			emp.setJob("영업");
			emp.setMgr(7369);
			emp.setHiredate("2018-01-23");
			emp.setSal(3000);
			emp.setComm(500);
			emp.setDeptno(20);
			session.insert("insert", emp);
		}
	}
	
	public int update(Emp emp) {
		return session.update("update", emp);
	}
	
	
	public List<Emp> listManager() {
		return session.selectList("selectManager");
	}
	@Override
	public int insert(Emp emp) {
		return session.insert("insert", emp);
	}
	@Override
	public int delete(int empno) {
		return session.delete("delete", empno);
	}
	@Override
	public List<EmpDept> listEmp(EmpDept empDept) {
		return session.selectList("TKlistEmp", empDept);
	}

}
