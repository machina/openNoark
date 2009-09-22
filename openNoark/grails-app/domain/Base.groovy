class Base {
    String systemid
    static constraints = {
        systemid(nullable: false, unique: true)
    }

    static mapping = {
        tablePerHierarchy false
    }

}
