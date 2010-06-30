package org.friark

class UserService {

    static transactional = true

    def editREST(def user)  {
        def old_user = ShiroUser.get(user.id)

        def xml_user = user
        old_user.passwordHash = xml_user.passwordHash

        old_user.save()
        return [user: old_user]
    }
}
