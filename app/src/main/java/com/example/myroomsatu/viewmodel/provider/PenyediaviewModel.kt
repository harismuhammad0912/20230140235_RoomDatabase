package com.example.myroomsatu.viewmodel.provider // REVISI: Tambahkan .provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myroomsatu.repositori.AplikasiSiswa
import com.example.myroomsatu.viewmodel.EntryViewModel // Import manual karena beda package
import com.example.myroomsatu.viewmodel.HomeViewModel  // Import manual karena beda package

object PenyediaViewModel {

    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(repositoriSiswa = aplikasiSiswa().container.repositoriSiswa)
        }

        initializer {
            EntryViewModel(repositoriSiswa = aplikasiSiswa().container.repositoriSiswa)
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
 * [AplikasiSiswa].
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)