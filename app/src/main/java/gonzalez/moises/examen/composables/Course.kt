package gonzalez.moises.examen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.moises.examen.R
import gonzalez.moises.examen.data.cursos

@Composable
fun Cursos_pantalla(){
    //Columna
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top)
    {
        Box(contentAlignment = Alignment.CenterStart)
        {
            Row(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically)
            {
                Image(
                    //Foto de perfil
                    painter = painterResource(id= R.drawable.profp),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(75.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
                Column(modifier = Modifier.padding(12.dp).weight(1f)) {
                    Text(
                        //Nombre
                        text = "Lunar2hou", fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,

                    )

                    Text(
                        //Grado
                        text = "4to Grado", fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "",
                    )
                    Text(
                        //Texto como el del ejemplo
                        text = "Grade", fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Left
                    ) }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            //Texto start
            text = "Inicio", fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(170.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFC8E6C9))) {
            Row() {
                Box(modifier = Modifier.fillMaxHeight().padding(16.dp).weight(1f),)
                {
                    Column(Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            //Texto start
                            text = "Numeros", fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.inversePrimary,
                            textAlign = TextAlign.Left,
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            //Texto start
                            text = " ¡Hola números de peluche!", fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.inversePrimary,
                            textAlign = TextAlign.Left,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = {}) {
                            Row()
                            {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = "Alerta")
                                Text(
                                    text = "Start", fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold)

                            }
                        }
                    }
                }
                Image(
                    painter = painterResource(id= R.drawable.rana),
                    contentDescription = "Rnana",
                    modifier = Modifier
                    .fillMaxHeight().size(170.dp),
                    contentScale = ContentScale.Crop,
                )

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Cursos", fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Left,
        )
        val cursos_list = listOf(
            cursos("Try for 7 days", R.drawable.chiyo, "Start on Aug, 1st","No Registrado","$9.9"),
            cursos("Autumn Termn", R.drawable.jitafa, "Start on Sep, 1st","No Registrado","$398"),
            cursos("Autumn Termn", R.drawable.jaimeerrique, "Semana 2","No Registrado","$67"),
        )
        val cursos_reg=cursos_list.filter { it.tipo=="No Registrado" }
        LazyColumn(modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(1.dp),
        ){
            items(cursos_reg.size){cursos->
                CrearCarta(cursos_reg[cursos])
            }
        }
    }
}
