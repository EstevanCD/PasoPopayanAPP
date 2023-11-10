package co.edu.unicauca.app_pasopopayan

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
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
import co.edu.unicauca.app_pasopopayan.navegation.AppScreens
import co.edu.unicauca.app_pasopopayan.screens.WeatherCard
import co.edu.unicauca.app_pasopopayan.ui.theme.App_PasoPopayanTheme

@Composable
fun PasoPopayanAppPortrait(navController: NavController) {
    App_PasoPopayanTheme {
        Scaffold(
            bottomBar = { SootheBottomNavigation(navController) }
        ) { padding ->
            PrincipalScreen(navController,Modifier.padding(padding))
        }
    }
}
/*
@Composable
fun PasoPopayanAppLandscape(){
    App_PasoPopayanTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                SootheNavigationRail()
                PrincipalScreen()
            }
        }
    }
}*/


@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.img_logo))
                },
                selected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_profile))
                },
                selected = false,
                onClick = {}
            )
        }
    }
}
/*
@Composable
fun PasoPopayanApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            PasoPopayanAppPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            //PasoPopayanAppLandscape()
        }
    }
}*/

// Step: Bottom navigation - Material
@Composable
public fun SootheBottomNavigation(navController: NavController,modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navController.navigate(AppScreens.Inicio.route)
                    }
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
fun SearchBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clickable { navController.popBackStack() }
        )

        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            placeholder = {
                Text(stringResource(R.string.icon_busqueda))
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // El TextField ocupa el espacio restante
        )
    }
}


@Composable
fun FavoriteCollectionCard(
    navController: NavController,
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    ruta: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier.clickable { navController.navigate(ruta) }
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
fun LogoCollectionCard(
    @DrawableRes drawable: Int,
    @DrawableRes drawable2: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Image(
                painter = painterResource(drawable2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}



@Composable
fun FavoriteCollectionsGrid(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(navController,item.imageResource, item.stringResource,item.navigationPath, Modifier.height(80.dp))
        }
    }
}

@Composable
fun HomeSection(
    navController: NavController,
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun AlignYourBodyElement(
    navController: NavController,
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    ruta: String
) {
    Column(
        modifier = Modifier.clickable { navController.navigate(ruta) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun AlignYourBodyRow(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(navController,item.imageResource, item.stringResource,item.navigationPath)
        }
    }
}

@Composable
fun PrincipalScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(navController,Modifier.padding(horizontal = 16.dp))
        HomeSection(navController,title = R.string.seccion_uno) {
            AlignYourBodyRow(navController)
        }
        HomeSection(navController,title = R.string.seccion_dos) {
            FavoriteCollectionsGrid(navController)
        }
        HomeSection(navController,title = R.string.seccion_tres) {
            WeatherCard()
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { navController.navigate(AppScreens.Creditos.route) },
            text = "¿Quienes somos?"
        )
    }
}
data class PlaceData(
    val imageResource: Int,
    val stringResource: Int,
    val navigationPath: String
)

private val alignYourBodyData = listOf(
    PlaceData(R.drawable.logoapp,R.string.img_iglesias,AppScreens.Comida.route),
    PlaceData(R.drawable.logoapp,R.string.img_museos,AppScreens.Artesania.route),
    PlaceData(R.drawable.logoapp,R.string.img_monumentos,AppScreens.Hotel.route),
)

private val favoriteCollectionsData = listOf(
    PlaceData(R.drawable.jesus_1,R.string.img_procesiones,AppScreens.Procesion.route),
    PlaceData(R.drawable.carantanta,R.string.img_comida,AppScreens.Comida.route),
    PlaceData(R.drawable.s_domingo,R.string.img_artesanias,AppScreens.Artesania.route),
    PlaceData(R.drawable.j2,R.string.img_hoteles,AppScreens.Hotel.route),
)

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

/*
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun SearchBarPreview() {
    App_PasoPopayanTheme { SearchBar(Modifier.padding(8.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    App_PasoPopayanTheme {
        AlignYourBodyElement(
            text = R.string.img_lunes,
            drawable = R.drawable.jesus_1,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
    App_PasoPopayanTheme {
        FavoriteCollectionCard(
            text = R.string.img_lunes,
            drawable = R.drawable.jesus_1,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionsGridPreview() {
    App_PasoPopayanTheme { FavoriteCollectionsGrid() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun LogoCollectionCardPreview() {
    App_PasoPopayanTheme {
        LogoCollectionCard(
            drawable = R.drawable.title,
            drawable2 = R.drawable.logoapp1,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyRowPreview() {
    App_PasoPopayanTheme { AlignYourBodyRow() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
    App_PasoPopayanTheme {
        HomeSection(R.string.seccion_uno) {
            AlignYourBodyRow()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
@Composable
fun ScreenContentPreview() {
    App_PasoPopayanTheme { PrincipalScreen() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BottomNavigationPreview() {
    App_PasoPopayanTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun NavigationRailPreview() {
    App_PasoPopayanTheme { SootheNavigationRail() }
}
*/

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PasoPopayanPortraitPreview() {
    //PasoPopayanAppPortrait()
    //Comida()
    //Artesania()
    //Hotel()
    //StartOrderScreen()
    WeatherCard()
}