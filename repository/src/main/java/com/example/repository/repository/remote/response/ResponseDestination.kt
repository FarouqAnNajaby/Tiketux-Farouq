package com.example.repository.repository.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseDestination(

	@field:SerializedName("tiketux")
	val tiketuxDestination: TiketuxDestination? = null
)

data class Destination(

	@field:SerializedName("rute")
	val rute: String? = null,

	@field:SerializedName("tarif")
	val tarif: Int? = null,

	@field:SerializedName("tersedia")
	val tersedia: Int? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("tarif_str")
	val tarifStr: String? = null,

	@field:SerializedName("terisi")
	val terisi: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("kapasitas")
	val kapasitas: Int? = null
)

data class TiketuxDestination(

	@field:SerializedName("result")
	val result: List<Destination?>? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
