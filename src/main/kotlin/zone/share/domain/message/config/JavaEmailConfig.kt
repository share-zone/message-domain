package zone.share.domain.message.config

import zone.share.domain.message.sender.ISender

/**
 * JavaEmailConfig
 * @author Iamee
 * @create 2019-01-30 10:58
 */
data class JavaEmailConfig(
        val username: String,
        val password: String,
        val host: String,
        val port: String) : ISender.Config()