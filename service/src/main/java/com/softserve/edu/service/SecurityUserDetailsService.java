package com.softserve.edu.service;

import com.softserve.edu.entity.user.Employee;
import com.softserve.edu.entity.user.User;
import com.softserve.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static com.softserve.edu.entity.user.SystemAdmin.AdminRole.SYS_ADMIN;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOne(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        Long employeeOrganizationId = user.getRole().equals(SYS_ADMIN.roleName()) ?
                null : ((Employee) user).getOrganization().getId();

        return new CostumeUserDetails(username, user.getPassword(), authorities, employeeOrganizationId);
    }

    /**
     * Provide additional information about company(organization) where user works except SYS_ADMIN role.
     */
    public static class CostumeUserDetails extends org.springframework.security.core.userdetails.User {
        private static final long serialVersionUID = UUID.randomUUID().getMostSignificantBits();
        private Long organizationId;

        public CostumeUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long organizationId) {
            super(username, password, authorities);
            this.organizationId = organizationId;
        }

        public Long getOrganizationId() {
            return organizationId;
        }
    }
}
