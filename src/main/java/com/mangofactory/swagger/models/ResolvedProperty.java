package com.mangofactory.swagger.models;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.classmate.members.ResolvedMethod;

public class ResolvedProperty implements MemberInfoSource {
    private final boolean isGetter;
    private String name;
    private ResolvedMethod method;

    public ResolvedProperty(String name, ResolvedMethod method) {
        this.isGetter = true;
        this.name = name;
        this.method = method;
    }

    public ResolvedProperty(String name, ResolvedMethod method, boolean isGetter) {
        this.isGetter = isGetter;
        this.name = name;
        this.method = method;
    }


    public Class<?> getType() {
        return resolvedType().getErasedType();
    }

    private ResolvedType resolvedType() {
        if (isGetter) {
            if (method.getReturnType().getErasedType().getTypeParameters().length > 0) {
                return method.getReturnType();
            } else {
                return new TypeResolver().resolve(method.getReturnType().getErasedType());
            }
        } else {
            if (method.getArgumentType(0).getErasedType().getTypeParameters().length > 0) {
                return method.getArgumentType(0);
            } else {
                return new TypeResolver().resolve(method.getArgumentType(0).getErasedType());
            }
        }
    }

    public String getName() {
        return name;
    }

    public ResolvedType getResolvedType() {
        return resolvedType();
    }

    public String getMethodName() {
        return method.getName();
    }

    @Override
    public <T extends java.lang.annotation.Annotation>  T getAnnotation(java.lang.Class<T> tClass)
    {
        return method.getRawMember().getAnnotation(tClass);
    }

    @Override
    public boolean isSubclassOf(Class<?> clazz) {
        return (getType() != Object.class) && clazz.isAssignableFrom(getType());
    }

    @Override
    public boolean isEnum() {
        return EnumHelper.isEnum(getType());
    }


    public void setName(String name) {
        this.name = name;
    }
}
