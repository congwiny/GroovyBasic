package variable

int x = 10
println(x.class)//java.lang.Integer；编译器自动装包


def y = 11
println(y.class)//class java.lang.Integer
def z = 3.14//
println(z.class)//class java.math.BigDecimal
def name = 'congwiny'
println(name.class)//class java.lang.String

y = 'abcd'
println(y.class)//class java.lang.String

//string
def name1 = 'a single string'
println(name1.class)//java.lang.String

def tripleName = '''love you 
        love me
                love us
'''
println(tripleName)


//可扩展字符串，可以包含变量
def doubleName = "this is a common string"
println(doubleName.class)//java.lang.String

def hi = "hi,"
def sayHi = "${hi}congwiny"
println(sayHi)//hi,congwiny
println(sayHi.class)//org.codehaus.groovy.runtime.GStringImpl

def sum = "The sum of 2 and 3 equals ${2+3}"
println(sum)