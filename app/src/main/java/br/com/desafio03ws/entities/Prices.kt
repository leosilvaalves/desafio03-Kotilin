package br.com.desafio03ws.entities
import com.google.gson.annotations.SerializedName

data class Prices (

	@SerializedName("type") val type : String,
	@SerializedName("price") val price : String
)