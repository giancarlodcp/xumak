package princital.bicci.xumak

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  Created by Giancarlo Calderón on 04/11/2021.
 */
class CharacterRepository {
    private lateinit var allCollectionsRest: MutableLiveData<ArrayList<CharacterModel>>

    fun getallCollectionCharacters(): LiveData<ArrayList<CharacterModel>> {
        allCollectionsRest = MutableLiveData()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiRetrofit::class.java)
        val call = api.getCharacterList("10")
        call.enqueue(object : Callback<ArrayList<CharacterModel>> {
            override fun onResponse(
                call: Call<ArrayList<CharacterModel>>,
                response: Response<ArrayList<CharacterModel>>
            ) {
                if (response.isSuccessful) {
                    println(response.body())
                    allCollectionsRest.value = response.body()
                }
            }

            override fun onFailure(call: Call<ArrayList<CharacterModel>>, t: Throwable) {
                Log.e("RETROFIT API ERROR",t.toString())
            }

        })
        return allCollectionsRest
    }
}