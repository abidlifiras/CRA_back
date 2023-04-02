package com.example.cra.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "cra_servers")
public class CraServer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serverName", nullable = false, length = 17)
    private String serverName;

    @Column(name = "application", nullable = false)
    private int application;

    @Column(name = "dataSource", nullable = false, length = 11)
    private String dataSource;

    @Column(name = "operatingSystem", nullable = false, length = 47)
    private String operatingSystem;

    @Column(name = "type", nullable = false, length = 8)
    private String type;

    @Column(name = "role", nullable = false, length = 10)
    private String role;

    @Column(name = "currentNumberOfCores", nullable = false)
    private int currentNumberOfCores;

    @Column(name = "currentRAMGB", nullable = false)
    private int currentRAMGB;

    @Column(name = "currentDiskGB", nullable = false)
    private int currentDiskGB;

    @Column(name = "powerStatus", nullable = false, length = 30)
    private String powerStatus;

    @Column(name = "serverNotes", nullable = false, length = 30)
    private String serverNotes;

    @Column(name = "ipAddress", nullable = false, length = 30)
    private String ipAddress;

    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

}
