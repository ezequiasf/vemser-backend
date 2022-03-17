package com.dbccompany.vemser.dto;

import com.dbccompany.vemser.entity.Entidade;
import com.dbccompany.vemser.entity.Pessoa2;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DataTransitionBack <T extends Entidade> implements DTO {
    public T t;
}
