package gonzalez.moises.examen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.moises.examen.R
import gonzalez.moises.examen.data.cursos

@Composable
fun CrearCarta(cursos: cursos) {
    if (cursos.tipo=="Registrado"){
        Card(modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .height(150.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF64B5F6))) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Column(modifier = Modifier.fillMaxHeight()
                        .padding(8.dp ).weight(1f),
                        verticalArrangement = Arrangement.Center,
                        ) {
                        Text(
                            //nombre
                            text = cursos.nombre, fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left
                        )
                        Text(
                            //Semana/Dia
                            text = cursos.valor, fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left
                        )
                        Spacer(modifier = Modifier.height(16.dp))
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
                    Spacer(modifier = Modifier.width(12.dp))
                    Image(
                        //Foto de perfil
                        painter = painterResource(id= cursos.imagen),
                        contentDescription = "Foto de perfil",
                        modifier = Modifier
                            .size(140.dp)
                            .fillMaxHeight(),
                        contentScale = ContentScale.Crop,)
                }
            }
    }else if (cursos.tipo=="No Registrado")
    {
        //Porque no se subio
        Row(modifier = Modifier.fillMaxWidth().padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFBBDEFB)))
            {
                Image(
                    //Imagen de tarjeta
                    painter = painterResource(id= cursos.imagen),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,)
            }
            Column(modifier = Modifier.fillMaxHeight()
                .padding(8.dp ).weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    //nombre
                    text = cursos.nombre, fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
                Text(
                    //Subtitulo
                    text = cursos.valor, fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Left
                )
            }
            Column() {
                Text(
                    //precio
                    modifier = Modifier.padding(8.dp),
                    text = cursos.precio, fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    textAlign = TextAlign.Left
                )
                Text(
                    text = "¥${cursos.precio.toFloat() * 5}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough,
                    textAlign = TextAlign.Left
                )}
        }
    }
}

