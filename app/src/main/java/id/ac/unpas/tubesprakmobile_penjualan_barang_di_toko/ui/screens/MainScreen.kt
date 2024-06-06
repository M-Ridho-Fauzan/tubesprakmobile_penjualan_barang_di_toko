package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onExitClick: () -> Unit) {
    val navController = rememberNavController()
    val currentRoute = remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
                 TopAppBar(
                     title = { Text(text = "Qasir") },
                     navigationIcon = {
                         if (currentRoute.value != NavScreen.Login.route) {
                             Image(
                                 painterResource(id = R.drawable.baseline_home_24),
                                 contentDescription = "Menu",
                                 colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                                 modifier = Modifier.clickable {
                                     navController.navigate(NavScreen.Home.route)
                                 }
                             )
                         }

                     },
                     colors = topAppBarColors(
                         containerColor = MaterialTheme.colorScheme.primary,
                         titleContentColor = MaterialTheme.colorScheme.onPrimary
                     ),
                     actions = {
                         Image(
                             painterResource(id = R.drawable.baseline_exit_to_app_24),
                             contentDescription = "Exit",
                             colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                             modifier = Modifier.clickable {
                                 onExitClick()
                             }
                         )
                     }
                 )
        },
        bottomBar = {
            if (currentRoute.value != NavScreen.Login.route) {
                BottomAppBar (
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painterResource(id = R.drawable.baseline_add_24),
                            contentDescription = "Tambah",
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(NavScreen.Add.route)
                                }
                                .weight(0.5f)
                        )
                        Image(
                            painterResource(id = R.drawable.baseline_remove_red_eye_24),
                            contentDescription = "Lihat",
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(NavScreen.List.route)
                                }
                                .weight(0.5f)
                        )
                    }
                }
            }

        },
        floatingActionButton = {
            if (currentRoute.value == NavScreen.Home.route) {
                FloatingActionButton(onClick = { navController.navigate(NavScreen.Add.route) }) {
                    Image(painterResource(id = R.drawable.baseline_add_24), contentDescription = "Add")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = NavScreen.Login.route) {

            composable(NavScreen.Login.route) {
                currentRoute.value = NavScreen.Login.route
                LoginScreen(modifier = Modifier.padding(innerPadding)) {
                    navController.navigate(NavScreen.Home.route)
                }
            }
            composable(NavScreen.Home.route) {
                currentRoute.value = NavScreen.Home.route
                HomeScreen(navController = navController, modifier = Modifier.padding(innerPadding)) {
                    navController.navigate(NavScreen.List.route)
                }
            }
            composable(NavScreen.List.route) {
                currentRoute.value = NavScreen.List.route
                ListTodoScreen(modifier = Modifier.padding(innerPadding), onDelete = {
                    scope.launch {
                        snackBarHostState.showSnackbar("Data telah dihapus", "OK")
                    }

                }) { id ->
                    navController.navigate("${NavScreen.Edit.route}/$id")
                }
            }
            composable(NavScreen.Add.route) {
                currentRoute.value = NavScreen.Add.route
                FormTodoScreen(modifier = Modifier.padding(innerPadding))
            }
            composable(NavScreen.Edit.routeWithArgument,
                arguments = listOf(navArgument(NavScreen.Edit.argument0) { type = NavType.StringType }))
                { backStackEntry ->
                val id = backStackEntry.arguments?.getString(NavScreen.Edit.argument0) ?: return@composable

                currentRoute.value = NavScreen.Edit.route
                FormTodoScreen(modifier = Modifier.padding(innerPadding), id = id)
            }
        }
    }
}