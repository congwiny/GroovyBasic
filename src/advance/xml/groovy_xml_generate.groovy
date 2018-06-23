package advance.xml

import groovy.xml.MarkupBuilder

/**
 *
 * 生成xml格式数据
 * <langs type='current' count='3' mainstream='true'>
 *    <language flavor='static' version='1.5'>Java</language>
 *    <language flavor='dynamic' version='1.9'>JavaScript</language>
 * </langs>
 */

StringWriter sw = new StringWriter()
MarkupBuilder xmlBuilder = new MarkupBuilder(sw)
xmlBuilder.langs(type: 'current', count: '3', mainstream: 'true') {
    language(flavor: 'static', version: '1.5', 'Java')
    language(flavor: 'dynamic', version: '1.9', 'JavaScript')
}
//println sw

/**
 * 实体转xml文档
 */

class Langs {
    String type = 'current'
    int count = 3
    boolean mainstream = true
    def languages = [new Language(flavor: 'static', version: '1.5', value: 'Java'),
                     new Language(flavor: 'dynamic', version: '1.9', value: 'JavaScript')]
}

class Language {
    String flavor
    String version
    String value
}

StringWriter sw2 = new StringWriter()
MarkupBuilder xmlBuilder2 = new MarkupBuilder(sw2)

def langs = new Langs()

xmlBuilder2.langs(type: langs.type, count: langs.count, mainstream: langs.mainstream) {
    langs.languages.each { lang ->
        language(flavor: lang.flavor, version: lang.version, lang.value)
    }
}

println sw2

