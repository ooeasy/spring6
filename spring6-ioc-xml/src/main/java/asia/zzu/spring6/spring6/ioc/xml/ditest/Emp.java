package asia.zzu.spring6.spring6.ioc.xml.ditest;

public class Emp {
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public Emp() {
    }

    public Emp(Dept dept, String ename, Integer dage) {
        this.dept = dept;
        this.ename = ename;
        this.dage = dage;
    }

    public String getEname() {
        return ename;
    }

    public Integer getDage() {
        return dage;
    }
    private String ename;
    private Integer dage;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setDage(Integer dage) {
        this.dage = dage;
    }

    public void work() {
        System.out.println(ename + " work......" + dage);
        dept.info();
    }

}
