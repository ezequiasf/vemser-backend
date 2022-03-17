package com.dbccompany.vemser.dto;

import com.dbccompany.vemser.entity.Entidade;
import com.dbccompany.vemser.entity.Pessoa2;

public class DTOUtils<T> {

    public DataTransitionBack<? extends Entidade> getTransitionInformation (T o, String... s){
        if (o instanceof Pessoa2 p){
            DataTransitionBack<Pessoa2> d = new DataTransitionBack<>();
            Pessoa2 info = new Pessoa2();
            for (String str: s){
                if (str.equalsIgnoreCase("id")){
                    info.setId(p.getId());
                }else if (str.equalsIgnoreCase("nome")){
                    info.setNome(p.getNome());
                }else if (str.equalsIgnoreCase("nascimento")){
                    info.setNascimento(p.getNascimento());
                }else if (str.equalsIgnoreCase("email")){
                    info.setEmail(p.getEmail());
                }else if (str.equalsIgnoreCase("cpf")){
                    info.setCpf(p.getCpf());
                }
            }
            d.setT(info);
            return d;
        }
        return null;
    }
}
