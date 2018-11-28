package oracle.java.umyBatis3.dao;

import java.util.List;

import oracle.java.umyBatis3.model.Member1;

public interface Member1Dao {

	public int memCount(String id);

	public List<Member1> listMem(Member1 member1);

}
