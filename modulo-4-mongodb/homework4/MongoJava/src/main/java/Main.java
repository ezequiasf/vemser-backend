import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;

import java.util.HashMap;

import static com.mongodb.client.model.Filters.eq;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();
//        UserEntity u1 = UserEntity.builder()
//                .username("zezin")
//                .email("zezin@gmail.com")
//                .password("$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM/o9rFec.QfZ/6Lltm")
//                .isactive(true)
//                .role("ROLE_STANDARD").build();
//
//        UserEntity u2 = UserEntity.builder()
//                .username("claudio")
//                .email("claudin@gmail.com")
//                .password("$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM/o9rFec.QfZ/6Lltm")
//                .isactive(true)
//                .role("ROLE_PREMIUM").build();
//        //Cadastro
//        userRepo.saveUser(u1);
//        userRepo.saveUser(u2);
//
//        //Update & find
//        String jsonMaic = userRepo.findUser("maic321");
//        System.out.println(jsonMaic);
//        userRepo.updateUser("maic321", "role", "ROLE_STANDARD");
//        String jsonMaic2 = userRepo.findUser("maic321");
//        System.out.println(jsonMaic2)

//        Delete
//        userRepo.deleteUser("claudio");

        //Projection
//        userRepo.findAllProjection("username", "email");
        userRepo.aggregatingUser(Aggregates.match(eq("role", "ROLE_STANDARD")),
                Aggregates.count("Usuários não pagantes"));
    }
}
