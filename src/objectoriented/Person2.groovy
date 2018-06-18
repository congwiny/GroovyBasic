package objectoriented

class Person2 implements DefaultAction {

    String name
    Integer age

    @Override
    void eat() {

    }

    /**
     *
     * @param methodName 要调用的方法名
     * @param args 要调用的方法参数
     */
    def invokeMethod(String methodName, Object args) {
        return "the method is ${methodName}, the params is ${args}"
    }

    def methodMissing(String methodName, Object args) {
        return "the method ${methodName} is missing"
    }
}
