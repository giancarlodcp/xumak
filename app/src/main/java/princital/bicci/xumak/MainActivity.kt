package princital.bicci.xumak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(CharacterViewModel::class.java) }
    private lateinit var CharacterId:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getrestaurantDetails().observe(this,{
            CharacterId = "just testing the URL"
        })

    }
}