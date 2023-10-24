package br.edu.ifsp.scl.fastcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.ifsp.scl.fastcalculation.Extras.EXTRA_SETTINGS
import br.edu.ifsp.scl.fastcalculation.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private val activityGameBinding: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }

    private lateinit var settings: Settings
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityGameBinding.root)

        setSupportActionBar(activityGameBinding.gameTbIn.gameTb)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            subtitle = getString(R.string.game)
        }

        settings = intent.getParcelableExtra<Settings>(EXTRA_SETTINGS) ?: Settings() //obsoleto para a versão em que estamos utilizando
    }
}