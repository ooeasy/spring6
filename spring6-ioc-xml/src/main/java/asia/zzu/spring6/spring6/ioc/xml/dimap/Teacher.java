package asia.zzu.spring6.spring6.ioc.xml.dimap;

public class Teacher {
    private String teacherId;
    private String teacherName;

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }


    public Teacher() {
    }

//    public Teacher(String teacherId, String teacherName) {
//        this.teacherId = teacherId;
//        this.teacherName = teacherName;
//    }
}
