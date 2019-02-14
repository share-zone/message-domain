package zone.share.domain.message.sender.config

/**
 * JavaEmailConfig
 * @author Iamee
 * @create 2019-01-30 10:58
 */
data class JavaEmailConfig(
        val username: String,
        val password: String,
        val host: String,
        val port: String) : AbstractSenderConfig()