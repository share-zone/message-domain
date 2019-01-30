package zone.share.domain.message.sender

/**
 * ConsoleSender
 * @author Iamee
 * @create 2019-01-30 10:35
 */
class ConsoleSender : ISender {

    constructor()

    override fun init(config: ISender.Config): Boolean {
        return true
    }

    override fun send(to: String, title: String, content: String): Boolean {
        println("{ to = $to, title = $title, content = $content }")
        return true
    }

}