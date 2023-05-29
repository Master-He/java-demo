package org.mybatis.example.pojo;

/**
 * @author hewenji
 * @Date 2023/5/29 0:51
 */
public class Email {
    private String email;

    @Override
    public String toString() {
        return "Email{" +
            "email='" + email + '\'' +
            '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
