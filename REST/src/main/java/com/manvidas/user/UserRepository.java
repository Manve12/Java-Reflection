package com.manvidas.user;

import com.manvidas.billing.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findUserByUsername(String username);
    List<Billing> findBillingsByUsername(String username);
}
