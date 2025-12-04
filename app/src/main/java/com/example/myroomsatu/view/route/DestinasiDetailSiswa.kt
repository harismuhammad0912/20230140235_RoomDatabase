package com.example.myroomsatu.view.route

import com.example.myroomsatu.R

object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa // Pastikan string ini ada di strings.xml
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}