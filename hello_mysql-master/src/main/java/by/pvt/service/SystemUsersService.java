package by.pvt.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.pvt.dto.SystemUsersExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import by.pvt.dao.SystemUsersMapper;
import by.pvt.dto.SystemUsers;


public class SystemUsersService {
    private static Logger log = Logger.getLogger(SystemUsersService.class.getName());
    private SqlSessionFactory sqlSessionFactory;

    public SystemUsersService() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config.xml")
            );


        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    protected void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<SystemUsers> getSystemUsers(SystemUsersExample usersExample) {
        SqlSession session = sqlSessionFactory.openSession();
        SystemUsersMapper dao =
                session.getMapper(SystemUsersMapper.class);

        List<SystemUsers> dtoUsers
                = dao.selectByExample(usersExample);

        session.close();
        return dtoUsers;
    }



    public void add(SystemUsers systemUser) {
        SqlSession session = sqlSessionFactory.openSession();
        SystemUsersMapper dao = session.getMapper(SystemUsersMapper.class);
        int result = dao.insert(systemUser);
        log.info("Added new systemUser with result= " + result);
        session.commit();
        session.close();
    }



    public static void main(String[] args) {

//        SystemUsers systemUsers = new SystemUsers();
//        systemUsers.setId(3);
//        systemUsers.setUsername("User2");
//        systemUsers.setActive(false);
//        systemUsers.setDateofbirth(new Date());
//
//        new SystemUsersService().add(systemUsers);

        /**
         * test main method
         */

        SystemUsersService service = new SystemUsersService();
        service.getSystemUsers(null)
                .forEach(user ->
                        log.info(user.getId() + " " + user.getUsername() + " " + user.getActive() + " " + user.getDateofbirth()));

       log.info("Run with example");
        SystemUsersExample example = new SystemUsersExample();
        example.createCriteria().andActiveEqualTo(true);

        service.getSystemUsers(example)
                .forEach(user ->
                        log.info(user.getId() + " " + user.getUsername() + " " + user.getActive() + " " + user.getDateofbirth()));


    }
}
