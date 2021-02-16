package com.pluralsight.conferencedemo.Repositories;

import com.pluralsight.conferencedemo.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
