package sk.vildibald.polls.mapping

import org.springframework.core.convert.converter.Converter
import sk.vildibald.polls.model.PerformerStyle
import sk.vildibald.polls.payload.PerformerStyleResponse

class PerformerStyleConverter : Converter<PerformerStyle, PerformerStyleResponse> {
    override fun convert(source: PerformerStyle): PerformerStyleResponse =
            PerformerStyleResponse(id = source.id,
                    styleName = source.styleName
            )
}