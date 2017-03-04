package server;


/**
 * @author Yoann Boyer
 */
class Message {
    private String username;
    private long timestamp;
    private String message;

    public Message(String username, long timestamp, String message) {
        this.username = username;
        this.timestamp = timestamp;
        this.message = message;
    }

    /**
     * Format the message for a socket use
     * @return The formatted message
     */
    public String format() {
        return this.username + " " + this.timestamp + " " + this.message;
    }
}
