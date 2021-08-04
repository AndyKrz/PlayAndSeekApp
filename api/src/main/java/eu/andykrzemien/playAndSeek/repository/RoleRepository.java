package eu.andykrzemien.playAndSeek.repository;

import eu.andykrzemien.playAndSeek.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Set<Role> findAll();

    Role findByName(String name);

}
