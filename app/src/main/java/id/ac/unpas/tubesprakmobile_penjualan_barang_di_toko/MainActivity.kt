package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.MainScreen
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.theme.TubesPrakMobilePenjualanbarangditokoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TubesPrakMobilePenjualanbarangditokoTheme{
                // A surface container using the 'background' color from the theme
                MainScreen(onExitClick = {
                    finish()
                })
            }
        }
    }
}