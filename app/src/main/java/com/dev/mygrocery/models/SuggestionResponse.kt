package com.dev.mygrocery.models


import com.google.gson.annotations.SerializedName

data class SuggestionResponse(
    @SerializedName("data")
    val `data`: Data
) {
    data class Data(
        @SerializedName("suggestionList")
        val suggestionList: List<Suggestion>
    ) {
        data class Suggestion(
            @SerializedName("name")
            val name: String
        )
    }
}