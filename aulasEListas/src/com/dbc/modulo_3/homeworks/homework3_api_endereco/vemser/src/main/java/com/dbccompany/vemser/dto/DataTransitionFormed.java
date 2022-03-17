package com.dbccompany.vemser.dto;

import com.dbccompany.vemser.entity.Entidade;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataTransitionFormed <T extends Entidade>{
    private T t;
}
