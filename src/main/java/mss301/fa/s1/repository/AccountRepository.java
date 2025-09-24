package mss301.fa.s1.repository;

import mss301.fa.s1.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    // Find by email
    Account findByEmail(String email);

    // Find by account name
    Account findByAccountName(String accountName);

    // Find by role ID
    List<Account> findByRoleRoleId(int roleId);

    // Find by role name
    List<Account> findByRoleRoleName(String roleName);

    // Search by email containing pattern
    List<Account> findByEmailContaining(String emailPattern);

    // Check if email exists
    boolean existsByEmail(String email);

    // Find by role name and email containing
    List<Account> findByRoleRoleNameAndEmailContaining(String roleName, String email);

    // Find by account name containing
    List<Account> findByAccountNameContaining(String accountName);

    // Default search (alias for findByEmailContaining)
    default List<Account> search(String emailPattern) {
        return findByEmailContaining(emailPattern);
    }
}
