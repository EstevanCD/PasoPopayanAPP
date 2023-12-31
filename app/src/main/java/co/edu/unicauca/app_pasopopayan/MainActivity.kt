package co.edu.unicauca.app_pasopopayan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import co.edu.unicauca.app_pasopopayan.ui.theme.App_PasoPopayanTheme
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import co.edu.unicauca.app_pasopopayan.navegation.AppNavigation
import co.edu.unicauca.app_pasopopayan.screens.Artesania
import co.edu.unicauca.app_pasopopayan.screens.Hotel
import co.edu.unicauca.app_pasopopayan.screens.StartOrderScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_PasoPopayanTheme {
                val windowSizeClass = calculateWindowSizeClass(this)
                AppNavigation()
            }
        }
    }
}