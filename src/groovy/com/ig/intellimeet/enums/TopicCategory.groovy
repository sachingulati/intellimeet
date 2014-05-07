package com.ig.intellimeet.enums

public enum TopicCategory {
    JAVA('Java'),
    GROOVY('Groovy'),
    GRAILS('Grails'),
    NODE_JS('Node JS'),
    ANGULAR_JS('AngularJS'),
    AWS('AWS'),
    SALES('Sales'),
    CQ5('CQ5'),
    ANDROID('Android'),
    IOS('IOS'),
    TESTING('Testing'),
    BIG_DATA('Big Data'),
    JAVA_SCRIPT('Javascript'),
    UI('UI'),
    OTHERS('Others')

    String displayName

    TopicCategory(String displayName){
        this.displayName = displayName
    }
}