package mss301.fa.s1.service;

import mss301.fa.s1.model.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    public Role findRoleByName(String name);
    public boolean addRole(Role role);
}
