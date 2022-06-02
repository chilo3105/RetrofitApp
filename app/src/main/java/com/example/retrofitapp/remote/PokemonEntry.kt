package com.example.retrofitapp.remote

import com.google.gson.annotations.SerializedName

data class PokemonEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("types")
    val types: List<TypeEntry>,

    @SerializedName("stats")
    val stats: List<StatsEntry>,

    @SerializedName("sprites")
    val sprites :  SpriteEntry

    )

//Sprite front_default
data class SpriteEntry(
    @SerializedName("front_default")
    val front_default: String,

    @SerializedName("front_shiny")
    val front_shiny: String

)


//Stats
data class StatsEntry(
    @SerializedName("base_stat")
    val base_stat: String,
    @SerializedName("stat")
    val stat: StatEntry
)

data class StatEntry(
    @SerializedName("name")
    val stat_value: String
)

// para etrar a tipes del json
data class TypeEntry(
    @SerializedName("type")
    val type: TypeName,
)

data class  TypeName(
    @SerializedName("name")
    val name:String
)


