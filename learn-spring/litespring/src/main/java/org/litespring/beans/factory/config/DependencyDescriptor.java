package org.litespring.beans.factory.config;

import org.litespring.util.Assert;

import java.lang.reflect.Field;

/**
 * @author ch113
 */
public class DependencyDescriptor {
    private Field field;
    private boolean required;

    public DependencyDescriptor(Field field, boolean required) {
        Assert.notNull(field, "Field must not be null");
        this.field = field;
        this.required = required;

    }

    public Class<?> getDependencyType() {
        if (this.field != null) {
            return field.getType();
        }
        throw new RuntimeException("only support field dependency");
    }

    public boolean isRequired() {
        return this.required;
    }
}
