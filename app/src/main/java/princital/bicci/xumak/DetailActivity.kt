package princital.bicci.xumak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_character.txtName

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extras = intent.extras
        if (extras != null) {
            txtName.text = "Nombre: " + extras.getString("NAME")
            txtAka.text =  "Apodo: " + extras.getString("NICKNAME")
            txtCategory.text =  "Categoría: " + extras.getString("CATEGORY")
            txtStatus.text =  "Estado: " + extras.getString("STATUS")
            Glide
                .with(imageView)
                .load(extras.getString("IMG"))
                .centerCrop()
                .placeholder(R.drawable.heisenberg)
                .into(imageView)
        }

    }
}