package sk.vildibald.polls.service.impl

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import sk.vildibald.polls.exception.AppException
import sk.vildibald.polls.model.RoleName
import sk.vildibald.polls.model.User
import sk.vildibald.polls.payload.ApiResponse
import sk.vildibald.polls.payload.JwtAuthenticationResponse
import sk.vildibald.polls.payload.LoginRequest
import sk.vildibald.polls.payload.SignUpRequest
import sk.vildibald.polls.repository.*
import sk.vildibald.polls.security.JwtTokenProvider
import sk.vildibald.polls.service.AuthService

@Service
class AuthServiceImpl(
        private val authenticationManager: AuthenticationManager,
        private val userRepository: UserRepository,
        private val performerStyleRepository: PerformerStyleRepository,
        private val performerTypeRepository: PerformerTypeRepository,
        private val performanceSubCategoryRepository: PerformanceSubCategoryRepository,
        private val passwordEncoder: PasswordEncoder,
        private val tokenProvider: JwtTokenProvider
) : AuthService {
    override fun authenticateUser(loginRequest: LoginRequest): JwtAuthenticationResponse {
        val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        loginRequest.usernameOrEmail,
                        loginRequest.password
                )
        )

        SecurityContextHolder.getContext().authentication = authentication

        return JwtAuthenticationResponse(tokenProvider.generateToken(authentication))
    }

    override fun registerUser(signUpRequest: SignUpRequest): ApiResponse {
        val (username, password, name, email, isSolo, performerTypeIds, performerStyleIds,
                pricedPerformanceSubcategory, web, youtubeLink, otherPerformerInfo) = signUpRequest
        if (userRepository.existsByUsername(username)) {
            return ApiResponse(false, "Username '$username' is already taken!")
        }
        if (userRepository.existsByEmail(email)) {
            return ApiResponse(false, "Email address '$email' is already in use!")
        }

        val performerType = performerTypeRepository.findById(performerTypeIds)

        val performerStyle = performerStyleRepository.findById(performerStyleIds)

        val newUser = User(
                username = username,
                password = passwordEncoder.encode(password),
                performerName = name,
                email = email,
                isSolo = isSolo,
                performerType = performerType,
                performerStyle = performerStyle,
                pricedPerformanceSubcategories = pricedPerformanceSubcategory,
                web = web,
                youtube = youtubeLink,
                otherInfo = otherPerformerInfo
        )

        userRepository.save(newUser)

        return ApiResponse(true, "User registered successfully.")
    }
}