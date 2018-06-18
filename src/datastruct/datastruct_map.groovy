package datastruct

//groovy map
def colors = [red  : 'ff0000',//key默认为不带单引号的字符串（不可变字符串）
              green: '00ff00',
              blue : '0000ff']

//传入key,获取value
println colors.get('blue')//0000ff
//方式2
println colors['red']//ff0000
//方式3
println colors.red//ff0000

/**
 * 元素的添加
 */
colors.yellow = 'ffff00'
println colors.toMapString()//[red:ff0000, green:00ff00, blue:0000ff, yellow:ffff00]
//添加方式2
colors.leftShift(pink: 'FFC0CB')
println colors.toMapString()//[red:ff0000, green:00ff00, blue:0000ff, yellow:ffff00, pink:FFC0CB]

//添加多个元素
//groovy很强大，可添加不同类型的map元素
colors.complex = [a: 1, b: 2]
println colors.toMapString()//[red:ff0000, green:00ff00, blue:0000ff, yellow:ffff00, pink:FFC0CB, complex:[a:1, b:2]]

//不可以用属性class（"."操作符加属性已经作为查找key）
println colors.getClass()//java.util.LinkedHashMap

/**
 * 元素的删除
 */
colors.remove('complex')
println colors.toMapString()//[red:ff0000, green:00ff00, blue:0000ff, yellow:ffff00, pink:FFC0CB]

/**
 * map常用操作
 */
def students = [
        1: [number: '0001', name: 'Bob',
            score : 55, sex: 'male'],
        2: [number: '0002', name: 'John',
            score : 62, sex: 'male'],
        3: [number: '0003', name: 'Claire',
            score : 73, sex: 'male'],
        4: [number: '0004', name: 'Amy',
            score : 66, sex: 'male']
]

//map遍历
students.each {
    student ->
        println "the key is ${student.key}," +
                "the value is ${student.value}"
}
/**
 * the key is 1,the value is [number:0001, name:Bob, score:55, sex:male]
 * the key is 2,the value is [number:0002, name:John, score:62, sex:male]
 * the key is 3,the value is [number:0003, name:Claire, score:73, sex:male]
 * the key is 4,the value is [number:0004, name:Amy, score:66, sex:male]
 */

//带索引的each遍历
students.eachWithIndex { student, int index ->
    println "index is ${index}, the key is ${student.key}," +
            "the value is ${student.value}"
}
/**
 * index is 0, the key is 1,the value is [number:0001, name:Bob, score:55, sex:male]
 * index is 1, the key is 2,the value is [number:0002, name:John, score:62, sex:male]
 * index is 2, the key is 3,the value is [number:0003, name:Claire, score:73, sex:male]
 * index is 3, the key is 4,the value is [number:0004, name:Amy, score:66, sex:male]
 */

//map直接遍历key,value
students.each {
    key, value ->
        println "the key is ${key}," +
                "the value is ${value}"
}
/**
 the key is 1,the value is [number:0001, name:Bob, score:55, sex:male]
 the key is 2,the value is [number:0002, name:John, score:62, sex:male]
 the key is 3,the value is [number:0003, name:Claire, score:73, sex:male]
 the key is 4,the value is [number:0004, name:Amy, score:66, sex:male]
 */

students.eachWithIndex {
    key, value, index ->
        println "index is ${index}, the key is ${key}," +
                "the value is ${value}"
}
/**
 index is 0, the key is 1,the value is [number:0001, name:Bob, score:55, sex:male]
 index is 1, the key is 2,the value is [number:0002, name:John, score:62, sex:male]
 index is 2, the key is 3,the value is [number:0003, name:Claire, score:73, sex:male]
 index is 3, the key is 4,the value is [number:0004, name:Amy, score:66, sex:male]
 */

//map的查找，类似SQL

//查找一个及格的
def entry = students.find {
    def student ->
        return student.value.score >= 60//查询条件
}
println entry //2={number=0002, name=John, score=62, sex=male}

def entry2 = students.findAll {
    def student ->
        return student.value.score >= 60
}
println entry2.toMapString()
/**
 * [2:[number:0002, name:John, score:62, sex:male], 3:[number:0003, name:Claire, score:73, sex:male], 4:[number:0004, name:Amy, score:66, sex:male]]
 */

//count统计
def count = students.count {
    def student ->
        return student.value.score >= 60 &&
                student.value.sex == 'male'
}
println count //3

//查询所有及格人的名字
def names = students.findAll {
    def student ->
        return student.value.score >= 60
}.collect {//过滤
    return it.value.name
}

println names.toListString()//[John, Claire, Amy]

//map分组

//根据学生的分数是否及格分组
def group = students.groupBy {
    def student ->
        return student.value.score >= 60 ? '及格' : '不及格'
}

println group.toMapString()
/**
 * [不及格:[1:[number:0001, name:Bob, score:55, sex:male]],
 * 及格:[2:[number:0002, name:John, score:62, sex:male], 3:[number:0003, name:Claire, score:73, sex:male], 4:[number:0004, name:Amy, score:66, sex:male]]]
 */

//map排序

def sortStudents = students.sort {
    def stu1, def stu2 ->
        Number score1 = stu1.value.score
        Number score2 = stu2.value.score
        return score1 == score2 ? 0 :
                score1 < score2 ? -1 : 1
}
println sortStudents.toMapString()
/**
 * [1:[number:0001, name:Bob, score:55, sex:male], 2:[number:0002, name:John, score:62, sex:male], 4:[number:0004, name:Amy, score:66, sex:male], 3:[number:0003, name:Claire, score:73, sex:male]]
 */