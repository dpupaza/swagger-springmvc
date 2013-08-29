package com.mangofactory.swagger.models;

import com.wordnik.swagger.annotations.ApiProperty;
import com.wordnik.swagger.core.DocumentationSchema;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: dan
 * Date: 8/26/13
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractMemberVisitor implements MemberVisitor{

    @SuppressWarnings("ConstantConditions")
    @Override
    public DocumentationSchema schema(MemberInfoSource member) {
        ApiProperty apiProp = member.getAnnotation(ApiProperty.class);
        DocumentationSchema schema = schemaGeneration(member);
        if(apiProp != null){
            schema.setRequired(apiProp.required());
            if(!StringUtils.isEmpty(apiProp.notes())){
                schema.setDescription(apiProp.notes());
            }
        }
        return schema;
    }

    protected abstract DocumentationSchema schemaGeneration(MemberInfoSource member);
}
