package objectoriented

//类的实例的创建
/**
 * 虽然没有构造方法，但是groovy中可以为属性设置初始化值
 * 无论你是直接用"."还是调用get/set最终调用的都是get/set
 */
def person = new Person(name: 'congwiny', age: 26)
println "the name is ${person.name}," +//相当于调用person.getName()
        "the age is ${person.getAge()}"
person.increaseAge(10)

//def person0 = new Person()
//person0.cry()//编译不会报错，运行groovy.lang.MissingMethodException:

//在Person2中实现了invokeMethod方法
def person2 = new Person2()
//println person2.cry()//the method is cry, the params is []

//在Person2中实现了methodMissing方法
//println person2.cry()//the method cry is missing

/**
 * metaClass 在运行时强大的作用:
 * 在运行时期，动态的为类添加属性，方法
 */

//将外部注入的属性和方法设置为全局的，整个app都可以用了
ExpandoMetaClass.enableGlobally()


//为Person类添加一个sex属性，并且赋值为male
Person.metaClass.sex = 'male'
def person3 = new Person(name: 'congwiny', age: 26)
println person3.sex //male

//修改sex
person3.sex = 'female'
println "the new sex is: ${person3.sex}" //the new sex is: female

//为Person类从外部注入一个方法（为类动态添加方法）
Person.metaClass.sexUpperCase = { -> sex.toUpperCase() }
println person3.sexUpperCase()//FEMALE

//为Person类动态添加静态方法
Person.metaClass.static.createPerson = {
    String name, int age ->
        new Person(name: name, age: age)
}

def person4 = Person.createPerson('xiaoyu', 25)
println "name=${person4.name},age=${person4.age}"//name=xiaoyu,age=25

