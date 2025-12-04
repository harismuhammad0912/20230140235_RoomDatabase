package com.example.myroomsatu.repositori

import com.example.myroomsatu.room.Siswa
import com.example.myroomsatu.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    fun getSiswaStream(id: Int): Flow<Siswa?> // Tambahan
    suspend fun insertSiswa(siswa: Siswa)
    suspend fun deleteSiswa(siswa: Siswa)     // Tambahan
    suspend fun updateSiswa(siswa: Siswa)     // Tambahan
}

class OfflineRepositoriSiswa(private val siswaDao: SiswaDao) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override fun getSiswaStream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id) // Tambahan
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)    // Tambahan
    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.update(siswa)    // Tambahan
}