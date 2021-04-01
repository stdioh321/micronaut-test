package br.com.stdioh.helloworld.config.security

import br.com.stdioh.helloworld.controller.UserRepository
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import java.lang.Long
import javax.inject.Singleton


@Singleton
class UserPasswordAuthenticationProvider(
    private val userRepository: UserRepository,
    private val bc: BCryptPasswordEncoderService,
) : AuthenticationProvider {
    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {
        val user = userRepository.findById(Long.parseLong(authenticationRequest?.identity as String))?.get();

        if (user != null
            && bc.matches(authenticationRequest?.secret as String, user.password)
        ) {
            val userDetails = UserDetails(user.cpf.toString(), listOf());
            return Flowable.just(
                userDetails
            );
        }
        return Flowable.error(AuthenticationException(AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)));

    }
}