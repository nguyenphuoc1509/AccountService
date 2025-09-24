package mss301.fa.s1.repository;

import mss301.fa.s1.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByRoleName(String roleName);
}
