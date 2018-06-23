package advance.xml

final String xml = '''
    <response version-api="2.0">
        <value>
            <books id="1" classification="android">
                <book available="20" id="1">
                    <title>疯狂Android讲义</title>
                    <author id="1">李刚</author>
                </book>
                <book available="14" id="2">
                   <title>第一行代码</title>
                   <author id="2">郭林</author>
               </book>
               <book available="13" id="3">
                   <title>Android开发艺术探索</title>
                   <author id="3">任玉刚</author>
               </book>
               <book available="5" id="4">
                   <title>Android源码设计模式</title>
                   <author id="4">何红辉</author>
               </book>
           </books>
           <books id="2" classification="web">
               <book available="10" id="1">
                   <title>Vue从入门到精通</title>
                   <author id="4">李刚</author>
               </book>
           </books>
       </value>
    </response>
'''

//开始解析xml
def xmlSluper = new XmlSlurper()
def response = xmlSluper.parseText(xml)
//访问xml内容值  疯狂Android讲义
println response.value.books[0].book[0].title.text()
//第一行代码
println response.value.books[0].book[1].title.text()

//访问xml属性值 14
println response.value.books[0].book[1].@available

//对xml数据的查询
//查询所有作者是李刚的书名
def list = []
response.value.books.each { books ->
    books.book.each { book ->
        def author = book.author.text()
        if (author.equals('李刚')) {
            list.add(book.title.text())
        }
    }
}
//[疯狂Android讲义, Vue从入门到精通]
//println list.toListString()

//groovy 提供的深度遍历方法
def titles = response.depthFirst().findAll { book ->
    book.author.text().equals('李刚')
}
//println titles

//深度遍历的简单写法
titles = response.'**'.findAll { book ->
    book.author.text().equals('李刚')
}
println titles



//广度遍历
def name = response.value.books.children().findAll { node ->
    //节点的名字是'book'
    node.name() == 'book' && node.@id == 2

}.collect { node ->
    return node.title.text()
}
//[第一行代码]
//println name


//广度遍历的简单写法
name = response.value.books.'*'.findAll { node ->
    //节点的名字是'book'
    node.name() == 'book' && node.@id == 2

}.collect { node ->
    return node.title.text()
}

println name