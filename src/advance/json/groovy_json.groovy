package advance.json

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objectoriented.Person

def list = [new Person(name: 'John',age: 15),
            new Person(name: 'Tom',age: 14)]

//[{"age":15,"name":"John"},{"age":14,"name":"Tom"}]
def json =  JsonOutput.toJson(list)
println json

//pretty 以格式化输出json
println JsonOutput.prettyPrint(json)

//json转实体对象，并不需要定义实体，直接调用属性字段，哈哈哈
def jsonSlurper = new JsonSlurper()
def result = jsonSlurper.parseText(json)
//John
println result[0].name

//--------------

def response = getNetWorkData("https://www.sojson.com/open/api/weather/json.shtml?city=北京")

//查询天气温度 25
println response.data.wendu


def getNetWorkData(String url) {
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()

    def response = connection.content.text
    def jsonSlurper = new JsonSlurper()
    return jsonSlurper.parseText(response)
}
