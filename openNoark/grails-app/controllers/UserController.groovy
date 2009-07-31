import org.jsecurity.crypto.hash.Sha1Hash
class UserController {

    def index = {redirect(action: 'list', params: params) }

		def list = {
			[users: JsecUser.findAll()]
		}

		def create = {
			[user: new JsecUser(username: params.username), errors: params.errors]
		}

		def save = {
			def user = new JsecUser(params)
			user.passwordHash = new Sha1Hash(params.passwd).toHex()
			if(!user.save()){
				render(view: "create", model: [user: user])
			} else {
				redirect(action: 'list', params: params)
			}
		}
}
