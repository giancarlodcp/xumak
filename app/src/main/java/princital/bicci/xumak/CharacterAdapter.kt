package princital.bicci.xumak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter ():RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    var items:ArrayList<CharacterModel> = ArrayList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var imgCharacter: ImageView = view.imgCharacter
        var txtName: TextView = view.txtName
        var akaText: TextView = view.akaText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_character,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(items.size>0) {
            Glide
                .with(holder.imgCharacter)
                .load(items[position].img)
                .centerCrop()
                .placeholder(R.drawable.heisenberg)
                .into(holder.imgCharacter)
            holder.txtName.text = items[position].name
            holder.akaText.text = ("a.k.a. - " + items[position].nickname)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}