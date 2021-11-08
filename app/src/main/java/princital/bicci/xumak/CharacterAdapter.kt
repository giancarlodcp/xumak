package princital.bicci.xumak

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter ():RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    var items:ArrayList<CharacterModel> = ArrayList()
    private lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var imgCharacter: ImageView = view.imgCharacter
        var txtName: TextView = view.txtName
        var akaText: TextView = view.akaText
        var layout : ConstraintLayout = view.layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
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
            holder.layout.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("NAME",items[position].name)
                intent.putExtra("IMG",items[position].img)
                intent.putExtra("NICKNAME",items[position].nickname)
                intent.putExtra("STATUS",items[position].status)
                intent.putExtra("CATEGORY",items[position].category)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}