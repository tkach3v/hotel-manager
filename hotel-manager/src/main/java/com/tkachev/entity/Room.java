package com.tkachev.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "room_number", nullable = false)
    private Integer number;

    @Column(name = "price", nullable = false, precision = 0)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private RoomStatus status;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @ToString.Exclude
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) && Objects.equals(number, room.number) && Objects.equals(price, room.price) && status == room.status && Objects.equals(capacity, room.capacity) && Objects.equals(rating, room.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, price, status, capacity, rating);
    }
}

