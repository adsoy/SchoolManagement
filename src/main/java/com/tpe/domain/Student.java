package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "Isim null olamaz")
    @NotBlank(message = "Isim bos girilemez")
    @Size(min=2,max=25,message = "Isim '${validateValue}' {min} ve {max} arasinda olmalidir.")
    private String firstName;

    @NotNull(message = "Soy isim null olamaz")
    @NotBlank(message = "Soy isim bos girilemez")
    @Size(min=2,max=25,message = "Soy isim '${validateValue}' {min} ve {max} arasinda olmalidir.")
    private String lastName;

    private Integer grade;

    @Email(message = "Gecerli bir mail adresi giriniz.")
    private String mail;

    @Setter(AccessLevel.NONE)
    private LocalDate createDate = LocalDate.now();


}
