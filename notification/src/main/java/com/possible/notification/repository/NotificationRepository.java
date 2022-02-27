package com.possible.notification.repository;

import com.possible.notification.model.NotificationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationRecord, Integer> {
}
