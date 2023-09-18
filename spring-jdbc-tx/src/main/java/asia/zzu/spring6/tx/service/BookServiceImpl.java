package asia.zzu.spring6.tx.service;

import asia.zzu.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(noRollbackFor = ArithmeticException.class)
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //根据图书id查询图书价格
        int price = bookDao.getBookPriceByBookId(bookId);

        //更新图书库存量
        bookDao.updateStock(bookId);

        //更新用户表余额
        bookDao.updateUserBalance(userId, price);
    }
}
