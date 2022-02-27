package com.possible.notification.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class NotificationRecord {
    @Id
    @SequenceGenerator(name = "notification_id_seq", sequenceName = "notification_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_seq")

    private  Integer id;
    private String userName;
    private String email;
}
