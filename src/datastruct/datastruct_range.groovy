package datastruct

def range = 1..10
println range[0] //1
//判断范围中是否包含某个值
println range.contains(10) //true

//范围的起始值
println range.from //1
//范围的终止值
println range.to //10

/**
 * 说明：
 * public interface Range<T extends Comparable> extends List<T>
 *
 *   其实Range就是个List的子类，操作和List是一样的
 *
 *   既然有了List，为啥还要搞个范围呢？
 *   Range比List更轻量级，作为List的辅助
 */

//遍历方式1（推荐）
range.each {
    println it
}

//遍历方式2
for (i in range) {
    println i
}

//switch-case

def getGrade(Number num) {
    def result
    switch (num) {
        case 0..<60:
            result = '不及格'
            break
        case 60..<70:
            result = '及格'
            break
        case 70..<80:
            result = '良好'
            break
        case 80..100:
            result = '优秀'
            break
        return result

    }
}

def result = getGrade(76)
println result //良好
