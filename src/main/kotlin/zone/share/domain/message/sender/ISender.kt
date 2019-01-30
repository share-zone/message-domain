package zone.share.domain.message.sender

/**
 * ISender
 * @author Iamee
 * @create 2019-01-29 21:59
 */
interface ISender {

    fun init(config: Config): Boolean

    fun send(to: String, title: String, content: String): Boolean

    abstract class Config

}