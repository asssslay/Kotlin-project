package w.cati.factsaboutcats.data.remote

import retrofit2.http.GET

import w.cati.factsaboutcats.data.remote.dto.FactsDto

interface FactsApi {

    @GET("/fact")
    suspend fun getFacts(): FactsDto
}