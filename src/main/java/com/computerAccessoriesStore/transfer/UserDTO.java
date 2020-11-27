package com.computerAccessoriesStore.transfer;


import com.computerAccessoriesStore.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Date;

@Data
@AllArgsConstructor
@Builder
@EnableJpaRepositories("com.computerAccessoriesStore.*")
public class UserDTO {
    Long id;

    String firstName;
    String lastName;
    String email;
    String username;
    String password;
    Date created_at;
    Role role;

}
