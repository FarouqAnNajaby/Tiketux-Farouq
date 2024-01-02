package com.example.repository.repository.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseJadwal(

	@field:SerializedName("tiketux")
	val tiketux: Tiketux? = null
)

data class Tiketux(

	@field:SerializedName("result")
	val result: List<ResultItem?>? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class ResultItem(

	@field:SerializedName("rute_kota")
	val ruteKota: String? = null,

	@field:SerializedName("list_outlet_transit")
	val listOutletTransit: String? = null,

	@field:SerializedName("rute")
	val rute: String? = null,

	@field:SerializedName("keterangan")
	val keterangan: String? = null,

	@field:SerializedName("layanan")
	val layanan: String? = null,

	@field:SerializedName("tersedia")
	val tersedia: Int? = null,

	@field:SerializedName("terisi")
	val terisi: Int? = null,

	@field:SerializedName("list_outlet_dropoff")
	val listOutletDropoff: String? = null,

	@field:SerializedName("detail_rute")
	val detailRute: String? = null,

	@field:SerializedName("list_outlet_pickup")
	val listOutletPickup: String? = null,

	@field:SerializedName("kode_jadwal")
	val kodeJadwal: String? = null,

	@field:SerializedName("jam")
	val jam: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("id_rute")
	val idRute: String? = null,

	@field:SerializedName("kapasitas")
	val kapasitas: Int? = null,

	@field:SerializedName("armada")
	val armada: String? = null
)
