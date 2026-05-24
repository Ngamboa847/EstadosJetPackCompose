package me.nicolas.estadosjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.nicolas.estadosjetpackcompose.ui.theme.EstadosJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //CONTADOR
            //MyApp()
            //DADOS
            Dados()

            //TAX VIEW MODEL
            //val viewModel : FormTaxViewModel = viewModel()
            //FormTax(myViewModel =  viewModel)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyApp(){
    var contador by remember{ mutableStateOf(value=0) }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text="Sumado de numeros: $contador", fontSize = 50.sp,
            textAlign = TextAlign.Center)

        Button(onClick = {
            Log.i("mi-error", "Estoy haciendo click")
            contador = contador + 1
        }){
            Text("Sumar +")
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun Dados(){
    val list = listOf(R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6)

    var dado by remember {mutableStateOf(list.random())}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Image(
            painter = painterResource(id = dado),
            contentDescription = "Imagen dado",
            modifier = Modifier.size(250.dp)
        )

        Button(onClick = {
            Log.i("mi-error", "Estoy haciendo click")
            dado = list.random()
        }){
            Text("Lanza el dado")
        }}
}
