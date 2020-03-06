package by.pvt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        System.out.println(context.getBeanDefinitionCount());
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        MessageCmdProc messageCmdProc = (MessageCmdProc) context.getBean("messageCmdProc");

        messageCmdProc.execute(new SendMessageCmd(
                MessageType.HELLO_MESSAGE,
                "Ivanov",
                "email")
        );

        System.out.println(messageCmdProc.getList().size());
        messageCmdProc.getList().forEach(System.out::println);

//        Message message1 = (Message) context.getBean("message");
//        System.out.println("Message1: " + message1.hashCode());
//
//        Message message2 = (Message) context.getBean("message");
//        System.out.println("Message2: " + message2.hashCode());

//        context.close();
    }
}
