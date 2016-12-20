package logs;

/**
 * Created by jmunarb on 22/11/16.
 */

/**
 * Funcio emprada per obtenir la contrasenya i el email de l'usuari introduits en el formulari.
 */
public class User {
    private String name;
    private String pass;
    private String email;

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public User(String name, String pass, String email) {
        this.name = name;
        this.pass = pass;
        this.email = email;
    }
}
