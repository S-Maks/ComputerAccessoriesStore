package com.computerAccessoriesStore.models;

import com.computerAccessoriesStore.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Account",schema = "public", catalog = "ComputerAccessoriesStore")
public class User {
    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    String email;
    String username;
    String password;
    Date created_at;

    @Enumerated(EnumType.STRING)
    Role role;

}
