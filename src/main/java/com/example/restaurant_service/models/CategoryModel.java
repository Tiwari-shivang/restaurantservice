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
@Table(name = "category")
public class CategoryModel {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name, description;
    private Timestamp created_at, updated_at;

    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private RestaurantModel restaurant;
}
