package sk.vildibald.polls.payload

import sk.vildibald.polls.model.PricedPerformanceSubcategory
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SignUpRequest(

        @NotBlank
        @Size(min = 3, max = 15)
        val username: String,

        @NotBlank
        @Size(min = 6, max = 20)
        val password: String,

        @NotBlank
        @Size(min = 4, max = 40)
        val name: String,

        @NotBlank
        @Size(max = 40)
        @Email
        val email: String,

        @NotBlank
        val isSolo: Boolean = false,

        @NotBlank
        val performerType: List<Long>,

        @NotBlank
        val performerStyle: List<Long>,

        @NotBlank
        val pricedPerformanceSubcategory: List<PricedPerformanceSubcategoryRequest>,

        @Size(max = 255)
        val web: String = "",

        @Size(max = 255)
        val youtubeLink: String = "",

        @Size(max = 255)
        val otherPerformerInfo: String
)