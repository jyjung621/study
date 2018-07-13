package p00.exercise;

public class MemberService {
	
	//	15번 문제
	//	method
	public boolean login(String id, String password)
	{
		//if((id == "hong") && (password == "12345"))
		if(id.equals("hong") && password.equals("12345"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void logout(String id)
	{
		System.out.println("로그아웃 되었습니다.");
	}
}
