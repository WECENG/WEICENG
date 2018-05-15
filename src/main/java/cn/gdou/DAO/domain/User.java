package cn.gdou.DAO.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String gender;
    private Integer age;
    @OneToMany
    private List<User> friends;

    public User(String username, String password, String gender, Integer age) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
