package p00.example04;

public class Employee {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String date;
	private double sal;
	private double comm;
	private int deptno;
	
	public Employee() {
	
	}

	public Employee(int empno, String ename, String job, int mgr, String date, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.date = date;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public String getEname() {
		return ename;
	}

	public String getJob() {
		return job;
	}

	public int getMgr() {
		return mgr;
	}

	public String getDate() {
		return date;
	}

	public double getSal() {
		return sal;
	}

	public double getComm() {
		return comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
	

}
