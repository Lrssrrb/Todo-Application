package com;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository  extends JpaRepository<Task, Long> {

}
