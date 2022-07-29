package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by OnKa on 28.07.2022.
 */
@Entity
@Data
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pid;

    @Length(message = "Title Min=3 Max=30", min=3, max=30)
    @NotNull(message = "Title NotNull!")
    @NotEmpty(message = "Title Not Empty!")
    private String title;

    @NotBlank(message = "Detail not empty or nor Null")
    private String detail;

    @Max(message = "Price Max 1000", value = 1000)
    @Min(message = "Price Min 3", value = 3)
    private Integer price;
}
