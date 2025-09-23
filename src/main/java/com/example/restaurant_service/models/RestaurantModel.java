package com.example.restaurant_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class RestaurantModel {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "owner_id")
    private UUID ownerId;
    private String name, description, phone_number, email, logo_url, status;
    @Column(name = "is_active")
    private int isActive;
    private Timestamp created_at, updated_at;
}
