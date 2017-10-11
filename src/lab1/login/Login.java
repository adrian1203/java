package lab1.login;

public class Login {
    private String login;
    private String password;


    public Login(String _login, String _password) {
        login = _login;
        password = _password;
    }


    public boolean check(String _login, String _password) {
        return (this.login.equals(_login) && this.password.equals(_password));
    }
}