package mesqui.model;

import java.util.UUID;

public class Client {

    private final String id;
    private String email;

    public Client(String email) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
