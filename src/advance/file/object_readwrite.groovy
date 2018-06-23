package advance.file

def saveObject(Object object, String path) {
    try {
        def destFile = new File(path)
        if (!destFile.exists()) {
            destFile.createNewFile()
        }
        destFile.withObjectOutputStream { out ->
            out.writeObject(object)
        }
        return true
    } catch (Exception e) {

    }
    return false
}

def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (!file.exists()) {
            return null
        }

        file.withObjectInputStream { input ->
            obj = input.readObject()
        }

    } catch (Exception e) {

    }
    return obj
}