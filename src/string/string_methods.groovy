package string

//字符串填充
def str = "hello groovy"
//对已有字符串的填充
println(str.center(8,'a'))//agroovya
println str.padLeft(8,'a')//aagroovy

//字符串比较
def str2 = 'hello'
println str2.compareTo(str) //1

//groovy中提供了比较操作符
println str2 > str //true


//字符串中对字符的索引
println str[0]//g
println str[0..1]//gr

//字符串中的减法
println str.minus(str2)

//其他几个常用的方法
//倒序
println str.reverse() //yvoorg olleh

//首字母大写
println str.capitalize()//Hello groovy

//判断是否是数字
println str.isNumber() //false