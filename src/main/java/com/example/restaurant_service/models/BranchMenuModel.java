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
@Table(name = "branch_menu_item")
public class BranchMenuModel {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private Double custom_price;
    private int isAvailable;
    private Timestamp created_at, updated_at;

    @JoinColumn(name = "restaurant_address_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AddressModel address;

    @JoinColumn(name = "menu_item_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuModel menu;
}