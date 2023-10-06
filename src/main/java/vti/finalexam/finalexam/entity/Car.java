package vti.finalexam.finalexam.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Car")
@IdClass(CarId.class)
public class Car{
    @Id
    @Column(nullable = false, name = "license_plate")
    private String licensePlate;
    
    @Id
    @Column(nullable = false, name = "repair_date")
    // @DateTimeFormat(pattern = "dd-MM-yyyy")
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
    private String repairDate;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String catalogs;

    @Column(nullable = false)
    private String carMaker;

}