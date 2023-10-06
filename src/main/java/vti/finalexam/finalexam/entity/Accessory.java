package vti.finalexam.finalexam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accessory")
public class Accessory {
    @Id
    @Column(nullable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String statusDamaged;
    private String repairStatus;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "license_plate", referencedColumnName = "license_plate"),
            @JoinColumn(name = "repair_date", referencedColumnName = "repair_date")
    })
    private Car car;

    public Accessory(String name, double price, String statusDamaged, String repairStatus) {
        this.name = name;
        this.price = price;
        this.statusDamaged = statusDamaged;
        this.repairStatus = repairStatus;
    }

    public Accessory(Long id, String name, double price, String statusDamaged, String repairStatus) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.statusDamaged = statusDamaged;
        this.repairStatus = repairStatus;
    }

    @Override
    public String toString() {
        return "Accessory [name=" + name + ", price=" + price + ", statusDamaged=" + statusDamaged + ", repairStatus="
                + repairStatus + ", car=" + car + "]";
    }

    public Accessory(String name, double price, String statusDamaged, String repairStatus, Car car) {
        this.name = name;
        this.price = price;
        this.statusDamaged = statusDamaged;
        this.repairStatus = repairStatus;
        this.car = car;
    }

}