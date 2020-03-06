package services;

import dao.UsersMapper;
import dto.Users;
import dto.UsersExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemUsersService {
    private static Logger log = Logger.getLogger(SystemUsersService.class.getName());
    private SqlSessionFactory sqlSessionFactory;

    public SystemUsersService() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("mybatis-config.xml")
            );


        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }
    protected void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Users> getSystemUsers(UsersExample usersExample) {
        SqlSession session = sqlSessionFactory.openSession();
        UsersMapper dao =
                session.getMapper(UsersMapper.class);

        List<Users> dtoUsers
                = dao.selectByExample(usersExample);

        session.close();
        return dtoUsers;
    }

    public void add(Users systemUser) {
        SqlSession session = sqlSessionFactory.openSession();
        UsersMapper dao = session.getMapper(UsersMapper.class);
        int result = dao.insert(systemUser);
        log.info("Added new systemUser with result= " + result);
        session.commit();
        session.close();
    }

    public static void main(String[] args) {

        SystemUsersService service = new SystemUsersService();
//        service.add(new Users(1,"Victor", 34, "fadfad@tut.by"));
//        service.getSystemUsers(null)
//                .forEach(user ->
//                log.info(user.getId() + " " + user.getName() + " " + user.getAge() + " " + user.getEmail()));
//        log.info("Run with example");
        UsersExample example = new UsersExample();
        example.createCriteria().andIdBetween(1,3);

        service.getSystemUsers(example)
                .forEach(user ->
                        log.info(user.getId() + " " + user.getName() + " " + user.getAge() + " " + user.getEmail()));

    }
}
