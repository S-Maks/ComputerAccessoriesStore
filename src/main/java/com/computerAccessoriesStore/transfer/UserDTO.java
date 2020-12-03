package com.computerAccessoriesStore.transfer;


import com.computerAccessoriesStore.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import java.sql.Date;

@Data
@AllArgsConstructor
@Builder
@EnableJpaRepositories("com.computerAccessoriesStore.*")
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Date created_at;
    private Role role;
}
