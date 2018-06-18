package datastruct

//def list = new ArrayList()//java

//groovy
def emptyList = []

def list = [1, 2, 3, 4]
println list.class//java.util.ArrayList
println list.size()//4

//如何定义数组
def array = [1, 2, 3, 4, 5] as int[]
int[] array2 = [1, 2, 3, 4, 5]

//对list的操作
//java对列表的排序
def sortList = [6, 1, 3, 7, 2, 9]
//Comparator cmp = {
//    a,b -> a==b ? 0 :
//            Math.abs(a)<Math.abs(b)?-1:1
//}
//Collections.sort(sortList,cmp)//[1, 2, 3, 6, 7, 9]
//println sortList

//groovy排序
//sortList.sort()
//println sortList

//闭包指定排序规则
sortList.sort {
    a, b ->
        a == b ? 0 :
                Math.abs(a) < Math.abs(b) ? 1 : -1
}
println sortList//[9, 7, 6, 3, 2, 1]

//字符串对象的排序
def sortStringList = ['abc', 'z', 'hello', 'groovy']
//根据长度来排序
sortStringList.sort {
    it.length()
}
println sortStringList//[z, abc, hello, groovy]

//列表的查找
def findList = [-3, 9, 6, 2, -7, 1, 5]
int result = findList.find {
    return it % 2 == 0
}

println result //6

def result2 = findList.findAll {
    it % 2 != 0
}

println result2.toListString()//[-3, 9, -7, 1, 5]

def result3 = findList.any {
    it % 2 != 0
}
println result3//true

def result4 = findList.every {
    it % 2 == 0
}
println result4//false


println findList.min()//-7

println findList.max()//9

def result5 = findList.min {
    Math.abs(it)
}

println result5 //1

//统计列表个数
int number = findList.count {
    it % 2 == 0
}

println number //2

/**
 * list的添加元素
 */
def list2 = [1, 2, 3, 4, 5]
list2.add(6)
list2.leftShift(7)
list2 << 8
println list2.toListString()//1, 2, 3, 4, 5, 6, 7, 8

def plusList = list2 + 9
println plusList.toListString()//[1, 2, 3, 4, 5, 6, 7, 8, 9]

/**
 * list的删除操作
 */

plusList.remove(7)
println plusList //[1, 2, 3, 4, 5, 6, 7, 9]
plusList.removeAt(6)
println plusList//[1, 2, 3, 4, 5, 6, 9]
plusList.removeElement(6)
println plusList//[1, 2, 3, 4, 5, 9]

plusList.removeAll {
    it%2==0
}
println plusList//[1, 3, 5, 9]

println plusList -[1,5]//[3, 9]


