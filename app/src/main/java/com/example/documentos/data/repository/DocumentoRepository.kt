package com.example.documentos.data.repository

import com.example.documentos.data.dto.DocumentoDTO
import com.example.documentos.data.remote.DocumentoApi
import com.example.documentos.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DocumentoRepository @Inject constructor(private val api: DocumentoApi) {
    fun getDocumento(): Flow<Resource<List<DocumentoDTO>>> = flow {
        try{
            emit(Resource.Loading())

            val documento = api.getDocumentos()

            emit(Resource.Success(documento))
        }catch (e: HttpException){
            emit(Resource.Error(e.message ?: "Error HTTP"))

        }catch (e: IOException){
            emit(Resource.Error(e.message ?: "Verificar conexion"))
        }
    }
}