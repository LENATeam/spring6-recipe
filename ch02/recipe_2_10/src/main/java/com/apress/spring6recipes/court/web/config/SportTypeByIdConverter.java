package com.apress.spring6recipes.court.web.config;

import com.apress.spring6recipes.court.domain.SportType;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public class SportTypeByIdConverter implements Converter<String, SportType> {

    private final List<SportType> sportTypes;

    public SportTypeByIdConverter(List<SportType> sportTypes) {
        this.sportTypes = sportTypes;
    }

    @Override
    public SportType convert(String id) {
        try {
            int typeId = Integer.parseInt(id);
            return sportTypes.stream()
                    .filter(st -> st.getId() == typeId)
                    .findFirst()
                    .orElse(null);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

