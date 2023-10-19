package com.example.c4zone.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListImageDto {
    private Collection<String> path;
}
