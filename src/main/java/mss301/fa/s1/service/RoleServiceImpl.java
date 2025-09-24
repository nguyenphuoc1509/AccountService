package mss301.fa.s1.service;

import mss301.fa.s1.model.Role;
import mss301.fa.s1.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public boolean addRole(Role role) {
        return roleRepository.save(role) != null;
    }
}
