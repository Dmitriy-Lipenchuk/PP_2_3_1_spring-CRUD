package web.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Enter the name!")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Enter the email!")
    @Email(message = "Enter valid email")
    @Column(name = "email")
    private String email;

    @Min(value = 0, message = "Age can't be negative!")
    @Max(value = 127, message = "Age max value is 127")
    @Column(name = "age")
    private byte age;

    public User() {

    }

    public User(String name, String email, byte age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
