package com.takeaway.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String username;
    private String password;
    private String cname;
    private String phone;
    private String address;
    private Timestamp createdDate;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cname='" + cname + '\'' +
                ", phone='" + phone + '\'' +
                ", createdDate=" + createdDate +
                ", email='" + email + '\'' +
                '}';
    }
}
