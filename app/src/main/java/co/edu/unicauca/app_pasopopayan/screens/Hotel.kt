package co.edu.unicauca.app_pasopopayan.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.unicauca.app_pasopopayan.AlignYourBodyRow
import co.edu.unicauca.app_pasopopayan.FavoriteCollectionsGrid
import co.edu.unicauca.app_pasopopayan.HomeSection
import co.edu.unicauca.app_pasopopayan.R
import co.edu.unicauca.app_pasopopayan.SearchBar
import co.edu.unicauca.app_pasopopayan.SootheBottomNavigation

@Composable
fun Hotel(navController: NavController){
    Scaffold (
        bottomBar = { SootheBottomNavigation(navController) }
    ){
        HotelScreen(navController)
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun HotelScreen(navController: NavController, modifier: Modifier = Modifier) {
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
        SearchBar(navController,Modifier.padding(horizontal = 16.dp))
        Spacer(Modifier.height(16.dp))
        HotelElevatedCard(R.drawable.j1,"Hotel La Herreria Colonial", navController)
        Spacer(Modifier.height(16.dp))
        HotelElevatedCard(R.drawable.j2,"Hotel Dann Monasterio",navController)
        Spacer(Modifier.height(16.dp))
        HotelElevatedCard(R.drawable.j3,"Hotel San Martín",navController)
    }
}

@Composable
fun HotelElevatedCard(imagen:Int,tituloTexto:String,navController: NavController) {
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
        IconWithText()
        FilledButtonExample(miAccion)
    }
}
val miAccion: () -> Unit = {
    // Coloca aquí el código que deseas ejecutar cuando se haga clic en el botón.
    // Por ejemplo, puedes mostrar un mensaje en la consola.
    println("Se hizo clic en el botón")
}
@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(
        onClick = { onClick() }, modifier = Modifier.padding(10.dp)){
        Text("Reservar")
    }
}
@Composable
fun IconWithText() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        )
        {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Wifi",
            )
            Text("Servicio habitaciones")
        }
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        )
        {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Wifi",
                )
                Text("Wifi")
        }
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        )
        {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Wifi",
            )
            Text("Desayuno")
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreviewHotel(){
    Hotel()
}*/