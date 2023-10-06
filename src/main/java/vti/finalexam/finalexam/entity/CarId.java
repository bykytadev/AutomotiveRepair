package vti.finalexam.finalexam.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class CarId implements Serializable{
    private String licensePlate;
    private String repairDate;

}
