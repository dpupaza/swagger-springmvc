package com.mangofactory.swagger.models;

import com.fasterxml.classmate.ResolvedType;

import static com.mangofactory.swagger.models.ResolvedTypes.modelName;

public class ResolvedTypeMemberSource implements MemberInfoSource {
    private final ResolvedType resolvedType;

    public ResolvedTypeMemberSource(ResolvedType resolvedType) {
        this.resolvedType = resolvedType;
    }

    @Override
    public <T extends java.lang.annotation.Annotation>  T getAnnotation(java.lang.Class<T> tClass)
    {
        return null;
    }

    @Override
    public Class<?> getType() {
        return resolvedType.getClass();
    }

    @Override
    public String getName() {
        return modelName(resolvedType);
    }

    @Override
    public ResolvedType getResolvedType() {
        return resolvedType;
    }

    @Override
    public boolean isSubclassOf(Class<?> clazz) {
        return (resolvedType.getErasedType() != Object.class) && (
                 clazz.isAssignableFrom(resolvedType.getClass())
                || clazz.isAssignableFrom(resolvedType.getErasedType()));
    }

    @Override
    public boolean isEnum() {
        return EnumHelper.isEnum(resolvedType.getErasedType());
    }
}
