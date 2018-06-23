package advance.file

def file = new File('../../../GroovyTest.iml')
//遍历文件内容
file.eachLine { line ->
    //println line
}

//获取文件内容方式1
def text = file.getText()
//println text

//获取文件内容方式2 返回的是list
def linesList = file.readLines()
//println linesList

/**
 * 自定义读取文件的内容
 */
//demo 读取前100字符数据
def reader = file.withReader { reader ->
    char[] buffer = new char[100]
    reader.read(buffer)
    return buffer
}

println reader

/**
 * 向文件中写内容
 */
def writer = file.withWriter {

}

/**
 * 文件的copy
 */
def copy(String srcPath, String destPath) {
    try {
        def destFile = new File(destPath)
        if (!destFile.exists()) {
            destFile.createNewFile()
        }
        new File(srcPath).withReader { reader ->
            def lines = reader.readLines()
            destFile.withWriter { writer ->
                lines.each { line ->
                    writer.append(line + "\n\r")
                }
            }

        }
        return true
    } catch (Exception e) {

    }
    return false
}