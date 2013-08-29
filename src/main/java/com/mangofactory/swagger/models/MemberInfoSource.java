package com.mangofactory.swagger.models;

import com.fasterxml.classmate.ResolvedType;

public interface MemberInfoSource {
    Class<?> getType();
    String getName();
    ResolvedType getResolvedType();
    <T extends java.lang.annotation.Annotation>  T getAnnotation(java.lang.Class<T> tClass);

    boolean isSubclassOf(Class<?> clazz);

    boolean isEnum();
}
