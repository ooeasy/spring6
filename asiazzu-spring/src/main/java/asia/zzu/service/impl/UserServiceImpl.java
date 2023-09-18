package asia.zzu.service.impl;

import asia.zzu.anno.Bean;
import asia.zzu.anno.Di;
import asia.zzu.dao.UserDao;
import asia.zzu.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;
}
