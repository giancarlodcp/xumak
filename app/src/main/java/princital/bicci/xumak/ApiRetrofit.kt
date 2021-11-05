package princital.bicci.xumak

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.Url

/**
 *  Created by Giancarlo Calderón on 04/11/2021.
 */
interface ApiRetrofit {
    @GET("characters")
    fun getCharacterList(@Query("limit") limit: String): Call<ArrayList<CharacterModel>>

    @GET("characters")
    fun getCharacter(@Url() id: String): Call<CharacterModel>

}