package com.ifsp.omdbsearch.model

data class Resposta(
    var metadata: Metadata? = Metadata(),
    var results: List<Result?>? = listOf()
)
data class Result(
    var id: String? = "",
    var language: String? = "",
    //var lexicalEntries: List<LexicalEntry?>? = listOf(),
    var type: String? = "",
    var word: String? = ""
)

data class Metadata(
    var provider: String? = ""
)
