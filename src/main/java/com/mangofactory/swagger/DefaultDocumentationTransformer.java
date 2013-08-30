package com.mangofactory.swagger;

import com.wordnik.swagger.core.Documentation;
//import com.wordnik.swagger.core.DocumentationEndPoint;


public class DefaultDocumentationTransformer extends DocumentationTransformer {

    public DefaultDocumentationTransformer(EndpointComparator endPointComparator,
                                           OperationComparator operationComparator) {
        super(endPointComparator, operationComparator);
    }

    @Override
    public Documentation applyTransformation(Documentation documentation) {
//        for(DocumentationEndPoint endPoint: documentation.getApis()){
//            if(endPoint.getPath().startsWith((SwaggerConfiguration.API_DOCS_PATH))){
//                endPoint.setPath(endPoint.getPath().substring(SwaggerConfiguration.API_DOCS_PATH.length()));
//            }
//        }
       return documentation;
    }
}
