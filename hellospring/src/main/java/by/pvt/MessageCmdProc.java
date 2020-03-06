package by.pvt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MessageCmdProc {

    @Value("VessageProc")
    private String name;

    @Value("{{1},{2}}")
    private List<String> list;

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private UserRepository userRepository;

    public void execute(SendMessageCmd cmd){

        Message message = new Message();

        message.setId(new Random().nextLong());
        message.setBody( String.format(cmd.messageType.getBody(),cmd.recipient));
        message.setSubject(cmd.messageType.getSubject());
        message.setFrom("info@shop.by");

        message.setTo(userRepository.findUserAddressByChannel(cmd.channel, cmd.recipient));

        messageSender.send(message);

    }

    public List<String> getList() {
        return list;
    }
}
