package br.edu.ifsp.scl.fastcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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

        settings = intent.getParcelableExtra(EXTRA_SETTINGS) ?: Settings()
        Toast.makeText(this, settings.toString(), Toast.LENGTH_SHORT).show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { //para exibir o menu
        menuInflater.inflate(R.menu.menu_game, menu)
        return true
    }

    //Para tratar clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.restartGameMi -> { true }

            R.id.exitMi -> {
                finish()
                true
            }

            else -> { false}
        }
    }

}