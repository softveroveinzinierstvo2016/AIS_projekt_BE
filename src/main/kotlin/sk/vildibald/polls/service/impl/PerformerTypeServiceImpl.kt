package sk.vildibald.polls.service.impl

import org.springframework.stereotype.Service
import sk.vildibald.polls.mapping.PageConverter
import sk.vildibald.polls.mapping.PerformerTypeConverter
import sk.vildibald.polls.payload.PagedResponse
import sk.vildibald.polls.payload.PerformerTypeResponse
import sk.vildibald.polls.repository.PerformerTypeRepository
import sk.vildibald.polls.security.UserPrincipal
import sk.vildibald.polls.service.PerformerTypeService

@Service
class PerformerTypeServiceImpl(private val performerTypeRepository: PerformerTypeRepository) : PerformerTypeService{

    override fun allPerformerTypes(): List<PerformerTypeResponse> {
        val types = performerTypeRepository.findAll()



        val typeResponsesData = types.map { perfomerType ->
            PerformerTypeResponse(
                perfomerType.id,
                perfomerType.typeName
            )
        }

        return typeResponsesData
    }
}