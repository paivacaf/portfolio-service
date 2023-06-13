package com.nomadit.api.portfolio.infrastructure.persistence.entities.converters;

import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.RiscoEnum;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.StatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RiscoEnumConverter implements AttributeConverter<RiscoEnum, String> {

    @Override
    public String convertToDatabaseColumn(RiscoEnum riscoEnum) {
        if (riscoEnum == null) {
            return null;
        }
        return riscoEnum.getDescricao();
    }

    @Override
    public RiscoEnum convertToEntityAttribute(String valor) {
        if (valor == null) {
            return null;
        }
        for (RiscoEnum riscoEnum : RiscoEnum.values()) {
            if (riscoEnum.getDescricao().equals(valor)) {
                return riscoEnum;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Risco: " + valor);
    }
}
