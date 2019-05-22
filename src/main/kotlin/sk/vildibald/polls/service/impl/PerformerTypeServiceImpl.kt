package sk.vildibald.polls.service.impl

import org.springframework.stereotype.Service
import sk.vildibald.polls.payload.PerformerTypeResponse
import sk.vildibald.polls.repository.PerformerTypeRepository
import sk.vildibald.polls.service.PerformerTypeService

@Service
class PerformerTypeServiceImpl(
        private val performerTypeRepository: PerformerTypeRepository
) : PerformerTypeService {

    override fun allPerformerTypes(): List<PerformerTypeResponse> =

            performerTypeRepository.findAll().map {
                PerformerTypeResponse(
                        it.id,
                        it.typeName
                )
            }
}