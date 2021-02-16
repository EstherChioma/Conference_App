package com.pluralsight.conferencedemo.Repositories;

import com.pluralsight.conferencedemo.Models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository  extends JpaRepository<Speaker, Long> {
}
