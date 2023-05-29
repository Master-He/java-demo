package org.mybatis.example.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author hewenji
 * @Date 2023/5/28 21:11
 */
public class User implements Serializable {
    private Integer id;
    private String password;
    private String name;
    private String email;
    private Date birthday;
    private Integer money;

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", birthday=" + birthday +
            ", money=" + money +
            '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
