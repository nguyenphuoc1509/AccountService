package mss301.fa.s1.config;

import mss301.fa.s1.model.Account;
import mss301.fa.s1.model.Role;
import mss301.fa.s1.repository.RoleRepository;
import mss301.fa.s1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception{
        if (roleRepository.count() > 0 || accountRepository.count() > 0) {
            System.out.println("Database already initialized");
            return;
        }
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("USER");
        roleRepository.save(userRole);

        Account admin = new Account();
        admin.setAccountName("admin");
        admin.setPassword("admin123");
        admin.setEmail("admin@gmail.com");
        admin.setRole(adminRole);
        accountRepository.save(admin);

        Account user = new Account();
        user.setAccountName("user");
        user.setPassword("user123");
        user.setEmail("user@gmail.com");
        user.setRole(userRole);
        accountRepository.save(user);

        System.out.println("Database initialized");

    }

}
