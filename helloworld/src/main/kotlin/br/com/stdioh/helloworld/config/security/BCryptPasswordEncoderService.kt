package br.com.stdioh.helloworld.config.security

    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.inject.Singleton

@Singleton
class BCryptPasswordEncoderService : PasswordEncoder {


    private val bc: BCryptPasswordEncoder = BCryptPasswordEncoder()

    override fun encode(rawPassword: CharSequence?): String {
        return bc.encode(rawPassword);
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
        return bc.matches(rawPassword, encodedPassword);
    }
}