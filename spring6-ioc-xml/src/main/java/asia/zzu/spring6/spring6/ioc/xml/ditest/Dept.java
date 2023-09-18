package asia.zzu.spring6.spring6.ioc.xml.ditest;

public class Dept {

    private String dname;
    public String getDname() {
        return dname;
    }

    public Dept() {
    }

    public Dept(String dname) {
        this.dname = dname;
    }

    public void info() {
        System.out.println("部门名称:" + dname);
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
