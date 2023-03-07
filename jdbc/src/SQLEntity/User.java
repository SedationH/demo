package SQLEntity;

public class User {
    int id;
    String account;
    String PASSWORD;
    String nickname;

    @Override
    public String toString() {
        return "id: " + id + ", account: " + account + ", password: " + PASSWORD + ", nickname: " + nickname;
    }
}
