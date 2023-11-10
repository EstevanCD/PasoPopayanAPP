package co.edu.unicauca.app_pasopopayan.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import co.edu.unicauca.app_pasopopayan.HomeSection
import co.edu.unicauca.app_pasopopayan.R
import co.edu.unicauca.app_pasopopayan.SearchBar
import co.edu.unicauca.app_pasopopayan.SootheBottomNavigation
import co.edu.unicauca.app_pasopopayan.ui.theme.App_PasoPopayanTheme

@Composable
fun Artesania(navController: NavController) {
    Scaffold(
        bottomBar = { SootheBottomNavigation(navController) }
    ) {
        ArtesaniaScreen(navController)
    }
}

@Composable
fun ArtesaniaScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
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
        Text(
            text = stringResource(R.string.img_artesanias),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        App_PasoPopayanTheme { FavoriteCollectionsGridArt(navController) }
    }
}

@Composable
fun CollectionCardArt(
    navController: NavController,
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun FavoriteCollectionsGridArt(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),

    ) {
        favoriteCollectionsDataArt.forEach { item ->
            CollectionCardArt(navController,item.drawable, item.text, Modifier.height(80.dp))
        }
    }
}



private val favoriteCollectionsDataArt = listOf(
    R.drawable.s_domingo to R.string.img_santoDomingo,
    R.drawable.casa_moneda to R.string.img_Cmoneda,
    R.drawable.bomberos to R.string.img_Bomberos,
    R.drawable.inem to R.string.img_inem,
    R.drawable.exito to R.string.img_Exito,
    R.drawable.bolivar to R.string.img_bolivar
).map { DrawableStringPairArt(it.first, it.second) }

private data class DrawableStringPairArt(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreviewArt(){
    Artesania()
}
*/