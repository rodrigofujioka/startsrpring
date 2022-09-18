package br.tabajara.api.domain.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Errors {

    String entity;
    List<String> error;
}
