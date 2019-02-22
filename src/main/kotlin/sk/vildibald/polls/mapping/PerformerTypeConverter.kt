package sk.vildibald.polls.mapping

import org.springframework.core.convert.converter.Converter
import sk.vildibald.polls.model.PerformerType
import sk.vildibald.polls.payload.PerformerTypeResponse

class PerformerTypeConverter : Converter<PerformerType, PerformerTypeResponse> {

    override fun convert(source: PerformerType): PerformerTypeResponse =
            PerformerTypeResponse(id = source.id,
                    typeName = source.typeName
            )
}