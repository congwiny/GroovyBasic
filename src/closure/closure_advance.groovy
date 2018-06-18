package closure

/**
 * 闭包的三个重要变量: this, owner, delegate
 */

def script_closure = {
    println "script closure this:"+this         //closure.closure_advance@5bd03f44
    println "script closure owner:"+owner       //closure.closure_advance@5bd03f44
    println "script closure delegate:"+delegate //closure.closure_advance@5bd03f44
}

script_closure.call()

//为什么会定义这三个关键字，而且对象都是同一个，有啥用？
/**
 * this 与Java中的this意义是一样的
 * 代表闭包定义处的类或对象
 *
 * owner 代表闭包定义处的类或对象
 *   对象（闭包内部还可以嵌套定义闭包）
 *
 * delegate 代表任意一个三方对象，delegate默认值是owner持有的那个对象
 */

class Person {
    def static classClosure = {
        println "class closure this:"+this
        println "class closure owner:"+owner
        println "class closure delegate:"+delegate
    }

    def static say(){
        //方法中定义的闭包
        def methodClosure = {
            println "method closure this:"+this
            println "method closure owner:"+owner
            println "method closure delegate:"+delegate
        }
        methodClosure.call()
    }

}

Person.classClosure.call()
Person.say()
/**
 class closure this:class closure.Person 类的字节码
 class closure owner:class closure.Person
 class closure delegate:class closure.Person
 method closure this:class closure.Person
 method closure owner:class closure.Person
 method closure delegate:class closure.Person
 */


class Person2 {
    def classClosure = {
        println "class closure this:"+this
        println "class closure owner:"+owner
        println "class closure delegate:"+delegate
    }

    def say(){
        //方法中定义的闭包
        def methodClosure = {
            println "method closure this:"+this
            println "method closure owner:"+owner
            println "method closure delegate:"+delegate
        }
        methodClosure.call()
    }

}

Person2 person = new Person2()
person.classClosure.call()
person.say()
/**
 * class closure this:closure.Person2@393671df Person2的对象
 * class closure owner:closure.Person2@393671df
 * class closure delegate:closure.Person2@393671df
 * method closure this:closure.Person2@393671df
 * method closure owner:closure.Person2@393671df
 * method closure delegate:closure.Person2@393671df
 */

//闭包中定义闭包，区别this和owner
def nestClosure = {
    def innerClosure = {
        println "inner closure this:"+this
        println "inner closure owner:"+owner
        println "inner closure delegate:"+delegate
    }
    innerClosure.call()
}
nestClosure.call()
/**
 * inner closure this:closure.closure_advance@31d7b7bf
 * inner closure owner:closure.closure_advance$_run_closure2@1ab3a8c8
 * inner closure delegate:closure.closure_advance$_run_closure2@1ab3a8c8
 */

/**
 * 在类或方法中定义闭包，this,owner,delegate这三个变量是一样的;
 * 在闭包中嵌套定义闭包，this,owner,delegate的值不一样了:
 * this指向闭包定义处的类或对象
 * owner,delegate都会指向离它最近的闭包对象
 */

//什么情况下，owner和delegate又不相同了
//人为的修改情况下。但是this,owner是不能被修改的
def nestClosure2 = {
    def innerClosure = {
        println "inner closure this:"+this
        println "inner closure owner:"+owner
        println "inner closure delegate:"+delegate
    }
    innerClosure.delegate = person//修改默认的delegate
    innerClosure.call()
}
nestClosure2.call()

//这三个字段有啥作用呢？学习了闭包的委托策略就知道了

/**
 * 闭包的委托策略
 */
class Student{
    String name
    //name默认指向定义闭包处类（闭包的owner）的name
    def pretty = {"My name is ${name}"}

    String toString(){
        pretty.call()
    }
}

class Teacher{
    String name
}


def stu = new Student(name: 'congwiny')
def tea = new Teacher(name: 'Xiaoyu')
println stu.toString()//My name is congwiny

//使用delegate改变委托，委托策略可应用于变量和方法
//闭包中的name就会指向delegate对象中的name
stu.pretty.delegate = tea
//修改闭包的委托策略(每个闭包都有自己的委托策略，默认是Closure.OWNER_FIRST)
//从delegate处优先寻找对象的name，而delegate在这里是Teacher对象; 如果委托中没有name字段的话，就会到owner中寻找
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST//(Closure.DELEGATE_ONLY只会从delegate对象中寻找)
println stu.toString()//My name is Xiaoyu

//委托策略一般在框架中使用的比较多，一般不会用到，了解即可


