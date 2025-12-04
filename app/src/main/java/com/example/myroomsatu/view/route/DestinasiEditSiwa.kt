package com.example.myroomsatu.view.route

import com.example.myroomsatu.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa // Pastikan string ini ada di strings.xml
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}