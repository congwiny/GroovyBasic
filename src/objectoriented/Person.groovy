package objectoriented

/**
 * 1.groovy中默认都是public
 * 与Java一样
 */
class Person implements Action{
    String name
    Integer age

    /**
     * 方法默认是public类型的
     * @param years
     * @return def是返回值类型（Object）
     */
    def increaseAge(Integer years) {
        this.name += years
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }
}