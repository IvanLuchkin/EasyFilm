package intensive.util;

import intensive.model.Role;
import intensive.model.User;
import intensive.service.RoleService;
import intensive.service.UserService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void addRoles() {
        Role adminRole = new Role(Role.RoleName.ADMIN);
        Role userRole = new Role(Role.RoleName.USER);
        roleService.addRole(adminRole);
        roleService.addRole(userRole);
        User admin = new User();
        admin.setEmail("admin");
        admin.setRoles(List.of(adminRole, userRole));
        admin.setPassword("admin");
        userService.add(admin);
    }
}
