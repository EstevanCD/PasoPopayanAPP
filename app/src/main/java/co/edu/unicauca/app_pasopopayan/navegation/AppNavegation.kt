package co.edu.unicauca.app_pasopopayan.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.unicauca.app_pasopopayan.PasoPopayanAppPortrait
import co.edu.unicauca.app_pasopopayan.screens.Artesania
import co.edu.unicauca.app_pasopopayan.screens.Comida
import co.edu.unicauca.app_pasopopayan.screens.Creditos
import co.edu.unicauca.app_pasopopayan.screens.Hotel
import co.edu.unicauca.app_pasopopayan.screens.Procesion
import co.edu.unicauca.app_pasopopayan.screens.StartOrderScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Principal.route){
        composable(route=AppScreens.Principal.route){
            StartOrderScreen(navController)
        }
        composable(route=AppScreens.Inicio.route){
            PasoPopayanAppPortrait(navController)
        }
        composable(route=AppScreens.Comida.route){
            Comida(navController)
        }
        composable(route=AppScreens.Artesania.route){
            Artesania(navController)
        }
        composable(route=AppScreens.Hotel.route){
            Hotel(navController)
        }
        composable(route=AppScreens.Procesion.route){
            Procesion(navController)
        }
        composable(route=AppScreens.Creditos.route){
            Creditos(navController)
        }
    }
}