package co.edu.unicauca.app_pasopopayan.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.unicauca.app_pasopopayan.R
import co.edu.unicauca.app_pasopopayan.SearchBar
import co.edu.unicauca.app_pasopopayan.SootheBottomNavigation

@Composable
fun Procesion(navController: NavController) {
    Scaffold(
        bottomBar = { SootheBottomNavigation(navController) }
    ) {
        HomeScreenProcesion(navController)
    }
}

@Composable
fun HomeScreenProcesion( navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoapp_comp),
                contentDescription = null,
                modifier = Modifier.width(600.dp),
            )
        }
        Spacer(Modifier.height(16.dp))
        SearchBar(navController, Modifier.padding(horizontal = 16.dp))
        Spacer(Modifier.height(16.dp))
        ElevatedCardProcesion(
            R.drawable.domingo,"Domingo de Ramos - FINALIZADO","Templo de Belén\n")
        Spacer(Modifier.height(16.dp))
        ElevatedCardProcesion(
            R.drawable.lunes,"Lunes Santo - FINALIZADO","Iglesia San Agustín\n\n")
        Spacer(Modifier.height(16.dp))
        ElevatedCardProcesion(
            R.drawable.martes,"Martes Santo - FINALIZADO","Templo La Ermita\n")
        Spacer(Modifier.height(16.dp))
        ElevatedCardProcesion(
            R.drawable.miercoles,"Miercoles Santo - FINALIZADO","Iglesia San Francisco\n")
        Spacer(Modifier.height(16.dp))
        ElevatedCardProcesion(
            R.drawable.jueves,"Jueves Santo - FINALIZADO","Iglesia Santo Domingo\n")
        Spacer(Modifier.height(16.dp))
        ElevatedCardProcesion(
            R.drawable.viernes,"Viernes Santo - FINALIZADO","Templo de Belén\n")
    }
}

@Composable
fun ElevatedCardProcesion(imagen:Int,tituloTexto:String,contenidoTexto:String,) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(imagen),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
        )
        Text(

            text = tituloTexto,
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .padding(10.dp),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black)
        )
        Text(
            text = "Lugar",
            modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                    .padding(10.dp),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black)
            )
        Text(
            text = contenidoTexto,
            modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                    .padding(10.dp),
            style = MaterialTheme.typography.bodyMedium ,
            )
    }
}
