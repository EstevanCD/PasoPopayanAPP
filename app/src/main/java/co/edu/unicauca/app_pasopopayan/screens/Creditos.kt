package co.edu.unicauca.app_pasopopayan.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.unicauca.app_pasopopayan.R
import co.edu.unicauca.app_pasopopayan.SearchBar
import co.edu.unicauca.app_pasopopayan.SootheBottomNavigation

@Composable
fun Creditos(navController: NavController){
    Scaffold (
        bottomBar = { SootheBottomNavigation(navController) }
    ){
        CreditosScreen(navController)
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun CreditosScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        SearchBar(navController,Modifier.padding(horizontal = 16.dp))
        Spacer(Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.logoapp_comp),
            contentDescription = null,
            modifier = Modifier.width(600.dp),
        )
        Spacer(Modifier.height(16.dp))
        Text(

            text = "Quienes somos:",
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .padding(10.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(16.dp))
        Text(

            text = "Somos una aplicación movil desarrollada por dos estudiantes de ultimo semestre de Ingeniería de Sistemas" +
                    "de la Universidad del Cauca, buscamos ayudar a las personas que aman nuestra tradición de SEMANA SANTA" +
                    "su estadía en Popayán. Esperamos que sea de tu agrado y la disfrutes!",
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .padding(10.dp),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black)
        )
        Text(

            text = "APLICACIÓN MÓVIL DESARROLLADA POR: CAMILO DAZA Y LUIS ARROYO PARA LA MATERIA ELECTIVA DE APLICACIONES MOVILES",
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .padding(10.dp),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black)
        )
    }
}