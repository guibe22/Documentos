package com.example.documentos.data.remote

import com.example.documentos.data.dto.DocumentoDTO
import retrofit2.http.GET

interface DocumentoApi {
    @GET("documentos")
    suspend fun getDocumentos():List<DocumentoDTO>
}