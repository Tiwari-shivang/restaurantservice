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
@Table(name = "restaurant_review")
public class ReviewsModel {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "user_id")
    private String userId;
    private Float rating;
    private String comment;
    private Timestamp created_at;

    @JoinColumn(name = "restaurant_id" , referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private RestaurantModel restaurant;
}
