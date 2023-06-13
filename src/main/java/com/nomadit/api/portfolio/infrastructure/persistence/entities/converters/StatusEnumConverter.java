package com.nomadit.api.portfolio.infrastructure.persistence.entities.converters;

import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.StatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusEnumConverter implements AttributeConverter<StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusEnum statusEnum) {
        if (statusEnum == null) {
            return null;
        }
        return statusEnum.getDescricao();
    }

    @Override
    public StatusEnum convertToEntityAttribute(String valor) {
        if (valor == null) {
            return null;
        }
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getDescricao().equals(valor)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("Valor inválido para StatusEnum: " + valor);
    }
}
