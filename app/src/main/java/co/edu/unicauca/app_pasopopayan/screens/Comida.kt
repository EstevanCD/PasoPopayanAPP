package co.edu.unicauca.app_pasopopayan.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
fun Comida(navController: NavController) {
    Scaffold(
        bottomBar = { SootheBottomNavigation(navController) }
    ) {
        HomeScreen(navController)
    }
}

@Composable
fun HomeScreen(navController: NavController,modifier: Modifier = Modifier) {
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
        SearchBar(navController,Modifier.padding(horizontal = 16.dp))
        Spacer(Modifier.height(16.dp))
        ElevatedCardExample(R.drawable.empanadas,"Empanadas de Pipián","El pipián es una mezcla de papa colorada, típicas de la zona, maní molido, " +
                "cebolla y achiote, con algunas variaciones. El secreto una empanada " +
                "de pipián está en su masa fina, delgada y muy crujiente, como si fuera " +
                "una pieza de orfebrería.",navController)
        Spacer(Modifier.height(16.dp))
        ElevatedCardExample(R.drawable.carantanta,"Carantanta","Uno de los platos más típicos de la cocina payanesa y caucana es la Carantanta, designación " +
                "de origen indígena que significaría «pan de maíz». Carantanta es una especie de caracha dura que se forma sobre la paila en que se ha cocinado la " +
                "masa del maíz añejo.",navController)
        Spacer(Modifier.height(16.dp))
        ElevatedCardExample(R.drawable.tamal,"Tamal de Pipián","El Tamal de Pipián es típico de Popayán(Cauca), se diferencia de los demás no solo " +
                "por su tamaño mas pequeño sino también porque su ingrediente principal es una mezcla típica  de la región llamado de la misma forma: Pipián, cuyo ingrediente " +
                "principal es la papa y se debe preparar antes empezar a armar los tamales",navController)
    }
}

@Composable
fun ElevatedCardExample(imagen:Int,tituloTexto:String,contenidoTexto:String,navController: NavController) {
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

            text = contenidoTexto,
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .padding(10.dp),
            style = MaterialTheme.typography.bodyMedium ,
            textAlign = TextAlign.Justify
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Comida()
}*/