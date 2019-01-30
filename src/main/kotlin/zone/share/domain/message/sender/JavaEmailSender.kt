package zone.share.domain.message.sender

import zone.share.domain.message.config.JavaEmailConfig
import java.util.*
import javax.mail.Authenticator
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.internet.MimeMessage

/**
 * JavaEmailSender
 * @author Iamee
 * @create 2019-01-29 22:09
 */
class JavaEmailSender : ISender {

    private lateinit var session: Session

    lateinit var username: String
        private set

    lateinit var password: String
        private set

    constructor()

    override fun init(config: ISender.Config): Boolean {
        if (config !is JavaEmailConfig) return false
        return this.init(config = config)
    }

    fun init(config: JavaEmailConfig): Boolean {
        val properties = Properties()
        properties["mail.smtp.auth"] = "true"
        properties["mail.smtp.host"] = config.host
        properties["mail.user"] = config.username
        properties["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"
        properties["mail.smtp.socketFactory.port"] = config.port
        properties["mail.password"] = config.password
        val authenticator = object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                val username = properties.getProperty("mail.user")
                val password = properties.getProperty("mail.password")
                return PasswordAuthentication(username, password)
            }
        }
        session = Session.getInstance(properties, authenticator)
        return true
    }

    override fun send(to: String, title: String, content: String): Boolean {
        val transport = session.transport
        val message = MimeMessage(session)
        transport.connect(username, password)
        message.setRecipients(MimeMessage.RecipientType.TO, to)
        message.setSubject(title, "UTF-8")
        message.setContent(content, "text/html;charset=utf8")
        message.sentDate = Date()
        transport.sendMessage(message, message.allRecipients)
        transport.close()
        return true
    }

}