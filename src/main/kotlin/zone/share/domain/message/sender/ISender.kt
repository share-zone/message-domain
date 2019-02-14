package zone.share.domain.message.sender

import zone.share.domain.message.sender.config.AbstractSenderConfig

/**
 * ISender
 * @author Iamee
 * @create 2019-01-29 21:59
 */
interface ISender {

    fun init(config: AbstractSenderConfig): Boolean

    fun send(to: String, title: String, content: String): Boolean

}