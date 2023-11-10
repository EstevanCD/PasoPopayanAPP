package co.edu.unicauca.app_pasopopayan.navegation

sealed class AppScreens(val route: String){

    object Artesania: AppScreens("artesania")
    object Comida: AppScreens("comida")
    object Hotel: AppScreens("hotel")
    object Inicio: AppScreens("inicio")
    object Principal: AppScreens("principal")
    object Procesion: AppScreens("procesiones")

}

