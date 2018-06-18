package closure

//闭包的定义
def closure = {println 'hello groovy'}
closure.call()//闭包的调用方式1
closure()//闭包的调用方式2


//带参数的闭包: 通过'->'分隔参数与闭包体
def closure_params = {String name -> println "hello groovy! $name"}
closure_params.call('congwiny')
closure_params('haha')

//带有多个参数的闭包
def closure_params2 = {String name,int age -> println "hello groovy! $name age:${age}"}
closure_params2('huhu',20)

//闭包默认参数，隐式it参数
def closure_params3 = {println "hello groovy! ${it}"}
closure_params3('cccc')//hello groovy! cccc


def closure_params4 = {String name -> println "hello ${name}"}
def name = 'groovy'
def result = closure_params4(name)
println result //null
