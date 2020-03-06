package by.pvt.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import by.pvt.dao.ClientFeedbackMapper;
import by.pvt.dto.ClientFeedback;

public class ClientFeedbackService {

    private static Logger log = Logger.getLogger(ClientFeedbackService.class.getName());
    private SqlSessionFactory sqlSessionFactory;

    public ClientFeedbackService() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("by/pvt/service/mybatis-config.xml"));
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public List<ClientFeedback> selectAllFedback() {
        SqlSession session = sqlSessionFactory.openSession();
        ClientFeedbackMapper dao = session.getMapper(ClientFeedbackMapper.class);
        List<ClientFeedback> dtoFedback = dao.selectByExample(null);
        session.close();
        return dtoFedback;
    }

    public void addFeedback(ClientFeedback fedbask) {
        SqlSession session = sqlSessionFactory.openSession();
        ClientFeedbackMapper dao = session.getMapper(ClientFeedbackMapper.class);
        int result = dao.insert(fedbask);
        log.info("Added new feedback with result= " + result);
        session.commit();
        session.close();
    }

    public static void main(String[] args) {
        ClientFeedback clientFeedback = new ClientFeedback();
        clientFeedback.setId(1);
        clientFeedback.setClientId(2);
        clientFeedback.setProductId(3);
        clientFeedback.setMessage("Very pleased with the purchase");
        clientFeedback.setPostDate(new Date());
        new ClientFeedbackService().addFeedback(clientFeedback);

        ClientFeedbackService service = new ClientFeedbackService();
        service.selectAllFedback()
                .forEach(feedback ->
                        log.info(feedback.getId() + " " + feedback.getClientId() + " " + feedback.getProductId() + " " + feedback.getMessage() + " " + feedback.getPostDate()));

    }
}
