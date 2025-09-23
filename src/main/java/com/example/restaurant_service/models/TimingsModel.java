package com.example.restaurant_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Time;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant_timings")
public class TimingsModel {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "day_of_week")
    private String dayOfWeek;
    private Time open_time, close_time;
    private int is_closed;

    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private AddressModel addressModel;
}
