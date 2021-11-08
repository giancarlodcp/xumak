package princital.bicci.xumak

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 *  Created by Giancarlo Calderón on 04/11/2021.
 */
class CharacterViewModel : ViewModel(){
    private var repository: CharacterRepository = CharacterRepository()

    fun getrestaurantDetails(): LiveData<ArrayList<CharacterModel>> {
        return repository.getallCollectionCharacters(50)
    }
}