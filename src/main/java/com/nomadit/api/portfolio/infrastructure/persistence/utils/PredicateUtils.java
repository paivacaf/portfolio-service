package com.nomadit.api.portfolio.infrastructure.persistence.utils;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathBuilder;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Objects;

public class PredicateUtils {

    public static <T> Predicate criarPredicate(EntityManager entityManager, Class<T> entityClass, T entity) {
        EntityPathBase<T> entityPath = new EntityPathBase<>(entityClass, entityClass.getSimpleName());
        PathBuilder<T> pathBuilder = new PathBuilder<>(entityClass, entityPath.getMetadata());
        BooleanExpression predicate = null;

        for (Field field : entityClass.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(entity);
                if (Objects.nonNull(value)) {
                    BooleanExpression expression = pathBuilder.get(field.getName()).eq(value);
                    predicate = Objects.isNull(predicate) ? expression : predicate.and(expression);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return predicate;
    }
}
