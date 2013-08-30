package com.mangofactory.swagger.models;

import com.google.common.base.Function;
import com.wordnik.swagger.core.DocumentationSchema;

/**
 * Created with IntelliJ IDEA.
 * User: dan
 * Date: 8/26/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class JodaDateTimeMemberVisitor extends AbstractMemberVisitor {
    private static MemberVisitor instance = new JodaDateTimeMemberVisitor();

    public static Function<SchemaProvider, MemberVisitor> factory() {
        return new Function<SchemaProvider, MemberVisitor>() {
            @Override
            public MemberVisitor apply(SchemaProvider context) {
                return instance;
            }
        };
    }

    @Override
    public DocumentationSchema schemaGeneration(MemberInfoSource member) {
        Class<?> returnType = member.getType();
        DocumentationSchema propertySchema = new DocumentationSchema();
        propertySchema.setName(member.getName());
        propertySchema.setType("date-time");
        propertySchema.setDescription("Accepts ISO 8061 format i.e. 2030-07-16T19:20:30.45+01:00");
        return propertySchema;
    }
}
