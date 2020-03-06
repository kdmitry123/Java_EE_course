package by.pvt;

public enum MessageType {
    HELLO_MESSAGE("Hello %s new user", "Hello", "email"),
    INVITE_MESSAGE("Dear %s! You are invited!", "Invited", "email"),
    CANCEL_MESSAGE("Sorry, %s ! Your order has bean canceled", "Cancel", "SMS");
    private String body;

    private String subject;

    private String channel;



    MessageType(String body, String subject, String channel) {
        this.body = body;
        this.subject = subject;
        this.channel = channel;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

    public String getChannel() {
        return channel;
    }
}