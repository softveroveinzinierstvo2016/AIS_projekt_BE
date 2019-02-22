package sk.vildibald.polls.service.impl

import org.springframework.stereotype.Service
import sk.vildibald.polls.payload.PagedResponse
import sk.vildibald.polls.payload.PerformerStyleResponse
import sk.vildibald.polls.repository.PerformerStyleRepository
import sk.vildibald.polls.security.UserPrincipal
import sk.vildibald.polls.service.PerformerStyleService

@Service
class PerformerStyleServiceImpl(private val performerStyleRepository: PerformerStyleRepository) : PerformerStyleService{

    override fun allPerformerStyles(): List<PerformerStyleResponse> {
        val styles = performerStyleRepository.findAll()



        val styleResponsesData = styles.map { perfomerStyle ->
            PerformerStyleResponse(
                    perfomerStyle.id,
                    perfomerStyle.styleName
            )
        }

        return styleResponsesData
    }
}