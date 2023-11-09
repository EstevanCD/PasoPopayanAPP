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
import co.edu.unicauca.app_pasopopayan.R
import co.edu.unicauca.app_pasopopayan.SearchBar

@Composable
fun Comida() {
    Scaffold() {
        HomeScreen()
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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
        SearchBar(Modifier.padding(horizontal = 16.dp))
        Spacer(Modifier.height(16.dp))
        ElevatedCardExample(R.drawable.empanadas,"Empanadas de Pipián","El pipián es una mezcla de papa colorada, típicas de la zona, maní molido, " +
                "cebolla y achiote, con algunas variaciones. El secreto una empanada " +
                "de pipián está en su masa fina, delgada y muy crujiente, como si fuera " +
                "una pieza de orfebrería.")
        Spacer(Modifier.height(16.dp))
        ElevatedCardExample(R.drawable.empanadas,"Empanadas de Pipián","El pipián es una mezcla de papa colorada, típicas de la zona, maní molido, " +
                "cebolla y achiote, con algunas variaciones. El secreto una empanada " +
                "de pipián está en su masa fina, delgada y muy crujiente, como si fuera " +
                "una pieza de orfebrería.")
        Spacer(Modifier.height(16.dp))
        ElevatedCardExample(R.drawable.empanadas,"Empanadas de Pipián","El pipián es una mezcla de papa colorada, típicas de la zona, maní molido, " +
                "cebolla y achiote, con algunas variaciones. El secreto una empanada " +
                "de pipián está en su masa fina, delgada y muy crujiente, como si fuera " +
                "una pieza de orfebrería.")
    }
}

@Composable
fun ElevatedCardExample(imagen:Int,tituloTexto:String,contenidoTexto:String) {
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

@Composable
fun ElementosComida() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.empanadas),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = "hola",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Comida()
}