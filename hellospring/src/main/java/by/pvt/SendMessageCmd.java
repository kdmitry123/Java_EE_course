package by.pvt;


public class SendMessageCmd {

    public final MessageType messageType;     // тип сообщения

    public final String recipient;      // получатель сообщения

    public final String channel;         // канал для отправки

    public SendMessageCmd(MessageType messageType, String recipient, String channel) {
        this.messageType = messageType;
        this.recipient = recipient;
        this.channel = channel;
    }
}
