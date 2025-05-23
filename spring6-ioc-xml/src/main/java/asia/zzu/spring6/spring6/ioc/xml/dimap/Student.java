package asia.zzu.spring6.spring6.ioc.xml.dimap;

import java.util.Map;

public class Student {
    private Map<String, Teacher> teacherMap;

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    private String sid;
    private String sname;

    public void run() {
        System.out.println("学生编号：" + sid + "   学生名称：" + sname);
        //teacherMap.forEach((s, teacher) -> System.out.println(s + "==>" + teacher));
        System.out.println(teacherMap);
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }


    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

//    public Student(Map<String, Teacher> teacherMap, String sid, String sname) {
//        this.teacherMap = teacherMap;
//        this.sid = sid;
//        this.sname = sname;
//    }

    public Student() {
    }
}
