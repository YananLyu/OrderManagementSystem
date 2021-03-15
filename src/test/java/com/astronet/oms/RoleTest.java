package com.astronet.oms;

import com.astronet.oms.entity.Role;
import com.astronet.oms.enums.RoleEnum;
import com.astronet.oms.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Yanan Lyu
 * @date 3/14/21 7:33 PM
 */

@SpringBootTest
public class RoleTest {

    @Autowired
    private RoleRepository repository;

    @Test
    public void testSaveRole() {
        Role role = new Role();

//        role.setName(RoleEnum.ROLE_USER);
//        repository.save(role);

        role.setName(RoleEnum.ROLE_ADMIN);
        repository.save(role);

    }
}
