package com.example.myroomsatu.repositori

import android.app.Application
import android.content.Context
import com.example.myroomsatu.room.DatabaseSiswa

// import com.example.myroomsatu.repositori.OfflineRepositoriSiswa // Pastikan import ini ada jika OfflineRepositoriSiswa beda file

interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context) : ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            siswaDao = DatabaseSiswa.getDatabase(context).siswaDao()
        )
    }
}

class AplikasiSiswa : Application() {
    /**
     * AppContainer instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
     */
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(context = this)
    }
}