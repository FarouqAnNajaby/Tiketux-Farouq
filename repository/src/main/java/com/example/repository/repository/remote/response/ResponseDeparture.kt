package com.example.repository.repository.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseDeparture(

	@field:SerializedName("tiketux")
	val tiketux: TiketuxDeparture? = null
)

data class Departure(

	@field:SerializedName("tgl_berangkat_induk")
	val tglBerangkatInduk: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("tgl_berangkat")
	val tglBerangkat: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null,

	@field:SerializedName("jam_berangkat")
	val jamBerangkat: String? = null
)

data class TiketuxDeparture(

	@field:SerializedName("result")
	val result: List<Departure?>? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
