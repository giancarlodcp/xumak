package princital.bicci.xumak

import com.google.gson.annotations.SerializedName

/**
 *  Created by Giancarlo Calderón on 04/11/2021.
 */
class CharacterModel {

    @SerializedName("char_id") var char_id:Int = 0
    @SerializedName("name") lateinit var name:String
    @SerializedName("birthday") lateinit var birthday:String
    @SerializedName("occupation") lateinit var occupation:Array<String>
    @SerializedName("img") lateinit var img:String
    @SerializedName("status") lateinit var status:String
    @SerializedName("nickname") lateinit var nickname:String
    @SerializedName("appearance") lateinit var appearance:Array<Int>
    @SerializedName("portrayed") lateinit var portrayed:String
    @SerializedName("category") lateinit var category:String


}