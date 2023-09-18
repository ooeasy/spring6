package asia.zzu.spring6.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据图书id查询图书价格
    @Override
    public Integer getBookPriceByBookId(Integer bookId) {
        String sql = "SELECT price FROM t_book WHERE book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }

    //更新图书库存量
    @Override
    public void updateStock(Integer bookId) {
        String sql = "UPDATE t_book SET stock =stock -1 WHERE book_id = ? ";
        jdbcTemplate.update(sql, bookId);

    }

    //更新用户表余额
    @Override

    public void updateUserBalance(Integer userId, int price) {
        String sql = "UPDATE t_user SET balance =balance - ? WHERE user_id = ? ";
        jdbcTemplate.update(sql, price, userId);
    }
}
