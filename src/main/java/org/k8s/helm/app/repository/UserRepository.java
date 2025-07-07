package org.k8s.helm.app.repository;

import org.k8s.helm.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
