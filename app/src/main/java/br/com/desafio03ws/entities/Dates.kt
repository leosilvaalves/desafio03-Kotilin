package br.com.desafio03ws.entities
import com.google.gson.annotations.SerializedName

data class Dates (

	@SerializedName("type") val type : String,
	@SerializedName("date") val date : String
)