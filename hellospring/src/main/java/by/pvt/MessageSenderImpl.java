package by.pvt;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MessageSenderImpl implements MessageSender, BeanNameAware, ApplicationContextAware {


    @Override
    public void send(Message message) {
        System.out.println("Sending message... ");
        System.out.println(message);
        System.out.println("Finish sending message. ");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BEAN NAME: " + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("CONTEXT: " + applicationContext);
    }

    @PostConstruct
    public  void init() {
        System.out.println("CALL INIT()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CALL DESTROY()");
    }
}
