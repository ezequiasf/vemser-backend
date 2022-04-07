import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    String username;
    String password;
    String email;
    boolean isactive;
    String role;
}
