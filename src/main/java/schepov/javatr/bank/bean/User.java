package schepov.javatr.bank.bean;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String password;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User that = (User) o;
        return ((id == null ? that.id == null : id.equals(that.id)) &&
                (password == null ? that.password == null : password.equals(that.password)));
    }

    @Override
    public int hashCode() {
        int result = (id == null ? 0 : id.hashCode());
        result = 31 * result + (password == null? 0 : password.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " : { id: " + id + "; password: " + password + "}";
    }
}
