package asia.zzu.spring6.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FilterOutputStream;
import java.util.List;
import java.util.Map;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //返回对象
    @Test
    public void testSelectObject1() {
        String sql = "SELECT * FROM t_emp WHERE id = ?";
        Emp empResult = jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> {
                    Emp emp = new Emp();
                    emp.setName(rs.getString("name"));
                    emp.setAge(rs.getInt("age"));
                    emp.setSex(rs.getString("sex"));
                    emp.setId(rs.getInt("id"));
                    return emp;
                }, 1);
        System.out.println(empResult.toString());
    }

    @Test
    public void testSelectObject2() {
        String sql = "SELECT * FROM t_emp WHERE id = ?";
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 3);
        System.out.println(emp.toString());
    }


    //返回list集合

    @Test
    public void testSelectList() {
        String sql = "SELECT * FROM t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }

    //返回单个值
    @Test
    public void testSelectValue() {
        String sql = "SELECT count(*) FROM t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {

//        //添加
//        String sql = "INSERT INTO t_emp VALUES (NULL,?,?,?)";
//        //调用jdbcTemplate的方法
//        Object[] params = {"朱文杰", 20, "中"};
//        //int rows = jdbcTemplate.update(sql, "赵庆举", 21, "男");
//        int rows = jdbcTemplate.update(sql, params);
//        System.out.println(rows);
        //修改
//        String sql = "UPDATE t_emp SET name = ? WHERE id = ?";
//        int rows = jdbcTemplate.update(sql, "白冰玉", 2);
//        System.out.println(rows);
        //删除
        String sql = "DELETE FROM t_emp WHERE id =?";
        int rows = jdbcTemplate.update(sql, 2);
        System.out.println(rows);
    }


}
