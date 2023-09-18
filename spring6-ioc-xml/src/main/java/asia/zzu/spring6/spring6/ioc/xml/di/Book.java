package asia.zzu.spring6.spring6.ioc.xml.di;

public class Book {
    private String bname;
    private String auther;

    public Book() {
        System.out.println("无参构造器执行");
    }

    public Book(String bname, String auther) {
        System.out.println("有参构造器执行");
        this.bname = bname;
        this.auther = auther;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", auther='" + auther + '\'' +
                '}';
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }
}
