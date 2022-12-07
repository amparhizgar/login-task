package ir.amirhparhizgar.logintask

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base.setAppLocale())
    }

    fun Context.setAppLocale(): Context {
        val locale = Locale("fa", "IR")
        Locale.setDefault(locale)
        with(resources.configuration) {
            setLocale(locale)
            setLayoutDirection(locale)
            return createConfigurationContext(this)
        }
    }
}