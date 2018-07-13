package p00.exercise;

import java.security.GeneralSecurityException;

public class ShopService {	//	18번 문제
	
	private static ShopService shopservice = new ShopService();
	
	//	constructor
	private static void ShopService() {};
	
	//	method
	public static ShopService getInstance()
	{
		return shopservice;
	}
}
