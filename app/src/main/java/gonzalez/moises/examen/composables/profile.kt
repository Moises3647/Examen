package gonzalez.moises.examen.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.moises.examen.R
import gonzalez.moises.examen.data.cursos


@Composable
fun PantallaPerfil()
{
    //Columna principal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ){
            //Columna para el usuario
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    //Foto de perfil
                    painter = painterResource(id= R.drawable.profp),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    //Nombre
                    text = "Lunar2hou", fontSize = 42.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Left
                )
                Text(
                    //Grado
                    text = "4to Grado", fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Left
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            )
        {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically)
            {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Alerta",
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Fecha de entrega proxima!",
                    fontSize = 16.sp
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Alerta",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        //Texto de Subtitulo
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Learning",
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left
        )
        val gridState = rememberLazyGridState()
        val cursos_list = listOf(
            cursos("Autumn Termn", R.drawable.jitafa , "Semana 1","Registrado","9.9"),
            cursos("Autumn Termn", R.drawable.chiyo, "Dia 2","Registrado","9.9"),
            cursos("Autumn Termn", R.drawable.jaimeerrique, "Semana 2","Registrado","9.9"),
        )
        val cursos_reg=cursos_list.filter { it.tipo=="Registrado" }
        LazyColumn(modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(1.dp),
        ){
            items(cursos_reg.size){cursos->
                CrearCarta(cursos_reg[cursos])
            }
        }
    }
}
