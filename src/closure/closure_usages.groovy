package closure

int x = 10
//10的阶乘

int fab(int number){
    int result = 1
    1.upto(number,{num -> result*=num})
    return result
}

println fab(x) //3628800


//downto
int fab2(int number){
    int result = 1
    number.downto(1){
        num ->result*=num
    }
    return  result
}
println fab2(x) //3628800

//10以内求和
int cal(int number){
    int result = 0
    number.times {
        num -> result+=num
    }
    return result
}
println cal(x+1) //55


//字符串与闭包结合使用

//字符串通过闭包来遍历
String str = 'the 2 and 3 is 5'
//each遍历
def closure_each = str.each {
    //print it
}
println closure_each//返回值是本身,the 2 and 3 is 5

//find查找符合条件的第一个
def closure_find =  str.find {
    //String s -> s.isNumber()
    it.isNumber()
}

println closure_find //2

//findAll
def list = str.findAll{
    it.isNumber()
}
println list.toListString()//[2, 3, 5]

//判断字符串是否满足某种条件

//表示字符串里包含数字
println str.any {//true
    it.isNumber()
}

//判断每一项是否是数字
def result = str.every {String s -> s.isNumber()}
println result //false

def list2 = str.collect {
    it.toUpperCase()
}
println list2.toListString()//[T, H, E,  , 2,  , A, N, D,  , 3,  , I, S,  , 5]