package zone.share.domain.message

import zone.share.domain.message.sender.ISender

/**
 * Message
 * @author Iamee
 * @create 2019-01-29 21:58
 */
class Message {

    lateinit var sender: ISender

    constructor()

    constructor(sender: ISender) {
        this.sender = sender
    }

    fun send(to: String, title: String, content: String): Boolean {
        return this.sender.send(to = to, title = title, content = content)
    }

    companion object {
        fun build(sender: ISender): Message {
            return Message(sender = sender)
        }
    }

}